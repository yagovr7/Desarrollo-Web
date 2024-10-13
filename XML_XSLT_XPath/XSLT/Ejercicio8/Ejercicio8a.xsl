<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>

		<xsl:template match="horario">

			<materias>

				<xsl:for-each select="dia">

					<xsl:element name="dia">

						<xsl:attribute name="num">

							<xsl:value-of select="@num"/>

						</xsl:attribute>

					</xsl:element>

				</xsl:for-each>

			</materias>

		</xsl:template>

</xsl:stylesheet>