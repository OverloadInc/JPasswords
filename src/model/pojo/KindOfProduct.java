package model.pojo;

import model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class KindOfProduct {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean addKindOfProduct(KindOfProduct kindOfProduct) {
        return false;
    }

    public ArrayList<KindOfProduct> getAllKindOfProduct() {
        ArrayList<KindOfProduct> kindOfProducts = new ArrayList<>();

        String query = "SELECT * FROM tipo_productos ORDER BY id_tipoproducto ASC;";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                KindOfProduct kindOfProduct = new KindOfProduct();
                kindOfProduct.setId(resultSet.getInt("id_tipoproducto"));
                kindOfProduct.setName(resultSet.getString("nombre"));

                kindOfProducts.add(kindOfProduct);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return kindOfProducts;
    }

    public String toString() {
        return this.name;
    }
}