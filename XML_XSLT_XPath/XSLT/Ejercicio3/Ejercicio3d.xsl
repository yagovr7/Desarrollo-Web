<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>
	<xsl:template match="equipos">
		<máquinas>

			
		<xsl:for-each select="//hardware">
			<xsl:element name="máquina">

				<xsl:attribute name="tipo">
					<xsl:value-of select="tipo"/>
				</xsl:attribute>

				<xsl:attribute name="fabricante">
					<xsl:value-of select="fabricante"/>
				</xsl:attribute>

				<xsl:attribute name="procesador">
					<xsl:value-of select="procesador/@marca"/><xsl:text> </xsl:text><xsl:value-of select="procesador/@num_nucleos"/><xsl:text> nucleos a </xsl:text><xsl:value-of select="procesador/@velocidad"/><xsl:text> GHz</xsl:text>
				</xsl:attribute>

				<xsl:attribute name="discos">
					<xsl:value-of select="count(disco)"/><xsl:text> con </xsl:text><xsl:value-of select="sum(disco/@capacidad)"/><xsl:text>GB </xsl:text>
				</xsl:attribute>

			</xsl:element>
		</xsl:for-each>
		</máquinas>
	</xsl:template>
</xsl:stylesheet>