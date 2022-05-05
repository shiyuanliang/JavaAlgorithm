/**
 * @author LiangShiyuan
 * @create 2022-05-05 20:11
 */
public class IslandQustation {
    public int islandQ (int[][] nums){//计算返回有多少个岛
        int X = nums.length;//有多少行
        int Y = nums[0].length;//有多少列
        int res = 0;
        for(int i=0;i<X;i++){
            for (int j=0;j<Y;j++){
                if(nums[i][j]==1){
                    infect(nums,X,Y,i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void infect(int[][] nums, int X, int Y, int i, int j){//感染过程将一片1变为2
        if(i<0||i>=X||j<0||j>=Y||nums[i][j]!=1){
            return;
        }
        nums[i][j]=2;
        infect(nums, X,Y, i+1,j);
        infect(nums, X,Y, i-1,j);
        infect(nums, X,Y, i,j+1);
        infect(nums, X,Y, i,j-1);
    }
}
