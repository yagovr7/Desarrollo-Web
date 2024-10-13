<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output encoding="UTF-8" indent="yes" method="xml"/>
	<xsl:template match="cliente">
		<xsl:element name="{@cod}">
			<xsl:attribute name="num_productos">
				<xsl:value-of select="count(//producto)"/>
			</xsl:attribute>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>