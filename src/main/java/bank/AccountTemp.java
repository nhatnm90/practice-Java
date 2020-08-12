package bank;
import java.util.Calendar;
import java.util.List;

public class AccountTemp {
    private long accountId;
    private String firstName;
    private String lastName;
    private Calendar createdDate;
    private Calendar endDate;
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

    public AccountTemp(long accountId, String firstName, String lastName, Calendar createdDate, Calendar endDate, long currentBalance, Period period) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.rate = rate;
        this.currentBalance = currentBalance;
        this.period = period;
    }

    private long generateTotalBalance() {
        return 0;
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
    }
}
