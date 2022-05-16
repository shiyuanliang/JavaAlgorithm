/**
 * @author LiangShiyuan
 * @create 2022-05-16 15:48
 */
public class YinBITest {
    /*
    由若干个硬币  有一个目标值 要求求出最小硬币数瞒住得到目标值
     */

    //暴力递归的方法
    public static  int minCoins1(int[] arr, int aim){
        return  process1(arr, 0, aim);
    }

    public  static  int process1(int[] arr, int index, int rest){
        if(rest<0){
            return -1;
        }
        if(rest==0){
            return 0;
        }
        if(index==arr.length){
            return  -1;
        }
        int  p1 = process1(arr, index+1, rest);
        int p2next = process1(arr, index+1, rest-arr[index]);
        if(p1==-1&&p2next==-1){
            return  -1;
        }else{
            if(p1==-1){
                return p2next+1;
            }
            if(p2next==-1){
                return  p1;
            }
            return  Math.min(p1,p2next+1);
        }
    }

    //记忆搜索的方法
    public  static  int  minCoins2(int[] arr, int aim){
        int N = arr.length;
        int[][] dp= new int[N+1][aim+1];
        for(int i =0;i<N+1;i++){
            for(int j=0;j<aim+1;j++){
                dp[i][j] = -2;//初始化
            }
        }
        return process2(arr,0, aim, dp);
    }

    public  static  int process2(int[] arr, int index, int rest, int[][] dp){
        if(rest<0){
            return -1;
        }
        if(dp[index][rest]!=-2){
            return  dp[index][rest];
        }
        if(rest==0){
            dp[index][rest] = 0;
        }else if(index==arr.length){
            dp[index][rest] = -1;
        }else {
            int p1 = process2(arr, index + 1, rest, dp);
            int p2next = process2(arr, index + 1, rest - arr[index], dp);
            if (p1 == -1 && p2next == -1) {
                dp[index][rest] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][rest] = p2next + 1;
                }else if (p2next == -1) {
                    dp[index][rest] = p1;
                }else {
                    dp[index][rest] = Math.min(p1, p2next + 1);
                }
            }
        }
        return  dp[index][rest];
    }


    //动态规划
    public  static int minCoins3(int[] arr, int aim){
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        for(int i =0;i<N+1;i++){//将第一列全部为0   也就是说当rest=0时为0
            dp[i][0] = 0;
        }
        for(int i=0;i<aim+1;i++){//将最后一行设定为-1  也就是说当index=index时为-1
            dp[N][i] = -1;
        }
        for(int index=N-1;index>=0;index--){
            for(int rest =1;rest<aim+1;rest++){
                int p1 = dp[index+1][rest];
                int p2next = -1;
                if(rest-arr[index]>=0){
                    p2next = dp[index+1][rest-arr[index]];
                }
                if(p1==-1&&p2next==-1){
                    dp[index][rest] = -1;
                }else{
                    if(p1==-1){
                        dp[index][rest] = p2next+1;
                    }else if(p2next==-1){
                        dp[index][rest] =  p1;
                    }else{
                        dp[index][rest] =Math.min(p1,p2next+1);
                    }
                }
            }
        }
        for(int i =0;i<N+1;i++){
            for(int j=0;j<aim+1;j++){
                System.out.println(dp[i][j]);
            }
        }

        return  dp[0][aim];
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
            if(minCoins1(arr, aim)!=minCoins2(arr,aim) || minCoins2(arr,aim)!=minCoins3(arr,aim)){
                System.out.println("输出不同");
                break;
            }
        }
    }
}
