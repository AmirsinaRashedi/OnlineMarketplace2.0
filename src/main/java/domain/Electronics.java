package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Electronics.TABLE_NAME)
public class Electronics extends Product {

    public static final String TABLE_NAME = "electronics";


    public Electronics() {
    }

}
