package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Litterateur.TABLE_NAME)
public class Litterateur extends Product {

    public static final String TABLE_NAME = "litterateur";

    @Column(name = "litterateur_title")
    private String litterateurTitle;

    @Column(name = "litterateur_type")
    private String litterateurType;

    @Column(name = "litterateur_author")
    private String litterateurAuthor;

    public Litterateur() {
    }

    public String getLitterateurTitle() {
        return litterateurTitle;
    }

    public void setLitterateurTitle(String litterateurTitle) {
        this.litterateurTitle = litterateurTitle;
    }

    public String getLitterateurType() {
        return litterateurType;
    }

    public void setLitterateurType(String litterateurType) {
        this.litterateurType = litterateurType;
    }

    public String getLitterateurAuthor() {
        return litterateurAuthor;
    }

    public void setLitterateurAuthor(String litterateurAuthor) {
        this.litterateurAuthor = litterateurAuthor;
    }
}
