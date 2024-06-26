package com.alura.validaciones;

import java.io.IOException;
import java.net.InetAddress;

public class Valid {

    public static boolean connection() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            return address.isReachable(5000);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isString(String str){
        try{
            Double.parseDouble(str);
            return false;
        } catch(NumberFormatException nfe){
            return true;
        }
    }
}
