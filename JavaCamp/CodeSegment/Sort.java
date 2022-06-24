package CodeSegment;

import java.util.ArrayList;

public class Sort{
    public static void main(String[] args) {
        System.out.println("Hello Sort!");        
    }

    //1.冒泡排序
    public static void bubbleSort(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length; i++){       
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //2.选择排序
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //3.插入排序
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                swap(arr, j, j-1);
                j--;
            }
        }
    }

    //4.堆排序
    public static void heapSort(int[] arr){
        //构建大顶堆
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }
        //堆排序
        for(int i = arr.length - 1; i > 0; i--){
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    public static void heapAdjust(int[] arr, int i, int length){
        int temp = arr[i];
        int child = 2 * i + 1;
        while(child < length){
            if(child + 1 < length && arr[child] < arr[child + 1]){
                child++;
            }
            if(temp >= arr[child]){
                break;
            }
            arr[i] = arr[child];
            i = child;
            child = 2 * i + 1;
        }
        arr[i] = temp;
    }

    //5.归并排序
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int i, int j) {
        if(i >= j){
            return;
        }
        int mid = (i + j) / 2;
        mergeSort(arr, temp, i, mid);
        mergeSort(arr, temp, mid + 1, j);
        merge(arr, temp, i, mid, j);
    }

    private static void merge(int[] arr, int[] temp, int i, int mid, int j) {
        int p = i;
        int q = mid + 1;
        int k = i;
        while(p <= mid && q <= j){
            if(arr[p] < arr[q]){
                temp[k++] = arr[p++];
            }else{
                temp[k++] = arr[q++];
            }
        }
        while(p <= mid){
            temp[k++] = arr[p++];
        }
        while(q <= j){
            temp[k++] = arr[q++];
        }
        for(int m = i; m <= j; m++){
            arr[m] = temp[m];
        }
    }

    //6.快速排序
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int i, int j) {
        if(i >= j){
            return;
        }
        int mid = partition(arr, i, j);
        quickSort(arr, i, mid - 1);
        quickSort(arr, mid + 1, j);
    }

    private static int partition(int[] arr, int i, int j) {
        int temp = arr[i];
        int p = i;
        int q = j + 1;
        while(true){
            while(arr[++p] < temp){
                if(p == j){
                    break;
                }
            }
            while(arr[--q] > temp){
                if(q == i){
                    break;
                }
            }
            if(p >= q){
                break;
            }
            swap(arr, p, q);
        }
        swap(arr, i, q);
        return q;
    }

    //7.希尔排序
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while(gap > 0){
            for(int i = gap; i < arr.length; i++){
                int temp = arr[i];
                int j = i;
                while(j >= gap && arr[j - gap] > temp){
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    //8.计数排序
    public static void countSort(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        int k = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                arr[k++] = i;
                count[i]--;
            }
        }
    }

    //9.桶排序
    public static void bucketSort(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int bucketSize = 10;
        int bucketCount = (max + 1) / bucketSize;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < bucketCount; i++){
            bucket.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < arr.length; i++){
            bucket.get(arr[i] / bucketSize).add(arr[i]);
        }
        int k = 0;
        for(int i = 0; i < bucketCount; i++){
            for(int j = 0; j < bucket.get(i).size(); j++){
                arr[k++] = bucket.get(i).get(j);
            }
        }
    }

    //10.基数排序
    public static void radixSort(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int radix = 10;
        int bucketCount = (max + 1) / radix;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < bucketCount; i++){
            bucket.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < arr.length; i++){
            bucket.get(arr[i] / radix).add(arr[i]);
        }
        int k = 0;
        for(int i = 0; i < bucketCount; i++){
            for(int j = 0; j < bucket.get(i).size(); j++){
                arr[k++] = bucket.get(i).get(j);
            }
        }
    }
}