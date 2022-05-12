import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiangShiyuan
 * @create 2022-04-19 12:42
 */

public class getSuccessorNode {
    class TwoTreeP{
        int val;
        TwoTreeP left;
        TwoTreeP right;
        TwoTreeP parent;
    }
    static  class TwoTree{
        int val;
        TwoTree left;
        TwoTree right;

        TwoTree(int value){
            val = value;
        }
    }
    //得到一个二叉树的后继节点
    /*
    1、存在右节点的时候：后继节点为右节点的最左的节点
    2、没有右节点的时候：找到一个节点为父节点的左节点， 这个父节点为后继节点
     */
    public static TwoTreeP getSuccessorNode(TwoTreeP node){
        if(node==null){
            return node;
        }
        if(node.right!=null){
            return  getLeftMost(node.right);
        }else {
            TwoTreeP parent = node.parent;
            while(parent!=null&&node!=parent.left){
                node = node.parent;
                parent = node.parent;
            }
            return  parent;
        }
    }

    public static  TwoTreeP getLeftMost(TwoTreeP node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }


    //序列化与反序列化
    //序列化
    public  String serialByPre(TwoTree head){//先序遍历
        if(head==null){
            return "#_";
        }
        String res = head.val + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return  res;
    }

    //反序列化
    public  static  TwoTree  reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for(String str : values){
            queue.add(str);
        }
        return reconPreOrder(queue);
    }

    public static  TwoTree reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        TwoTree head = new TwoTree(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    //纸的折痕
    public  static  void printAllFolds(int N){
        printProcess(1,N, true);
    }

    public  static  void printProcess(int i, int N, boolean down){
        if(i>N){
            return;
        }
        printProcess(i+1,N,true);
        System.out.println(down ? "凹": "凸");
        printProcess(i+1, N, false);
    }

    @Test
    public   void testPrintALLFolds(){
        int N = 3;
        printAllFolds(N);
    }
}
