import javax.print.attribute.IntegerSyntax;
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



    //第二种Dijkstra算法 新建一个小根堆的结构  这样就不用遍历选择最小的那个值

    public  class NodeRecord {
        public  Node  node;
        public  int distance;

        public  NodeRecord(Node node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public class NodeHeap {
        private  Node[] nodes;
        private  HashMap<Node, Integer> heapIndexMap;
        private  HashMap<Node, Integer> distanceMap;
        private  int size;
        public NodeHeap(int size){
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public   boolean isEmpty(){
            return  size ==0;
        }

        public   void addOrUpdateOrIgnore(Node node, int distance){
            if(inHeap(node)){//还在Node[] 大根堆中
                distanceMap.put(node,Math.min(distanceMap.get(node),distance));
                insertHeapify(node,heapIndexMap.get(node));
            }
            if(!isEntered(node)){
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node,distance);
                insertHeapify(node,size++);
            }
        }

        public NodeRecord pop(){
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0,size-1);
            heapIndexMap.put(nodes[size-1],-1);//删除弹出的节点
            distanceMap.remove(nodes[size-1]);
            nodes[size-1] = null;
            heapify(0,--size);
            return  nodeRecord;
        }

        private void insertHeapify(Node node, int index){
            while(distanceMap.get(nodes[index])<distanceMap.get(nodes[(index-1)/2])){
                swap(index,(index-1)/2);
                index = (index-1)/2;
            }
        }

        private  void heapify(int index,int size){
            int left = index*2+1;
            while(left<size){
                int smallext= left+1 <size && distanceMap.get(nodes[left])<distanceMap.get(nodes[left+1]) ?left :left+1;
                smallext = distanceMap.get(nodes[smallext])<distanceMap.get(nodes[index])? smallext:index;
                if(smallext==index){
                    break;
                }
                swap(smallext,index);
                index = smallext;
                left = index*2+1;
            }
        }

        private  boolean isEntered(Node node){
            return  heapIndexMap.containsKey(node);
        }
        private boolean inHeap(Node node){
            return  isEntered(node) && heapIndexMap.get(node)!=-1;
        }
        private  void swap(int index1, int index2){
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2],index1);
            Node temp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = temp;
        }
    }


    public  HashMap<Node, Integer> dijkstra2(Node head, int size){
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head,0);
        HashMap<Node, Integer> result = new HashMap<>();
        while(!nodeHeap.isEmpty()){
            NodeRecord record = nodeHeap.pop();
            Node  cur = record.node;
            int distance = record.distance;
            for(Edge edge :cur.edges){
                nodeHeap.addOrUpdateOrIgnore(cur, edge.weight+distance);
            }
            result.put(cur,distance);
        }
        return  result;
    }

}
