<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>
	<xsl:template match="/">
		<xsl:for-each select="equipos">
<xsl:sort select="//máquina/@nombre"/>
			<xsl:copy-of select="máquina[starts-with(@nombre, 'PC')]"/>

		</xsl:for-each>
		
	</xsl:template>
</xsl:stylesheet>