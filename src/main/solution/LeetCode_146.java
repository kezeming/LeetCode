package main.solution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 哈希表 + 双向链表
//--- 自己手动实现 --- LRUCache缓存机制
public class LeetCode_146 {
    static class Solution146 {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
        }
        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public Solution146(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if(node == null) {
                return -1;
            }
            // 如果key存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if(node == null) {
                // key不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                size++;
                if(size > capacity) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                // key存在，先通过哈希表定位，再修改value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // moveToNode 拆分成两步：首先删除一个节点，然后在头部添加一个节点
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    // --- 使用Java自带的LinkedHashMap ---
    static class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache2(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}