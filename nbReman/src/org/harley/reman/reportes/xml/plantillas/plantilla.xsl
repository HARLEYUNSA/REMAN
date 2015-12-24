<?xml version="1.0" encoding="iso-8859-1" ?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="1.0">
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
<xsl:template match="libroEspecificacion">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master  master-name="plantillaEsp"
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
        <fo:page-sequence master-reference="plantillaEsp">
            <fo:flow flow-name="xsl-region-body">
                <xsl:apply-templates/>
            </fo:flow>
        </fo:page-sequence>
    </fo:root>	
</xsl:template>
<xsl:template match="libroRequisitosNF">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master  master-name="plantillaRnf"
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
        <fo:page-sequence master-reference="plantillaRnf">
            <fo:flow flow-name="xsl-region-body">
                <xsl:apply-templates/>
            </fo:flow>
        </fo:page-sequence>
    </fo:root>	
</xsl:template>
<xsl:template match="libroActores">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master  master-name="plantillaAct"
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
        <fo:page-sequence master-reference="plantillaAct">
            <fo:flow flow-name="xsl-region-body">
                <xsl:apply-templates/>
            </fo:flow>
        </fo:page-sequence>
    </fo:root>	
</xsl:template>
<xsl:template match="libroOrganizacion">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master  master-name="plantillaOrg"
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
        <fo:page-sequence master-reference="plantillaOrg">
            <fo:flow flow-name="xsl-region-body">
                <xsl:apply-templates/>
            </fo:flow>
        </fo:page-sequence>
    </fo:root>	
</xsl:template>
<xsl:attribute-set name="row4col1">
	<xsl:attribute name="border">solid 0.1cm black</xsl:attribute>
	<xsl:attribute name="padding-left">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-top">1.6cm</xsl:attribute>
	<xsl:attribute name="number-rows-spanned">4</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="row4col2">
	<xsl:attribute name="border">solid 0.1cm black</xsl:attribute>
	<xsl:attribute name="padding-left">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-top">1.6cm</xsl:attribute>
	<xsl:attribute name="number-rows-spanned">4</xsl:attribute>
	<xsl:attribute name="number-columns-spanned">2</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="row3col1">
	<xsl:attribute name="border">solid 0.1cm black</xsl:attribute>
	<xsl:attribute name="padding-left">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-top">1.1cm</xsl:attribute>
	<xsl:attribute name="number-rows-spanned">3</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="row3col2">
	<xsl:attribute name="border">solid 0.1cm black</xsl:attribute>
	<xsl:attribute name="padding-left">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-top">1.1cm</xsl:attribute>
	<xsl:attribute name="number-rows-spanned">3</xsl:attribute>
	<xsl:attribute name="number-columns-spanned">2</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="cell">
	<xsl:attribute name="border">solid 0.1cm black</xsl:attribute>
	<xsl:attribute name="padding-left">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-top">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-bottom">0.13cm</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="cell2">
	<xsl:attribute name="border">solid 0.1cm black</xsl:attribute>
	<xsl:attribute name="padding-left">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-top">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-bottom">0.13cm</xsl:attribute>
	<xsl:attribute name="number-columns-spanned">2</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="cell4">
	<xsl:attribute name="border">solid 0.1cm black</xsl:attribute>
	<xsl:attribute name="padding-left">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-top">0.2cm</xsl:attribute>
	<xsl:attribute name="padding-bottom">0.13cm</xsl:attribute>
	<xsl:attribute name="number-columns-spanned">4</xsl:attribute>                      
</xsl:attribute-set>
<xsl:attribute-set name="title">
	<xsl:attribute name="padding-left">0.9cm</xsl:attribute>
	<xsl:attribute name="margin">0cm</xsl:attribute>                   
</xsl:attribute-set>
<xsl:attribute-set name="title-top">
	<xsl:attribute name="padding-top">0.5cm</xsl:attribute>
	<xsl:attribute name="padding-left">0.9cm</xsl:attribute>
	<xsl:attribute name="margin">0cm</xsl:attribute>                   
</xsl:attribute-set>
<xsl:attribute-set name="title-bottom">
	<xsl:attribute name="margin-bottom">0.5cm</xsl:attribute>
	<xsl:attribute name="padding-left">0.9cm</xsl:attribute>
	<xsl:attribute name="margin">0cm</xsl:attribute>                   
