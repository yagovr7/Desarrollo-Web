<?xml version="1.0" encoding="UTF-8"?>
	<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
		<xsl:output encoding="UTF-8" indent="yes" method="xml"/>

		<xsl:template match="horario">

			<xsl:element name="materias">

				<xsl:for-each select="dia">

				<materia><xsl:value-of select="distinct-values((materia/@nombre))"/></materia>

				</xsl:for-each>

			</xsl:element>

		</xsl:template>

	</xsl:stylesheet>