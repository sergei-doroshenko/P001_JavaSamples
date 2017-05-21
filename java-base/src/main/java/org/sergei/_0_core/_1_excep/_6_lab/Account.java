package org.sergei._0_core._1_excep._6_lab;

/**
 * Created by Sergei on 28.02.2015.
 */
public interface Account {
    void cange (int delta) throws TryAgainException, BlockAccountException;
}
