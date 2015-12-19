<?xml version="1.0" encoding="iso-8859-1" ?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="1.0">

<xsl:template match="libroHistorico">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="plantillaHist"
                  page-height="29.7cm" 
                  page-width="21cm"
                  margin-top="1cm" 
                  margin-bottom="2cm" 
                  margin-left="2.5cm" 
                  margin-right="2.5cm">
                <fo:region-body margin-top="3cm"/>
                <fo:region-before extent="3cm"/>
                <fo:region-after extent="1.5cm"/>
            </fo:simple-page-master>
        </fo:layout-master-set>
  
        <fo:page-sequence master-reference="plantillaHist">
            <fo:flow flow-name="xsl-region-body">
                <xsl:apply-templates/>
            </fo:flow>
        </fo:page-sequence>
    </fo:root>	
</xsl:template>

<xsl:template match="titulo">
	<fo:block font-size="20pt" 
            font-family="sans-serif" 
            line-height="24pt"
            space-after.optimum="15pt"
            text-align="center"
            padding-top="3pt">
        <xsl:value-of select="."/>
  </fo:block>
</xsl:template>

<xsl:template match="intro">
	<fo:block font-size="14pt" 
            font-family="sans-serif" 
            line-height="15pt"
            space-after.optimum="5pt"
            text-align="justify">
      <xsl:value-of select="."/> 
  </fo:block>
</xsl:template>
<xsl:template match="historicos">                     
    <fo:table table-layout="fixed" width="375pt" border-width="1mm"
                border-style="ridge">
        <fo:table-column column-number="1"  column-width="65pt" />
        <fo:table-column column-number="2" column-width="80pt"/>
        <fo:table-column column-number="3" column-width="200pt"/>
        <fo:table-column column-number="4" column-width="120pt"/>
        <fo:table-body>
            <fo:table-row>
                <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
                <fo:block font-weight="bold">
                   Versión
                </fo:block>
                </fo:table-cell>
                <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
                <fo:block font-weight="bold">
                   Fecha
                </fo:block>
                </fo:table-cell>
                <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
                <fo:block font-weight="bold">
                   Razón de Cambio
                </fo:block>
                </fo:table-cell>
                <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
                <fo:block font-weight="bold">
                   Autor(es)
                </fo:block>
                </fo:table-cell> 
            </fo:table-row>
            <xsl:apply-templates/> 
        </fo:table-body> 
    </fo:table> 
    <fo:block>
            &#160;
    </fo:block>
</xsl:template>
<xsl:template match="historico">
        <fo:table-row>
        <xsl:apply-templates/> 
        </fo:table-row>
</xsl:template> 
<xsl:template match="version">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="fecha">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="razon">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="autor">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
</xsl:stylesheet>