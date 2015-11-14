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
 * Clase que convierte archivos xml a pdf usando fop
 * @author Gonzalo
 */
public class XMLConverter {

    private final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
    File databaseDir;
    File baseDir;
    File outDir;
    
    /**
     * Constructor de la clase <code>XMLConverter</code>
     */
    public  XMLConverter (){
        databaseDir = new File("src/org/harley/reman/database");
        outDir = new File("src/org/harley/reman/informes");
        baseDir = new File("src/org/harley/reman/conversion/plantillas");
    }
    
    /**
     * Convierte un archivo XSL y XML file to a FO file 
     * @param xsl Hoja de estilos
     * @param xml Archivo XML
     * @param fo Archivo fo destino
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
     * Convierte un archivo FO a PDF usando FOP
     * @param fo Archivo FO origen
     * @param pdf Archivo PDF destino
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
            /*FormattingResults foResults = fop.getResults();
            List pageSequences = foResults.getPageSequences();
            for (Iterator it = pageSequences.iterator(); it.hasNext();) {
                PageSequenceResults pageSequenceResults = (PageSequenceResults)it.next();
                System.out.println("PageSequence "
                        + (String.valueOf(pageSequenceResults.getID()).length() > 0
                                ? pageSequenceResults.getID() : "<no id>")
                        + " generated " + pageSequenceResults.getPageCount() + " pages.");
            }
            System.out.println("Generated " + foResults.getPageCount() + " pages in total.");
*/
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

    /**
     * Convierte el archivo XML en PDF
     * @param plantilla Archivo XLS para dar formato
     * @param archivoXML Archivo XML de origen
     */
    public void convert(String plantilla, String archivoXML){
        //Setup input and output files
        File xmlFile = new File(databaseDir, archivoXML +".xml");
        File xslFile = new File(baseDir, plantilla +".xsl");
        File foFile = new File(databaseDir, archivoXML +".fo");
        File pdfFile = new File(outDir, archivoXML +".pdf");

        //Status
        System.out.println("Input: XML (" + xmlFile + ")");
        System.out.println("Output: PDF (" + pdfFile + ")");
        System.out.println();
        System.out.println("Transforming...");

        XMLConverter pdfFactory = new XMLConverter();
        pdfFactory.convertXML2PDF(xmlFile, xslFile, foFile, pdfFile);

        System.out.println("Success!");
    }

    /**
     * Convierte un archivo XML a PDF
     * @param xml Archivo XML origen
     * @param xsl Archivo XSL origen
     * @param fo Archivo FO intermedio
     * @param pdf Archivo PDF destino
     */
    public void convertXML2PDF(File xml, File xsl, File fo, File pdf){
        
        //Convert from XML and XLS to FOP
        convertXML2FO(xsl, xml, fo);

        //Convert from FOP to PDF
        convertFO2PDF(fo, pdf);
        //Delete temporal directory
        clean(fo);
        abrirPDF(pdf);
    }
    
    /**
     * Abre el archivo PDF 
     * @param archivoPDF Archivo PDF que se desea abrir
     */
    public void abrirPDF(File archivoPDF){
         try {
            Desktop.getDesktop().open(archivoPDF);
        } catch (IOException ex) {
            Logger.getLogger(XMLConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Elimina el archivo FO intermedio
     * @param fo Archivo FO creado
     */
    public void clean(File fo){
        fo.delete();
    }
}