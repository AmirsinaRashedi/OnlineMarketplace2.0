package domain;

import base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Product extends BaseEntity<Long> {

    @Column(name = "number_of_available_units")
    private Integer availableUnits;

    @Column(name = "price_per_unit")
    private Integer pricePerUnit;

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
}
