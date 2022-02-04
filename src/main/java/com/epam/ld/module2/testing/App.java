package com.epam.ld.module2.testing;

/**
 * Main app class
 */
public class App {
    /**
     * Main method
     * @param args runtime args
     */
    public static void main(String[] args) {

        System.out.println(System.getProperty("argumentA"));
        System.out.println(System.getProperty("argumentB"));

        for(int i=0; i<args.length; i++) {
            System.out.println("Argument " + i + " equals " + args[i]);
        }
}
}
