package domain;

import base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Product extends BaseEntity<Long> {

    @Column(name = "product_type")
    private Integer productTypeId;

    @Column(name = "number_of_available_units")
    private Integer availableUnits;

    @Column(name = "price_per_unit")
    private Integer pricePerUnit;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "creator")
    private String creator;

    public Product() {
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {

        if (productTypeId == 1)

            return "Electronic ->    "
                    + "Name: " + title
                    + "    Model: " + type
                    + "    Manufacturer: " + creator;

        else if (productTypeId == 2)

            return "Shoe ->    "
                    + "Name: " + title
                    + "    Type: " + type
                    + "    Brand: " + creator;

        else if (productTypeId == 3)

            return "Litterateur ->    "
                    + "Title: " + title
                    + "    type: " + type
                    + "    author: " + creator;

        else

            return null;
    }
}