</xsl:attribute-set>
<xsl:attribute-set name="whiteRed">
	<xsl:attribute name="color">white</xsl:attribute>
	<xsl:attribute name="background-color">rgb(255,0,0)</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="whiteYellow">
	<xsl:attribute name="color">white</xsl:attribute>
	<xsl:attribute name="background-color">rgb(255,192,0)</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="whiteGreen">
	<xsl:attribute name="color">white</xsl:attribute>
	<xsl:attribute name="background-color">rgb(0,128,0)</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="whiteGray">
	<xsl:attribute name="color">white</xsl:attribute>
	<xsl:attribute name="background-color">rgb(166,166,166)</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="whiteLightBlue">
	<xsl:attribute name="color">white</xsl:attribute>
	<xsl:attribute name="background-color">rgb(0,176,240)</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="whiteOrange">
	<xsl:attribute name="color">white</xsl:attribute>
	<xsl:attribute name="background-color">rgb(235,112,12)</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="borde">
	<xsl:attribute name="border">0.03cm rgb(140,180,225)</xsl:attribute>
	<xsl:attribute name="border-style">dashed</xsl:attribute>
	<xsl:attribute name="border-width">medium</xsl:attribute>
</xsl:attribute-set>
<xsl:template match="intro">                       
    <xsl:apply-templates/>
</xsl:template>
<xsl:template match="carTit"> 
    <fo:block text-align="center" padding-left="1.8cm" margin="0cm">
        <fo:external-graphic src="src/org/harley/reman/reportes/imagenes/img_1red.png" 
                             content-height="scale-to-fit" height="2.1cm" 
                             content-width="3.93cm" scaling="non-uniform"/>                 
    </fo:block>  
    <fo:block	border-bottom-width="0.03cm" border-bottom-style="solid" 
				padding-top="0.4cm" border-bottom-color="rgb(140,180,225)">
    </fo:block>
    <fo:block 	font-family="cambria"  font-size="27pt" 
				padding-top="0.4cm"
				text-align="center"
				font-weight="bold">
				<xsl:apply-templates/>
    </fo:block>
    <fo:block 	border-bottom-width="0.03cm" border-bottom-style="solid" 
				margin-bottom="1cm" 
				border-bottom-color="rgb(140,180,225)">
    </fo:block>
</xsl:template>
<xsl:template match="carPro">  
    <fo:block-container xsl:use-attribute-sets="borde">
		<xsl:apply-templates/>
    </fo:block-container>
</xsl:template>
<xsl:template match="proNom">  
    <fo:block xsl:use-attribute-sets="title-top">
        <fo:inline font-weight="bold">Proyecto: </fo:inline>
        <xsl:apply-templates/>
    </fo:block> 
</xsl:template>
<xsl:template match="empDes">                       
    <fo:block xsl:use-attribute-sets="title">
        <fo:inline font-weight="bold">Empresa desarrolladora: </fo:inline>
        <xsl:apply-templates/>
    </fo:block>
</xsl:template>
<xsl:template match="empCli">                       
    <fo:block xsl:use-attribute-sets="title">
        <fo:inline font-weight="bold">Empresa cliente: </fo:inline>
        <xsl:apply-templates/>
    </fo:block> 
</xsl:template>
<xsl:template match="lidPro">                       
    <fo:block xsl:use-attribute-sets="title">
        <fo:inline font-weight="bold">Líder del proyecto: </fo:inline>
        <xsl:apply-templates/>
    </fo:block> 
</xsl:template>
<xsl:template match="estPro">                       
    <fo:block xsl:use-attribute-sets="title">
        <fo:inline font-weight="bold">Estado del proyecto: </fo:inline>
        <xsl:apply-templates/>
    </fo:block> 
</xsl:template>
<xsl:template match="fecIni">                       
    <fo:block xsl:use-attribute-sets="title">
        <fo:inline font-weight="bold">Fecha inicial: </fo:inline>
        <xsl:apply-templates/>
    </fo:block>
</xsl:template>
<xsl:template match="fecFin">                       
    <fo:block xsl:use-attribute-sets="title-bottom">
        <fo:inline font-weight="bold">Fecha final: </fo:inline>
        <xsl:apply-templates/>
    </fo:block>
</xsl:template>
<xsl:template match="carFec">    
    <fo:block text-align="center" padding-top="0.7cm" padding-left="1.8cm" margin="0cm">
        <fo:external-graphic 	src="src/org/harley/reman/reportes/imagenes/img_2red.png" 
								content-height="scale-to-fit" 	height="1.33cm"  
								content-width="2.1cm" 			scaling="non-uniform"
		/>                 
    </fo:block>                       
    <fo:block font-weight="bold" text-align="center" padding-top="10cm">
        <xsl:apply-templates/>
    </fo:block>
</xsl:template>
<xsl:template match="carLug">                       
    <fo:block font-weight="bold" text-align="center">
        <xsl:apply-templates/>
    </fo:block>
</xsl:template>
<xsl:template match="tablas">
    <xsl:apply-templates/>
