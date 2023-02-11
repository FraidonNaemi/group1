<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="5.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html  bgcolor="#EDF2F2">
            <head>
                <title>Admin View</title>
                <link rel="stylesheet" type="text/css" href="css/style.css" />
                <link rel="stylesheet" type="text/css" href="css/users.css" />
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="product">
        <table class="content-table">
            <thead>
                <tr>
                    <th colspan="4">
                        <h3>product Information</h3>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="td-title">ID</td>
                    <td class="td-title">Image</td>
                    <td class="td-title">Name</td>
                    <td class="td-title">price</td>
                    <td class="td-title">categoryID</td>
                    <td class="td-title">manufacturur</td>
                    <td class="td-title">description</td>
                </tr>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="/product">
        <tr>
            <td>
                <xsl:value-of select="productID"/>
            </td>
            <td>
                <xsl:value-of select="productImage"/>
            </td>
            <td>
                <xsl:value-of select="productName"/>
            </td>
            <td>
                <xsl:value-of select="productPrice"/>
            </td>
            <td>
                <xsl:value-of select="categoryID"/>
            </td>
            <td>
                <xsl:value-of select="productManufacturer"/>
            </td>
            <td>
                <xsl:value-of select="productDescription"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>