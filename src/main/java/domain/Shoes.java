package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Shoes.TABLE_NAME)
public class Shoes extends Product {

    public static final String TABLE_NAME = "shoes";

    public Shoes() {
    }


}
