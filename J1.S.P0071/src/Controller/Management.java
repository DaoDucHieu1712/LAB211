/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Management {

    private static ArrayList<Task> list = new ArrayList<>();

    public Management() {
        list.add(new Task(1, "Test Program", 2, "26-12-2018", 9.5, 14.5, "Dev", "Lead"));
        list.add(new Task(2, "Design Program", 2, "10-10-2013", 8.5, 15.0, "Dev", "Lead"));
        list.add(new Task(3, "XYZ Program", 4, "01-07-2015", 10.0, 13.0, "Dev", "Lead"));
        list.add(new Task(4, "ABC Program", 3, "19-03-2021", 9.0, 10.5, "Dev", "Lead"));
    }

    public static void menu() {
        System.out.println("========= TASK PROGRAM =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }

    public int addTask(String name, int typeID, String date,
            double from, double to, String assignee, String reviewer) throws Exception{

        int id = 0;
        int lastID = list.size() - 1;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(lastID).getId() + 1;
        }

        list.add(new Task(id, name, typeID, date, from, to, assignee, reviewer));
        return id;

    }

    public void ADD() throws Exception {
        System.out.println("--------ADD TASK--------");
        String name = Validate.getString("Requirement Name: ", "Name Invalid !");
        int typeID = Validate.getTask("Task Type: ", "TypeID: 1->4 !");
        String date = Validate.getSimpleDate("Date: ", "Date Invalid !", "dd-MM-yyyy");
        double from = Validate.getFrom("From: ");
        double to = Validate.getTo("To: ", from);
        String assignee = Validate.getString("Assignee: ", "Assignee Invalid !");
        String reviewer = Validate.getString("Reviewer", "Reviewer Invalid !");
        addTask(name, typeID, date, from, to, assignee, reviewer);
        System.out.println("ADD TASK SUCCESS.");
    }
    
    

    public void deleteTask() {
        System.out.println("--------DELETE TASK--------");
        if (list.isEmpty()) {
            System.out.println("List Empty.");
            return;
        }
        int idDelete;
        while (true) {
            idDelete = Validate.getInt("Enter ID to delete: ");
            if (Utility.checkID(list, idDelete)) {
                System.out.println("Not found.");
            } else {
                break;
            }
        }

        Task t = Utility.listByID(list, idDelete);
        if (t == null) {
            System.out.println("Not found.");
        } else {
            list.remove(t);
        }
        System.out.println("DELETE TASK SUCCESS.");

    }
    
    public void getDataTask() {
        System.out.println("--------DATA TASK--------");
        if (list.isEmpty()) {
            System.out.println("List Epmpty.");
            return;
        }
        System.out.printf("%-5s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                 "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task t : list) {
            t.display();
        }
    }

}
