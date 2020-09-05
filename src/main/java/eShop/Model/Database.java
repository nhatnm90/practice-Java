package eShop.Model;

import java.util.List;

public class Database {
    public List<Category> categories;
    public List<Product> products;
    public List<Order> orders;
    public List<OrderDetail> orderDetails;

    public Database(List<Category> categories, List<Product> products, List<Order> orders, List<OrderDetail> orderDetails) {
        this.categories = categories;
        this.products = products;
        this.orders = orders;
        this.orderDetails = orderDetails;
    }
}
