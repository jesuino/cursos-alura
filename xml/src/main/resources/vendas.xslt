<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="venda">
		<h1>Venda</h1>
			Forma de Pagamento:<i><xsl:value-of select="formaPagamento" /></i>
		<xsl:apply-templates select="produtos" />
	</xsl:template>

	<xsl:template match="produtos">
		<xsl:apply-templates select="produto" />
	</xsl:template>

	<xsl:template match="produto">
		<h3><xsl:value-of select="nome" /></h3>
		<p><xsl:value-of select="preco" /></p>
		<hr />
	</xsl:template>
</xsl:stylesheet>