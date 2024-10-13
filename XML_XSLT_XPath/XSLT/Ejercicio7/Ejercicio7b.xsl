<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>

	<xsl:template match="equipos">

		<equipos>
			
			<xsl:for-each select="máquina[config/IP]">

				<xsl:choose>

					<xsl:when  test="config/IP[starts-with(., '192')]">
					
						<xsl:element name="máquina">

							<xsl:attribute name="nombre">

								<xsl:value-of select="@nombre"/>

							</xsl:attribute>

							<xsl:copy-of select="config/IP"/>
							<máscara>255.255.255.0</máscara>
							<xsl:copy-of select="config/gateway"/>

						</xsl:element>

					</xsl:when>

			</xsl:choose>

			</xsl:for-each>

		</equipos>
	</xsl:template>
</xsl:stylesheet>