<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>
	<xsl:template match="equipos">
			<discos>
				<xsl:apply-templates select="//disco"/>
			</discos>
	</xsl:template>

	<xsl:template match="disco">
		<xsl:element name="disco">
		<xsl:attribute name="tecnología">
			<xsl:value-of select="@tecnología"/>
		</xsl:attribute>
		<xsl:attribute name="capacidad">
			<xsl:value-of select="@capacidad"/>
		</xsl:attribute>
		<xsl:attribute name="máquina">
			<xsl:value-of select="../../@nombre"/>
		</xsl:attribute>
	</xsl:element>
	</xsl:template>
</xsl:stylesheet>