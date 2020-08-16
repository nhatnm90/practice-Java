package bank;

import java.util.Calendar;
import java.util.UUID;

public class AccountHistory implements Comparable<AccountHistory> {

    //<editor-fold desc="Constant">
    public enum Type {
        in,
        out,
        transferIn,
        transferOut
    }
    //</editor-fold>

    //<editor-fold desc="Properties">
    private UUID historyId;
    private Calendar createdDate;
    private long balance;
    private Type type;
    private long sourceAccountId;
    private long destinationAccountId;
    //</editor-fold>

    //<editor-fold desc="Getter Setter">
    public Calendar getCreatedDate() {
        return createdDate;
    }

    public UUID getHistoryId() {
        return historyId;
    }

    public long getBalance() {
        return balance;
    }

    public Type getType() {
        return type;
    }

    public long getSourceAccountId() {
        return sourceAccountId;
    }

    public long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setSourceAccountId(long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public void setDestinationAccountId(long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public AccountHistory(long balance, Type type) {
        this.historyId =  UUID.randomUUID();
        this.createdDate = Calendar.getInstance();
        this.balance = balance;
        this.type = type;
    }
    //</editor-fold>

    //<editor-fold desc="Public functions">
    public int compareTo(AccountHistory accountHistory) {
        if (this.createdDate.equals(accountHistory.createdDate))
            return 0;
        else if (createdDate.after(accountHistory.createdDate))
            return -1;
        else
            return 1;
    }
    //</editor-fold>
}
