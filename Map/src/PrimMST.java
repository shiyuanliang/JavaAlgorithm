import org.junit.Test;

import java.util.*;

/**
 * @author LiangShiyuan
 * @create 2022-04-22 16:45
 */
public class PrimMST {
    //适用于无向图
    public  static  class EdgeComparatot implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }
    @Test
    public static Set<Edge> PrimMST(Graph graph){
        //新建一个小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparatot());
        HashSet<Node>  set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for(Node node : graph.nodes.values()){//为了防止是森林图的情况
             //
            if(!set.contains(node)){
                set.add(node);
                for(Edge edge : node.edges){
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for(Edge nextEdge : toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return  result;
    }
}
