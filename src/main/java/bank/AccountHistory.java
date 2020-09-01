package bank;

import utils.StringFormat;

import java.text.NumberFormat;
import java.util.*;

import static utils.StringFormat.printSeparatedLine;

public class AccountHistory {

    //<editor-fold desc="Constant">
    private static final String FORMAT_DATE_TEMPLATE = "dd-MM-yyyy hh:mm:ss";
    //</editor-fold>

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
    public String fullName;
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
    public AccountHistory(long balance, Type type, long accountId) {
        this.historyId =  UUID.randomUUID();
        this.createdDate = Calendar.getInstance();
        this.balance = balance;
        this.type = type;
        if (type == Type.transferIn) {
            this.destinationAccountId = accountId;
        }
        if (type == Type.transferOut) {
            this.sourceAccountId = accountId;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Public functions">


    public String translatedType() {
        switch (type) {
            case in:
                return "Nạp tiền";
            case out:
                return "Rút tiền";
            case transferIn:
                return "Nhận tiền";
            case transferOut:
                return "Chuyển tiền";
        }
        return null;
    }


    public void showInfo() {
        System.out.println("- Ngày giao dịch: " + StringFormat.formatDate(this.createdDate, FORMAT_DATE_TEMPLATE));
        System.out.println("- Số tiền: " + StringFormat.formatCurrency(this.balance));
        System.out.println("- Loại giao dịch: " + this.translatedType());
        System.out.println("- Người nạp: " + this.fullName);
        StringFormat.printSeparatedLine();
    }

    public void showInfoWithoutType() {
        printSeparatedLine(50, "-");
        System.out.println("- Ngày giao dịch: " + StringFormat.formatDate(this.createdDate, FORMAT_DATE_TEMPLATE));
        System.out.println("- Số tiền: " + StringFormat.formatCurrency(this.balance));
        if (this.type == Type.transferIn) {
            System.out.println("- Người nạp: " + this.fullName);
        } else {
            System.out.println("- Người tạo: " + this.fullName);
        }
    }


    //</editor-fold>
}
