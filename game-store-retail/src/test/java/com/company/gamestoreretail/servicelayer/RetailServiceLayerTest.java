package com.company.gamestoreretail.servicelayer;

import com.company.gamestoreretail.model.CustomerViewModel;
import com.company.gamestoreretail.model.Inventory;
import com.company.gamestoreretail.model.InvoiceItem;
import com.company.gamestoreretail.model.InvoiceViewModel;
import com.company.gamestoreretail.util.feign.*;
import com.company.gamestoreretail.util.message.LevelViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class RetailServiceLayerTest {

    @InjectMocks
    private RetailServiceLayer service;

    @Mock
    private CustomerFeignClient customerClient;

    @Mock
    private InventoryFeignClient inventoryClient;

    @Mock
    private InvoiceFeignClient invoiceClient;

    @Mock
    private LevelUpFeignClient levelClient;

    @Mock
    private ProductFeignClient productClient;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void submitInvoice() {
    }

    @Test
    public void getInvoice() {
    }

    @Test
    public void getAllInvoicesByCustomerId() {
    }

    private void setUpCustomerViewModelMock() {
        CustomerViewModel expected = new CustomerViewModel();
        expected.setCustomer_id(1);
        expected.setFirst_name("Jung");
        expected.setLast_name("Yoon");
        expected.setStreet("Somewhere st");
        expected.setCity("Decatur");
        expected.setZip("30024");
        expected.setEmail("email@email.com");
        expected.setPhone("303-303-3030");

        doReturn(expected).when(customerClient).getCustomer(1);
    }

    private void setUpInventoryMock() {
        Inventory expected = new Inventory();
        expected.setInventory_id(1);
        expected.setProduct_id(1);
        expected.setQuantity(5);

        doReturn(expected).when(inventoryClient).getInventory(1);
    }

    private void setUpInvoiceItemMock() {
        InvoiceItem expected = new InvoiceItem();
        expected.setInvoice_item_id(1);
        expected.setInvoice_id(1);
        expected.setInventory_id(1);
        expected.setQuantity(5);
        expected.setUnit_price(new BigDecimal("15.99"));

        List<InvoiceItem> iList = new ArrayList<>();
        iList.add(expected);

        doReturn(expected).when(invoiceClient).getInvoiceItem(1);
        doReturn(iList).when(invoiceClient).getAllInvoiceItems();
    }

    private void setUpInvoiceViewModelMock() {
        InvoiceViewModel expected = new InvoiceViewModel();
        expected.setInvoice_id(1);
        expected.setCustomer_id(1);
        expected.setPurchase_date(LocalDate.of(1993,8,5));

        InvoiceItem iItem = new InvoiceItem();
        iItem.setInvoice_item_id(1);
        iItem.setInvoice_id(1);
        iItem.setInventory_id(1);
        iItem.setQuantity(5);
        iItem.setUnit_price(new BigDecimal("15.99"));

        List<InvoiceItem> iList = new ArrayList<>();
        iList.add(iItem);
        expected.setInvoiceItems(iList);

        doReturn(expected).when(invoiceClient).getInvoice(1);
        doReturn(expected).when(invoiceClient).getInvoiceByCustomerId(1);
        doReturn(iList).when(invoiceClient).getAllInvoices();
    }

    private void setUpLevelModelMock() {
        LevelViewModel expected = new LevelViewModel();
        expected.setLevel_up_id(1);
        expected.setCustomer_id(1);
        expected.setMember_date(LocalDate.of(2019,10,26));
        expected.setPoints(50);


        doReturn(expected).when(levelClient).createLevelUp(expected);
        doReturn(expected).when(levelClient).getLevelUpByCustomer(1);
    }

    private void setUpProductModelMock() {

    }
}