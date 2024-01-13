package application;

import entitie.Client;
import entitie.Order;
import entitie.OrderItem;
import entitie.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.Scanner;

public class Program {
    public static void main(String[]args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Order order;
        OrderItem product;

        System.out.println("Entre com os dados do cliente: ");
        System.out.print("Nome: ");
        String client = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de Aniversário(DD/MM/AAAA): ");
        Date birthDate = sdf.parse(sc.next());
        System.out.println("Entre com os dados do pedido: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        order = new Order(new Date(), status, new Client(client, email, birthDate));
        System.out.print("Quantos pedidos deseja fazer: ");
        int qtdOrder = sc.nextInt();

        for(int i = 0; i < qtdOrder; i++){
            System.out.printf("Digite os dados do produto %d:%n", i + 1);
            System.out.print("Nome do produto: ");
            String nameProduct = sc.next();
            System.out.print("Preço do produto: ");
            double priceProduct = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();
            product = new OrderItem(quantity, priceProduct, new Product(nameProduct, priceProduct));
            order.addItem(product);
        }
        System.out.println(order);

    }
}
