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
public class Task {
    
    private int id;
    private String name;
    private int typeID;
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String name, int typeID, String date, 
            double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.name = name;
        this.typeID = typeID;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public String typeName(){
        if(typeID == 1){
            return "Code";
        }
        if(typeID == 2){
            return "Test";
        }
        if(typeID == 3){
            return "Design";
        }
        if(typeID == 4){
            return "Review";
        }
        return null;
    }
    
    public double getTime(){
        double time = to - from;
        return time;
    }
    
    public void display(){
        
        System.out.printf("%-5d%-20s%-20s%-20s%-20.1f%-20s%-20s\n",
                this.id, this.name, typeName(), 
                this.date, getTime(), this.assignee, this.reviewer);
    }
}
