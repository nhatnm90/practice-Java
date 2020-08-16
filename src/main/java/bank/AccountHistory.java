package bank;

import java.util.Calendar;
import java.util.UUID;

public class AccountHistory implements Comparable<AccountHistory> {
    private UUID historyId;
    private Calendar createdDate;
    private long balance;
    private Type type;

    public enum Type {
        in,
        out,
        transferIn,
        transferOut
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public AccountHistory(long balance, Type type) {
        this.historyId =  UUID.randomUUID();
        this.createdDate = Calendar.getInstance();
        this.balance = balance;
        this.type = type;
    }

    public int compareTo(AccountHistory accountHistory) {
        if (this.createdDate.equals(accountHistory.createdDate))
            return 0;
        else if (createdDate.after(accountHistory.createdDate))
            return -1;
        else
            return 1;
    }
}
