<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="5.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html  bgcolor="#EDF2F2">
            <head>
                <title>My orders</title>
                <link rel="stylesheet" type="text/css" href="css/style.css" />
                <link rel="stylesheet" type="text/css" href="css/orders.css" />
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="orders">
        <table class="content-table">
            <thead>
                <tr class="orderList">
                    <th colspan="3">
                        <h3>Order List</h3>
                    </th>
                    <tr class="orderHeaderItems">
                        <th class="td-title">Order ID</th>
                        <th class="td-title">Date</th>
                        <th class="td-title">Customer ID</th>
                    </tr>
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