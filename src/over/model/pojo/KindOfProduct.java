package over.model.pojo;

import over.model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * <code>KindOfProduct</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
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

    public ArrayList<KindOfProduct> getAllKindOfProduct() {
        ArrayList<KindOfProduct> kindOfProducts = new ArrayList<>();

        String query = "SELECT * FROM tipo_productos ORDER BY id_tipoproducto ASC;";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
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

    public KindOfProduct getKindOfProduct(ArrayList<KindOfProduct> kindOfProducts, int id) {
        for(KindOfProduct kindOfProduct : kindOfProducts)
            if(kindOfProduct.getId() == id)
                return kindOfProduct;

        return null;
    }

    public boolean addKindOfProduct() {
        boolean result = false;
        String command = "INSERT INTO tipo_productos (nombre) VALUES ('" + this.name + "');";

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

    public boolean updateKindOfProduct() {
        boolean result = false;
        String command = "UPDATE tipo_productos SET nombre = '" + this.name + "' WHERE id_tipoproducto = " + this.id + ";";

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

    public boolean deleteKindOfProduct() {
        boolean result = false;
        String command = "DELETE FROM tipo_productos WHERE id_tipoproducto = " + this.id + ";";

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

    public String toString() {
        return this.name;
    }
}