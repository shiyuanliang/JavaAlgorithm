/**
 * @author LiangShiyuan
 * @create 2022-05-16 12:51
 */
public class NumsRootTest {
    /*一共有1~N位置
    最终的目标是end
    初始位置为end
    总共有K步
    有多少种走法
    */
    //这个是暴力递归的版本
    public  static  int  walkWays1(int N, int start, int end, int K){
        return  f1(N, end, K, start);
    }

    public  static int f1(int N , int end, int rest, int cur){
        if(rest==0){
            return end==cur ? 1:0;
        }
        if(cur==1){
            return  f1(N, end, rest-1, 2);
        }
        if(cur==N){
            return  f1(N, end, rest-1, N-1);
        }
        return  f1(N, end, rest-1, cur-1)+f1(N, end, rest-1,cur+1);
    }


    //记忆搜索
    public  static  int walkWays2(int N, int start, int end, int K){
        int[][] dp = new int[K+1][N+1];
        for(int i = 0;i<K+1;i++){
            for(int j=0;j<N+1;j++){
                dp[i][j] = -1;
            }
        }
        return  f2(N, start, end,K, dp);
    }

    public  static  int f2(int N, int cur, int end, int rest, int[][] dp){
        if(dp[rest][cur]!=-1){//表示这个位置已经求过了
            return  dp[rest][cur];
        }

        if(cur==1){
            dp[rest][cur] = f2(N, 2, end, rest-1, dp);
        }else if(cur==N){
            dp[rest][cur] = f2(N, N-1, end, rest-1, dp);
        }
        dp[rest][cur] = f2(N, cur-1,end, rest-1,dp)+f2(N, cur+1,end, rest-1,dp);
        return  dp[rest][cur];
    }

    //动态规划：核心就是利用数组的位置信息  来代替递归进行求解
    public  static  int walksWays(int N, int start, int end , int K){
        int[][] dp = new int[K+1][N+1];
        dp[0][end] = 1;
        for(int i =0;i<K+1;i++){
            for (int j=0;j<N+1;j++){
                if(j==0){
                    dp[i][j]=-1;
                    continue;
                }
                if(j==1){
                    dp[i][j] = dp[i-1][j+1];
                    continue;
                }
                if(j==N){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
            }
        }
        return  dp[K][end];
    }
}
