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
                    System.out.println("Select quantity fruit: " + min + " - " + max);
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
                if (a > 0) {
                    break;
                } else {
                    System.out.println(err);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid !");
            }
        }

        return a;
    }

    public static double getDouble(String smg, String err) {
        double a = 0;
        while (true) {
            try {
                System.out.print(smg);
                a = Double.parseDouble(sc.nextLine());
                if (a > 0) {
                    break;
                } else {
                    System.out.println(err);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid !");
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
}
