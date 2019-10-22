package com.company.gamestoreinvoiceserver.Dao;

import com.company.gamestoreinvoiceserver.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice createInvoice(Invoice invoice);

    Invoice getInvoice(Integer invoice_id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(Integer invoice_id);
}
