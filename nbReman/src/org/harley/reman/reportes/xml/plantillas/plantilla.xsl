<?xml version="1.0" encoding="iso-8859-1" ?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="1.0"
>
<xsl:template match="libroEduccion">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master  master-name="plantillaEdu"
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
<xsl:template match="libroElicitacion">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master  master-name="plantillaEli"
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
<xsl:attribute-set name="bigCell">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">16mm</xsl:attribute>
  <xsl:attribute name="number-rows-spanned">4</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="big2Cells">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">16mm</xsl:attribute>
  <xsl:attribute name="number-rows-spanned">4</xsl:attribute>
  <xsl:attribute name="number-columns-spanned">2</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="mediumCell">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">11mm</xsl:attribute>
  <xsl:attribute name="number-rows-spanned">3</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="medium2Cells">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">11mm</xsl:attribute>
  <xsl:attribute name="number-rows-spanned">3</xsl:attribute>
  <xsl:attribute name="number-columns-spanned">2</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="oneCell">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">2mm</xsl:attribute>
  <xsl:attribute name="padding-bottom">1.3mm</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="twoCells">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">2mm</xsl:attribute>
  <xsl:attribute name="padding-bottom">1.3mm</xsl:attribute>
  <xsl:attribute name="number-columns-spanned">2</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="fourCells">
  <xsl:attribute name="border">solid 1mm black</xsl:attribute>
  <xsl:attribute name="padding-left">2mm</xsl:attribute>
  <xsl:attribute name="padding-top">2mm</xsl:attribute>
  <xsl:attribute name="padding-bottom">1.3mm</xsl:attribute>
  <xsl:attribute name="number-columns-spanned">4</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="whiteRed">
  <xsl:attribute name="color">white</xsl:attribute>
  <xsl:attribute name="background-color">rgb(255,0,0)</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="whiteYellow">
  <xsl:attribute name="color">white</xsl:attribute>
  <xsl:attribute name="background-color">rgb(255,192,0)</xsl:attribute>
</xsl:attribute-set>
<xsl:template match="intro">                       
    <xsl:apply-templates/>
</xsl:template>
<xsl:template match="titulo"> 
    <fo:block text-align="center" padding-left="1.8cm" margin="0cm">
        <fo:external-graphic src="src/org/harley/reman/img/img_1red.png" 
                             content-height="scale-to-fit" height="2.1cm" 
                             content-width="3.93cm" scaling="non-uniform"/>                 
    </fo:block>  
    <fo:block border-bottom-width="1pt" border-bottom-style="solid" 
              padding-top="4mm" border-bottom-color="rgb(140,180,225)">
    </fo:block>
    <fo:block font-family="cambria"  font-size="27pt" 
            padding-top="4mm"
            text-align="center"
            font-weight="bold">
            <xsl:apply-templates/>
    </fo:block>
    <fo:block border-bottom-width="1pt" border-bottom-style="solid" 
              margin-top="1mm" margin-bottom="1cm" 
              border-bottom-color="rgb(140,180,225)">
    </fo:block>
</xsl:template>
<xsl:template match="pro">  
        <fo:block-container border="1pt rgb(140,180,225)" border-style="dashed"
                            border-width="medium">
            <xsl:apply-templates/>
        </fo:block-container> 
</xsl:template>
<xsl:template match="proNom">  
        <fo:block padding-top="5mm" padding-left="0.9cm" margin="0cm">
            <fo:inline font-weight="bold">Proyecto: </fo:inline>
            <xsl:apply-templates/>
        </fo:block> 
</xsl:template>
<xsl:template match="empDes">                       
        <fo:block padding-left="0.9cm" margin="0cm">
            <fo:inline font-weight="bold">Empresa desarrolladora: </fo:inline>
            <xsl:apply-templates/>
        </fo:block> </xsl:template>
<xsl:template match="empCli">                       
        <fo:block padding-left="0.9cm" margin="0cm">
            <fo:inline font-weight="bold">Empresa cliente: </fo:inline>
            <xsl:apply-templates/>
        </fo:block> 
</xsl:template>
<xsl:template match="lidPro">                       
        <fo:block padding-left="0.9cm" margin="0cm">
            <fo:inline font-weight="bold">Líder del proyecto: </fo:inline>
            <xsl:apply-templates/>
        </fo:block> 
</xsl:template>
<xsl:template match="estPro">                       
        <fo:block padding-left="0.9cm" margin="0cm">
            <fo:inline font-weight="bold">Estado del proyecto: </fo:inline>
            <xsl:apply-templates/>
        </fo:block> 
</xsl:template>
<xsl:template match="fecIni">                       
        <fo:block padding-left="0.9cm" margin="0cm">
            <fo:inline font-weight="bold">Fecha inicial: </fo:inline>
            <xsl:apply-templates/>
        </fo:block>
