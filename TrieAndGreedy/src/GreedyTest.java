import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LiangShiyuan
 * @create 2022-04-24 21:30
 */
public class GreedyTest {

    //会议排班问题：有一个会议室，若干个会议需要安排，设计最多能安排几个会议
    public  class Program{
        int start;

        int end;
        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public class  ProgramComparator implements Comparator<Program> {
        @Override
        public  int compare(Program o1, Program o2){
            return  o1.end-o2.end;
        }
    }


    public  int bestArrnge(Program[] programs, int timePoint){
        Arrays.sort(programs,new ProgramComparator());
        int result =0;
        //遍历所有会议
        for(int i = 0;i<programs.length;i++){
            if(timePoint <= programs[i].start){
                result++;
                timePoint = programs[i].end;
            }
        }
        return  result;
    }
}
