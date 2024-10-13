<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="html"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>Lista das maquinas</title>
			</head>

			<body>
				<h1>Maquinas</h1>
				<br/>
				<a href="http://192.168.20.105">
					<xsl:value-of select="//máquina[1]/@nombre"/>
				</a><br/>
				<a href="http://192.168.20.10">
					<xsl:value-of select="//máquina[2]/@nombre"/>
				</a>
				<br/>
				<h1><xsl:value-of select="//máquina[1]/@nombre"/></h1>
				<br/>
				<ul>
					<li><xsl:value-of select="//máquina[1]/hardware/tipo"/></li>
					<li><xsl:value-of select="//máquina[1]/hardware/fabricante"/></li>
					<li><xsl:value-of select="//máquina[1]/hardware/procesador"/></li>
					<li><xsl:text>Memoria: </xsl:text><xsl:value-of select="//máquina[1]/hardware/memoria"/><xsl:text>GB</xsl:text></li>
					<li><xsl:text>Disco: </xsl:text><xsl:value-of select="//máquina[1]/hardware/disco/@capacidad"/><xsl:text>GB</xsl:text></li>
					<li><xsl:text>Grabadora </xsl:text><xsl:text>de </xsl:text><xsl:value-of select="//máquina[1]/hardware/grabadora/@tipo"/></li>
				</ul>

				<br/>
				<h1><xsl:value-of select="//máquina[2]/@nombre"/></h1>
				<br/>
				<ul>
					<li><xsl:value-of select="//máquina[2]/hardware/tipo"/></li>
					<li><xsl:value-of select="//máquina[2]/hardware/fabricante"/></li>
					<li><xsl:value-of select="//máquina[2]/hardware/procesador"/></li>
					<li><xsl:text>Memoria: </xsl:text><xsl:value-of select="//máquina[2]/hardware/memoria"/><xsl:text>GB</xsl:text></li>
					<li><xsl:text>Disco: </xsl:text><xsl:value-of select="//máquina[2]/hardware/disco[1]/@capacidad"/><xsl:text>GB</xsl:text></li>
					<li><xsl:text>Disco: </xsl:text><xsl:value-of select="//máquina[2]/hardware/disco[2]/@capacidad"/><xsl:text>GB</xsl:text></li>
					<li><xsl:text>Disco: </xsl:text><xsl:value-of select="//máquina[2]/hardware/disco[3]/@capacidad"/><xsl:text>GB</xsl:text></li>
					<li><xsl:text>Lectora </xsl:text><xsl:text>de </xsl:text><xsl:value-of select="//máquina[2]/hardware/lectora/@tipo"/></li>
				</ul>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>