<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="html"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>Horario 1 ASIR Ordinario</title>
			</head>
			<h1>Asignatura por día</h1>
			<body>
				<ul>
					<li>
						<xsl:text>Dia </xsl:text><xsl:value-of select="//dia[1]/@num"/>
					</li>
					<ul>
						<li><xsl:value-of select="//dia[1]/materia[1]/@nombre" /></li>
						<li><xsl:value-of select="//dia[1]/materia[2]/@nombre" /></li>
						<li><xsl:value-of select="//dia[1]/materia[3]/@nombre" /></li>
						<li><xsl:value-of select="//dia[1]/materia[4]/@nombre" /></li>
						<li><xsl:value-of select="//dia[1]/materia[5]/@nombre" /></li>
						<li><xsl:value-of select="//dia[1]/materia[6]/@nombre" /></li>
						<li><xsl:value-of select="//dia[1]/materia[7]/@nombre" /></li>
					</ul>

					<li>
						<xsl:text>Dia </xsl:text><xsl:value-of select="//dia[2]/@num"/>
					</li>
					<ul>
						<li><xsl:value-of select="//dia[2]/materia[1]/@nombre" /></li>
						<li><xsl:value-of select="//dia[2]/materia[2]/@nombre" /></li>
						<li><xsl:value-of select="//dia[2]/materia[3]/@nombre" /></li>
						<li><xsl:value-of select="//dia[2]/materia[4]/@nombre" /></li>
						<li><xsl:value-of select="//dia[2]/materia[5]/@nombre" /></li>
						<li><xsl:value-of select="//dia[2]/materia[6]/@nombre" /></li>
						<li><xsl:value-of select="//dia[2]/materia[7]/@nombre" /></li>
					</ul>

					<li>
						<xsl:text>Dia </xsl:text><xsl:value-of select="//dia[3]/@num"/>
					</li>
					<ul>
						<li><xsl:value-of select="//dia[3]/materia[1]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[2]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[3]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[4]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[5]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[6]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[7]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[8]/@nombre" /></li>
						<li><xsl:value-of select="//dia[3]/materia[9]/@nombre" /></li>
					</ul>

					<li>
						<xsl:text>Dia </xsl:text><xsl:value-of select="//dia[4]/@num"/>
					</li>
					<ul>
						<li><xsl:value-of select="//dia[4]/materia[1]/@nombre" /></li>
						<li><xsl:value-of select="//dia[4]/materia[2]/@nombre" /></li>
						<li><xsl:value-of select="//dia[4]/materia[3]/@nombre" /></li>
						<li><xsl:value-of select="//dia[4]/materia[4]/@nombre" /></li>
						<li><xsl:value-of select="//dia[4]/materia[5]/@nombre" /></li>
						<li><xsl:value-of select="//dia[4]/materia[6]/@nombre" /></li>
						<li><xsl:value-of select="//dia[4]/materia[7]/@nombre" /></li>
					</ul>

					<li>
						<xsl:text>Dia </xsl:text><xsl:value-of select="//dia[5]/@num"/>
					</li>
					<ul>
						<li><xsl:value-of select="//dia[5]/materia[1]/@nombre" /></li>
						<li><xsl:value-of select="//dia[5]/materia[2]/@nombre" /></li>
						<li><xsl:value-of select="//dia[5]/materia[3]/@nombre" /></li>
						<li><xsl:value-of select="//dia[5]/materia[4]/@nombre" /></li>
						<li><xsl:value-of select="//dia[5]/materia[5]/@nombre" /></li>
						<li><xsl:value-of select="//dia[5]/materia[6]/@nombre" /></li>
						<li><xsl:value-of select="//dia[5]/materia[7]/@nombre" /></li>
					</ul>
				</ul>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>