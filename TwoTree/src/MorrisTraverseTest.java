import TreeDP.MaxDisTreeTest;
import TreeDP.MaxDisTreeTest.Node;

import java.util.ArrayList;

/**
 * @author LiangShiyuan
 * @create 2022-05-10 20:40
 */
public class MorrisTraverseTest {

    public  static  void morris(Node head){
        if(head==null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur!=null){
            mostRight = cur.left;
            if(mostRight!=null){//有左子树的情况
                while(mostRight.right!=null&& mostRight.right==cur){
                    mostRight = mostRight.right; //找到最右的那个节点
                }
                if(mostRight.right==null){//第一次来到最右节点的时候  将这个节点的空指针指向当前节点  当前节点向左移动
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(mostRight.right==cur){//第二次来到最右的节点  将这个最右节点的指针从新置空
                    mostRight.right=null;
                }
            }
            cur = cur.right;
        }
    }


    public  static  void morrisPre(Node head){//先序遍历：有两次的只打印第一次   没两次的直接打印
        if(head==null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur!=null){
            mostRight = cur.left;
            if(mostRight!=null){//有左子树的情况
                while(mostRight.right!=null&& mostRight.right==cur){
                    mostRight = mostRight.right; //找到最右的那个节点
                }
                if(mostRight.right==null){//第一次来到最右节点的时候  将这个节点的空指针指向当前节点  当前节点向左移动
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(mostRight.right==cur){//第二次来到最右的节点  将这个最右节点的指针从新置空
                    mostRight.right=null;
                }
            }else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }


    public  static  void morrisIn(Node head){//中序遍历：有两次的打印第二次   没有的直接打印
        if(head==null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur!=null){
            mostRight = cur.left;
            if(mostRight!=null){//有左子树的情况
                while(mostRight.right!=null&& mostRight.right==cur){
                    mostRight = mostRight.right; //找到最右的那个节点
                }
                if(mostRight.right==null){//第一次来到最右节点的时候  将这个节点的空指针指向当前节点  当前节点向左移动
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(mostRight.right==cur){//第二次来到最右的节点  将这个最右节点的指针从新置空
                    mostRight.right=null;
                }
            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    public  static  void  MorrisLast(Node head){//后序遍历：先前都不动  只有在第二次到达接节点的时候  打印左子树的右边界
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur!=null){
            mostRight = cur.left;
            if(mostRight!= null){
                while (mostRight.right!=null&&mostRight.right!=cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(mostRight.right==cur){//第二次到达这个节点的位置
                    mostRight.right =null;
                    printEdg(cur.left)//打印左子树的有边界
                }
            }
            cur= cur.right;
        }
        printEdg(head);//打印整个树的右边界
    }

    public  static  void  printEdg(Node X){
        Node tail = reverseEdge(X);
        Node cur = tail;
        while (cur!=null){
            System.out.println(cur.value+"");
            cur = cur.right;
        }
        reverseEdge(tail);
    }
    public  static  Node reverseEdge(Node from ){
        Node pre = null;
        Node next = null;
        while (from!=null){
            next = from.right;
            from.right = pre;
            pre = from;
            from  = next;
        }
        return pre;
    }
}
