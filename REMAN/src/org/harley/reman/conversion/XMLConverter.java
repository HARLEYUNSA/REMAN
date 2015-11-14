package org.harley.reman.conversion;

import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FormattingResults;
import org.apache.fop.apps.MimeConstants;
import org.apache.fop.apps.PageSequenceResults;

/**
 * This class demonstrates the convert of a XML file to PDF using FOP.
 */

public class XMLConverter {

    // Configure FopFactory
    private final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
    File databaseDir;
    File baseDir;
    File outDir;
        
    public  XMLConverter (){
        databaseDir = new File("src/org/harley/reman/database");
        outDir = new File("src/org/harley/reman/informes");
        baseDir = new File("src/org/harley/reman/conversion/plantillas");
    }
    /**
     * Converts an XSL and XML file to a FO file 
     * @param xsl the Stylesheet file
     * @param xml the XML file
     * @param fo the target FO file
     */
    public void convertXML2FO(File xsl, File xml, File fo){

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer; 
        try {
            transformer = factory.newTransformer(new StreamSource(xsl));
            
            // Setup input stream
            Source src = new StreamSource(xml);

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new StreamResult(new FileOutputStream(fo));

            // Start XSLT transformation and FOP processing
            transformer.transform(src, res);
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
    
     /**
     * Converts an FO file to a PDF file using FOP
     * @param fo the FO file
     * @param pdf the target PDF file
     */
    public void convertFO2PDF(File fo, File pdf){

        OutputStream out = null;

        try {
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            out = new FileOutputStream(pdf);
            out = new BufferedOutputStream(out);

            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup JAXP using identity transformer
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(); // identity transformer

            // Setup input stream
            Source src = new StreamSource(fo);

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            transformer.transform(src, res);

            // Result processing
            FormattingResults foResults = fop.getResults();
            List pageSequences = foResults.getPageSequences();
            for (Iterator it = pageSequences.iterator(); it.hasNext();) {
                PageSequenceResults pageSequenceResults = (PageSequenceResults)it.next();
                System.out.println("PageSequence "
                        + (String.valueOf(pageSequenceResults.getID()).length() > 0
                                ? pageSequenceResults.getID() : "<no id>")
                        + " generated " + pageSequenceResults.getPageCount() + " pages.");
            }
            System.out.println("Generated " + foResults.getPageCount() + " pages in total.");

        } catch (FileNotFoundException | FOPException | TransformerException e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(XMLConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void convert(String archivo, String nombre){
        //Setup input and output files
        File xmlFile = new File(databaseDir, nombre +".xml");
        File xslFile = new File(baseDir, archivo +".xsl");
        File foFile = new File(databaseDir, nombre +".fo");
        File pdfFile = new File(outDir, nombre +".pdf");

        //Status
        System.out.println("Input: XML (" + xmlFile + ")");
        System.out.println("Output: PDF (" + pdfFile + ")");
        System.out.println();
        System.out.println("Transforming...");

        XMLConverter pdfFactory = new XMLConverter();
        pdfFactory.convertXML2PDF(xmlFile, xslFile, foFile, pdfFile);

        System.out.println("Success!");
    }

    public void convertXML2PDF(File xml, File xsl, File fo, File pdf){
        
        //Convert from XML and XLS to FOP
        convertXML2FO(xsl, xml, fo);

        //Convert from FOP to PDF
        convertFO2PDF(fo, pdf);
        //Delete temporal directory
        clean(fo);
        
        try {
            Desktop.getDesktop().open(pdf);
        } catch (IOException ex) {
            Logger.getLogger(XMLConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clean(File fo){
        fo.delete();
    }
}