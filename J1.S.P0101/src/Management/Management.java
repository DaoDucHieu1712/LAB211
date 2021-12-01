/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import Entity.Employees;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Management {

    private static ArrayList<Employees> list = new ArrayList<>();
    private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    
    public Management(){

        try {
            list.add(new Employees("1", "Nguyen", "Hoang", "0912323223",
                    "nguyenhoang@gmail.com", "Ha Noi", df.parse("09/02/1999"), "Male", 5150f, "E"));
            list.add(new Employees("3", "Le", "Duy", "0995432235",
                    "LeDuy@gmail.com", "TPHCM", df.parse("06/08/1998"), "Male", 2300f, "C"));
            list.add(new Employees("5", "Pham", "Duc", "0912395423",
                    "nguyenDuc@gmail.com", "Hai Phong", df.parse("09/07/2000"), "Male", 1110f, "C"));
            list.add(new Employees("2", "Duong", "Thanh", "091732324",
                    "duongThanh@gmail.com", "Vinh Phuc", df.parse("22/05/2007"), "Female", 1500f, "B"));
            list.add(new Employees("4", "Phan", "Giang", "0129876890",
                    "giang12@gmail.com", "Da Lat", df.parse("26/12/2001"), "female", 3100f, "A"));
        } catch (ParseException ex) {
            
        }
        
        

    }

    public static void menu() {
        System.out.println("------Employee management system------");
        System.out.println("1.	Add employees \n"
                + "2.	Update employees\n"
                + "3.	Remove employees\n"
                + "4.	Search employees\n"
                + "5.	Sort employees by salary\n"
                + "6.	Exit");
    }

    //Case 1:
    public static void AddEmployees() {
        System.out.println("--------Add Employees--------");
        String id;
        while (true) {
            id = Validate.getString("Enter id: ", "ID invalid !!");
            if (!Validate.checkID(list, id)) {
                System.out.println("ID duplicate");
            } else {
                break;
            }
        }

        String fistName = Validate.getString("Enter First Name:  ", "FirstName invalid !!");
        String lastName = Validate.getString("Enter Last Name: ", "Last Name invalid !!");
        String phone = Validate.getStringRegex("Enter number phone: ", "Number phone invalid", "^[0-9]{10}+$");
        String email = Validate.getStringRegex("Enter email: ", "Email Invalid !!", "^[a-zA-Z]\\w+@(\\w+[.])+\\w+$");
        String address = Validate.getString("Enter address: ", "Address Invalid !!");
        Date DOB = Validate.getSimpleDate("Enter Day of birth: ", "DOB Invalid", "dd/MM/yyyy");
        String sex = Validate.getSex("Enter gender: ", "Input : Male or Female. Pls input again !");
        float salary = Validate.getFloat("Enter Salary: ", "Salary Invalid !!");
        String Egency = Validate.getEgence("Enter Agency: ", "Egency :(A->F).Pls input again !!");

        list.add(new Employees(id, fistName, lastName, phone, email, address, DOB, sex, salary, Egency));
        System.out.println("Add Employees successfull. ");
    }

    //Case 2:
    public static void UpdateEmployees() {
        System.out.println("--------Update Employees--------");
        if (list.isEmpty()) {
            System.out.println("List Empty.");
            return;
        }
        String idUpdate;
        while (true) {
            idUpdate = Validate.getString("Enter ID to search: ", "ID Invalid !!");
            if (Validate.checkID(list, idUpdate)) {
                System.out.println("Not found");
            } else {
                break;
            }
        }

        for (Employees e : list) {
            if (idUpdate.equalsIgnoreCase(e.getId())) {
                if (Validate.checkYN("Do you want update ID?(Y/N)")) {
                    while (true) {
                        String id = Validate.getString("Enter ID: ", "ID invalid !!");
                        if (!Validate.checkID(list, id)) {
                            System.out.println("ID duplicate");
                        } else {
                            e.setId(id);
                            break;
                        }
                    }
                }

                if (Validate.checkYN("Do you want update First Name?(Y/N)")) {
                    String fistName = Validate.getString("Enter First Name:  ", "FirstName invalid !!");
                    e.setFirstName(fistName);
                }

                if (Validate.checkYN("Do you want update Last Name?(Y/N)")) {
                    String lastName = Validate.getString("Enter Last Name: ", "Last Name invalid !!");
                    e.setLastName(lastName);
                }

                if (Validate.checkYN("Do you want update Phone?(Y/N)")) {
                    String phone = Validate.getStringRegex("Enter number phone: ", "Number phone invalid", "^[0-9]+$");
                    e.setPhone(phone);
                }

                if (Validate.checkYN("Do you want update Email?(Y/N)")) {
                    String email = Validate.getStringRegex("Enter email: ", "Email Invalid !!", "^[a-zA-Z0-9]\\w+@(\\w+.)+(\\w+)$");
                    e.setEmail(email);
                }

                if (Validate.checkYN("Do you want update Address?(Y/N)")) {
                    String address = Validate.getString("Enter address: ", "Address Invalid !!");
                    e.setAddress(address);
                }

                if (Validate.checkYN("Do you want update Day of birth?(Y/N)")) {
                    Date DOB = Validate.getSimpleDate("Enter Day of birth: ", "Invalid", "dd/MM/yyyy");
                    e.setDOB(DOB);
                }

                if (Validate.checkYN("Do you want update Gender?(Y/N)")) {
                    String sex = Validate.getSex("Enter gender: ", "Input : Male or Female");
                    e.setSex(sex);
                }

                if (Validate.checkYN("Do you want update Salary?(Y/N)")) {
                    float salary = Validate.getFloat("Enter Salary: ", "Salary Invalid !!");
                    e.setSalary(salary);
                }

                if (Validate.checkYN("Do you want update Egency?(Y/N)")) {
                    String Egency = Validate.getEgence("Enter Egency: ", "Egency (A->F). pls input again !!");
                    e.setAgency(Egency);
                }
                System.out.println("Update successfull.");
                break;
            }
        }
    }

    //Case 3:
    public static void RemoveEmployees() {
        System.out.println("-------Remove Employees--------");
        if (list.isEmpty()) {
            System.out.println("List Empty.");
            return;
        }

        String idDelete;
        while (true) {
            idDelete = Validate.getString("Enter id to remove: ", "ID Invalid !!!");
            if (Validate.checkID(list, idDelete)) {
                System.out.println("ID Invalid !!");
            } else {
                break;
            }
        }
        Employees e = Validate.employeesByID(list, idDelete);
        if (e == null) {
            System.out.println("Not Found.");
        } else {
            list.remove(e);
        }
        System.out.println("Remove Successful.");
    }

    //Case 4:
    public static void SearchEmployees() {
        System.out.println("--------Search Employees--------");
        if (list.isEmpty()) {
            System.out.println("List Empty.");
            return;
        }

        String nameSearch;
        while (true) {
            nameSearch = Validate.getString("Enter name to search: ", "Name Invalid !!!");
            if (Validate.checkName(list, nameSearch)) {
                System.out.println("Name Search Invalid !");
            } else {
                break;
            }
        }
        System.out.printf("%-10s%-20s%-20s%-15s%-25s%-20s%-20s%-15s%-15s%-10s\n", "ID",
                "First Name", "Last Name", "Phone", "Email", "Address", "Day of birth", "Gender", "Salary", "Egency");

        for (Employees e : list) {
            
            if (nameSearch.equalsIgnoreCase(e.getLastName())
                    ||nameSearch.equalsIgnoreCase(e.getFirstName())
                    ||nameSearch.equalsIgnoreCase(e.getFullName())) {
                System.out.printf("%-10s%-20s%-20s%-15s%-25s%-20s%-20s%-15s%-15.1f%-10s\n",
                        e.getId(), e.getFirstName(), e.getLastName(),
                        e.getPhone(), e.getEmail(),
                        e.getAddress(), df.format(e.getDOB()),
                        e.getSex(), e.getSalary(), e.getAgency());
            }

        }
    }

    //Case 5:
    public static void SortEmployeesBySalary() {
        if (list.isEmpty()) {
            System.out.println("List Empty.");
            return;
        }

        Collections.sort(list, new Comparator<Employees>() {
            @Override
            public int compare(Employees t, Employees t1) {
                return (int) (t.getSalary() - t1.getSalary());
            }
        });

        System.out.printf("%-10s%-20s%-20s%-15s%-25s%-20s%-20s%-15s%-15s%-10s\n", "ID",
                "First Name", "Last Name", "Phone", "Email", "Address", "Day of birth", "Gender", "Salary", "Egency");
        for (Employees e : list) {
            System.out.printf("%-10s%-20s%-20s%-15s%-25s%-20s%-20s%-15s%-15.1f%-10s\n",
                    e.getId(), e.getFirstName(), e.getLastName(),
                    e.getPhone(), e.getEmail(),
                    e.getAddress(), df.format(e.getDOB()),
                    e.getSex(), e.getSalary(), e.getAgency());
        }
    }
    
}
