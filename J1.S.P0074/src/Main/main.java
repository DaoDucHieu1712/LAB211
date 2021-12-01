/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Calculator;
import Controller.Validate;

/**
 *
 * @author ADMIN
 */
public class main {
    public static void main(String[] args) {
                    int[][] matrix1;
                    int[][] matrix2 ;
                    int[][] result ;
        while (true) {            
            Calculator.menu();
            int choice = Validate.getChoice("Your choice: ", 
                    "(1->4).Pls input again", 1, 4);
            switch(choice){
                case 1:
                    System.out.println("--------Addition--------");
                    matrix1 = Calculator.addMatrix(1);
                    matrix2 = Calculator.addMatrix(2);
                    System.out.println("--------Result----------");
                    Calculator.display(matrix1);
                    System.out.println("+");
                    Calculator.display(matrix2);
                    System.out.println("=");
                    result = Calculator.additionMatrix(matrix1, matrix2);
                    Calculator.display(result);
                    break;
                case 2:
                    System.out.println("--------Subtraction--------");
                    matrix1 = Calculator.addMatrix(1);
                    matrix2 = Calculator.addMatrix(2);
                    System.out.println("--------Result---------");
                    Calculator.display(matrix1);
                    System.out.println("-");
                    Calculator.display(matrix2);
                    System.out.println("=");
                    result = Calculator.subtractionMatrix(matrix1, matrix2);
                    Calculator.display(result);
                    break;
                case 3:
                    System.out.println("--------Multiplication--------");
                    matrix1 = Calculator.addMatrix(1);
                    matrix2 = Calculator.addMatrix(2);
                    System.out.println("--------Result---------");
                    Calculator.display(matrix1);
                    System.out.println("*");
                    Calculator.display(matrix2);
                    System.out.println("=");
                    result = Calculator.multiplicationMatrix(matrix1, matrix2);
                    Calculator.display(result);
                    break;
                case 4:
                    System.exit(0);
                    break;
                    
            }
        }
    }
}
