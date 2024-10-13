<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>

	<xsl:template match="equipos">

		<equipos>
			
			<xsl:for-each select="máquina[notas]">
			
						<xsl:element name="máquina">

							<xsl:attribute name="nombre">

								<xsl:value-of select="@nombre"/>

							</xsl:attribute>

							<nota>

								<xsl:value-of select="notas"/>

							</nota>
								
						</xsl:element>

			</xsl:for-each>

		</equipos>
	</xsl:template>
</xsl:stylesheet>