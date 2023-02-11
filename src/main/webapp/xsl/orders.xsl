<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="5.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html  bgcolor="#EDF2F2">
            <head>
                <title>My orders</title>
                <link rel="stylesheet" type="text/css" href="css/style.css" />
                <link rel="stylesheet" type="text/css" href="css/users.css" />
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="orders">
        <table class="content-table" style="margin-top:100px!important;">
            <thead>
                <tr>
                    <th colspan="3">
                        <h3>Orders List</h3>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="td-title">ID</td>
                    <td class="td-title">Date</td>
                    <td class="td-title">Customer ID</td>
                    
                </tr>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="/orders/order">
        <tr>
            <td>
                <xsl:value-of select="orderDate"/>
            </td>
            <td>
                <xsl:value-of select="customerID"/>
            </td>
            <td>
                <xsl:variable name="orderIDurl" select="orderID"></xsl:variable>
                <a href="http://localhost:8080/group1/orderView.jsp?orderID={$orderIDurl}" style="text-decoration: none; color black;">
                    <xsl:value-of select="orderID"/>
                </a>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>