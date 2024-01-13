package entitie;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date moment;
    private OrderStatus status;

    private Client client;
    private Product product;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(){

    }

    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }
    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Moment do pedido: " + moment + "\n");
        sb.append("Status do pedido: " + status + "\n");
        sb.append("Cliente: " + client.getName() + ' '
                + "(" + sdf.format(client.getBirthDate()) + ")"
                + " - " + client.getEmail()
                + "\n");
        sb.append("Itens do pedido: " + "\n");
        double totalPrice = 0.0;
        for(OrderItem i : orderItems){
            sb.append(i.getProduct().getName() + ", ");
            sb.append("R$" + i.getProduct().getPrice()+ ", ");
            sb.append("Quantidade: " + i.getQuantity() + ", ");
            sb.append("Subtotal: R$" + i.subTotal() + "\n");
            totalPrice = totalPrice + i.subTotal();
        }
        sb.append("Preço total: R$" + totalPrice);
        return sb.toString();
    }
}
