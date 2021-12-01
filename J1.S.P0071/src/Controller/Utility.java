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
public class Utility {

    public static boolean checkID(ArrayList<Task> list, int id) {
        for (Task t : list) {
            if (id == t.getId()) {
                return false;
            }
        }
        return true;
    }
    
    public static Task listByID(ArrayList<Task> list, int id){
        for (Task t : list) {
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    
}
