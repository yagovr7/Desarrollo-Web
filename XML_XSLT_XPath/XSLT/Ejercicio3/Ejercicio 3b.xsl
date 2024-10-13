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
				  </tr>
				
				 <xsl:for-each select="//hardware">
				    <tr>
				      <td><xsl:value-of select="../@nombre"/></td>

				      <td><xsl:value-of select="procesador/@marca"/>-<xsl:value-of select="procesador"/>
				 	 </td>

				      <td>
				      	<xsl:value-of select="memoria"/> GB <xsl:value-of select="memoria/@tecnología"/>
				      </td>
				    </tr>
				  </xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>