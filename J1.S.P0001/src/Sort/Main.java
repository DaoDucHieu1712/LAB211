/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author ADMIN
 */

public class Main {
    
    public static void main(String[] args){
        
        
        int n = Utility.getNumber("Enter number of array:");
        int arr[] = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = Utility.getRandom(n, 1);
        }
        
        Manager.display(arr);
    }
}

