package main.solution;

import java.util.HashMap;

// Definition for a Node.
public class LeetCode_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
//深拷贝带随机指针的 *链表*

     class Solution {
        private HashMap<Node, Node> vis = new HashMap<>();
        public Node copyRandomList(Node head) {
            if(head == null) {
                return head;
            }
            Node dummyHead = new Node(-1);
            Node dummyCurr = dummyHead;
            Node curr = head;
            while(curr != null) {
                if(!vis.containsKey(curr)) {
                    dummyCurr.next = cloneNode(curr);
                } else {
                    dummyCurr.next = vis.get(curr);
                }
                curr = curr.next;
                dummyCurr = dummyCurr.next;
            }
            return dummyHead.next;
        }
        public Node cloneNode(Node node) {
            if(vis.containsKey(node)) {
                return vis.get(node);
            }
            Node cloneNode = new Node(node.val);
            vis.put(node, cloneNode);
            if(node.random != null) {
                cloneNode.random = cloneNode(node.random);
            }
            return cloneNode;
        }
    }
}