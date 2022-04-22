import java.util.PriorityQueue;

public class HeapSortExport1 {
    //已知一个几乎有序的数组，几乎有序指，如果吧数组排好顺序的话，每个元素移动的距离不能超过k，并且
    //k相对于数组而言比较小。请选择一个合适的排序算法针对这个数据进行排序。
    public static void main(String[] args) {
        PriorityQueue<Integer> heap  = new PriorityQueue<>();


    }

    public  static  void sortArrDistanceLessK(int[]  arr, int k){
        PriorityQueue<Integer>  heap = new PriorityQueue<Integer>();
        int index = 0;
        for(;index<=Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i  = 0;
        for(;index<arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}
