/**
 * @author LiangShiyuan
 * @create 2022-04-20 15:52
 */
public class Edge {
    public  int weight;
    public  Node from;
    public  Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
