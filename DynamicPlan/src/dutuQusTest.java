/**
 * @author LiangShiyuan
 * @create 2022-05-18 15:15
 */
public class dutuQusTest {
    //赌徒问题
    /*
    有一个数组 有两个绝顶聪明的人AB  每次只能从数组两边拿数，A先拿 B后拿 问返回最后谁一定赢  以及他拿到的数的总和
     */
    //递归问题

    public  static int win1(int[] arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        return  Math.max(f(arr, 0, arr.length-1),s(arr, 0,arr.length-1));
    }
    //先手函数
    public  static  int f(int[] arr, int i, int j){
        if(i==j){
            return arr[i];
        }
        return  Math.max(arr[i]+s(arr, i+1,j),
                arr[j]+s(arr,i,j-1));
    }
    //后手函数
    //这个时候其实你也没有拿  是别人在i与j选这个数 然后你当先手
    public  static  int s(int[] arr, int i, int j){
        if(i==j){
            return  0;
        }
        return Math.min(f(arr,i+1,j),
                f(arr,i,j-1));
    }


    //动态规划解决
    public static  int win2(int[] arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int [N][N];
        //初始化边界条件
        for(int  i=0;i<N;i++){
            f[i][i] = arr[i];
            s[i][i] = 0;
        }
        int row = 0;
        int col=1;
        while(col<N){
            int i=row;
            int j=col;
            while (i<N&& j<N){
                f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
                i++;
                j++;
            }
            col++;
        }
        return  Math.max(f[0][N-1],s[0][N-1]);
    }

    //测试  对数器
    public  static int[] generateRandomArray(int len, int max){
        int[] arr = new int[(int) (Math.random()*len)+1];
        for(int i =0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*max) +1;
        }
        return  arr;
    }

    public  static  void main(String[] args) {
        System.out.println("对数器开始");
        int len = 10;
        int max = 10;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(len, max);
            if (win1(arr) != win2(arr)) {
                System.out.println("输出不同");
                break;
            }
        }
    }
}
