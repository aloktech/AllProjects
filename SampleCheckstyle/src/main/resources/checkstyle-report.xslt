<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="ISO-8859-1" indent="yes" method="html"></xsl:output>
 
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <xsl:for-each select="//checkstyle">
                        <xsl:apply-templates></xsl:apply-templates>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
 
    <xsl:template match="file">
        <xsl:variable name="new_name" select="translate(@name, '/', '.')"></xsl:variable>
        <!--<xsl:variable name="new_name" select="translate($new_name, '\', '.')"></xsl:variable>-->
        <!--<xsl:variable name="new_name" select="concat(substring-after($new_name,'.src.'),  substring-after($new_name,'.source.'))"></xsl:variable>-->
 
        <xsl:variable name="msg" select="./error"></xsl:variable>
        <xsl:if test="($msg='')">
            <tr>
                <td colspan="5">
                    <xsl:value-of select="substring-after(substring-before(@name, '.java'),'/')"></xsl:value-of>
                </td>
            </tr>
            <!--<tr>-->
            <xsl:apply-templates select="node()"></xsl:apply-templates>
            <!--</tr>-->
            <!--            <file name="{$new_name}">
                <xsl:apply-templates select="node()"></xsl:apply-templates>
            </file>-->
        </xsl:if>
    </xsl:template>
 
    <xsl:template match="error">
        <tr>
            <xsl:variable name="priority">
                <xsl:if test="@severity='error'">1</xsl:if>
                <xsl:if test="@severity='warning'">2</xsl:if>
                <xsl:if test="@severity='info'">3</xsl:if>
            </xsl:variable>
            <td>
                checkstyle
            </td>
            <td>
                <xsl:value-of select="@*"></xsl:value-of>
            </td>
            <td>
                <xsl:value-of select="@severity"></xsl:value-of>
            </td>
            <td>
                <xsl:value-of select="@message"></xsl:value-of>
            </td>
            <td>
                style
            </td>
        </tr>
        
        <!--        <message>
            <xsl:attribute name="tool">checkstyle</xsl:attribute>
            <xsl:attribute name="line">
                <xsl:value-of select="@*"></xsl:value-of>
            </xsl:attribute>
            <xsl:attribute name="message">
                <xsl:value-of select="@severity"></xsl:value-of>
            </xsl:attribute>
            <xsl:attribute name="priority"><xsl:value-of select="+$priority"></xsl:value-of></xsl:attribute>
            <xsl:attribute name="rule">
                <xsl:value-of select="@message"></xsl:value-of>
            </xsl:attribute>
            <xsl:attribute name="category">style</xsl:attribute>
        </message>-->
    </xsl:template>
 
</xsl:stylesheet>
