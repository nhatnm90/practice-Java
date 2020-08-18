package bank;

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
    public void Transfer() {
        if (this.accounts.size() != 2) {
            return;
        }
        Account sourceAccount = this.accounts.get(0);
        Account destinationAccount = this.accounts.get(1);
        // todo: add logic to transfer money between 2 accounts above
        sourceAccount.addMoney(11000);
        destinationAccount.addMoney(15000);
        destinationAccount.subMoney(11000);
    }
    //</editor-fold>
}
