package com.kevin.springboot.factura.springboot_difactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Cliente cliente;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("itemsInvoice")
    private List<Item> items;

    @PostConstruct // trabajamos luego de que la instancia esta creada para modificar esa data
    public void init() {
        System.out.println("creando componente de la factura");
        cliente.setName(cliente.getName().concat(" Pepito"));
        description = description.concat(" con papas fritas");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("eliminando componente de la factura");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
//        int total = 0;
//        for (Item item : items) {
//            total += item.getImporte();//lo mismo que etner total = total + item.get...
//        }
        // return items.stream().map(item -> item.getImporte()).reduce(0, (sum, importe) -> sum + importe);
        return items.stream()
                .mapToInt(Item::getImporte)
                .sum();//ya que el valor de importe es un dato primitivo podemos usar esto
    }
}
