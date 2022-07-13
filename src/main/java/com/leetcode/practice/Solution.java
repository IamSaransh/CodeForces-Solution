package com.leetcode.practice;

import java.util.Collections;
import java.util.HashSet;

class Solution {

    static void mergeSort(int [] arr, int s, int e)
    {
        if(s>=e)
            return;
        int mid = (s+e)/2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);
        merge(arr, s, e);


    }
    static void merge2(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        int x = l;
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[x++];
        x = m+1;
        for (int j = 0; j < n2; ++j)
            R[j] = arr[x++];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    private static void merge(int[] arr, int s, int e) {
        int mid  = (s+e)/2;

        int len1 = mid-s+1;
        int len2 = e-mid;
        int[] first = new int[len1];
        int[] second = new int[len2];
        //copy values
        int k =s;
        for(int i=0; i<len1;i++){
            first[i] = arr[k++];
        }
        k = mid+1;
        for(int i=0; i<len2;i++){
            second[i] = arr[k++];
        }

        //merge two sorted arrays logic here
        int index1 = 0;
        int index2 =0;
        k = s;

        while(index1< len1 && index2< len2){
            if (first[index1] < second[index2])
            {
                arr[k++] = first[index1++];
            }
            else{
                arr[k++] = second[index2++];
            }
        }
        while(index1<len1){
            arr[k++] = first[index1++];
        }
        while(index2< len2){
            arr[k++] = second[index2++];
        }

    }
    private static void check(String s) {
        for(int i=1; i<s.length()-1;i++){
            String s1 = s.substring(0, i+1);
            String s2 = s.substring(i+1);

        }

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,100,6,6,6,6,6,6,7,8};
        mergeSort(arr, 0, arr.length-1);
        for(int a: arr){
            System.out.print(a + " ");
        }



    }
}


