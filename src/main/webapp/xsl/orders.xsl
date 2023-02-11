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
                <tr colspan = "3" >
                    <h3>Orders List</h3>
                </tr>
                <tr>
                    <th class="td-title">ID</th>
                    <th class="td-title">Date</th>
                    <th class="td-title">Customer ID</th>
                </tr>
            </thead>
            <tbody>
                
                    
                    
                
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="/orders/order">
        <tr>
            <td>
                <xsl:variable name="orderIDurl" select="orderID"></xsl:variable>
                <a href="http://localhost:8080/group1/orderView.jsp?orderID={$orderIDurl}" style="text-decoration: none; color black;">
                    <xsl:value-of select="orderID"/>
                </a>
            </td>
            <td>
                <xsl:value-of select="orderDate"/>
            </td>
            <td>
                <xsl:value-of select="customerID"/>
            </td>

        </tr>
    </xsl:template>
</xsl:stylesheet>