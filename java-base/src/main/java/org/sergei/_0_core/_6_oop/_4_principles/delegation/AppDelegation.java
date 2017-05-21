package org.sergei._0_core._6_oop._4_principles.delegation;

import java.util.Arrays;

/**
 * Created by Sergei on 18.03.2015.
 */
public class AppDelegation {
    public static void main(String[] args) {

        Delegation<Integer> delegation = new Delegation<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(delegation.max());
        System.out.println(delegation);

        Delegation<String> delegation1 = new Delegation<>(Arrays.asList("A", "_", "B", "C"));
        System.out.println(delegation1);
    }
}
