package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Shoes.TABLE_NAME)
public class Shoes extends Product {

    public static final String TABLE_NAME = "shoes";

    @Column(name = "shoe_brand")
    private String shoeBrand;

    @Column(name = "shoe_type")
    private String shoeType;

    public Shoes() {
    }

    public String getShoeBrand() {
        return shoeBrand;
    }

    public void setShoeBrand(String shoeBrand) {
        this.shoeBrand = shoeBrand;
    }

    public String getShoeType() {
        return shoeType;
    }

    public void setShoeType(String shoeType) {
        this.shoeType = shoeType;
    }
}
