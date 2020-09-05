package eShop;

import bank.Account;
import bank.AccountHistory;
import eShop.Model.*;
import utils.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static array.MainInteger.dash;
import static java.util.Comparator.comparing;
import static utils.StringFormat.*;

public class InitData {
    public static Database run() {

        List<Category> listCategory = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
        List<Order> listOrder = new ArrayList<>();
        List<OrderDetail> listOrderDetail = new ArrayList<>();

        //<editor-fold desc="Init Category">
        Category cateCSM = new Category("Da");
        Category cateCSD = new Category("Mặt");
        Category cateTD = new Category("Trang điểm");
        Category cateDGD = new Category("Dầu gội đầu");

        Category cateTT = new Category("Tẩy trang", cateCSM.getCategoryId());
        Category cateMN = new Category("Mặt nạ", cateCSM.getCategoryId());
        Category cateXK = new Category("Xịt khoáng", cateCSM.getCategoryId());
        Category cateKCN = new Category("Kem chống nắng", cateCSM.getCategoryId());
        Category cateDT = new Category("Dưỡng thể", cateCSD.getCategoryId());
        Category cateMSR = new Category("Mascara", cateTD.getCategoryId());
        Category cateS = new Category("Son", cateTD.getCategoryId());

        listCategory.add(cateCSM);
        listCategory.add(cateCSD);
        listCategory.add(cateTD);
        listCategory.add(cateDGD);

        listCategory.add(cateTT);
        listCategory.add(cateMN);
        listCategory.add(cateXK);
        listCategory.add(cateKCN);
        listCategory.add(cateDT);
        listCategory.add(cateMSR);
        listCategory.add(cateS);
        //</editor-fold>

        //<editor-fold desc="Init Product">
        Product product1 = new Product(cateTT.getCategoryId(), "Tẩy trang Garnier Pháp 400ml", 169000);
        Product product2 = new Product(cateTT.getCategoryId(), "Dầu tẩy trang Tatcha Cleansing Oils", 1235000);
        Product product3 = new Product(cateTT.getCategoryId(), "Bông tẩy trang Soin Pur 500 miếng", 180000);

        Product product4 = new Product(cateMN.getCategoryId(), "Mặt nạ dưỡng da Kiehl's Calendula & Aloe", 218000);
        Product product5 = new Product(cateMN.getCategoryId(), "Mặt nạ phục hồi làm sáng Cosmetic Skin Solution Phyto+ Corrective Gel Masque", 854000);
        Product product6 = new Product(cateMN.getCategoryId(), "Mặt Nạ Bơ Kiehl's Avocado Nourishing Hydration Mask 100g", 999000);

        Product product7 = new Product(cateXK.getCategoryId(), "Xịt Khoáng cho da mụn La roche Posay Serozinc", 265500);
        Product product8 = new Product(cateXK.getCategoryId(), "Xịt khoáng dưỡng da Vichy Mineralizing Thermal Water", 385000);
        Product product9 = new Product(cateXK.getCategoryId(), "Xịt khoáng Avene", 297000);
        Product product10 = new Product(cateXK.getCategoryId(), "Xịt dưỡng cấp ẩm làm sáng Dr Dennis C", 814000);

        Product product11 = new Product(cateKCN.getCategoryId(), "Kem chống nắng SkinCeuticals Fusion Spf 50 4ml", 110000);
        Product product12 = new Product(cateKCN.getCategoryId(), "Kem chống nắng Neutrogena Beach Defense Sunscreen Lotion with Broad Spectrum SPF 70 Protection", 297000);
        Product product13 = new Product(cateKCN.getCategoryId(), "Kem chống nắng Heliocare Advanced Gel SPF50", 877000);
        Product product14 = new Product(cateKCN.getCategoryId(), "Kem chống nắng cho da dầu PCA Weightless Protection Broad Spectrum SPF 45 - 7.5g", 171000);
        Product product15 = new Product(cateKCN.getCategoryId(), "Kem chống nắng Skinceuticals Sheer Physical UV Defense SPF50", 1690000);

        Product product16 = new Product(cateDT.getCategoryId(), "Tẩy Tế Bào Chết Chiết Xuất Từ Xương Rồng Huxley Secret Of Sahara Scrub Mask", 117000);
        Product product17 = new Product(cateDT.getCategoryId(), "Sữa tắm Molton Brown Orange & Bergamot 30ml", 54000);
        Product product18 = new Product(cateDT.getCategoryId(), "Set Nuxe son dưỡng và kem dưỡng tay Nuxe", 267000);

        Product product19 = new Product(cateMSR.getCategoryId(), "Chì kẻ mày hai đầu Studio Pro Shade & Define Duo Brow Pencil", 125000);
        Product product20 = new Product(cateMSR.getCategoryId(), "Chì kẻ mày BH Cosmetics Studio Pro HD Brow Pencil", 135000);
        Product product21 = new Product(cateMSR.getCategoryId(), "Bộ Mascara Urban Decay Primed for Perversion + Subversion Duo", 485000);
        Product product22 = new Product(cateMSR.getCategoryId(), "e.l.f. Studio Eyebrow Duo Brush - Cọ Kẻ Và Chải Mày 2 Đầu", 108000);
        Product product23 = new Product(cateMSR.getCategoryId(), "Gel chân mày BH Cosmetics Studio Pro Waterproof Brow Pomade", 135000);

        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);
        listProduct.add(product4);
        listProduct.add(product5);
        listProduct.add(product6);
        listProduct.add(product7);
        listProduct.add(product8);
        listProduct.add(product9);
        listProduct.add(product10);
        listProduct.add(product11);
        listProduct.add(product12);
        listProduct.add(product13);
        listProduct.add(product14);
        listProduct.add(product15);
        listProduct.add(product16);
        listProduct.add(product17);
        listProduct.add(product18);
        listProduct.add(product19);
        listProduct.add(product20);
        listProduct.add(product21);
        listProduct.add(product22);
        listProduct.add(product23);
        //</editor-fold>

