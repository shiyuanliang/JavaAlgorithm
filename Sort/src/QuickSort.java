public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,4,5,7,8,9,1,2,6,0};
        quickSort(arr);
        printArr(arr);

    }

    public static  void quickSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    public  static  void quickSort(int[] arr, int L, int R){
        if(L<R){
            swap(arr, L+(int)(Math.random()*(R-L+1)),R);
            int[] p = partition(arr, L,R);
            quickSort(arr,L,p[0]);
            quickSort(arr,p[1],R);
        }
    }
    //将数组划分为左边是小于P的区域， 等于P， 大于P
    public  static  int[] partition(int[] arr, int L, int R){
        int less = L -1;  //小于区域的右边界 开始的时候都是没有的  所以为空的
        int more  = R  ; // 大于区域的左边界 开始的时候都是没有的  所以为空的
        while (L<more){
            if(arr[L]<arr[R]){
                swap(arr,++less,L++);
            } else  if(arr[L]>arr[R]){
                swap(arr, --more,L);
            }else {
                L++;
            }
        }
        swap(arr, more, R);//more位置为等于arr【R】的值  more+1才是
        return new int[] {less, more+1}; //返回的是小于区域的右边界  包含less；大于区域的左边界 包含more+1
    }

    public static void swap(int[] arr, int first, int second){
        if(first!=second){
            arr[first] = arr[first] ^arr[second];
            arr[second] = arr[first] ^arr[second];
            arr[first] = arr[first] ^arr[second];
        }
    }

    public  static void printArr(int arr[]){
        for(int i= 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


}
