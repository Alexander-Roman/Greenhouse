package com.epam.greenhouse.entity;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractFlower {

    private long id;
    private String name;
    private GrowingConditions conditions;
    private BigDecimal price;

    public AbstractFlower() {
    }

    public AbstractFlower(long id, String name, GrowingConditions conditions, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.conditions = conditions;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GrowingConditions getConditions() {
        return conditions;
    }

    public void setConditions(GrowingConditions conditions) {
        this.conditions = conditions;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractFlower that = (AbstractFlower) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(conditions, that.conditions) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

}
