<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="5.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Admin View</title>
                <link rel="stylesheet" type="text/css" href="css/style.css" />
                <link rel="stylesheet" type="text/css" href="css/customers.css" />
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="customers">
        <table class="content-table" style="margin-top:100px!important;">
            <thead>
                <tr class="customerList">
                    <th colspan="6">
                        <h3>Customers List</h3>
                    </th>
                    <tr class="customerHeaderItems" style="text-align: left; background-color: #f8f8f8; color: black; font-size: 18px;">
                        <td class="td-title">ID</td>
                        <td class="td-title">Name</td>
                        <td class="td-title">Email</td>
                        <td class="td-title">Date of Birth</td>
                        <td class="td-title">Phone Number</td>
                        <td class="td-title">Address</td>
                    </tr>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="/customers/customer">
        <tr>
            <td>
                <xsl:value-of select="customerID"/>
            </td>
            <td>
                <xsl:value-of select="customerName"/>
            </td>
            <td>
                <xsl:variable name="emailurl" select="customerEmail"></xsl:variable>
                <a href="http://localhost:8080/group1/adminCustomerAccount.jsp?emailView={$emailurl}" style="text-decoration: none; color black;">
                    <xsl:value-of select="customerEmail"/>
                </a>
            </td>
            <td>
                <xsl:value-of select="customerDOB"/>
            </td>
            <td>
                <xsl:value-of select="customerPhoneNumber"/>
            </td>
            <td>
                <xsl:value-of select="customerAddress"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>