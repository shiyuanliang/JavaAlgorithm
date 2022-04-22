public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4};
        selectionSort(arr);
        printArr(arr);
    }

    public  static  void selectionSort(int arr[]){
        if(arr ==null || arr.length<2){
            return;
        }
        for(int i =0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j =i+1;j<arr.length;j++){
                minIndex = arr[j]<arr[minIndex] ? j: minIndex;
            }
            if(minIndex!= i) {
                swap(arr, minIndex, i);
            }
        }
    }

    public static void  swap(int arr[], int first, int second){
        arr[first] = arr[first]^ arr[second];
        arr[second] = arr[first]^arr[second];
        arr[first] = arr[first]^arr[second];
    }

    public  static  void printArr(int arr[]){
        for (int i :arr){
            System.out.println(i);
        }
    }
}
