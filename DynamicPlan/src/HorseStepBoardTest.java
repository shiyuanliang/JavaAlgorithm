/**
 * @author LiangShiyuan
 * @create 2022-05-18 20:14
 */
public class HorseStepBoardTest {
    /*
    在象棋盘中 马从原点的位置跳到（x，y）  走K步 有多少种运动的方法
     */
    public  static  int horse1(int x, int y,int K){
        return process(x,y,K);
    }

    //从原点运动到x，y的算法是等价于从x，y运动到原点的
    public static  int  process(int x, int y, int step){
        if(x>8||x<0||y>9||y<0||step<0){
            return 0;
        }
        if(step==0){
            return  (x==0 && y==0) ? 1:0;
        }
        return  process(x-1,y+2,step-1)+
                process(x-2,y+1,step-1)+
                process(x-2,y-1,step-1)+
                process(x-1,y-2,step-1)+
                process(x+1,y-2,step-1)+
                process(x+2,y-1,step-1)+
                process(x+2,y+1,step-1)+
                process(x+1,y+2,step-1);
    }

    public  static int  horse2(int x, int y,int K){
        int[][][] dp = new int[9][10][K+1];
        dp[0][0][0] = 1;
        for(int i = 1;i<=K;i++){
            for(int j = 0;j<9;j++){
                for(int k=0;k<10;k++){
                    dp[j][k][i] +=getValue(dp,j-1,k+2,i-1);
                    dp[j][k][i] +=getValue(dp,j-2,k+1,i-1);
                    dp[j][k][i] +=getValue(dp,j-2,k-1,i-1);
                    dp[j][k][i] +=getValue(dp,j-1,k-2,i-1);
                    dp[j][k][i] +=getValue(dp,j+1,k-2,i-1);
                    dp[j][k][i] +=getValue(dp,j+2,k-1,i-1);
                    dp[j][k][i] +=getValue(dp,j+1,k+2,i-1);
                    dp[j][k][i] +=getValue(dp,j+2,k+1,i-1);
                }
            }
        }
        return dp[x][y][K];
    }


    public  static  int getValue(int[][][] dp, int x,int y, int step){
        if(x>8||x<0||y>9||y<0||step<0){
            return 0;
        }
        return  dp[x][y][step];
    }

    public  static int[] generateRandomArray(){
        int[] arr = new int[2];
        arr[0] = (int)(Math.random()*8)+1;
        arr[1] = (int)(Math.random()*9)+1;
        return  arr;
    }
    public  static void  main(String[] args){
        System.out.println("对数器开始");
        int minStep = 2;
        int testTime = 10000;
        for(int i=0;i<testTime;i++){
            int step = (int)(Math.random()*minStep*2) + minStep;
            int[] arr = generateRandomArray();
            if(horse1(arr[0],arr[1],step)!=
                    horse2(arr[0],arr[1],step)){
                System.out.println("输出错误");
            }
        }
        System.out.println("结束");
    }
}
