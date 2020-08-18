package bank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class ProcessServices {

    //<editor-fold desc="Constant">
    //</editor-fold>

    //<editor-fold desc="Properties">
    private List<Account> accounts;
    //</editor-fold>

    //<editor-fold desc="Getter Setter">
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public ProcessServices(List<Account> accounts) {
        this.accounts = accounts;
    }
    //</editor-fold>

    //<editor-fold desc="Public functions">
    public void Transfer(long sourceAccountId, long destinationAccountId) {
        // validation
        if (this.accounts.size() < 2 || sourceAccountId == destinationAccountId) {
            return;
        }
        Account sourceAccount = this.findAccountById(sourceAccountId);
        Account destinationAccount = this.findAccountById(destinationAccountId);
        // todo: add logic to transfer money between 2 accounts above
        sourceAccount.addMoney(11000);
        destinationAccount.addMoney(15000);
        destinationAccount.subMoney(11000);
    }
    //</editor-fold>

    //<editor-fold desc="Private functions">
    private Account findAccountById (long accountId) {
        return this.accounts.stream()
                .filter(account -> {
                    return account.getAccountId() == accountId;
                })
                .findAny()
                .orElse(null);
    }
    //</editor-fold>
}
