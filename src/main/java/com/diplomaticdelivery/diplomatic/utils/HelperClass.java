package com.diplomaticdelivery.diplomatic.utils;

public class HelperClass {

    public static String generateAccountNumber(){
        long number = (long) (Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);

        return String.valueOf(number);
    }
}
