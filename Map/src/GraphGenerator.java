/**
 * @author LiangShiyuan
 * @create 2022-04-20 16:17
 */
public class GraphGenerator {
    //矩阵是N*3每行的第一个表示当前边的权重，第二个表示边的起始点，第三个表示边的终止点
    public static  Graph matrixToGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for(int i = 0; i < matrix.length; i++){
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return  graph;
    }
}
