/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {
    private static final Scanner sc = new Scanner(System.in);

    public static int getChoice(String msg, String err, int min, int max) {
        int a = 0;
        while (true) {
            try {
                System.out.print(msg);

                a = Integer.parseInt(sc.nextLine());
                if (min <= a && a <= max) {
                    break;
                } else {
                    System.out.println("Number inrange: " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }

        return a;
    }

    public static String getString(String msg, String err) {
        String str;
        while (true) {
            System.out.print(msg);
            str = sc.nextLine();
            if (!str.trim().isEmpty()) {
                break;
            } else {
                System.out.println(err);
            }
        }
        return str;
    }

    public static int getInt(String smg, String err) {
        int a = 0;
        while (true) {
            try {
                System.out.print(smg);

                a = Integer.parseInt(sc.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }

        return a;
    }

    public static boolean checkInputYN(String msg) {
        while (true) {
            String str = getString(msg, "Invalid !");
            if (str.equalsIgnoreCase("Y")) {
                return true;
            }
            if (str.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }

    public static String getUD(String msg) {
        String str;
        while (true) {
            System.out.println(msg);
            str = sc.nextLine();
            if (str.equalsIgnoreCase("D") || str.equalsIgnoreCase("U")) {
                break;
            } else {
                System.out.println("(U) OR (D)");
            }

        }
        return str;

    }

    public static String getCouse(String msg) {
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("java")
                    || str.equalsIgnoreCase("c/c++")
                    || str.equalsIgnoreCase(".net")) {
                return str;
            }

            System.out.println("Only 3 course: java, .net, c/c++");

        }
    }
}
