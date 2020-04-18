package model.pojo;

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
}