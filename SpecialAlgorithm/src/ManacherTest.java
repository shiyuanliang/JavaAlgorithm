/**
 * @author LiangShiyuan
 * @create 2022-05-07 17:07
 */
public class ManacherTest {

    public  char[]  manacherString(String str){
        char[] s = str.toCharArray();
        char[] sW = new char[s.length*2+1];//扩展后的字符串数组
        for(int i = 0;i<sW.length;i++){
            sW[i] = i%2==0 ?'#' :s[i/2];//将原字符串变为中间含有’#‘的
        }
        return  sW;
    }

    public int mainManacher(String s){
        char[] str = manacherString(s);//扩展字符串
        int[] pArr = new int[str.length];
        int C = -1;  //中心
        int R = -1;  //回文右边界的再往右一个位置 最右的有效区域为R-1  也就是说R不是回文半径的边界  方便后面进行与i的比较
        //如果R比i大就证明  这个时候i在回文半径里面  只要R不大与i 即等于i(因为R小于i只有在第一个位置的时候出现)  这个时候都不在回文半径里面
        int max = Integer.MIN_VALUE;
        for(int i=0;i<str.length;i++){
            pArr[i] = R>i ? Math.min(pArr[2*C-i],R-i):1; //这就是将后面的三种情况都一起处理了  算法复杂度是一样的
            while (i+pArr[i]<str.length&&i-pArr[i]>-1){//只要不超过边界都进行
                if(str[i+pArr[i]]==str[i-pArr[i]]){
                    pArr[i]++;//这个时候证明数组能向外扩
                }else{
                    break;
                }
            }

            if(i+pArr[i]>R){//更新回文半径
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max,pArr[i]);
        }
        return  max-1;//最大回文子串就是等于回文半径-1  因为回文串已经经过了扩容    实际上回文子串的长度等于  （（回文半径-1）乘以2+1）/2-1  可以直接化简为这个
    }
}
