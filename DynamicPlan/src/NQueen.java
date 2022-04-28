import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author LiangShiyuan
 * @create 2022-04-25 16:53
 */
public class NQueen {
    //note:这里的N皇后问题主要是解决了N皇后解法的个数  关于N皇后的摆放在这个代码的基础上面进行修改即可


    //普通算法解决N皇后问题：

    class Solution {
        //还是使用数组先得到结果  然后将结果变为list  这样可以避免查看是否符合要求的时候过于复杂
        List<List<String>> result =  new ArrayList<>();
        HashMap<Integer, String> numsToStringMap;
        public List<List<String>> solveNQueens(int n) {
            //特殊的情况
            if(n==1){
                List<String> l = new ArrayList<>();
                l.add("Q");
                result.add(l);
                return result;
            }
            if(n==2||n==3){
                return result;
            }
            //将数字与String对应起来
            numsToStringMap  = new HashMap<>();
            for(int i=0;i<n;i++){
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[i] = 'Q';
                numsToStringMap.put(i,new String(row));
            }
            int[] nums = new int[n];
            NQueensProcessor(0, n,nums);
            return result;
        }
        //判断这个位置是否能添加
        public boolean checkRule(int[] nums, int addRank, int curRow){
            for(int i =0;i<curRow;i++){
                if(nums[i]==addRank||Math.abs(nums[i]-addRank)==Math.abs(curRow-i)){
                    return  false;
                }
            }
            return true;
        }

        //将nums变为字符串数组
        public List<String> numsToListString(int[] nums){
            List<String> listString  = new ArrayList<>();
            for(int i =0;i<nums.length;i++){
                listString.add(numsToStringMap.get(nums[i]));
            }
            return listString;
        }
        //递归函数
        public void NQueensProcessor(int curRow, int n, int[] nums){
            if(curRow==n){
                result.add(numsToListString(nums));
                return;
            }
            for(int i=0;i<n;i++){
                if(checkRule(nums,i,curRow)){
                    nums[curRow]=i;
                    NQueensProcessor(curRow+1,n,nums);
                }
            }
        }
    }
}
