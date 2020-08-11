package bank;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Account {
    private long accountId;
    private String firstName;
    private String lastName;
    private Calendar CreatedDate;
    private float rate;
    private long currentBalance;
    private List<String> history;
    private Period period;

    public enum  Period {
        Week,
        Month,
        Quarter,
        Year
    }

    /*
     * 1. Tạo constructor để tạo đối tượng
     * - số tài khoản
     * - tên + họ
     * - số tiền mặc định ban đầu là 50k
     * - ngày tạo là ngày hiện tại
     *
     * 2. Viết hàm in ra thông tin đối tượng vừa tạo
     *
     * 3. Viết hàm thực hiện thao tác nạp tiền, rút tiền 1 cách hoàn chỉnh (kiểm tra đầu vào đầu ra)
     *
     * 4. Tạo constructor để tạo đối tượng có tham số truyền vào là kỳ hạn (Period) và tính ra lãi suất theo công thức sau
     *  - Week: 3%
     *  - Month: 5%
     *  - Quarter: 10%
     *  - Year: 16%
     *
     * 5. Viết hàm thực hiện phương thức đáo hạn
     *  - Mỗi lần gọi phương thức này sẽ tính lại currentBalance
     *      currentBalance = currentBalance + currentBalance*rate
     *
     * 6. * Thêm vào 1 thuộc tính là ngày quyết toán (ngày kết thúc kì hạn gửi tiền)
     *  - Tính toán số tiền cuối cùng nhận được theo công thức sau: TBD
     * */


}
