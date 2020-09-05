package eShop.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Order {

    //<editor-fold desc="Constant">
    private static final long INITIALIZED_BALANCE = 100;

    public enum ShippingBrand {
        GHTK,
        GHN,
        Viettel,
        VNPost,
        Nasco
    }

    public enum Status {
        waitingForPayment,
        confirmed,
        shipping,
        received,
        cancelled
    }

    public enum PaymentMethod {
        Cash,
        Momo,
        Grab,
        CreditCard
    }
    //</editor-fold>

    //<editor-fold desc="Propeties">
    private UUID orderId;
    private double totalPrice;
    private Calendar createdDate;
    private ShippingBrand shippingBrand;
    private Status status;
    private PaymentMethod paymentMethod;
    private List<OrderDetail> orderDetails;
    //</editor-fold>

    //<editor-fold desc="Getter Setter">
    public UUID getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public ShippingBrand getShippingBrand() {
        return shippingBrand;
    }

    public Status getStatus() {
        return status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public void setShippingBrand(ShippingBrand shippingBrand) {
        this.shippingBrand = shippingBrand;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    //</editor-fold>

    //<editor-fold desc="Constructor">
    public Order(PaymentMethod paymentMethod, ShippingBrand shippingBrand) {
        this.createdDate = Calendar.getInstance();
        this.orderId = UUID.randomUUID();
        this.status = Status.waitingForPayment;
        this.orderDetails = new ArrayList<>();
        this.paymentMethod = paymentMethod;
        this.shippingBrand = shippingBrand;
    }
    //</editor-fold>

    //<editor-fold desc="Private functions">

    //</editor-fold>

    //<editor-fold desc="Public functions">

    //</editor-fold>
}


