package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Litterateur.TABLE_NAME)
public class Litterateur extends Product {

    public static final String TABLE_NAME = "litterateur";

    public Litterateur() {
    }

}
