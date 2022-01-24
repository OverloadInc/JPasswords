package over.model.pojo;

/**
 * <code>Credential</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class Credential {
    private int id;
    private String user;
    private String password;
    private String comment;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getComment() {
        return comment;
    }
}