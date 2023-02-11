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
                    <th colspan="3">
                        <h3>My Order</h3>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="td-title">OrderID</td>
                    <td class="td-title">ProductID</td>
                    <td class="td-title">quantity</td>
                </tr>
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