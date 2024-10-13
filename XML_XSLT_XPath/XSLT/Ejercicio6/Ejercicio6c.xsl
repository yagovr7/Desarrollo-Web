<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="html"/>
	<xsl:template match="equipos">
		<html>
			<head>
				<title>Taboa maquinas</title>
			</head>

			<body>

				<table border="1">

					<tr>
						<th>Maquinas</th>
						<th>Tipo</th>
						<th>OS</th>
						<th>Capacidade HD</th>
					</tr>
					<xsl:for-each select="//hardware">
						<xsl:sort select="tipo"/>
						<xsl:sort select="../@nombre"/>
						<tr>
							<xsl:choose>
								<xsl:when test="tipo='Semitorre' or tipo='PC Sobremesa' and ../config/OS= 'Windows' ">
									<td bgcolor="yellow"><xsl:value-of select="../@nombre[.!=contains(.,'PR')]"/></td>
									<td bgcolor="yellow"><xsl:value-of select="tipo[.!=contains(.,'Impresora')]"/></td>
									<td bgcolor="yellow"><xsl:value-of select="../config/OS"/></td>
				          			<td><xsl:value-of select="disco/@capacidad[tipo!=starts-with(.,'Impresora')]"/> GB</td>
								</xsl:when>
								<xsl:otherwise>
									<td><xsl:value-of select="../@nombre[.!=contains(.,'PR')]"/></td>
				          			<td><xsl:value-of select="tipo[.!=contains(.,'Impresora')]"/></td>
				          			<td><xsl:value-of select="../config/OS"/></td>
				          			<td><xsl:value-of select="disco/@capacidad[tipo!=starts-with(.,'Impresora')]"/> GB</td>
				       		 </xsl:otherwise>
				      		</xsl:choose>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>