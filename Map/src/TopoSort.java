import javax.print.attribute.HashAttributeSet;
import java.util.*;

/**
 * @author LiangShiyuan
 * @create 2022-04-21 15:51
 */
public class TopoSort {


    //拓扑排序 主要的应用场景有编译的过程中依赖包
    public  static List<Node>  sortTopo(Graph graph){
        HashMap<Node, Integer>  inMap = new HashMap<>();
        Queue<Node>  zeroInQueue = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in ==0){
                zeroInQueue.add(node);
            }
        }

        //拓扑排序的结果，依次加入result
        List<Node>  result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur  = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next, inMap.get(next) -1);
                if(inMap.get(next)==0){
                    zeroInQueue.add(next);
                }
            }
        }
        return  result;
    }
}
