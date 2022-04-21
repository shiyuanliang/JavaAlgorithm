import java.util.HashMap;
import java.util.HashSet;

/**
 * @author LiangShiyuan
 * @create 2022-04-20 15:52
 */
public class Graph {
    public HashMap<Integer, Node>  nodes;
    public HashSet<Edge> edges;

    public  Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
