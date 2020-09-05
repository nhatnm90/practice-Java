package eShop.Model;

import java.util.Calendar;
import java.util.UUID;

public class OrderDetail {

    //<editor-fold desc="Constant">

    //</editor-fold>

    //<editor-fold desc="Propeties">
    private UUID orderDetailId;
    private UUID productId;
    private UUID orderId;
    private long quantity;
    private double unitPrice;
    private boolean isReturn;
    private double totalPrice;
    //</editor-fold>

    //<editor-fold desc="Getter Setter">

    //</editor-fold>

    //<editor-fold desc="Constructor">
    public OrderDetail(UUID productId, UUID orderId, long quantity) {
        this.orderDetailId = UUID.randomUUID();
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.isReturn = false;
    }
    //</editor-fold>

    //<editor-fold desc="Private functions">

    //</editor-fold>

    //<editor-fold desc="Public functions">

    //</editor-fold>
}


