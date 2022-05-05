import java.util.List;

/**
 * @author LiangShiyuan
 * @create 2022-04-28 21:42
 */
public class HanNuoTa {
    public  static  void hanoi(int n){
        if(n>0){
            func(n,"左","右","中");
        }
    }


    public  static  void func(int i, String from, String to, String other){
        if(i==1){
            System.out.println("Move 1 from "+ from+ " to " + to);//最后的结束条件
        }else{
            func(i-1, from, other, to);//将i-1个从from到other
            System.out.println("Move "+ i +" from "+ from+ " to " + to);//将i个从from到to
            func(i-1, other, to, from);//将i-1从other到to
        }
    }
    public static void  main(String[] args){
        int n = 3;
        hanoi(3);
    }

}
