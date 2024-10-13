<?xml version="1.0" encoding="UTF-8"?>
	<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
		<xsl:output encoding="UTF-8" indent="yes" method="html"/>

			<xsl:template match="/">

				<html>
					
					<head>

						<title>Horario 1 ASIR Ordinario</title>

					</head>

					<h1>Horario 1 ASIR Ordinario, ano 2013</h1>

					<body>

						<table>

							<tr>
								
								<td></td>
								<td>Luns</td>
								<td>Martes</td>
								<td>Mercores</td>
								<td>Xoves</td>
								<td>Venres</td>

							</tr>

							<xsl:for-each select="horario">

								<tr>
									
									<td>De <xsl:value-of select="horas/hora/inicio"/>
										a <xsl:value-of select="horas/hora/fin"/></td>
									<td>Luns</td>
									<td>Martes</td>
									<td>Mercores</td>
									<td>Xoves</td>
									<td>Venres</td>

								</tr>

						</xsl:for-each>

						</table>

					</body>

				</html>

			</xsl:template>

	</xsl:stylesheet>