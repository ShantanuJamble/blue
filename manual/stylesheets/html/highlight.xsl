<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xslthl="http://xslthl.sf.net"
                exclude-result-prefixes="xslthl"
                version='1.0'>

<!-- ********************************************************************
     $Id: highlight.xsl,v 1.1 2008/10/04 01:59:24 kunstmusik Exp $
     ********************************************************************

     This file is part of the XSL DocBook Stylesheet distribution.
     See ../README or http://docbook.sf.net/release/xsl/current/ for
     and other information.

     ******************************************************************** -->

<xsl:template match='xslthl:keyword'>
  <b class="hl-keyword"><xsl:apply-templates/></b>
</xsl:template>

<xsl:template match='xslthl:string'>
  <b class="hl-string"><i style="color:red"><xsl:apply-templates/></i></b>
</xsl:template>

<xsl:template match='xslthl:comment'>
  <i class="hl-comment" style="color: silver"><xsl:apply-templates/></i>
</xsl:template>

<xsl:template match='xslthl:tag'>
  <b class="hl-tag" style="color: blue"><xsl:apply-templates/></b>
</xsl:template>

<xsl:template match='xslthl:attribute'>
  <span class="hl-attribute" style="color: blue"><xsl:apply-templates/></span>
</xsl:template>

<xsl:template match='xslthl:value'>
  <span class="hl-value" style="color: blue"><xsl:apply-templates/></span>
</xsl:template>

<xsl:template match='xslthl:html'>
  <b><i style="color: red"><xsl:apply-templates/></i></b>
</xsl:template>

<xsl:template match='xslthl:xslt'>
  <b style="color: blue"><xsl:apply-templates/></b>
</xsl:template>

<xsl:template match='xslthl:section'>
  <b><xsl:apply-templates/></b>
</xsl:template>

</xsl:stylesheet>

