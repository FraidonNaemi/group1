<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="5.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html  bgcolor="#EDF2F2">
            <head>
                <title>Admin View</title>
                <link rel="stylesheet" type="text/css" href="css/style.css" />
                <link rel="stylesheet" type="text/css" href="css/products.css" />
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="products">
        <table class="content-table" style="margin-top:100px!important;">
            <thead>
                <tr class="productList">
                    <th colspan="6">
                        <h3>product List</h3>
                    </th>
                    <tr class="productHeaderItems">
                        <td class="td-title">ID</td>
                        <td class="td-title">Name</td>
                        <td class="td-title">Price</td>
                        <td class="td-title">Category</td>
                        <td class="td-title">Description</td>
                        <td class="td-title">Stock</td>

                    </tr>
                </tr>
            </thead>
            <tbody>
             
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="/products/product">
        <tr>
            <td>
                <xsl:variable name="productIDurl" select="productID"></xsl:variable>
                <a href="http://localhost:8080/group1/productDashboard.jsp?productID={$productIDurl}" style="text-decoration: none; color black;">
                    <xsl:value-of select="productID"/>
                </a>
            </td>
            <td>
                <xsl:value-of select="productName"/>
            </td>
            <td>
                <xsl:value-of select="productPrice"/>
            </td>
            <td>
                <xsl:value-of select="productCategory"/>
            </td>
            <td>
                <xsl:value-of select="productDescription"/>
            </td>
            <td>
                <xsl:value-of select="productStock"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>