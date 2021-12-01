/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Report;
import Model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class StudentManagement {

    private ArrayList<Student> listStudent = new ArrayList<>();

    public StudentManagement() {
        listStudent.add(new Student("3", "Nguyen Van B", 1, "c/c++"));
        listStudent.add(new Student("7", "Nguyen Van D", 2, "java"));
        listStudent.add(new Student("1", "Nguyen Van A", 2, "java"));
        listStudent.add(new Student("3", "Nguyen Van B", 1, "c/c++"));
        listStudent.add(new Student("6", "Nguyen Van E", 3, ".net"));
        listStudent.add(new Student("5", "Nguyen Van A", 2, "java"));
        listStudent.add(new Student("4", "Nguyen Van C", 3, ".net"));
        listStudent.add(new Student("1", "Nguyen Van A", 1, "java"));
        listStudent.add(new Student("8", "Nguyen Van F", 3, ".net"));
        listStudent.add(new Student("2", "Nguyen Van G", 1, ".net"));
    }

    // hien thi thong tinh sinh vien
    public void displayStudent() {
        System.out.printf("%-5s%-20s%-15s%-15s\n", "ID", "Name", "Semster", "Course");
        for (Student t : listStudent) {
            t.display();
        }
    }

    // method tinh do dai list
    public int listStudentsize() {
        return listStudent.size();
    }

    // method goi den listStudent
    public ArrayList<Student> getlistStudent() {
        return listStudent;
    }

    // method co chuc nang add Student
    public void addStudent(String id, String name, int semester, String courseName) {
        listStudent.add(new Student(id, name, semester, courseName));
    }

    //Method Sort List theo ten
    public void SortlistStudent(ArrayList<Student> studentList) {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                return t.getName().compareTo(t1.getName());
            }
        });
    }

    //Check ID trung lap
    public boolean checkId(String id) {
        for (Student t : listStudent) {
            if (id.equalsIgnoreCase(t.getId())) {
                return true;
            }
        }
        return false;
    }

    //check NAME ton tai trong list Student
    public boolean checkName(String name) {
        for (Student t : listStudent) {
            if (name.equalsIgnoreCase(t.getName())) {
                return true;
            }
        }
        return false;
    }

    // check semester 
    public boolean checkSemester(int semester, String name, String id, String courseName) {
        for (Student t : listStudent) {
            if (semester == t.getSemeter()
                    && name.equalsIgnoreCase(t.getName())
                    && id.equalsIgnoreCase(t.getId())
                    && courseName.equalsIgnoreCase(t.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    //checkName theo ID
    public boolean checkNameExist(String name, String id) {
        for (Student t : listStudent) {
            if (name.equalsIgnoreCase(t.getName())
                    && id.equalsIgnoreCase(t.getId())) {
                return true;
            }
        }
        return false;
    }

    

    //check Rp
    private boolean checkRP(ArrayList<Report> rpList, String name, String courseName, int total, String id) {
        for (Report r : rpList) {
            if (name.equalsIgnoreCase(r.getStdName())
                    && courseName.equalsIgnoreCase(r.getCourseName())
                    && total == r.getTotalCouse()
                    && id.equalsIgnoreCase(r.getId())) {
                return false;
            }
        }
        return true;
    }

    //---------------------------------------------------------------------------
    
    //Case 2:
    //Tim kiem thong tinh sinh vien va Xap sep sinh vien theo ten
    public void FindAndSort(String name) {
        System.out.printf("%-5s%-20s%-15s%-15s\n", "ID", "Name", "Semster", "Course");
        for (Student t : listStudent) {
            if (name.equalsIgnoreCase(t.getName())) {
                t.display();
            }
        }

        System.out.println("--------List sort by Name---------");
        SortlistStudent(listStudent);
        displayStudent();
    }

    //Case 3 - U
    // method Update Student theo ID
    public void UpdateStudent(String id) {
        Student t = getStudentSearch(listStudentByID(id));
        if (t == null) {
            System.out.println("Student not Exist!");
            return;
        }

        //update ID
        if (Validate.checkInputYN("Do you want update ID (Y/N)") == true) {
            String idUp = Validate.getString("ID: ", "ID Invalid !");
            t.setId(idUp);
        }
        
        //update name
        if (Validate.checkInputYN("Do you want update Name ? (Y/N)") == true) {
            String nameUp = Validate.getString("Name :", "Name Invalid !");
            t.setName(nameUp);
        }
        
        //update CourseName
        if (Validate.checkInputYN("Do you want update Course Name ? (Y/N)") == true) {
             String CourseNameUp = Validate.getCouse("Course Name: ");
            t.setCourseName(CourseNameUp);
        }
        
        //update Semester
        if (Validate.checkInputYN("Do you want update Semester ? (Y/N)") == true) {
            int semesterUp = Validate.getInt("Semester: ", "Semester > 0");
            t.setSemeter(semesterUp);
        }
    }

    //Case 3 - D
    //method Xoa sinh vien theo ID
    public void DeleteStudent(String id) {
        Student t = getStudentSearch(listStudentByID(id));
        if (t == null) {
            System.out.println("Student not Exist!");
        } else {
            listStudent.remove(t);
        }
    }

    //Case 4:
    //report Student 
    public void ReportStudent() {
        ArrayList<Report> rpList = new ArrayList<>();
        for (Student t : listStudent) {
            int total = 0;
            for (Student tCheck : listStudent) {
                if (tCheck.getId().equalsIgnoreCase(t.getId())
                        && tCheck.getName().equalsIgnoreCase(t.getName())
                        && tCheck.getCourseName().equalsIgnoreCase(t.getCourseName())) {
                    total++; // check tung ban ghi neu id, name, course giong nhau va semester phai khac ky thi total ++
                }
            }
            if (checkRP(rpList, t.getName(), t.getCourseName(), total, t.getId()) == true) {
                Report rp = new Report(t.getName(), t.getCourseName(), total, t.getId());
                rpList.add(rp);     // add vao list Report
            }
        }
        //check List rong
        if (rpList.isEmpty()) {
            System.out.println("List empty. ");
            return;
        }
        // display thong tin report
        System.out.println("--------REPORT--------");
        System.out.printf("%-5s|%-15s|%-10s|%-10s\n", "ID", "Name", "Course", "Total");
        for (Report rp : rpList) {
            rp.display();
        }
        System.out.println("----------------------");
    }

}
