package com.epam.greenhouse.entity;

import java.math.BigDecimal;

public class PottedFlower extends AbstractFlower {

    private boolean bloomAble;

    public PottedFlower() {
    }

    public PottedFlower(long id, String name, GrowingConditions conditions, BigDecimal price, boolean bloomAble) {
        super(id, name, conditions, price);
        this.bloomAble = bloomAble;
    }

    public boolean isBloomAble() {
        return bloomAble;
    }

    public void setBloomAble(boolean bloomAble) {
        this.bloomAble = bloomAble;
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
        PottedFlower that = (PottedFlower) o;
        return bloomAble == that.bloomAble;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bloomAble ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", conditions=" + getConditions() +
                ", price=" + getPrice() +
                ", bloomAble=" + bloomAble +
                '}';
    }
}
