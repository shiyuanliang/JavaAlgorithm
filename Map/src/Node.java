import java.util.ArrayList;

/**
 * @author LiangShiyuan
 * @create 2022-04-20 15:52
 */
public class Node {
    public int value;
    public  int in;
    public  int out;
    public ArrayList<Node> nexts;
    public  ArrayList<Edge>  edges;

    public  Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
