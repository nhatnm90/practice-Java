package inventory;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Item {
    private UUID Id;
    private String Name;
    private Calendar CreatedDate;
    private Calendar ExpiredDate;
    private int OnHand;
    private boolean IsRecipe;

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    /*
     * 1. Tạo constructor để tạo đối tượng với tên (Name) và số lượng nhập kho cho trước (OnHand)
     *
     * 2. Viết hàm in ra thông tin đối tượng vừa tạo
     *
     * 3. Tạo constructor để tự gán 1 vài thông số mặc định khi khởi tạo 1 đối tượng Item
     * - Ngày sản xuất (CreatedDate) là ngày hiện tại
     * - Ngày hết hạn (ExpiredDate) là 2 tháng sau khi sản xuất
     *
     * 4. Tạo 1 đối tượng mới từ constructor ở câu 3 và in ra thông tin đối tượng đó
     *
     * 5. Tạo constructor để tạo mới đối tượng với những thông số cần truyền là:
     * - Tên
     * - Số lượng nhập
     * - Ngày sản xuất
     * - Ngày hết hạn
     *
     * 6. Tạo 1 đối tượng với constructor vừa tạo ở câu 5 và viết hàm in ra thông tin của đối tượng đó theo format sau:0
     * Item A:
     * - Tên: Bun
     * - Số lương: 10
     * - Ngày sản xuất: 08-08-2018
     * - Ngày hết hạn: 10-10-2020
     * - Sản phẩm còn hạn sử dụng
     *
     * ItemB
     * - Tên: Salad
     * - Số lương: 100
     * - Ngày sản xuất: 10-10-2010
     * - Ngày hết hạn: 09-09-2019
     * - Sản phẩm hết hạn sử dụng
     * */


}
