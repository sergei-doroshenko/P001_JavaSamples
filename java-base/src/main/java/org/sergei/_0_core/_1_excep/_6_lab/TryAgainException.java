package org.sergei._0_core._1_excep._6_lab;

/**
 * Created by Sergei on 28.02.2015.
 */
public class TryAgainException extends Exception {

    public TryAgainException(String message) {
        super(message);
    }

    public TryAgainException(String message, Throwable cause) {
        super(message, cause);
    }
}
