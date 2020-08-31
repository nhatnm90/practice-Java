package bank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public void checkValidAcc(long accountId){
        if (this.findAccountById(accountId) == null){
            System.out.println("Tài khoản " + accountId + "không tồn tại");
        }
    }

    public void Transfer(long sourceAccountId, long destinationAccountId, long value) {
        // validation
        if (this.accounts.size() < 2 || sourceAccountId == destinationAccountId) {
            return;
        }
        Account sourceAccount = this.findAccountById(sourceAccountId);
        // check valid account
        if(sourceAccount == null) {
            System.out.println("Tài khoản " + sourceAccountId + "không tồn tại");
            return;
        }
        sourceAccount.transferMoney(value, destinationAccountId);
        Account destinationAccount = this.findAccountById(destinationAccountId);
        if (destinationAccount == null) {
            System.out.println("Tài khoản " + destinationAccountId + "không tồn tại");
            return;
        }
        destinationAccount.receiveMoney(value, sourceAccountId);

    }
    //</editor-fold>

    //<editor-fold desc="Private functions">
    private Account findAccountById (long accountId) {
        return this.accounts.stream()
                .filter(account ->
                        account.getAccountId() == accountId
                ) // a = [abc]
                .findAny() //= > abc
                .orElse(null);
    }

    private Account filter(long balance) {
        List<Account> result = this.accounts.stream()
                .filter(account -> account.getCurrentBalance() > balance)
                .collect(Collectors.toList()); // return [a, b, c]
        Account finalResult = result.stream().filter(x -> x.getCurrentBalance() == 50000).findAny().orElse(null);// return a
        return finalResult;

    }

    //</editor-fold>
}