</xsl:template>
<xsl:template match="fecFin">                       
        <fo:block margin-bottom="5mm" padding-left="0.9cm" margin="0cm">
            <fo:inline font-weight="bold">Fecha final: </fo:inline>
            <xsl:apply-templates/>
        </fo:block>
</xsl:template>
<xsl:template match="fecAct">    
        <fo:block text-align="center" padding-top="20pt" padding-left="1.8cm" margin="0cm">
            <fo:external-graphic src="src/org/harley/reman/img/img_2red.png" content-height="scale-to-fit" height="1.33cm"  content-width="2.1cm" scaling="non-uniform"/>                 
        </fo:block>                       
        <fo:block font-weight="bold" text-align="center" padding-top="290pt">
           <xsl:apply-templates/>
        </fo:block>
</xsl:template>
<xsl:template match="lugar">                       
        <fo:block font-weight="bold" text-align="center">
           <xsl:apply-templates/>
        </fo:block>
</xsl:template>
<xsl:template match="educciones" >
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
<xsl:template match="eduNombre">
   <fo:table-row xsl:use-attribute-sets="whiteRed" font-weight="bold">
        <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduCod">
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
            <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="eduNom">
        <fo:table-cell  xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="eduVer">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
           Version
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduTip">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Tipo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduObj">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Objetivo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduFec">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Fecha
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduFueNom">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="mediumCell">
        <fo:block font-weight="bold">
            Fuente
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Nombre
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduFueCar">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Cargo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduFueTip">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Tipo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduEspNom">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="bigCell">
        <fo:block font-weight="bold">
            Especialista
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Nombre
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduEspEsp">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Especialidad
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduEspExp">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Experiencia
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduEspCar">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Cargo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduDes">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Descripción
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell  xsl:use-attribute-sets="oneCell" 
                        number-columns-spanned="2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eduObs">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Observaciones
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell  xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>

<xsl:template match="elicitaciones" >
    <xsl:apply-templates/>
</xsl:template>
<xsl:template match="elicitacion">
    <fo:table keep-together.within-page="always" table-layout="fixed" width="375pt">
        <fo:table-column column-number="1" column-width="85pt"/>
        <fo:table-column column-number="2" column-width="15pt"/>
        <fo:table-column column-number="3" column-width="115pt"/>
        <fo:table-column column-number="4" column-width="230pt"/>
        <fo:table-body>
            <xsl:apply-templates/> 
        </fo:table-body> 
    </fo:table>
    <fo:block>
            &#160;
    </fo:block>
</xsl:template>
<xsl:template match="eliNombre">
   <fo:table-row xsl:use-attribute-sets="whiteYellow" font-weight="bold">
        <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliCod">
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
            <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="eliNom">
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="eliEduCod">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
           Educción Nº
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliVer">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
           Version
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
      <xsl:apply-templates/>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliFec">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
            Fecha
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliFueNom">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="medium2Cells">
        <fo:block font-weight="bold">
            Fuente
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Nombre
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliFueCar">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Cargo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliFueTip">
   <fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Tipo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliEspNom">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="big2Cells">
        <fo:block font-weight="bold">
            Especialista
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Nombre
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliEspEsp">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Especialidad
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliEspExp">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Experiencia
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliEspCar">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block font-weight="bold">
            Cargo
        </fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="oneCell">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliDep">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
            Dependencias
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliDes">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
            Descripción
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliPre">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
            Pre-Condición
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliSec">
   <xsl:variable name="cols" select="@number" />
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell" number-rows-spanned="{$cols}">
        <fo:block font-weight="bold">
            Secuencia Normal
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
<xsl:template match="pasNum">
        <fo:table-cell xsl:use-attribute-sets="oneCell">
            <fo:block >
               <xsl:apply-templates/>
            </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="pasDes">
        <fo:table-cell xsl:use-attribute-sets="twoCells">
            <fo:block >
               <xsl:apply-templates/>
            </fo:block>
        </fo:table-cell>
</xsl:template>
<xsl:template match="eliPos">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
            Post-Condición
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
<xsl:template match="eliExc">
    <xsl:variable name="cols" select="@number" />
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="oneCell" number-rows-spanned="{$cols}">
        <fo:block font-weight="bold">
            Excepcion
        </fo:block>
        </fo:table-cell> 
   </fo:table-row>
   <xsl:apply-templates/>
</xsl:template>
<xsl:template match="eliObs">
   <fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block font-weight="bold">
            Observaciones
        </fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="twoCells">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
        </fo:table-cell>
   </fo:table-row>
</xsl:template>
</xsl:stylesheet>