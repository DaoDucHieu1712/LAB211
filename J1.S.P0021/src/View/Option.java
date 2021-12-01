/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StudentManagement;
import Controller.Validate;

/**
 *
 * @author ADMIN
 */
public class Option {

    private static final StudentManagement smn = new StudentManagement();
    private static final Validate v = new Validate();

    void menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit\n"
                + "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }

    // Method tao moi sinh vien
    public void createStudent() {
        if (smn.listStudentsize() > 10) { //kiem tra sinh vien khi so luong ban ghi > 10
            if (Validate.checkInputYN("Do you want to continue (Y/N)?") == false) {
                return;
            }
        }
        String id = Validate.getString("Enter ID: ", "ID Invalid !");
        String name;
        while (true) {
            name = Validate.getString("Enter Name: ", "Name Invalid !");
            if (smn.checkId(id) == true) {
                if (smn.checkNameExist(name, id) == true) {
                    break;
                } else {
                    System.out.println("Name Invalid !");
                }
            } else{
                break;
            }
        }
        String courseName = Validate.getCouse("Course Name: ");
        int semester;
        while (true) {
            semester = Validate.getInt("Semester : ", "Semester > 0");
            if (smn.checkSemester(semester, name, id, courseName) == true) {
                System.out.println("Invalid !");
            } else {
                break;
            }
        }

        smn.addStudent(id, name, semester, courseName);    //add student
        System.out.println("Create Successful.");
    }

    // Method tim kiem sinh vien va sap xep
    public void FindAndSortStudent() {
        String name;
        while (true) {
            name = Validate.getString("Enter the name to find: ", "Name Invalid !");
            if (smn.checkName(name) == true) {
                break;
            } else {
                System.out.println("Not found.");   // check sinh vien co ton tai hay khong
            }
        }
        smn.FindAndSort(name);
    }

    // cap nhat va xoa sinh vien
    public void UpdateORDelete() {
        if (smn.getlistStudent().isEmpty()) {   //check List Rong
            System.out.println("List Empty !");
            return;
        }

        String id;
        String choose = Validate.getUD("Do you want to update (U) or delete (D) student");
        switch (choose.toUpperCase()) {
            case "U": // CAP NHAT SINH VIEN
                while (true) {
                    id = Validate.getString("Enter ID to Update: ", "Name Invalid !");
                    if (smn.checkId(id) == true) {
                        break;
                    } else {
                        System.out.println("Student not Exist !");
                    }
                }
                smn.UpdateStudent(id);
                System.out.println("Update Successful.");
                break;
            case "D"://DELETE SINH VIEN
                while (true) {
                    id = Validate.getString("Enter ID to Delete: ", "Name Invalid !");
                    if (smn.checkId(id) == true) {
                        break;
                    } else {
                        System.out.println("Name Duplicate");
                    }

                }
                smn.DeleteStudent(id);
                System.out.println("Delete Successful.");
                break;
        }
    }

    public void Report() {
        smn.ReportStudent();
    }
}
