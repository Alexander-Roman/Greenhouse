package com.epam.greenhouse.entity;

import java.math.BigDecimal;

public class CutFlower extends AbstractFlower {

    private Inflorescence inflorescence;

    public CutFlower() {
    }

    public CutFlower(long id, String name, GrowingConditions conditions, BigDecimal price, Inflorescence inflorescence) {
        super(id, name, conditions, price);
        this.inflorescence = inflorescence;
    }

    public Inflorescence getInflorescence() {
        return inflorescence;
    }

    public void setInflorescence(Inflorescence inflorescence) {
        this.inflorescence = inflorescence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CutFlower cutFlower = (CutFlower) o;
        return inflorescence == cutFlower.inflorescence;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (inflorescence != null ? inflorescence.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", conditions=" + getConditions() +
                ", price=" + getPrice() +
                ", inflorescence=" + inflorescence +
                '}';
    }
}