        //<editor-fold desc="Init Order">
        Calendar createdDate1 = Calendar.getInstance();
        createdDate1.set(2020,Calendar.SEPTEMBER,01);
        Order order1 = new Order(Order.PaymentMethod.Cash, Order.ShippingBrand.GHN);
        Order order2 = new Order(Order.PaymentMethod.Momo, Order.ShippingBrand.GHTK);
        Order order3 = new Order(Order.PaymentMethod.CreditCard, Order.ShippingBrand.VNPost);
        Calendar createdDate4 = Calendar.getInstance();
        createdDate4.set(2020,Calendar.AUGUST,24);
        Order order4 = new Order(Order.PaymentMethod.CreditCard, Order.ShippingBrand.Nasco, createdDate4);
        Order order5 = new Order(Order.PaymentMethod.Cash, Order.ShippingBrand.GHTK);
        Order order6 = new Order(Order.PaymentMethod.Cash, Order.ShippingBrand.Nasco);
        Order order7 = new Order(Order.PaymentMethod.CreditCard, Order.ShippingBrand.GHN);
        Calendar createdDate8 = Calendar.getInstance();
        createdDate8.set(2020,Calendar.JULY,24);
        Order order8 = new Order(Order.PaymentMethod.Cash, Order.ShippingBrand.Nasco, createdDate8);
        Order order9 = new Order(Order.PaymentMethod.Momo, Order.ShippingBrand.GHTK);
        Calendar createdDate10 = Calendar.getInstance();
        createdDate10.set(2020,Calendar.JUNE,24);
        Order order10 = new Order(Order.PaymentMethod.Cash, Order.ShippingBrand.GHN, createdDate10);

        listOrder.add(order1);
        listOrder.add(order2);
        listOrder.add(order3);
        listOrder.add(order4);
        listOrder.add(order5);
        listOrder.add(order6);
        listOrder.add(order7);
        listOrder.add(order8);
        listOrder.add(order9);
        listOrder.add(order10);
        //</editor-fold>

        //<editor-fold desc="Init OrderDetail">
        OrderDetail orderDetail1a = new OrderDetail(product1.getProductId(), order1.getOrderId(), 1);
        OrderDetail orderDetail1b = new OrderDetail(product11.getProductId(), order1.getOrderId(), 1);

