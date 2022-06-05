package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Electronics.TABLE_NAME)
public class Electronics extends Product {

    public static final String TABLE_NAME = "electronics";

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    public Electronics() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
