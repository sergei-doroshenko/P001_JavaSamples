package core._1_excep._6_lab;

/**
 * Created by Sergei on 28.02.2015.
 */
public class AccountManagerImpl implements AccountManager {
    @Override
    public boolean transfer(Account[] accounts, int[] money) {
        for (int i = 0; i < accounts.length; i++) {
            try {

                while (true) {
                    try {
                        accounts[i].cange(money[i]);
                        break;
                    } catch (TryAgainException e) {
                        System.err.println(e.getMessage() + ", " + ( (AccountImpl) accounts[i]).getId());
                    }
                }


            } catch (BlockAccountException e) {
                System.err.println(e.getMessage() + ", " + ( (AccountImpl) accounts[i]).getId());
                System.err.println("Rollbak");
               for (int k = i-1; k >= 0; k--) {
                   while (true) {
                       try {
                           accounts[k].cange(-money[k]);
                           break;
                       } catch (Exception e1) {
                           System.err.println(e1.getMessage() + ", " + ( (AccountImpl) accounts[k]).getId());
                       }
                   }
               }
                return false;
            }
        }

        return true;
    }
}