        OrderDetail orderDetail2a = new OrderDetail(product2.getProductId(), order2.getOrderId(), 1);
        OrderDetail orderDetail2b = new OrderDetail(product2.getProductId(), order2.getOrderId(), 1);
        OrderDetail orderDetail2c = new OrderDetail(product22.getProductId(), order2.getOrderId(), 2);

        OrderDetail orderDetail3a = new OrderDetail(product3.getProductId(), order3.getOrderId(), 6);
        OrderDetail orderDetail3b = new OrderDetail(product23.getProductId(), order3.getOrderId(), 5);
        OrderDetail orderDetail3c = new OrderDetail(product4.getProductId(), order3.getOrderId(), 4);
        OrderDetail orderDetail3d = new OrderDetail(product14.getProductId(), order3.getOrderId(), 3);
        OrderDetail orderDetail3e = new OrderDetail(product13.getProductId(), order3.getOrderId(), 2);

        OrderDetail orderDetail4a = new OrderDetail(product5.getProductId(), order4.getOrderId(), 1);
        OrderDetail orderDetail4b = new OrderDetail(product6.getProductId(), order4.getOrderId(), 2);

        OrderDetail orderDetail5a = new OrderDetail(product10.getProductId(), order5.getOrderId(), 10);

        OrderDetail orderDetail6a = new OrderDetail(product7.getProductId(), order6.getOrderId(), 3);
        OrderDetail orderDetail6b = new OrderDetail(product8.getProductId(), order6.getOrderId(), 1);

        OrderDetail orderDetail7a = new OrderDetail(product9.getProductId(), order7.getOrderId(), 2);
        OrderDetail orderDetail7b = new OrderDetail(product15.getProductId(), order7.getOrderId(), 1);

        OrderDetail orderDetail8a = new OrderDetail(product16.getProductId(), order8.getOrderId(), 3);
        OrderDetail orderDetail8b = new OrderDetail(product18.getProductId(), order8.getOrderId(), 2);
        OrderDetail orderDetail8c = new OrderDetail(product17.getProductId(), order8.getOrderId(), 4);

        OrderDetail orderDetail9a = new OrderDetail(product19.getProductId(), order9.getOrderId(), 2);
        OrderDetail orderDetail9b = new OrderDetail(product8.getProductId(), order9.getOrderId(), 1);
        OrderDetail orderDetail9c = new OrderDetail(product1.getProductId(), order9.getOrderId(), 5);
        OrderDetail orderDetail9d = new OrderDetail(product3.getProductId(), order9.getOrderId(), 1);

        OrderDetail orderDetail10a = new OrderDetail(product7.getProductId(), order10.getOrderId(), 2);
        OrderDetail orderDetail10b = new OrderDetail(product8.getProductId(), order10.getOrderId(), 2);

        listOrderDetail.add(orderDetail1a);
        listOrderDetail.add(orderDetail1b);

        listOrderDetail.add(orderDetail2a);
        listOrderDetail.add(orderDetail2b);
        listOrderDetail.add(orderDetail2c);

        listOrderDetail.add(orderDetail3a);
        listOrderDetail.add(orderDetail3b);
        listOrderDetail.add(orderDetail3c);
        listOrderDetail.add(orderDetail3d);
        listOrderDetail.add(orderDetail3e);

        listOrderDetail.add(orderDetail4a);
        listOrderDetail.add(orderDetail4b);

        listOrderDetail.add(orderDetail5a);

        listOrderDetail.add(orderDetail6a);
        listOrderDetail.add(orderDetail6b);

        listOrderDetail.add(orderDetail7a);
        listOrderDetail.add(orderDetail7b);

        listOrderDetail.add(orderDetail8a);
        listOrderDetail.add(orderDetail8b);
        listOrderDetail.add(orderDetail8c);

        listOrderDetail.add(orderDetail9a);
        listOrderDetail.add(orderDetail9b);
        listOrderDetail.add(orderDetail9c);
        listOrderDetail.add(orderDetail9d);

        listOrderDetail.add(orderDetail10a);
        listOrderDetail.add(orderDetail10b);
        //</editor-fold>

        return new Database(listCategory, listProduct, listOrder, listOrderDetail);
    }
}


