import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    //最省钱的分割金条的方法
    //将一根金条分割成int[]数组的长度，当金条的长度为n的时候需要花费n元，问怎样分割花费最小
    public  int bestAr(int[] programs){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0;i<programs.length;i++){
            priorityQueue.add(programs[i]);
        }
        int sum =0;
        while(priorityQueue.size()>1){
            int result = priorityQueue.poll()+priorityQueue.poll();
            sum +=result;
            priorityQueue.add(result);
        }
        return  sum;
    }


    //投资问题
    //有初始资金M，最大投资数K，项目的收益已经项目的成本的数组programs【】，求怎么样才能收益最大化
    class  MoneyPrograms{
        int cost;

        int profit;

        public MoneyPrograms(int cost, int  profit){
            this.cost = cost;
            this.profit = profit;
        }
    }


    class  MinQriortyCompartor implements  Comparator<MoneyPrograms>{
        @Override
        public int compare(MoneyPrograms o1, MoneyPrograms o2) {
            return o1.cost-o2.cost;
        }
    }

    class  MaxQriortyCompartor implements  Comparator<MoneyPrograms>{
        @Override
        public int compare(MoneyPrograms o1, MoneyPrograms o2) {
            return o2.profit-o2.profit;
        }
    }

    public  int getBestProfit(int M, int K, MoneyPrograms[] programs){
        PriorityQueue<MoneyPrograms> minPri = new PriorityQueue<>(new MinQriortyCompartor());
        PriorityQueue<MoneyPrograms> maxPri = new PriorityQueue<>(new MaxQriortyCompartor());
        for(MoneyPrograms program : programs){
            minPri.add(program);
        }
        for(int i = 0;i<M;i++){
            if(!minPri.isEmpty()&&minPri.peek().cost<=M){
                maxPri.add(minPri.poll());
            }
            if(maxPri.isEmpty()){
                return M;
            }
            M += maxPri.poll().profit;
        }
        return M;
    }
}
