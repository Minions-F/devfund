package org.minions.devfund;

public class Main {
    public static void main(String args[]){
        int[] arr= new int[]{8,5,15,23,1,7};
        for (int i = arr.length -1;i > 0; i--){
            arr[ i -1] = arr[i];
        }
        System.out.println(arr[0]);
        System.out.println(arr.toString());
    }
}
