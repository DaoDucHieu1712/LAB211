/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Student {

    private String id;
    private String name;
    private int semeter;
    private String courseName;

    public Student() {
    }

    public Student(String id, String name, int semeter, String courseName) {
        this.id = id;
        this.name = name;
        this.semeter = semeter;
        this.courseName = courseName;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemeter() {
        return semeter;
    }

    public void setSemeter(int semeter) {
        this.semeter = semeter;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void display() {
        System.out.printf("%-5s%-20s%-15s%-15s\n", id, name, semeter, courseName);
    }
}
