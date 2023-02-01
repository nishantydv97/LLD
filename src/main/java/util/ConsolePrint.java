package util;

public class ConsolePrint implements Print{
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
