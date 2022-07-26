<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="@* | node()">
		<xsl:copy>
			<xsl:apply-templates select="@* | node()" />
		</xsl:copy>
	</xsl:template>
	<xsl:template match="/message/@id">
		<xsl:attribute name="id">
			<xsl:value-of select="/message/@id" />
		</xsl:attribute>
	</xsl:template>
	<xsl:template match="/message/text()">
		<xsl:value-of select="/message/text()" /> mondo !!!
	</xsl:template>
</xsl:stylesheet>