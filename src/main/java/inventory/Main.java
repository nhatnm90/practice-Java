package inventory;

import java.util.Properties;

public class Main {
    String Name = "Nhat";

    public static void main(String[] args){
        // Câu 3
        Item cau3 = new Item();
        cau3.showItemInfo();

        // Câu 5
        Item cau5 = new Item("Item_5", 69, 11, 8, 2020, 11, 8, 2021);
        cau5.showItemInfo();

        // Câu 6
        Item Item_A = new Item("Bun", 10, 8, 8, 2018, 10, 10, 2020);
        System.out.println("Item_A");
        Item_A.thongTinSanPham();
        Item Item_B = new Item("Salad", 100, 10, 10, 2010, 9, 9, 2019);
        System.out.println("Item_B");
        Item_B.thongTinSanPham();


//        Recipe r = new Recipe("Bunbo");
//        System.out.println(r.Name);
    }

}
