import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class HuiWenDanList {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,3,2,2,1};
//        Node<Integer> head = arrayToNode(nums);
//        printNode(head);
//        huiWenStack(head)
        String[] nums = {"OK"};
        System.out.println(nums[0]);
        cesi(nums);
        System.out.println(nums[0]);
    }

    public  static  void cesi(String[] nums){
        nums[0] = "hello";
    }


    public static  Node  arrayToNode(int[] nums){
        Node<Integer> node = new Node<>();
        Node<Integer> head;
        head = node;
        node.value = nums[0];
        node.next = new Node<Integer>();
        for(int i = 1; i<nums.length; i++) {
            node = node.next;
            node.value = nums[i];
            node.next = new Node<Integer>();
        }
        node.next=null;
        return  head;
    }
    public  static class  Node<V>{
        V  value;
        Node next;
    }

    public  static  void  printNode(Node head){
        while(head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
    public  static  boolean huiWenStack(Node head){
        Node<Integer> node1 = new Node<>();
        return  true;
    }
}
