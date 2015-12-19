<?xml version="1.0" encoding="iso-8859-1" ?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="1.0">
<xsl:template match="libroElicitacion">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="plantillaEli"
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
  
        <fo:page-sequence master-reference="plantillaEli">
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
<xsl:template match="elicitaciones">                     
    <xsl:apply-templates/>
    <fo:block>
            &#160;
    </fo:block>
</xsl:template>
<xsl:template match="elicitacion">                     
    <fo:table keep-together.within-page="always" table-layout="fixed" width="375pt" border-width="1mm"
                border-style="ridge">
        <fo:table-column column-number="1"  column-width="110pt" />
        <fo:table-column column-number="2" column-width="15pt"/>
        <fo:table-column column-number="3" column-width="25pt"/>
        <fo:table-column column-number="4" column-width="290pt"/>        
        <fo:table-body>
            <xsl:apply-templates/> 
        </fo:table-body> 
    </fo:table> 
    <fo:block>
            &#160;
    </fo:block>
</xsl:template>
<xsl:template match="elicitacionNombre">
   <fo:table-row>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="codigo">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
           ELI <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="nombre">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm" 
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="eduNombre">
    <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
           Educción Nº
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block font-weight="bold">
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
    </fo:table-row>
</xsl:template>
<xsl:template match="version">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
           Version
        </fo:block>
        </fo:table-cell>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="vMax">
        <fo:table-cell  border-style="solid"
                        border-width="0mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block text-align="right">
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="vMin">
        <fo:table-cell  border-style="solid"
                        border-width="0mm"
                        padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="2">
        <fo:block>
           .
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="autor">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Autor
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="fuentes">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Fuentes
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="dependencias">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Dependencias
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="descripcion">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Descripción
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="precondicion">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Precondicion
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="secNormal">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-rows-spanned="3">
            <fo:block font-weight="bold">
           Secuencia Normal
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
   <xsl:apply-templates/>
</xsl:template>
<xsl:template match="secExc">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-rows-spanned="3">
            <fo:block font-weight="bold">
            Excepciones
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
   <xsl:apply-templates/>
</xsl:template>
<xsl:template match="paso">
   <fo:table-row>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="pasoNum">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="pasoDes">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="comentarios">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Comentarios
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
</xsl:stylesheet>