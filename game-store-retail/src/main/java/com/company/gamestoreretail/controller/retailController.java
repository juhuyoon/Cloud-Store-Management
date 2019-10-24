package com.company.gamestoreretail.controller;

import com.company.gamestoreretail.model.InvoiceViewModel;
import com.company.gamestoreretail.servicelayer.RetailServiceLayer;
import com.company.gamestoreretail.viewmodel.CustomerInvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class retailController {

    @Autowired
    RetailServiceLayer service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CustomerInvoiceViewModel submitInvoice(InvoiceViewModel ivm) {
        return service.submitInvoice(ivm);
    }

    @GetMapping("/{customer_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerInvoiceViewModel> getAllInvoicesByCustomerId(@PathVariable(name = "customer_id") int customer_id) {
        return service.getAllInvoicesByCustomerId(customer_id);
    }

}
