<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>

	<xsl:template match="equipos">

		<equipos>
			
			<xsl:for-each select="máquina">
					
				<xsl:sort select="hardware/tipo"/>

					<xsl:element name="tipo">

						<xsl:attribute name="nombre_tipo">

							<xsl:value-of select="hardware/tipo"/>

						</xsl:attribute>

						<xsl:element name="máquina">

							<xsl:attribute name="nombre_tipo">

								<xsl:value-of select="@nombre"/>

							</xsl:attribute>

							<xsl:element name="hardware">

								<fabricante><xsl:value-of select="hardware/fabricante"/></fabricante>

							</xsl:element>

							<xsl:element name="config">

								<xsl:copy-of select="config/*"/>

							</xsl:element>

						</xsl:element>

					</xsl:element>

			</xsl:for-each>

		</equipos>
	</xsl:template>
</xsl:stylesheet>