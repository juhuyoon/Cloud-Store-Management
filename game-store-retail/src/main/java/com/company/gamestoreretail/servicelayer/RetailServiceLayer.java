package com.company.gamestoreretail.servicelayer;

import com.company.gamestoreretail.viewmodel.CustomerInvoiceViewModel;
import com.company.gamestoreretail.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;

public class RetailServiceLayer {

    @Autowired
    CustomerInvoiceViewModel civm;
    @Autowired
    OrderViewModel ovm;


}
