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
        if(this.findAccountById(accountId) == null){
            System.out.println("Tài khoản " + accountId + "không tồn tại");
        }
    }

//    public void addNewHistory (long accountId, AccountHistory.Type type) {
//        Account
//    }

    public void Transfer(long sourceAccountId, long destinationAccountId, long value) {
        // validation
        if (this.accounts.size() < 2 || sourceAccountId == destinationAccountId) {
            return;
        }
        Account sourceAccount = this.findAccountById(sourceAccountId);
        if(sourceAccount == null) {
            System.out.println("Tài khoản " + sourceAccountId + "không tồn tại");
            return;
        }
        if (sourceAccount.getCurrentBalance() - value < 50000) {
            System.out.println("Số tiền trong tài khoản không đủ để thực hiện giao dịch");
            return;
        } else {
            sourceAccount.subMoney(value, AccountHistory.Type.transferOut);
//           long currentBalance = sourceAccount.getCurrentBalance();
//            sourceAccount.setCurrentBalance(currentBalance - value);
//            List<AccountHistory> currentHistories = sourceAccount.getHistories();
//            AccountHistory history = new AccountHistory(value, AccountHistory.Type.transferOut);
//            currentHistories.add(history);
//            sourceAccount.setHistories(currentHistories);

        }
        Account destinationAccount = this.findAccountById(destinationAccountId);
        if (destinationAccount == null) {
            System.out.println("Tài khoản " + destinationAccountId + "không tồn tại");
            return;
        }
        destinationAccount.addMoney(value, AccountHistory.Type.transferIn);

//        long currentBalance = destinationAccount.getCurrentBalance();
//        destinationAccount.setCurrentBalance(currentBalance + value);
//        List<AccountHistory> currentHistories = destinationAccount.getHistories();
//        AccountHistory history = new AccountHistory(value, AccountHistory.Type.transferIn);
//        currentHistories.add(history);
//        destinationAccount.setHistories(currentHistories);

//        AccountHistory history = new AccountHistory(value, AccountHistory.Type.out);
//        destinationAccount.setHistories();

    }
    //</editor-fold>

    //<editor-fold desc="Private functions">
    private Account findAccountById (long accountId) {
        return this.accounts.stream()
                .filter(account ->
                        account.getAccountId() == accountId ||
                        account.getCurrentBalance() > 6
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
