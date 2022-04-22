import java.util.*;

public class traverse {

    public static void main(String[] args) {


    }
    class TwoTree <E>{
        E val;
        TwoTree left;
        TwoTree  right;
    }

    public  static  void  twoTreeRecursion(TwoTree head){
        if(head ==null){
            return;
        }
        System.out.println(head.val);//先序遍历
        twoTreeRecursion(head.left);
        System.out.println(head.val);//中序遍历u
        twoTreeRecursion(head.right);
        System.out.println(head.val);//后序遍历
    }

    public  static  void  twoTreeUnrecursion(TwoTree head){
        if (head == null){
            return;
        }
        //1.新建一个栈
        Stack<TwoTree> stack = new Stack<TwoTree>();
        stack.add(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.val + " ");
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }

    }


    public  static  void  twoTreeZhongUnrecusion(TwoTree head){
        if(head == null){
            return;
        }
        Stack<TwoTree> stack = new Stack<TwoTree>();
        while(!stack.isEmpty() || head !=null){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }
        }
    }

    public   static  int wideUnrecusion(TwoTree head){
        if(head ==null){
            return 0;
        }
        Queue<TwoTree> queue = new LinkedList<>();
        HashMap<TwoTree, Integer> hashMap = new HashMap<>();
        queue.add(head);
        hashMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TwoTree  cur = queue.poll();
            int curNodeLevel = hashMap.get(cur);
            if(curNodeLevel ==curLevel){
                curLevelNodes++;
            }else {
                max = Math.max(curLevelNodes,max);
                curLevel++;
                curLevelNodes=1;
            }
            System.out.println(cur.val);
            if(cur.left!= null){
                queue.add(cur.left);
                hashMap.put(cur.left, curLevel+1);
            }
            if(cur.right != null){
                queue.add(cur.right);
                hashMap.put(cur.right, curLevel+1);
            }
        }
        max = Math.max(curLevelNodes, max);
        return  max;
    }
}
