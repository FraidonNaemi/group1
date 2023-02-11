<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="5.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html  bgcolor="#EDF2F2">
            <head>
                <title>My order</title>
                <link rel="stylesheet" type="text/css" href="css/style.css" />
                <link rel="stylesheet" type="text/css" href="css/users.css" />
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="orderProducts">
        <table class="content-table" style="margin-top:100px!important;">
            <thead>
                <tr>
                    <th class="td-title">OrderID</th>
                    <th class="td-title">ProductID</th>
                    <th class="td-title">quantity</th>
                </tr>
            </thead>
            
            <tbody>
                
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="/orderProducts/orderProduct">
        <tr>
            <td>
                <xsl:value-of select="orderID"/>
            </td>
            <td>
                <xsl:variable name="productIDurl" select="productID"></xsl:variable>
                <a href="http://localhost:8080/group1/productControl.jsp?productID={$productIDurl}" style="text-decoration: none; color black;">
                    <xsl:value-of select="productID"/>
                </a>

            </td>
            <td>
                <xsl:value-of select="quantity"/>
            </td>

        </tr>
    </xsl:template>
</xsl:stylesheet>