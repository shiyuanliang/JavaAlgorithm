import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author LiangShiyuan
 * @create 2022-04-20 19:02
 */
public class MapTraverse {

    //宽度优先遍历
    public  static  void  bfs(Node node){
        if(node==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> hashSet = new HashSet<>();
        queue.add(node);
        hashSet.add(node);
         while(!queue.isEmpty()){
             Node cur = queue.poll();
             System.out.println(cur.value);
             for(Node  next : cur.nexts){
                 if(!hashSet.contains(next)){
                     hashSet.add(next);
                     queue.add(node);
                 }
             }

        }
    }

    //深度优先遍历
    public static  void dfs(Node node){
        if(node==null){
            return;
        }
        Stack<Node>  stack = new Stack<>();
        HashSet<Node>  hashSet = new HashSet<>();
        stack.add(node);
        hashSet.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if(!hashSet.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    hashSet.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
