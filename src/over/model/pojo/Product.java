package over.model.pojo;

import over.model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private KindOfProduct kindOfProduct;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKindOfProduct(KindOfProduct kindOfProduct) {
        this.kindOfProduct = kindOfProduct;
    }
  
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public KindOfProduct getKindOfProduct() {
        return kindOfProduct;
    }

    public ArrayList<Product> getAllProducts() {
        KindOfProduct kindOfProduct = new KindOfProduct();

        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<KindOfProduct> kindOfProducts = kindOfProduct.getAllKindOfProduct();

        String query = "SELECT * FROM productos ORDER BY id_producto ASC;";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getInt("id_producto"));
                product.setName(resultSet.getString("nombre"));
                product.setKindOfProduct(kindOfProduct.getKindOfProduct(kindOfProducts, resultSet.getInt("id_tipoproducto")));

                productList.add(product);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return productList;
    }

    public boolean addProduct() {
        boolean result = false;
        String command = "INSERT INTO productos (nombre, id_tipoproducto) VALUES ('" + this.name + "', '" + this.kindOfProduct.getId() + "');";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
            dbConnection.connect();

            result = dbConnection.executeCommand(command);

            dbConnection.disconnect();
        }
        catch(Exception e) {
        }

        return result;
    }

    public boolean updateProduct() {
        boolean result = false;
        String command = "UPDATE productos SET nombre = '" + this.name + "', id_tipoproducto = " + this.kindOfProduct.getId() + " WHERE id_producto = " + this.id + ";";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
            dbConnection.connect();

            result = dbConnection.executeCommand(command);

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return result;
    }

    public boolean deleteProduct() {
        boolean result = false;
        String command = "DELETE FROM productos WHERE id_producto = " + this.id + ";";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
            dbConnection.connect();

            result = dbConnection.executeCommand(command);

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return result;
    }
}