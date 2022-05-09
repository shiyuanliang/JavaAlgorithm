package TreeDP;

import java.util.List;

/**
 * @author LiangShiyuan
 * @create 2022-05-09 19:05
 */
public class EmployeeMaxHappyTest {
    public  static  class  Empolyee{
        int  happy;
        List<Empolyee> nexts;
    }


    public  static  class Info{
        public  int laiMaxHappy;//这个节点来的时候获得的最大的快乐
        public  int buMaxHappy;//.......不来的。。。。。。。。。。
        public Info(int lai, int bu){
            laiMaxHappy = lai;
            buMaxHappy = bu;
        }
    }

    public  static  Info process(Empolyee x){
        if(x.nexts.isEmpty()){
            return  new Info(x.happy,0);
        }
        int lai = x.happy;
        int bu = 0;
        for(Empolyee next :x.nexts){
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu +=  Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai,bu);
    }

    public  static  int EmployMaxHappy(Empolyee boss){
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }
}
