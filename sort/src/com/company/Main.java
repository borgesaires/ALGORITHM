package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int arr[] = {1, 9, 8, 7, 6, 5, 4, 3, 2, 109};

        Sort T = new SortTest();
        //T.quickSort(arr);

        //T.BubbleSort(arr);

        //T.SelectSort(arr);

        //T.MergeSort(arr);

        //T.InsertSort(arr);

        //T.ShellSort(arr);

        T.RadixSort(arr);
    }
}

