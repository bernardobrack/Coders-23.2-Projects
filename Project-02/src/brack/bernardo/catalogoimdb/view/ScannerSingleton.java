package brack.bernardo.catalogoimdb.view;

import java.util.Scanner;

public class ScannerSingleton {
    private static ScannerSingleton instance;
    private final Scanner scanner;
    private ScannerSingleton() {
        this.scanner = new Scanner(System.in);
    }
    public static ScannerSingleton getInstance() {
        if(instance == null) {
            instance = new ScannerSingleton();
        }
        return instance;
    }
    public Scanner getScanner() {
        return this.scanner;
    }

}
