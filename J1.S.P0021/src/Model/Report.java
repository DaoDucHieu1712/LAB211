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
public class Report {
    private String stdName;
    private String courseName;
    private int totalCouse;
    private String id;

    public Report() {
    }

    public Report(String stdName, String courseName, int totalCouse, String id) {
        this.stdName = stdName;
        this.courseName = courseName;
        this.totalCouse = totalCouse;
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCouse() {
        return totalCouse;
    }

    public void setTotalCouse(int totalCouse) {
        this.totalCouse = totalCouse;
    }

    public void display() {
        System.out.printf("%-5s|%-15s|%-10s|%-10d\n", id, stdName, courseName, totalCouse);
    }
}
