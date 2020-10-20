package com.epam.greenhouse.entity;

import java.math.BigDecimal;

public class PottedFlower extends Flower {

    private final boolean bloomAble;

    public PottedFlower(long id, String name, BigDecimal price, boolean bloomAble) {
        super(id, name, price);
        this.bloomAble = bloomAble;
    }

    public boolean isBloomAble() {
        return bloomAble;
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
                ", price=" + getPrice() +
                ", bloomAble=" + bloomAble +
                '}';
    }
}
