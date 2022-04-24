import org.w3c.dom.traversal.NodeIterator;

/**
 * @author LiangShiyuan
 * @create 2022-04-24 19:16
 */
public class TrieCode {
    public  static  class  TrieNode{
        public  int pass;
        public   int  end;
        public  TrieNode[] nexts;
        public  TrieNode(){
            pass = 0;
            end = 0;
            nexts = new  TrieNode[26];
        }
    }

    public  static  class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }
        //向前缀树中加上word
        public  void  insert(String word){
            char[] c = word.toCharArray();
            int nodeIndex=0;
            TrieNode node  = root;
            node.pass++;
            for(int i = 0;i<c.length;i++){
                nodeIndex = c[i]-'a';
                if(node.nexts[nodeIndex]==null){
                    node.nexts[nodeIndex] = new TrieNode();
                }
                node = node.nexts[nodeIndex];
                node.pass++;
            }
            node.end++;
        }

        //删除word
        public  void delete(String word){
            if(search(word)==0){
                return;
            }
            char[] c= word.toCharArray();
            TrieNode node = root;
            node.pass--;
            int nodeIndex;
            for(int i = 0;i<c.length;i++){
                nodeIndex = c[i]-'a';
                if(--node.nexts[nodeIndex].pass ==0){
                    node.nexts[nodeIndex]=null;
                    return;
                }
                node = node.nexts[nodeIndex];
            }
            node.end--;
        }

        //查询word加入的次数
        public  int  search(String   word){
            if(word==null){
                return root.end;
            }
            char[] c = word.toCharArray();
            int nodeIndex;
            TrieNode node = root;
            for(int i = 0;i<c.length;i++){
                nodeIndex = c[i]-'a';
                if(node.nexts[nodeIndex]==null){
                    return 0;
                }
                node = node.nexts[nodeIndex];
            }
            return  node.end;
        }

        //所有加入的字符串中， 有几个是以pre这个字符串作为前缀的
        public  int prefixNumber(String pre){
            if(pre==null){
                return root.end;
            }
            char[] c = pre.toCharArray();
            TrieNode node = root;
            int nodeIndex;
            for(int i=0;i<c.length;i++){
                nodeIndex = c[i]-'a';
                if(node.nexts[nodeIndex]==null){
                    return 0;
                }
                node = node.nexts[nodeIndex];
            }
            return node.pass;
        }
    }
}
