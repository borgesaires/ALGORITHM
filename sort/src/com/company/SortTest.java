package com.company;

import java.util.Arrays;

public class SortTest implements Sort {


    //快排
    @Override
    public void quickSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println("快速排序");
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }


    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);

            //对左分区快排
            quickSort(arr, low, index - 1);
            //对右分区快排
            quickSort(arr, index + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //定义首尾指针
        int i = low;
        int j = high;

        //第一个数为基准
        int x = arr[low];

        //分区
        while (i < j) {
            while (arr[j] >= x && i < j) {
                j--;
            }

            if (i < j) {
                arr[i] = arr[j];
                //i++;
            }

            while (arr[i] <= x && i < j) {
                i++;
            }

            if (i < j) {
                arr[j] = arr[i];
                //j--;
            }
        }
        //基准值位置
        arr[i] = x;
        return i;
    }


    //冒泡排序
    @Override
    public void BubbleSort(int[] arr) {

        System.out.println(Arrays.toString(arr));
        System.out.println("冒泡排序 :");
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    //选择排序
    @Override
    public void SelectSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println("选择排序：");
        int minIndex = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //System.out.println(min);
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));
    }

    //归并排序
    @Override
    public void MergeSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println("归并排序：");
        int temp[] = new int[arr.length];
        MergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }


    private void MergeSort(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(arr, left, mid, temp);
            MergeSort(arr, mid + 1, right, temp);
            Merge(arr, left, mid, right, temp);
        }
    }

    public void Merge(int[] arr, int left, int mid, int right, int[] temp) {
        //排序
        int t = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            } else {
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }


        //将剩余值载入temp

        while (i <= mid) {
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }


        //将temp录入arr

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    //插入排序
    @Override
    public void InsertSort(int[] arr) {

        System.out.println(Arrays.toString(arr));
        System.out.println("插入排序：");
        for (int i = 1; i < arr.length; i++) {
            int InsertVal = arr[i];
            int InsertIndex = i - 1;

            while (InsertIndex >= 0 && InsertVal < arr[InsertIndex]) {
                arr[InsertIndex + 1] = arr[InsertIndex];
                InsertIndex--;
            }

            arr[InsertIndex + 1] = InsertVal;

        }

        System.out.println(Arrays.toString(arr));
    }

    //希尔排序
    @Override
    public void ShellSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println("希尔排序：");


        //步长
        for (int i = arr.length / 2; i > 0; i /= 2) {

            //当前位置
            for (int point = 0; point <= i; point++) {

                //交换
                for (int j = point; i + j < arr.length; j += i) {

                    if (arr[j] > arr[j + i]) {
                        int temp = arr[j];
                        arr[j] = arr[j + i];
                        arr[j + i] = temp;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //基数排序
    @Override
    public void RadixSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println("基数排序：");

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //位数
        int maxLength = 0;
        while(max > 0){
            max /= 10;
            maxLength++;
        }

        int[][] temp = new int[10][arr.length];

        //记数
        int[] count = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {

                int radixNumber = arr[j] / n % 10;

                temp[radixNumber][count[radixNumber]] = arr[j];

                count[radixNumber]++;
            }

            int index = 0;

            //回填数组
            for (int k = 0; k < count.length; k++) {

                if (count[k] != 0) {

                    for (int l = 0; l < count[k]; l++) {
                        arr[index] = temp[k][l];

                        index++;
                    }

                    //桶内清零
                    count[k] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
