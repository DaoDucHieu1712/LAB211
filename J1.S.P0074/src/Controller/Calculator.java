/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author ADMIN
 */
public class Calculator {
    
    public static void menu(){
        System.out.println("======Calculator Program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix ");
        System.out.println("4. Quit");
    }
    
    public static int[][] addMatrix(int n){
        int col = Validate.getInt("Enter Row Matrix "+n+" : ", "Value of matrix is digit");
        int row = Validate.getInt("Enter Column Matrix "+n+" : ", "Value of matrix is digit");
        int [][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Validate.getInt("Enter Matrix"+n+"["+(i+1)+"]"+"["+(j+1)+"]: ", "Invalid !");
            }
        }
       return matrix;
    }
    
     public static void display(int[][] matrix){
         if(matrix == null){
             return;
         }
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length!=matrix2.length 
                || matrix1[0].length!=matrix2[0].length) {
            System.out.println("Matrix 1 and Matrix 2 not same size.");
            return null;
        }
        int row = matrix1.length;
        int col = matrix2[0].length;
        int [][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j]= matrix1[i][j] + matrix2[i][j];
            }
        }
        
        return result;
        
        
    }
    
    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2){
        if (matrix1.length!=matrix2.length 
                || matrix1[0].length!=matrix2[0].length) {
            System.out.println("Matrix 1 and Matrix 2 not same size.");
            
        }else{
        int row = matrix1.length;
        int col = matrix2[0].length;
        int [][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j]= matrix1[i][j] - matrix2[i][j];
            }
        }
        
        return result;
        }
        return null;
    }
    
    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2){
        if(matrix1[0].length!=matrix2.length){
            System.out.println("Matrix 1 and Matrix 2 not same size.");
            return null;
        }
        
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];
        
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                result[i][j] = 0;
            }
        }
        for (int i = 0; i < row1; i++) {  // chạy từng phần tử trong hàng của matrix 1
            for (int j = 0; j < col2; j++) { // chạy từng phần tử của trong cột của matrix 2
                for (int k = 0; k < col1; k++) { // chạy từng phần tử trong cột của matrix 1
                    result[i][j] += matrix1[i][k] * matrix2[k][j]; // tổng (từng phần tử trong hàng của m1 x từng phần tử trong cột của m2)
                }
            }
        }
        return result;
    }
    
   
}
