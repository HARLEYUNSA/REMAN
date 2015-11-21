<?xml version="1.0" encoding="iso-8859-1" ?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="1.0">
<xsl:template match="libroEduccion">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="plantillaEdu"
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
        <fo:page-sequence master-reference="plantillaEdu">
            <fo:flow flow-name="xsl-region-body">
                <xsl:apply-templates/>
            </fo:flow>
        </fo:page-sequence>
    </fo:root>	
</xsl:template>
<xsl:template match="titulo">
	<fo:block font-size="18pt" 
            font-family="candara" 
            text-align="center"
            padding-top="3pt"
            padding-bottom="10pt"
            font-weight="bold">
        <xsl:value-of select="."/>
  </fo:block>
</xsl:template>
<xsl:template match="intro">
	<fo:block font-size="18pt" 
            font-family="candara" 
            text-align="center"
            padding-bottom="10pt">
      <xsl:value-of select="."/> 
  </fo:block>
</xsl:template>
<xsl:attribute-set name="bigCell">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">16mm</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="mediumCell">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">11mm</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="myCell">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">2mm</xsl:attribute>
  <xsl:attribute name="padding-bottom">1.3mm</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="myColor">
  <xsl:attribute name="color">white</xsl:attribute>
  <xsl:attribute name="background-color">rgb(255, 0, 0)</xsl:attribute>
</xsl:attribute-set>
<xsl:template match="educciones">                       
    <xsl:apply-templates/>
</xsl:template>
<xsl:template match="educcion">
    <fo:table keep-together.within-page="always" table-layout="fixed" width="375pt">
        <fo:table-column column-number="1" column-width="100pt" />
        <fo:table-column column-number="2" column-width="115pt"/>
        <fo:table-column column-number="3" column-width="230pt"/>
        <fo:table-body>
            <xsl:apply-templates/> 
        </fo:table-body> 
    </fo:table>
    <fo:block>
            &#160;
    </fo:block>
</xsl:template>
<xsl:template match="educcionNombre">
   <fo:table-row xsl:use-attribute-sets="myColor" font-weight="bold">
        <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="codigo">
        <fo:table-cell xsl:use-attribute-sets="myCell">
        <fo:block>
           EDU <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="nombre">
        <fo:table-cell  xsl:use-attribute-sets="myCell"
                        number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="version">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
           Version
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell"
                        number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="fuente">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Fuente
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell" 
                        number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="cargo">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Cargo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="myCell"
                       number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="especialNombre">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="bigCell"
                        number-rows-spanned="4">
        <fo:block font-weight="bold">
            Especialista
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Nombre
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="especialEspecial">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Especialidad
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="especialTipo">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Tipo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="especialExp">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Experiencia
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="myCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="educcionTipo">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="mediumCell"
                        number-rows-spanned="3">
        <fo:block font-weight="bold">
            Educción
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Tipo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="educcionObj">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Objetivo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="myCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="educcionFecha">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Fecha
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="descripcion">
    <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="myCell myColor"
                        number-columns-spanned="3">
        <fo:block text-align="center" font-weight="bold">
            Educción
        </fo:block>
        </fo:table-cell>
    </fo:table-row> 
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Descripción
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell  xsl:use-attribute-sets="myCell" 
                        number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="observaciones">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="myCell">
        <fo:block font-weight="bold">
            Observaciones
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell  xsl:use-attribute-sets="myCell"
                        number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
</xsl:stylesheet>