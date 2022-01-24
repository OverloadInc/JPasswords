package over.model.pojo;

/**
 * <code>Access</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class Access {
    private int id;
    private String name;
    private Product product;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product getProduct() {
        return product;
    }
}