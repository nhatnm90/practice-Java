package bank;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Account {
    private long accountId;
    private String firstName;
    private String lastName;
    private Calendar createdDate;
    private float rate;
    private long currentBalance;
    private Calendar endDate;
    private List<String> history;
    private Period period;

    public enum Period {
        Week,
        Month,
        Quarter,
        Year
    }

    public Account(long accountId, String firstName, String lastName) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = Calendar.getInstance();
        this.currentBalance = 50000;
    }

    public Account(Period period) {
        switch (period) {
            case Week:
                rate = 3;
                break;
            case Month:
                rate = 5;
                break;
            case Quarter:
                rate = 10;
                break;
            case Year:
                rate = 16;
                break;
        }
        this.currentBalance = 50000;
    }

    public Account(long accountId, String firstName, String lastName, Calendar createdDate, Calendar endDate, long currentBalance, Period period) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.currentBalance = currentBalance;
        this.period = period;
        switch (period) {
            case Week:
                rate = 3;
                break;
            case Month:
                rate = 5;
                break;
            case Quarter:
                rate = 10;
                break;
            case Year:
                rate = 16;
                break;
        }
    }

    public String formatDate(Calendar date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date currentDate = date.getTime();
        return dateFormat.format(currentDate);
    }

    /*
     * Show Info
     * */
    public void showInfo() {
        System.out.println("- Số tài khoản: " + accountId);
        System.out.println("- Tên + Họ: " + firstName + " " + lastName);
        System.out.println("- Số tiền trong tài khoản: " + currentBalance);
        System.out.println("- Ngày tạo tài khoản: " + formatDate(createdDate, "dd-MM-YYYY"));
    }

    /*
     * Recalculate current balance when adding more money
     * @param value of money
     * */
    public void addMoney(long value) {
        currentBalance = currentBalance + value;
    }
    /*
     * Recalculate current balance when subtracting money
     * @param value of money
     * */
    public void subMoney(long value) {
        if ((currentBalance - 50000) >= value) {
            currentBalance = currentBalance - value;
        } else {
            System.out.println("Số tiền trong tài khoản không đủ");
        }
    }

    /*
     * Recalculate current balance with rate
     * */
    public void recalculatedBalance() {
        currentBalance = currentBalance + (currentBalance * (long) rate) / 100;

    }

    public float getRate() {
        return rate;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    /*
     * Tính ra số ngày cần cộng thêm theo chu kì, tự quy định chu kì Week +7, Month +30, Quarter +120, Year +365
     * */
    private int generateNumberOfAddedDays() {
        switch (this.period) {
            case Week:
                return 7;
            case Month:
                return 30;
            case Quarter:
                return 120;
            case Year:
                return 365;
        }
        return 0;
    }

    /*
     * Tính ra số lượng chu kì đã trả qua cho khách hàng đó tính từ ngày start -> end
     * Vd: khách hàng chọn
     * Khách hàng 1
     * - period: week
     * - startDate:  01-01-2020
     * - endDate:    06-01-2020
     * -> chưa qua đc chu kì nào -> result = 0
     *
     * Khách hàng 2
     * - period: week
     * - startDate:  01-01-2020
     * - endDate:    15-01-2020
     * -> Đã qua đc 2 chu kì (2 tuần) -> result = 2
     * */
    public int generateNumberOfExpiredDate() {
        // Lấy ngày hiện tại cộng với số ngày cần thêm vào theo Period
        // Nếu đã sau ngày kết thúc -> return 0 do chưa thỏa đc bất kì kì hạn nào
        this.createdDate.add(Calendar.DATE, generateNumberOfAddedDays());
        if (this.createdDate.after(this.endDate)) {
            return 0;
        }
        int result = 0;
        do {
            this.createdDate.add(Calendar.DATE, generateNumberOfAddedDays());
            result += 1;
        }
        while (this.createdDate.before(this.endDate));
        return result;
    }

    /*
     * Hàm tính tổng tiền lãnh
     * Dựa vào số chu kì đã đc tính bên trên, loop qua danh sách chu kì và cộng đồn tiền theo công thức
     * */
    public void calculateCurrentBalance() {
        // Todo: code here
        int noOfRate = this.generateNumberOfExpiredDate();

        for (int i = 1; i <= noOfRate; i++) {
            this.recalculatedBalance();
        }
    }


    public void calculatedEndBalance() {
        int totalDays = 0;
        Calendar currentDate = Calendar.getInstance();
        while (this.endDate.after(currentDate)) {
            this.endDate.add(Calendar.DATE, 1);
            totalDays = totalDays + 1;
        }
        long totalPeriods = 0;
        if (this.period == Period.Week) {
            totalPeriods = Math.round(totalDays / 7);
        } else if (this.period == Period.Month) {
            totalPeriods = Math.round(totalDays / 30);
        } else if (this.period == Period.Quarter) {
            totalPeriods = Math.round(totalDays / 90);
        } else {
            totalPeriods = Math.round(totalDays / 365);
        }
        currentBalance = currentBalance + (currentBalance * (long) rate * totalPeriods);
    }
}
    /*
        public int calculateAge() {
        int totalDays = 0;
        Calendar currentDate = Calendar.getInstance();
        while (this.BirthDate.before(currentDate)) {
            this.BirthDate.add(Calendar.DATE, 1);
            totalDays = totalDays + 1;
        }
        return Math.round(totalDays / 365);
    }
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



