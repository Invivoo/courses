package com.invivoo.catalog.domain.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Long employeeId;

    private int quantity;

    private BigDecimal unitPrice;

    private String href;

    public Product() {
    }

    public Product(String name, String description, Long employeeId, int quantity, BigDecimal unitPrice, String href) {
        this.name = name;
        this.description = description;
        this.employeeId = employeeId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", employeeId=" + employeeId +
               ", quantity=" + quantity +
               ", unitPrice=" + unitPrice +
               ", href='" + href + '\'' +
               '}';
    }
}
