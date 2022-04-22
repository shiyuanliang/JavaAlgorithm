import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author LiangShiyuan
 * @create 2022-04-22 19:03
 */
public class DijkstraMST {
    //适用于没有累加权重为负数的环
    //输出为head节点到不同节点的最小距离。
    public  static HashMap<Node, Integer>  dijkstra1(Node head){
        /*
        从head出发到所有点的最小距离
        key：从head出发到key
        value：从head出发到value的最小距离
        如果表中没有那个节点证明：从head到那个节点的最小距离为正无穷，即为不可达
         */
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        //已经求过的点就放在selectSet中，锁住
        HashSet<Node>  selectNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectNodes);
        while(minNode!=null){
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance+edge.weight);
                }
                distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance+edge.weight));
            }
            selectNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectNodes);
        }
        return  distanceMap;
    }

    public  static  Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectNodes){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!selectNodes.contains(node)  && distance<minDistance){
                minNode  = node;
                minDistance = distance;
            }
        }
        return  minNode;
    }
}
