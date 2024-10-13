<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/>
	<xsl:template match="/">
		<xsl:element name="materias">

			<xsl:element name="dia">

				<xsl:attribute name="num">
					<xsl:value-of select="//dia[1]/@num"/>
				</xsl:attribute>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[1]/materia[1]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[1]/materia[1]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[1]/materia[2]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[1]/materia[2]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[1]/materia[3]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[1]/materia[3]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[1]/materia[4]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[1]/materia[4]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[1]/materia[5]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[1]/materia[5]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[1]/materia[6]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[1]/materia[6]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[1]/materia[7]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[1]/materia[7]/@nombre"/>
					</xsl:attribute>

				</xsl:element>
			</xsl:element>

			<xsl:element name="dia">

				<xsl:attribute name="num">
					<xsl:value-of select="//dia[2]/@num"/>
				</xsl:attribute>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[2]/materia[1]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[2]/materia[1]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[2]/materia[2]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[2]/materia[2]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[2]/materia[3]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[2]/materia[3]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[2]/materia[4]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[2]/materia[4]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[2]/materia[5]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[2]/materia[5]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[2]/materia[6]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[2]/materia[6]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[2]/materia[7]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[2]/materia[7]/@nombre"/>
					</xsl:attribute>

				</xsl:element>
			</xsl:element>

			<xsl:element name="dia">

				<xsl:attribute name="num">
					<xsl:value-of select="//dia[3]/@num"/>
				</xsl:attribute>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[1]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[1]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[2]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[2]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[3]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[3]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[4]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[4]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[5]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[5]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[6]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[6]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[7]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[7]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[8]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[8]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[3]/materia[9]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[3]/materia[9]/@nombre"/>
					</xsl:attribute>

				</xsl:element>
			</xsl:element>
			<xsl:element name="dia">

				<xsl:attribute name="num">
					<xsl:value-of select="//dia[4]/@num"/>
				</xsl:attribute>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[4]/materia[1]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[4]/materia[1]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[4]/materia[2]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[4]/materia[2]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[4]/materia[3]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[4]/materia[3]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[4]/materia[4]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[4]/materia[4]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[4]/materia[5]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[4]/materia[5]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[4]/materia[6]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[4]/materia[6]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[4]/materia[7]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[4]/materia[7]/@nombre"/>
					</xsl:attribute>

				</xsl:element>
			</xsl:element>

				<xsl:element name="dia">

				<xsl:attribute name="num">
					<xsl:value-of select="//dia[5]/@num"/>
				</xsl:attribute>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[5]/materia[1]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[5]/materia[1]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[5]/materia[2]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[5]/materia[2]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[5]/materia[3]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[5]/materia[3]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[5]/materia[4]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[5]/materia[4]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[5]/materia[5]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[5]/materia[5]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[5]/materia[6]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[5]/materia[6]/@nombre"/>
					</xsl:attribute>

				</xsl:element>

				<xsl:element name="materia">

					<xsl:attribute name="hora">
						<xsl:value-of select="//dia[5]/materia[7]/@hora"/>
					</xsl:attribute>

					<xsl:attribute name="nombre">
						<xsl:value-of select="//dia[5]/materia[7]/@nombre"/>
					</xsl:attribute>

				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>