package leetcode.medium;
//https://leetcode.com/problems/lru-cache/description/
import java.util.HashMap;
import java.util.Map;

//Time: O(1) for get and put
//Space: O(capacity) for the HashMap + doubly linked list
public class LRUCache {
    int capacity;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer,Node> map=new HashMap<>();

    LRUCache(int c){
        capacity=c;
        map.clear();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int k){
        int val=-1;
        if(map.containsKey(k)){
            val=map.get(k).value;
            Node currNode=map.get(k);

            //delete node
            deleteNode(currNode);

            //add node
            addNode(currNode);
        }
        return val;
    }

    public void put(int k, int v){
        if(map.containsKey(k)){
            Node node=map.get(k);
            node.value=v;
            deleteNode(node);
            addNode(node);
            return;
        }
        if(map.size()==capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node node=new Node(k,v);
        map.put(k,node);
        addNode(node);

    }

    public void deleteNode(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }

    public void addNode(Node node){
        Node next=head.next;
        head.next=node;
        next.prev=node;
        node.prev=head;
        node.next=next;
    }

    public static void main(String[] args) {
        LRUCache lru=new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println("Expected= 1, Actual= "+lru.get(1));
        lru.put(3,3);
        System.out.println("Expected= -1, Actual= "+lru.get(2));
        lru.put(4,4);
        System.out.println("Expected= -1, Actual= "+lru.get(1));
        System.out.println("Expected= 3, Actual= "+lru.get(3));
        System.out.println("Expected= 4, Actual= "+lru.get(4));

    }

}

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int k, int v) {
        key = k;
        value = v;
    }
}
