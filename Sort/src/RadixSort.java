public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3,4,5,7,8,9,1,2,6,0};
        radixSort(arr);
        printArr(arr);
    }

    public static void radixSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        radixSort(arr,0,arr.length-1, maxbits(arr));
    }
    //获得数组中最大是多少位的
    public  static int maxbits(int[] arr){
        int  max= Integer.MIN_VALUE;
        for(int i =0; i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while(max!=0){
            res++;
            max /=10;
        }
        return res;
    }

    public  static  int getDigit(int arr, int digit){
        return (arr/((int)Math.pow(10,digit-1)))%10;
    }

    public  static void radixSort(int[] arr, int L, int R, int digit){
        final int radix = 10;
        int i = 0,j = 0;
        int[] bucket = new int[R-L+1];
        for(int d = 1;d<=digit;d++){
            int[] count = new int[radix];
            //计算数组中d位的数字个数
            for(i=L;i<=R;i++){
                j = getDigit(arr[i],d);
                count[j]++;
            }
            //将计算的个数变为总和计数
            for(i=1;i<radix;i++){
                count[i] = count[i]+ count[i-1];
            }
            //从右到左逐步的按照d位进行排序
            for(i=R;i>=L;i--){
                j = getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }
            //将辅助数值中的值弄到原始数组
            for(i=L,j=0;i<=R;i++,j++){
                arr[i] = bucket[j];
            }

        }
    }

    public  static void printArr(int arr[]){
        for(int i= 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
