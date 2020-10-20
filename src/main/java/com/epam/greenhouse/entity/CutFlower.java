package com.epam.greenhouse.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class CutFlower extends Flower {

    private final FlowerType type;

    public CutFlower(long id, String name, BigDecimal price, FlowerType type) {
        super(id, name, price);
        this.type = type;
    }

    public FlowerType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CutFlower cutFlower = (CutFlower) o;
        return getId() == cutFlower.getId() &&
                Objects.equals(getName(), cutFlower.getName()) &&
                Objects.equals(getPrice(), cutFlower.getPrice()) &&
                type == cutFlower.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", type=" + type +
                '}';
    }
}
