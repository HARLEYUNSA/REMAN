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

<xsl:template match="educciones">                     
    <fo:table table-layout="fixed" width="375pt" border-width="1mm"
                border-style="ridge">
        <fo:table-column column-number="1"  column-width="100pt" />
        <fo:table-column column-number="2" column-width="20pt"/>
        <fo:table-column column-number="3" column-width="20pt"/>
        <fo:table-column column-number="4" column-width="50pt"/>
        <fo:table-column column-number="5" column-width="90pt"/>
        <fo:table-column column-number="6" column-width="80pt"/>
        <fo:table-column column-number="7" column-width="100pt"/>
        <fo:table-body>
            <xsl:apply-templates/> 
        </fo:table-body> 
    </fo:table> 
    <fo:block>
            &#160;
    </fo:block>
</xsl:template>
<xsl:template match="educcion">
    <xsl:apply-templates/>
</xsl:template>
<xsl:template match="educcionNombre">
   <fo:table-row>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="codigo">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
           EDU <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="nombre">
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm" 
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="6">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
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
                        number-columns-spanned="5">
        <fo:block>
           .
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="actor">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Actor
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="6">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="cargo">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block font-weight="bold">
            Cargo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="6">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="especialista">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="16mm" padding-bottom="1.3mm"
                        number-rows-spanned="4">
        <fo:block font-weight="bold">
            Especialista
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block font-weight="bold">
            Nombre
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
<xsl:template match="especialEspecial">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block font-weight="bold">
            Especialidad
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
<xsl:template match="especialTipo">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block font-weight="bold">
            Tipo
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
<xsl:template match="especialExp">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block font-weight="bold">
            Experiencia
        </fo:block>
        </fo:table-cell>
        <fo:table-cell border-style="solid"
                       border-width="0.5mm"
                       padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                       number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="educcionTipo">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="11mm" padding-bottom="1.3mm"
                        number-rows-spanned="3">
        <fo:block font-weight="bold">
            Educción
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block font-weight="bold">
            Tipo
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
<xsl:template match="educcionObj">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="3">
        <fo:block font-weight="bold">
            Objetivo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell border-style="solid"
                       border-width="0.5mm"
                       padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                       number-columns-spanned="3">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="educcionFecha">
   <fo:table-row>
        <fo:table-cell border-style="solid"
                       border-width="0.5mm"
                       padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                       number-columns-spanned="3">
        <fo:block font-weight="bold">
            Fecha
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
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="7">
        <fo:block text-align="center" font-weight="bold">
            Educción
        </fo:block>
        </fo:table-cell>
    </fo:table-row> 
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block text-align="center">
            Descripción
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="6">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="observaciones">
   <fo:table-row>
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm">
        <fo:block text-align="center">
            Observaciones
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell  border-style="solid"
                        border-width="0.5mm"
                        padding-left="2mm" padding-top="2mm" padding-bottom="1.3mm"
                        number-columns-spanned="6">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
</xsl:stylesheet>