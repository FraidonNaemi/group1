package com.model.dao;

import com.model.Customers;
import com.model.OrderProducts;
import com.model.Orders;
import com.model.Products;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlTransformer {

    public XmlTransformer() {
    }

    public void transform(String xslPath, String xmlPath, StreamResult result) throws TransformerConfigurationException, TransformerException {
        //step 1: Create TransformerFactory instance
        TransformerFactory tf = TransformerFactory.newInstance();

        //Step 2: Load the XSL source file into StreamSource
        StreamSource xslSource = new StreamSource(xslPath);

        //Step 3: Load the XML source file into StreamSource
        StreamSource xmlSource = new StreamSource(xmlPath);

        //Step 4: Create a transformer instance using xsl document
        Transformer transformer = tf.newTransformer(xslSource);

        //Step 5: transform
        transformer.transform(xmlSource, result);
        StreamResult systemOutResult = new StreamResult(System.out);
        transformer.transform(xmlSource, systemOutResult);
    }

    public void transform(String xslPath, Products products, StreamResult result) throws JAXBException, TransformerConfigurationException, TransformerException {
        // Step 1: Create TransformerFactory instance
        TransformerFactory tf = TransformerFactory.newInstance();

        // Step 2: Load the XSL source file into StreamSource
        StreamSource xslSource = new StreamSource(xslPath);

        // Step 3: Load the XML data source - using JAXB
        JAXBContext jc = JAXBContext.newInstance(Products.class);
        JAXBSource xmlSource = new JAXBSource(jc, products);

        // Step 4: Create a transformer instance using xsl document
        Transformer transformer = tf.newTransformer(xslSource);

        // Step 5: transform
        transformer.transform(xmlSource, result);
        StreamResult systemOutResult = new StreamResult(System.out);
        transformer.transform(xmlSource, systemOutResult);
    }

    public void transform(String xslPath, Orders orders, StreamResult result) throws JAXBException, TransformerConfigurationException, TransformerException {
        // Step 1: Create TransformerFactory instance
        TransformerFactory tf = TransformerFactory.newInstance();

        // Step 2: Load the XSL source file into StreamSource
        StreamSource xslSource = new StreamSource(xslPath);

        // Step 3: Load the XML data source - using JAXB
        JAXBContext jc = JAXBContext.newInstance(Orders.class);
        JAXBSource xmlSource = new JAXBSource(jc, orders);

        // Step 4: Create a transformer instance using xsl document
        Transformer transformer = tf.newTransformer(xslSource);

        // Step 5: transform
        transformer.transform(xmlSource, result);
        StreamResult systemOutResult = new StreamResult(System.out);
        transformer.transform(xmlSource, systemOutResult);
    }

    public void transform(String xslPath, OrderProducts orderProducts, StreamResult result) throws JAXBException, TransformerConfigurationException, TransformerException {
        // Step 1: Create TransformerFactory instance
        TransformerFactory tf = TransformerFactory.newInstance();

        // Step 2: Load the XSL source file into StreamSource
        StreamSource xslSource = new StreamSource(xslPath);

        // Step 3: Load the XML data source - using JAXB
        JAXBContext jc = JAXBContext.newInstance(OrderProducts.class);
        JAXBSource xmlSource = new JAXBSource(jc, orderProducts);

        // Step 4: Create a transformer instance using xsl document
        Transformer transformer = tf.newTransformer(xslSource);

        // Step 5: transform
        transformer.transform(xmlSource, result);
        StreamResult systemOutResult = new StreamResult(System.out);
        transformer.transform(xmlSource, systemOutResult);
    }

    public void transform(String xslPath, Customers customers, StreamResult result) throws JAXBException, TransformerConfigurationException, TransformerException {
        // Step 1: Create TransformerFactory instance
        TransformerFactory tf = TransformerFactory.newInstance();

        // Step 2: Load the XSL source file into StreamSource
        StreamSource xslSource = new StreamSource(xslPath);

        // Step 3: Load the XML data source - using JAXB
        JAXBContext jc = JAXBContext.newInstance(Customers.class);
        JAXBSource xmlSource = new JAXBSource(jc, customers);

        // Step 4: Create a transformer instance using xsl document
        Transformer transformer = tf.newTransformer(xslSource);

        // Step 5: transform
        transformer.transform(xmlSource, result);
        StreamResult systemOutResult = new StreamResult(System.out);
        transformer.transform(xmlSource, systemOutResult);
    }

}
