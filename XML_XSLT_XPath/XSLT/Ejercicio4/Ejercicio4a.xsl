<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="html"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>Horario ASIR Ordinario</title>
			</head>
			<h1>Horario ASIR Ordinario, ano 2013</h1>
			<body>
				<table border="1" >
					<tr>
						<th style=" border: none" ></th>
						<th>Inicio</th>
						<th>Fin</th>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[1]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[1]/inicio"/></td>
						<td><xsl:value-of select="//hora[1]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[2]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[2]/inicio"/></td>
						<td><xsl:value-of select="//hora[2]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[3]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[3]/inicio"/></td>
						<td><xsl:value-of select="//hora[3]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[4]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[4]/inicio"/></td>
						<td><xsl:value-of select="//hora[4]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[5]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[5]/inicio"/></td>
						<td><xsl:value-of select="//hora[5]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[6]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[6]/inicio"/></td>
						<td><xsl:value-of select="//hora[6]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[7]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[7]/inicio"/></td>
						<td><xsl:value-of select="//hora[7]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[8]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[8]/inicio"/></td>
						<td><xsl:value-of select="//hora[8]/fin"/></td>
					</tr>
					<tr>
						<th><xsl:value-of select="//hora[9]/@id"/><xsl:text> Hora</xsl:text></th>
						<td><xsl:value-of select="//hora[9]/inicio"/></td>
						<td><xsl:value-of select="//hora[9]/fin"/></td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>

