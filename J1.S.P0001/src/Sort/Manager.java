/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class Manager {
    public static void bubbleSort(int arr[]){
        int n = arr.length; 
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void display(int arr[]){
        System.out.println("Unsorted array: "+Arrays.toString(arr));
        Manager.bubbleSort(arr);
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }
}
