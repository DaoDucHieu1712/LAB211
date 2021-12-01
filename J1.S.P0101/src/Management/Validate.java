/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import Entity.Employees;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {

    private static Scanner sc = new Scanner(System.in);

    public static int getChoice(String msg, String err, int min, int max) {
        int a = 0;
        while (true) {
            try {
                System.out.println(msg);
                a = Integer.parseInt(sc.nextLine());
                if (a >= min && a <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return a;
    }

    public static int getInt(String str, String err) {

        int a = 0;

        while (true) {
            try {
                System.out.println(str);
                a = Integer.parseInt(sc.nextLine());

                break;

            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return a;
    }

    public static String getString(String msg, String err) {
        String str;

        while (true) {
            System.out.println(msg);
            str = sc.nextLine();
            if (!str.trim().isEmpty()) {
                break;
            } else {
                System.out.println(err);
            }
        }
        return str;
    }

    public static float getFloat(String msg, String err) {

        float a = 0;

        while (true) {
            try {
                System.out.println(msg);
                a = Float.parseFloat(sc.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
        return a;
    }

    public static String getStringRegex(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.println(msg);
                String str = sc.nextLine();
                if (str.matches(regex)) {
                    return str;
                }
            } catch (Exception e) {
                System.out.println("IOException");
            }
            System.out.println(err);
        }
    }

    public static Date getSimpleDate(String msg, String err, String format) {

        while (true) {
            try {
                System.out.println(msg);
                SimpleDateFormat df = new SimpleDateFormat(format);
                df.setLenient(false);
                Date date = df.parse(sc.nextLine());
                return date;

            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    public static String getSex(String msg, String err) {
        String str;
        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();
                if (str.equalsIgnoreCase("Male")
                        || str.equalsIgnoreCase("Female")) {
                    return str;
                }
            } catch (Exception e) {
                System.out.println(err);
            }

        }

    }

    public static String getEgence(String msg, String err) {
        String str;
        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();
                if (str.equalsIgnoreCase("A")
                    || str.equalsIgnoreCase("B")
                    || str.equalsIgnoreCase("C")
                    || str.equalsIgnoreCase("D")
                    || str.equalsIgnoreCase("E")
                    || str.equalsIgnoreCase("F")) {
                    return str;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }

    }

    public static boolean checkID(ArrayList<Employees> list, String id) {
        for (Employees e : list) {
            if (e.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkName(ArrayList<Employees> list, String name) {
        for (Employees e : list) {
            if (name.equalsIgnoreCase(e.getFirstName())
                    || name.equalsIgnoreCase(e.getLastName())) {
                return false;
            }
        }
        return true;
    }

    public static Employees employeesByID(ArrayList<Employees> list, String id) {
        for (Employees t : list) {
            if (t.getId().equalsIgnoreCase(id)) {
                return t;
            }
        }
        return null;
    }
    
   public static Employees employeesbyName(ArrayList<Employees> list, String firstName, String lastName){
       for (Employees e : list) {
           if(e.getFirstName().equalsIgnoreCase(firstName)||e.getLastName().equalsIgnoreCase(lastName)){
               return e;
       }
   }  
        return null;
   }
    public static boolean checkYN(String msg){
        while (true) { 
            System.out.print(msg);
            String a = getString("", "(Y or N)Pls input again !!!");
            if(a.equalsIgnoreCase("Y")){
                return true;
            }
            if(a.equalsIgnoreCase("N")){
                return false;
            }
        }
    }
    
    
}
