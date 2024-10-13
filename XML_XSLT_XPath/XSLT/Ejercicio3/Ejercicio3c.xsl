<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="html"/>
	<xsl:template match="equipos">
		<html>
			<head>
				<title>Taboa maquinas</title>
			</head>

			<body>
				<h1>Taboa das maquinas</h1>
				<table border="1" >
				  <tr>
				    <th>Maquina</th>
				    <th>Procesador</th>
				    <th>Memoria</th>
				    <th>Disco(s)</th>
				  </tr>
                <xsl:for-each select="//hardware">
				  <tr>
				    <td>
						<a href="http://{//IP}">
						<xsl:value-of select="../@nombre"/></a>
					</td>
                    <td>
                        <xsl:value-of select="procesador/@marca"/>
                        <xsl:text>-</xsl:text>
                        <xsl:value-of select="procesador"/>
                    </td>
                    <td>
                        <xsl:value-of select="memoria"/>
                        <xsl:text> GB </xsl:text>
                        <xsl:value-of select="memoria/@tecnología"/>
                    </td>
                    <td>
                        <xsl:value-of select="disco/@capacidad"/>GB 
                        (<xsl:value-of select="disco/@tecnología"/>)
                    </td>
                </tr>
                </xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>