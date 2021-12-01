/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Management.Management;
import Management.Validate;
import java.text.ParseException;

/**
 *
 * @author ADMIN
 */
public class Main {
    
    public static void main(String[] args) throws ParseException{
        Management mn = new Management();
        while (true) { 
            
            Management.menu();
            int choice = Validate.getChoice("Choose: ", "Range input: 1 - 6", 1, 6);
            switch(choice){
                case 1:
                    mn.AddEmployees();                                                                  
                    break;
                case 2:
                    mn.UpdateEmployees();
                    break;
                case 3:
                    mn.RemoveEmployees();
                    break;
                case 4:
                    mn.SearchEmployees();
                    break;
                case 5:
                    mn.SortEmployeesBySalary();
                    break;
                case 6:
                    System.exit(0);
                    break;
                
            }
        }
    }

    
    
}

