import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3,4,5,7,8,9,1,2,6,0};
        heapSort(arr);
        printArr(arr);
    }

    public  static  void heapSort(int arr[]){
        if(arr ==null||arr.length<2){
            return;
        }
        //第一种算法
//        for(int i= 0;i<arr.length; i++){
//            heapInsert(arr,i);
//        }
        //第二种算法
        for(int i = arr.length;i>0;i--){
            heapify(arr, i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize>0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //某个(index)位置上的数向上移动
    public static void heapInsert(int arr[], int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr, index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    //某个(index)位置上的数向下移动
    public static void heapify(int arr[], int index, int heapSize){
        int left = index*2+1; //左孩子
        while(left<heapSize){
            //找到两个孩子中的最大的那个孩子
            int largest = left+1<heapSize && arr[left]<arr[left+1] ? left+1 :left;
            //比较最大的那个孩子与父
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left  = index*2 +1;
        }
    }

    public static void swap(int arr[],int first, int second){
        arr[first] = arr[first] ^ arr[second];
        arr[second] = arr[first] ^ arr[second];
        arr[first] = arr[first] ^ arr[second];
    }

    public  static void printArr(int arr[]){
        for(int i= 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
