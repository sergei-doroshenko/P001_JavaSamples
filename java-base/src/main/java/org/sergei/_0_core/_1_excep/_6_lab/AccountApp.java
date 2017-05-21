package org.sergei._0_core._1_excep._6_lab;

import java.util.Arrays;

/**
 * Created by Sergei on 28.02.2015.
 */
public class AccountApp {
    public static void main(String[] args) {
        Account a0 = new AccountImpl(0, 300);
        Account a1 = new AccountImpl(1, 0);
        Account a2 = new AccountImpl(2, 0);

        Account[] arr = {a0, a1, a2};
        System.err.println(Arrays.toString(arr));
        int[] money = {-100, 50, 50};

        AccountManager manager = new AccountManagerImpl();

        manager.transfer(arr, money);
        System.err.println(Arrays.toString(arr));
    }
}
