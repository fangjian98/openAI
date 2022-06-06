public class Sort{
    public static void main(String[] args) {
        
    }

    //冒泡排序
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

    //堆排序
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

    //选择排序
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
}