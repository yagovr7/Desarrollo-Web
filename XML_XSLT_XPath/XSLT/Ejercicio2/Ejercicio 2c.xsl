<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="html"/>

	<xsl:template match="cliente">
		<html>
			<head>
				<title>Cliente <xsl:value-of select="@cod"/></title>
			</head>
			<body>
					<xsl:element name="Cliente">
						<xsl:attribute name="cod">
							<xsl:value-of select="@cod"/>
						</xsl:attribute>
						<xsl:text>Cliente: </xsl:text>
						<xsl:value-of select="@cod"/>
					</xsl:element>
					<br/><br/>
					<xsl:element name="Numero_de_productos">
						<xsl:text>Numero de productos: </xsl:text>
							<xsl:value-of select="count(//producto)"/>
					</xsl:element>			
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
