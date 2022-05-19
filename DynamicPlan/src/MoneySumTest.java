/**
 * @author LiangShiyuan
 * @create 2022-05-18 21:46
 */
public class MoneySumTest {
    /*
    钱数总合问题
    有一组数组 表示有多少面额的钱 每个面额的钱都是无限的  要求满足钱数总和为target的组合总数为多少种。
     */
    public  static  int moneySum1(int[] arr, int target){
        return  process(arr,0,target);
    }
    public  static int process(int[] arr, int i , int rest){
        if(rest<0){
            return  0;
        }
        if(i==arr.length){
            return rest==0? 1:0;
        }
        int sum =0;
        for(int zhang=0;rest-zhang*arr[i]>=0;zhang++){
            sum +=process(arr,i+1,rest-zhang*arr[i]);
        }
        return  sum;
    }
    //DP算法
    public  static  int moneySum2(int[] arr, int target){
        int N = arr.length;
        int[][] dp= new int[arr.length+1][target+1];
        dp[N][0] = 1;
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<=target;j++){
                int sum =0;
                for(int zhang=0;j-zhang*arr[i]>=0;zhang++){
                    sum +=dp[i+1][j-zhang*arr[i]];
                }
                dp[i][j] = sum;
            }
        }
        return  dp[0][target];
    }

    //根据数数组的特点进行优化
    public  static  int moneySum3(int[] arr, int target){
        int N = arr.length;
        int[][] dp= new int[arr.length+1][target+1];
        dp[N][0] = 1;
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i+1][j];
                if(j-arr[i]>=0) {
                    dp[i][j] += dp[i][j - arr[i]];
                }
            }
        }
        return  dp[0][target];
    }


    //测试  对数器
    public  static int[] generateRandomArray(int len, int max){
        int[] arr = new int[(int) (Math.random()*len)+1];
        for(int i =0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*max) +1;
        }
        return  arr;
    }

    public  static  void main(String[] args){
        System.out.println("对数器开始");
        int len = 10;
        int max = 10;
        int testTime = 10000;
        for(int i = 0;i<testTime;i++){
            int[] arr  = generateRandomArray(len, max);
            int aim = (int) (Math.random()*max*3)+max;
            if(moneySum1(arr, aim)!=moneySum2(arr,aim)||moneySum2(arr, aim)!=moneySum3(arr,aim)){
                System.out.println("输出不同");
                break;
            }
        }
    }
}
