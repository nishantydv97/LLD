package util;

import java.util.Scanner;


public class InputUtil {
    private static Scanner sc;
    public static synchronized Scanner getScanner(){
        if(sc!=null){
            return sc;
        }else{
            return new Scanner(System.in);
        }
    }
}
