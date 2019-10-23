package com.company.gamestoreinvoiceserver.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Invoice {

    private int invoice_id;
    private int customer_id;
    private LocalDate purchase_date;
    private List<InvoiceItem> invoiceItems;

    public Invoice() {
    }

    public Invoice(int invoice_id, int customer_id, LocalDate purchase_date, List<InvoiceItem> invoiceItems) {
        this.invoice_id = invoice_id;
        this.customer_id = customer_id;
        this.purchase_date = purchase_date;
        this.invoiceItems = invoiceItems;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoice_id == invoice.invoice_id &&
                customer_id == invoice.customer_id &&
                purchase_date.equals(invoice.purchase_date) &&
                invoiceItems.equals(invoice.invoiceItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_id, customer_id, purchase_date, invoiceItems);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_id=" + invoice_id +
                ", customer_id=" + customer_id +
                ", purchase_date=" + purchase_date +
                ", invoiceItems=" + invoiceItems +
                '}';
    }
}