</xsl:template>
<xsl:template match="tabla">
    <fo:table keep-together.within-page="always" table-layout="fixed" width="16cm">
        <fo:table-column column-number="1" column-width="3cm"/>
        <fo:table-column column-number="2" column-width="0.9cm"/>
        <fo:table-column column-number="3" column-width="4cm"/>
        <fo:table-column column-number="4" column-width="8cm"/>  
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
<xsl:template match="eliNombre">
	<fo:table-row xsl:use-attribute-sets="whiteYellow" font-weight="bold">
        <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="espNombre">
	<fo:table-row xsl:use-attribute-sets="whiteGreen" font-weight="bold">
        <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="rnfNombre">
	<fo:table-row xsl:use-attribute-sets="whiteGray" font-weight="bold">
        <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="orgNombre">
	<fo:table-row xsl:use-attribute-sets="whiteLightBlue" font-weight="bold">
        <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="sthNombre">
	<fo:table-row xsl:use-attribute-sets="whiteGray" font-weight="bold">
        <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="pytNombre">
	<fo:table-row xsl:use-attribute-sets="whiteGray" font-weight="bold">
        <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="educcionCodigo">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
			   Educción Nº
			</fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
      <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="elicitacionCodigo">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
			   Elicitacion Nº
			</fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
      <xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="codigo">
    <fo:table-cell xsl:use-attribute-sets="cell2">
        <fo:block>
            <xsl:apply-templates/>
        </fo:block>
    </fo:table-cell>
</xsl:template>
<xsl:template match="nombre">
    <fo:table-cell  xsl:use-attribute-sets="cell2">
        <fo:block>
           <xsl:apply-templates/>
        </fo:block>
    </fo:table-cell>
</xsl:template>
<xsl:template match="version">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Version
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block>
				<xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
		<xsl:apply-templates/>
	</fo:table-row>
</xsl:template>
<xsl:template match="tipo">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Tipo
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block>
				<xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="objetivo">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Objetivo
			</fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="fecha">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Fecha
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="fuenteNombre">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="row3col2">
			<fo:block font-weight="bold">
				Fuente
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block font-weight="bold">
				Nombre
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="fuenteCargo">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block font-weight="bold">
				Cargo
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="fuenteTipo">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell">
			<fo:block font-weight="bold">
				Tipo
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="especialistaNombre">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="row4col2">
			<fo:block font-weight="bold">
				Especialista
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block font-weight="bold">
				Nombre
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="especialistaEspecialidad">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block font-weight="bold">
				Especialidad
        </fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="especialistaExperiencia">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block font-weight="bold">
				Experiencia
			</fo:block>
        </fo:table-cell>
        <fo:table-cell xsl:use-attribute-sets="cell">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="especialistaCargo">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block font-weight="bold">
				Cargo
			</fo:block>
        </fo:table-cell>
        <fo:table-cell  xsl:use-attribute-sets="cell">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="descripcion">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Descripción
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="observaciones">
	<fo:table-row>
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Observaciones
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell  xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="dependencias">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Dependencias
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="precondicion">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Pre-Condición
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="secuencia">
	<xsl:variable name="cols" select="@number" />
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell" number-rows-spanned="{$cols}">
			<fo:block font-weight="bold">
				Secuencia Normal
			</fo:block>
        </fo:table-cell> 
	</fo:table-row>
	<xsl:apply-templates/>
</xsl:template>
<xsl:template match="postcondicion">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Post-Condición
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="excepcion">
    <xsl:variable name="cols" select="@number" />
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell" number-rows-spanned="{$cols}">
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
<xsl:template match="pasNum">
    <fo:table-cell xsl:use-attribute-sets="cell">
        <fo:block >
            <xsl:apply-templates/>
        </fo:block>
    </fo:table-cell>
</xsl:template>
<xsl:template match="pasDes">
	<fo:table-cell xsl:use-attribute-sets="cell2">
        <fo:block >
            <xsl:apply-templates/>
        </fo:block>
    </fo:table-cell>
</xsl:template>

<xsl:template match="direccion">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Dirección
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="telefonos">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Teléfonos
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="paginaWeb">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Página Web
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="email">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Correo Electrónico
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="comentarios">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Comentarios
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="organizacion">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Organizacion
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="cargo">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Cargo
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="especialidad">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Especialidad
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
<xsl:template match="experiencia">
	<fo:table-row>
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block font-weight="bold">
				Experiencia
			</fo:block>
        </fo:table-cell> 
        <fo:table-cell xsl:use-attribute-sets="cell2">
			<fo:block>
			   <xsl:apply-templates/>
			</fo:block>
        </fo:table-cell>
	</fo:table-row>
</xsl:template>
</xsl:stylesheet>