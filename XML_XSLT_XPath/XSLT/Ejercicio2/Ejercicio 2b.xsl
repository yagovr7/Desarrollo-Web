<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="text"/>
	<xsl:template match="producto">
			<xsl:value-of select="@cod"/>	
	</xsl:template>
</xsl:stylesheet>