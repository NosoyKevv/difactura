package com.kevin.springboot.factura.springboot_difactura.controllers;

import com.kevin.springboot.factura.springboot_difactura.models.Cliente;
import com.kevin.springboot.factura.springboot_difactura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show() {
        Invoice i = new Invoice();
        Cliente c = new Cliente();
        c.setLastName(invoice.getCliente().getLastName());
        c.setName(invoice.getCliente().getName());
        i.setCliente(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
        return i;
    }
}
