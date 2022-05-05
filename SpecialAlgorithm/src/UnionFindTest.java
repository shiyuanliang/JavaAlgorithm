import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author LiangShiyuan
 * @create 2022-05-05 21:14
 */


public class UnionFindTest{
    public   class  Element<V> {  //包装数据V  为了避免V相同而hashmap的值是相同的
        public  V value;
        public  Element(V value){
            this.value  = value;
        }
    }

    public  class  UnionFind<V>{
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public  HashMap<Element<V>, Integer> sizeMap;

        public  UnionFind(List<V> list){
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap  =  new HashMap<>();
            for(V v:list){
                Element<V> element = new Element<>(v);
                elementMap.put(v, element);
                fatherMap.put(element,element);
                sizeMap.put(element,1);
            }
        }

        public Element<V> findHead(Element<V> element){
            Stack<Element<V>> path  = new Stack<>();
            while (element!=fatherMap.get(element)){
                path.push(element);
                element = fatherMap.get(element);
            }
            Element<V> head = element;//当前集合的头节点
            while(!path.isEmpty()){
                fatherMap.put(path.pop(),head);
            }
            return  head;
        }

        public  boolean isSameSet(V a, V b){
            if (elementMap.containsKey(a)&&elementMap.containsKey(b)){
                return findHead(elementMap.get(a))==findHead(elementMap.get(b)); //看两个节点是否是同一个父
            }
            return  false;//如果集合中不含有这个两个元素返回false
        }

        public  void  union(V a, V b){
            if(elementMap.containsKey(a)&&elementMap.containsKey(b)){
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if(aF==bF){
                    Element<V> big = sizeMap.get(aF)>sizeMap.get(bF)? aF:bF;
                    Element<V> small = big==aF? bF:aF;
                    fatherMap.put(small,big);
                    sizeMap.put(big, sizeMap.get(big)+sizeMap.get(small));
                    sizeMap.remove(small);
                }
            }
        }

    }


}
