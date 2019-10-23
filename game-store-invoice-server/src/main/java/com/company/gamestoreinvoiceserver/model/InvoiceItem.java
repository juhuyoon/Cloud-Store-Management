package com.company.gamestoreinvoiceserver.model;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {

    private int invoice_item_id;
    private int invoice_id;
    private int inventory_id;
    private int quantity;
    private BigDecimal unit_price;

    public InvoiceItem() {
    }

    public InvoiceItem(int invoice_item_id, int invoice_id, int inventory_id, int quantity, BigDecimal unit_price) {
        this.invoice_item_id = invoice_item_id;
        this.invoice_id = invoice_id;
        this.inventory_id = inventory_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public int getInvoice_item_id() {
        return invoice_item_id;
    }

    public void setInvoice_item_id(int invoice_item_id) {
        this.invoice_item_id = invoice_item_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return invoice_item_id == that.invoice_item_id &&
                invoice_id == that.invoice_id &&
                inventory_id == that.inventory_id &&
                quantity == that.quantity &&
                unit_price.equals(that.unit_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_item_id, invoice_id, inventory_id, quantity, unit_price);
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "invoice_item_id=" + invoice_item_id +
                ", invoice_id=" + invoice_id +
                ", inventory_id=" + inventory_id +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                '}';
    }
}