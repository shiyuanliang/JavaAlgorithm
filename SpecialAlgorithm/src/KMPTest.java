/**
 * @author LiangShiyuan
 * @create 2022-05-05 21:58
 */
public class KMPTest {
    public static  void main(String[] args){
        return;
    }
    public  int  getIndexOf(String s, String m){
        if(s==null||m==null||m.length()<1||m.length()<1||s.length()<m.length()){
            return  -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int[]  next = getNextAarray(str2);
        int i1=0;//第一个数组匹配的位置
        int i2 =0;//第二个数组匹配的位置
        while (i1<str1.length&&i2<str2.length){
            if(str1[i1]==str2[i2]){//表示匹配上后的情况
                i1++;
                i2++;
            }else if(i2==0||next[i2]==-1){//表示当前字符串匹配到m的第一个\\或者说前面没有重复的子串
                i1++;
            }else {//没有匹配上的时候将m移到最小前缀子串
                i2 = next[i2];
            }
        }
        return  i2 == str2.length ? i1-i2 :-1;
    }

    public  int[] getNextAarray(char[] ms){
        if(ms.length==1){
            return  new int[] {-1};
        }
        int[]  next = new int[ms.length];
        next[0] =-1;
        next[1] =0;
        int i =2;//表示当前字符串的长度
        int cn = 0; //表示当前比较的子字符串的长度以及当前比较的位置
        while(i<ms.length){
            if(ms[i-1]==ms[cn]){//表示当前比较的位置相等
                next[i++] = ++cn;  //下一个值的next就等于前一个的加上1
            }else if(cn >0){//表示这个时候比较的位置还没有到0 的位置  但是之前比较的位置都不相等的情况
                cn = next[cn];
            }else{
                next[i++] =0;//连一个一个位置都不相等  这个时候就证明这个位置的最大前缀为0
            }
        }
        return next;
    }
}
