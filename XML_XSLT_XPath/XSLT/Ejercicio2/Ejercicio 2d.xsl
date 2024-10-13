<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="text"/>

	<xsl:template match="producto">
		<xsl:text>Producto de la familia </xsl:text>
		<xsl:value-of select="substring(@cod,1,4)"/>
		<xsl:text> con codigo </xsl:text>
		<xsl:value-of select="substring(@cod,5,3)"/>
		<xsl:text> para el cliente de codigo </xsl:text>
		<xsl:value-of select="//cliente/@cod"/>
	</xsl:template>
</xsl:stylesheet>