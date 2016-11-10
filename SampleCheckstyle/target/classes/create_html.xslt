<xsl:stylesheet version="2.0"><!--  -->
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" 
    <!--  -->
    xmlns:uml="http://www.eclipse.org/uml2/2.0.0/UML" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"
    <!--  -->
    xmlns:fn="http://www.w3.org/2005/xpath-functions">
    <!--  -->
    <xsl:output encoding="ISO-8859-1" indent="yes" method="html"></xsl:output>
 
    <xsl:template match="sca">
         
             
                <title>XSLT Sample</title>
                 
             
                <h2>Report
                    <xsl:call-template name="out_whitespace"></xsl:call-template>
                    (<xsl:value-of select="current-date()"></xsl:value-of>;
                    <xsl:call-template name="out_whitespace"></xsl:call-template>
                    <xsl:value-of select="current-time()"></xsl:value-of>)
                </h2>
                <h3>Summary Messages</h3>
                <xsl:for-each-group group-by="@category" select="//message">
                        <xsl:sort select="@category"></xsl:sort>
                        <xsl:variable name="category1" select="@category"></xsl:variable>
                        </xsl:for-each-group><xsl:for-each-group group-by="@rule" select="//message[$category1=@category]">
                            <xsl:sort order="ascending" select="@priority"></xsl:sort>
                            </xsl:for-each-group><table border="0" class="details" width="90%">
                    <tbody><tr>
                        <th align="left">category</th>
                        <th align="left">tool</th>
                        <th align="left">priority</th>
                        <th align="left">rule</th>
                        <th align="left">count</th>
                    </tr>
 
                    <tr>
                            <td colspan="5">
                                <xsl:value-of select="$category1"></xsl:value-of>
                            </td>
                        </tr>
 
                        <tr class="alternate">
                                <td></td>
                                <td>
                                    <xsl:value-of select="@tool"></xsl:value-of>
                                </td>
                                <td align="left">
                                    <xsl:value-of select="@priority"></xsl:value-of>
                                </td>
                                <td>
                                    <xsl:if test="'findbugs'=@tool">
                                        <xsl:call-template name="findbugs_link"></xsl:call-template>
                                    </xsl:if>
                                    <xsl:if test="'pmd'=@tool">
                                        <xsl:call-template name="pmd_link"></xsl:call-template>
                                    </xsl:if>
                                    <xsl:if test="'checkstyle'=@tool">
                                        <xsl:value-of select="@rule"></xsl:value-of>
                                    </xsl:if>
                                </td>
                                <td align="center">
                                    <xsl:value-of select="count( current-group() )"></xsl:value-of>
                                </td>
                            </tr>
                         
                     
                    <tr class="dark">
                        <td colspan="4"></td>
                        <td align="center">
                            <xsl:value-of select="count( .//message )"></xsl:value-of>
                        </td>
                    </tr>
                </tbody></table>
                <p>
                 
                </p><h3>Summary Files</h3>
                <xsl:for-each-group group-by="@name" select="file">
                        <xsl:sort order="ascending" select="@name"></xsl:sort>
                        <xsl:variable name="fileName" select="@name"></xsl:variable>
     
                        </xsl:for-each-group><table border="0" class="details" width="90%">
                    <tbody><tr>
                        <th align="left" width="90pt">class file</th>
                        <th align="center" width="90pt">high</th>
                        <th align="center" width="90pt">medium</th>
                        <th align="center" width="90pt">low</th>
                        <th align="center" width="90pt">total</th>
                    </tr>
                    <tr class="alternate">
                            <td>
                                <xsl:call-template name="out_element_link"></xsl:call-template>
                            </td>
                            <td align="center">
                                <div class="p1">
                                    <xsl:value-of select="count(//file[@name=$fileName]/message[@priority = 1])"></xsl:value-of>
                                </div>
                            </td>
                            <td align="center">
                                <div class="p2">
                                    <xsl:value-of select="count(//file[@name=$fileName]/message[@priority = 2])"></xsl:value-of>
                                </div>
                            </td>
                            <td align="center">
                                <div class="p3">
                                    <xsl:value-of select="count(//file[@name=$fileName]/message[@priority = 3])"></xsl:value-of>
                                </div>
                            </td>
                            <td align="center">
                                <div class="p3">
                                    <xsl:value-of select="count(//file[@name=$fileName]/message)"></xsl:value-of>
                                </div>
                            </td>
                        </tr>
                     
                    <tr class="dark">
                        <td></td>
                        <td align="center">
                            <div class="p1">
                                <xsl:value-of select="count(.//message[@priority = 1])"></xsl:value-of>
                            </div>
                        </td>
                        <td align="center">
                            <div class="p2">
                                <xsl:value-of select="count(.//message[@priority = 2])"></xsl:value-of>
                            </div>
                        </td>
                        <td align="center">
                            <div class="p3">
                                <xsl:value-of select="count(.//message[@priority = 3])"></xsl:value-of>
                            </div>
                        </td>
                        <td align="center">
                            <div class="p3">
                                <xsl:value-of select="count(.//message)"></xsl:value-of>
                            </div>
                        </td>
                    </tr>
                </tbody></table>
                <p>
                 
                </p><h3>Details by Class</h3>
                 <xsl:for-each-group group-by="@name" select="file"> 
                <xsl:sort order="ascending" select="@name"></xsl:sort>
                    <xsl:call-template name="file_detail"></xsl:call-template>
                </xsl:for-each-group> 
                                 
             
    </xsl:template>
 
    <xsl:template name="file_detail">
        <xsl:variable name="fileName" select="@name"></xsl:variable>
        <xsl:for-each select="//file[@name=$fileName]/message">
                <xsl:sort order="ascending" select="@priority"></xsl:sort>
                </xsl:for-each><table border="0" class="details" width="90%">
            <tbody><tr><th align="left" colspan="6">
                <xsl:call-template name="out_element_anker"></xsl:call-template>
            </th>
            </tr><tr>
                <th align="left" width="80pt">tool</th>
                <th align="left" width="50pt">priority</th>
                <th align="left" width="30pt">line</th>
                <th align="left" width="80pt">category</th>
                <th align="left" width="380pt">rule</th>
                <th align="left">message</th>
            </tr>            
                 
            <tr class="alternate">
                    <td>
                        <xsl:value-of select="@tool"></xsl:value-of>
                    </td>
                    <td>
                        <xsl:value-of select="@priority"></xsl:value-of>
                    </td>
                    <td>
                        <xsl:value-of select="@line"></xsl:value-of>
                    </td>
                    <td>
                        <xsl:value-of select="@category"></xsl:value-of>
                    </td>
                    <td>
                        <xsl:value-of select="@rule"></xsl:value-of>
                    </td>
                    <td>
                        <xsl:value-of select="@message"></xsl:value-of>
                    </td>
                </tr>
             
        </tbody></table>
         
 
    </xsl:template>
 
    <xsl:template name="out_whitespace">
        <xsl:text disable-output-escaping="no"> </xsl:text>
    </xsl:template>
 
    <xsl:template name="out_key">
        <xsl:value-of select="@name"></xsl:value-of>
    </xsl:template>
 
    <xsl:template name="out_element">
        <xsl:value-of select="@name"></xsl:value-of>
    </xsl:template>
 
    <xsl:template name="out_element_anker">
        <xsl:text disable-output-escaping="yes"><a name="</xsl:text>
        <xsl:call-template name="out_key"></xsl:call-template>
        <xsl:text disable-output-escaping="yes">"></xsl:text>
        <xsl:call-template name="out_element"></xsl:call-template>
        <xsl:text disable-output-escaping="yes"></a></xsl:text>
    </xsl:template>
 
    <xsl:template name="out_element_link">
        <xsl:text disable-output-escaping="yes"><a href="#</xsl:text>
        <xsl:call-template name="out_key"></xsl:call-template>
        <xsl:text disable-output-escaping="yes">" title="</xsl:text>
        <xsl:call-template name="out_element"></xsl:call-template>
        <xsl:text disable-output-escaping="yes">"></xsl:text>
        <xsl:variable name="name1">
            <xsl:value-of select="@name"></xsl:value-of>
        </xsl:variable>
        <xsl:if test="(''=$name1)">
            <xsl:call-template name="out_element"></xsl:call-template>
        </xsl:if>
        <xsl:value-of select="@name"></xsl:value-of>
        <xsl:text disable-output-escaping="yes"></a></xsl:text>
    </xsl:template>
 
    <xsl:template name="findbugs_link">
        <xsl:text disable-output-escaping="yes"> <a
            href="http://findbugs.sourceforge.net/bugDescriptions.html#</xsl:text>
        <xsl:value-of select="@rule_id"></xsl:value-of>
        <xsl:text disable-output-escaping="yes">"></xsl:text>
        <xsl:value-of select="@rule"></xsl:value-of>
        <xsl:text disable-output-escaping="yes"></a></xsl:text>
    </xsl:template>
 
    <xsl:template name="pmd_link">
        <xsl:text disable-output-escaping="yes"> <a
            href="http://pmd.sourceforge.net/rules/basic.html#</xsl:text>
        <xsl:value-of select="@rule"></xsl:value-of>
        <xsl:text disable-output-escaping="yes">"></xsl:text>
        <xsl:value-of select="@rule"></xsl:value-of>
        <xsl:text disable-output-escaping="yes"></a></xsl:text>
    </xsl:template>
</xsl:stylesheet>