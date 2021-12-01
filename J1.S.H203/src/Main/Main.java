/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author ADMIN
 */
public class Main {
    
    public static void printReverse(String str){
        if(str.isEmpty()){
            str = Validate.getString("Enter string: ");
        }
        String[] txt = str.split(" ");
        String temp = "";
        
        for (int i = txt.length-1; i >= 0; i--) {
            temp += txt[i];
            temp += " ";
        }
        String result =  temp.substring(0, 1).toUpperCase() + temp.substring(1);
        System.out.println(result.trim());
        
    }
    
    public static void main(String[] args) {
        printReverse("hello there");
        printReverse("");
    }
    
}
