package com.model.dao;

import com.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductSqlDAO {
// decare and inject the sql query
    private Statement st;
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE store.products SET productImage=?, productName=?, productPrice=? , productCategory=?, productDescription=?,productStock=?  WHERE productID=?";
    private PreparedStatement deleteSt;
    private String deleteQuery = "DELETE FROM store.products WHERE productID=?";
//constructor to open connection to sql database
    public ProductSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.updateSt = connection.prepareStatement(updateQuery);
        this.deleteSt = connection.prepareStatement(deleteQuery);
    }

    //Create Query (id will be created in database)
    public void create(String productImage, String productName, double productPrice, String productCategory, String productDescription, int productStock) throws SQLException {
        String columns = "INSERT INTO store.products(productImage,productName,productPrice,productCategory,productDescription,productStock)";
        String values = "VALUES('" + productImage + "','" + productName + "','" + productPrice + "','" + productCategory + "','" + productDescription + "','" + productStock + "')";
        st.executeUpdate(columns + values);
    }
//Create Query
    public void create(int productID, String productImage, String productName, double productPrice, String productCategory, String productDescription, int productStock) throws SQLException {
        String columns = "INSERT INTO store.products(productImage,productName,productPrice,productCategory,productDescription)";
        String values = "VALUES('" + productID + "','" + productImage + "','" + productName + "','" + productPrice + "','" + productCategory + "','" + productDescription + "','" + productStock + "')";
        st.executeUpdate(columns + values);
    }
//Create Query (has all the values)
    public void create() throws SQLException {
        String columns = "INSERT INTO store.products(productImage,productName,productPrice,productCategory,productDescription,productStock)";
        String values = "VALUES('image', 'playstation','20.5','sport','football','5')";
        st.executeUpdate(columns + values);
    }
    //Create Query gitting the name as parameter
    public void create(String productName) throws SQLException {
        String columns = "INSERT INTO store.products(productImage,productName,productPrice,productCategory,productDescription,productStock)";
        String values = "VALUES('image','" + productName + "','20.5','sport','football',5)";
        st.executeUpdate(columns + values);
    }

    //Read Query - Read One by product id (for order update)
    public void updateStock(int productID, int newStock) throws SQLException {
        String query = "UPDATE store.products SET productStock=" + newStock + " WHERE productID = " + productID;
        st.executeUpdate(query);
    }

    //Read Query - Read One by product id
    public Product getProduct(int productID) throws SQLException {
        String query = "SELECT * FROM store.products WHERE productID=" + productID;
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (productID == currentID) {
                String productImage = rs.getString(2);
                String productName = rs.getString(3);
                double productPrice = Double.parseDouble(rs.getString(4));
                String productCategory = rs.getString(5);
                String productDescription = rs.getString(6);
                int productStock = Integer.parseInt(rs.getString(7));
                return new Product(currentID, productImage, productName, productPrice, productCategory, productDescription, productStock);
            }
        }
        return null;
    }
    
    //Read Query - Read One by product name
    public Product getProduct(String productName) throws SQLException {
        String query = "SELECT * FROM store.products WHERE productName='" + productName + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentProductName = rs.getString(3);

            if (productName.equals(currentProductName)) {
                int productID = Integer.parseInt(rs.getString(1));
                String productImage = rs.getString(2);
                double productPrice = Double.parseDouble(rs.getString(4));
                String productCategory = rs.getString(5);
                String productDescription = rs.getString(6);
                int productStock = Integer.parseInt(rs.getString(7));
                return new Product(productID, productImage, currentProductName, productPrice, productCategory, productDescription, productStock);
            }
        }
        return null;
    }

    //Read Query - Read All
    public List<Product> getProducts() throws SQLException {
        String query = "SELECT * FROM store.products";
        ResultSet rs = st.executeQuery(query);
        List<Product> temp = new ArrayList<>();

        while (rs.next()) {
            int productID = Integer.parseInt(rs.getString(1));
            String productImage = rs.getString(2);
            String productName = rs.getString(3);
            double productPrice = Double.parseDouble(rs.getString(4));
            String productCategory = rs.getString(5);
            String productDescription = rs.getString(6);
            int productStock = Integer.parseInt(rs.getString(7));
            temp.add(new Product(productID, productImage, productName, productPrice, productCategory, productDescription, productStock));
        }
        return temp;
    }

    //Read Query - Read All by ID
    public List<Product> getProducts(int productID) throws SQLException {
        String query = "SELECT * FROM store.products WHERE productID=" + productID;
        ResultSet rs = st.executeQuery(query);

        List<Product> temp = new ArrayList<>();

        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (productID == currentID) {
                String productImage = rs.getString(2);
                String productName = rs.getString(3);
                double productPrice = Double.parseDouble(rs.getString(4));
                String productCategory = rs.getString(5);
                String productDescription = rs.getString(6);
                int productStock = Integer.parseInt(rs.getString(7));

                temp.add(new Product(currentID, productImage, productName, productPrice, productCategory, productDescription, productStock));
            }
        }
        return temp;
    }

    //Update Query () by ID
    public void update(int productID, String productImage, String productName, double productPrice, String productCategory, String productDescription, int productStock) throws SQLException {
        updateSt.setString(1, productImage);
        updateSt.setString(2, productName);
        updateSt.setString(3, Double.toString(productPrice));
        updateSt.setString(4, productCategory);
        updateSt.setString(5, productDescription);
        updateSt.setString(6, "" + productStock);
        updateSt.setString(7, "" + productID);

        int row = updateSt.executeUpdate();
        System.out.println("Row " + row + " has been successflly updated");
    }

    //Delete Query - by ID
    public void delete(int productID) throws SQLException {
        deleteSt.setString(1, "" + productID);
        int row = deleteSt.executeUpdate();
        System.out.println("Row " + row + " has been successflly deleted");
    }

    public void show(List<Product> temp) {
        temp.forEach(p -> System.out.println(p));
    }
}
