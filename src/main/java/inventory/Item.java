package inventory;
import javax.management.ObjectName;
import java.text.SimpleDateFormat;
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
    private Object ObjectName;

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public Item(String name, int onHand) {
        this.Name = name;
        this.OnHand = onHand;
    }

    public Item(){
        setName("No Name");
        CreatedDate = Calendar.getInstance();
        Calendar createdDate = Calendar.getInstance();
        createdDate.add(Calendar.MONTH, 2);
        ExpiredDate = createdDate;

    }

    public Item(String name, int onHand, int createdDay, int createdMonth, int createdYear,int expiredDay, int expiredMonth, int expiredYear) {
        Name = name;
        OnHand = onHand;
        CreatedDate = setFormatDate(createdDay, createdMonth, createdYear);
        ExpiredDate = setFormatDate(expiredDay, expiredMonth, expiredYear);

    }

    public String formatDate(Calendar date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date currentDate = date.getTime();
        return dateFormat.format(currentDate);
    }

    public Calendar setFormatDate(int day, int month, int year) {
        Calendar formatDate = Calendar.getInstance();
        formatDate.set(year, month - 1, day );
        return formatDate;
    }

    private Boolean isExpired(Calendar expiredDate){
        Calendar currentDate = Calendar.getInstance();
        if (expiredDate.before(currentDate)){
            return true;
        }
        return false;
    }

//    private void isExpired(Calendar expiredDate){
//        if (expiredDate.before(Calendar.getInstance())) {
//            System.out.println("Sản phẩm còn hạn sử dụng");
//        }
//        System.out.println("Sản phẩm hết hạn sử dụng");
//    }

    /*
     * Show Item Info
     * */
    public void showItemInfo() {
        System.out.println("Item Name: " + Name);
        System.out.println("Item On Hand: " + OnHand);
        System.out.println("Created Date: " + formatDate(CreatedDate, "dd-MMM-YYYY"));
        System.out.println("Expired Date: " + formatDate(ExpiredDate, "dd-MMM-YYYY"));

    }    /*
     * Show Item Info Vietnamese
     * */
    public void thongTinSanPham() {
        System.out.println("Tên: " + Name);
        System.out.println("Số lượng nhập: " + OnHand);
        System.out.println("Ngày sản xuất: " + formatDate(CreatedDate, "dd-MM-YYYY"));
        System.out.println("Ngày hết hạn: " + formatDate(ExpiredDate, "dd-MM-YYYY"));
        if(isExpired(ExpiredDate)){
            System.out.println("Sản phẩm hết hạn sử dụng");
        } else {
            System.out.println("Sản phẩm còn hạn sử dụng");
        }

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
