package bank;

import java.util.Calendar;
import java.util.UUID;

public class AccountHistory {
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

    public AccountHistory(long balance, Type type) {
        this.historyId =  UUID.randomUUID();
        this.createdDate = Calendar.getInstance();
        this.balance = balance;
        this.type = type;
    }
}
