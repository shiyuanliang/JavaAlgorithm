import java.util.*;

/**
 * @author LiangShiyuan
 * @create 2022-04-21 16:30
 */
public class KruskalMST {
    //适用于无向图
    class Myset{
        public HashMap<Node, List<Node>> setMap;

        public  Myset(List<Node> nodes){
            for(Node cur: nodes){
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }
        public boolean isSameSet(Node from, Node to){
            List<Node>  fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return  fromSet == toSet;
        }

        public  void union(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for(Node cur: toSet){
                fromSet.add(cur);
                setMap.put(cur, fromSet);
            }
        }
    }

    public  static  class  EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2){
            return  o1.weight - o2.weight;
        }
    }

    public  static Set<Edge> KruskalMst(Graph graph){
        UnionFind unionFind= new  UnionFind(); //并查集结构
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        unionFind.makeSets(graph.nodes.values());
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge  edge = priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from, edge.to)){
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return  result;
    }
}
