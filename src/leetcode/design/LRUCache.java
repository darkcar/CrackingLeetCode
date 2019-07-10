package leetcode.design;

import java.util.Hashtable;

public class LRUCache {
	class CacheNode {
		int key;
		int val; 
		CacheNode next;
		CacheNode prev;
	}
	
	// Create datastructure 
	private Hashtable<Integer, CacheNode> lookUpTable;
	// head
	private CacheNode head;
	private CacheNode tail;
	private int maxCapacity; 
	private int totalNodesInCache;
	
	public LRUCache(int capacity) {
		this.maxCapacity = capacity;
		this.lookUpTable = new Hashtable<>(capacity);
		totalNodesInCache = 0;
		
		this.head = new CacheNode();
		this.tail = new CacheNode();
		
		this.head.prev = null;
		this.tail.next = null;
		this.tail.prev = head;
		this.head.next = tail;
	}
	
	public int get(int key) {
		CacheNode node = this.lookUpTable.get(key);
		boolean isFoundInCache = node != null;
		if (!isFoundInCache) {
			return -1;
		}
		
		// move to head
		moveNodeToHead(node);
		return node.val;
	}
	
	public void put(int key, int value) {
		//1. Node exits: update the value of that node and move that node to the front
		//2. Node doesn't exit: 
		//	2.1 totalNodesInCache is up to the maxCapacity, remove the last one and add the new node to the front
		// 	2.2 totalNodesInCache is not full, add this new node to the front. 
		CacheNode node = this.lookUpTable.get(key);
		boolean isFoundNodeInCache = node != null;
		if (!isFoundNodeInCache) {
			CacheNode newNode = new CacheNode();
			newNode.key = key;
			newNode.val = value;
			
			this.lookUpTable.put(key, newNode);
			
			// add the node to the list
			addToHead(newNode);
			
			this.totalNodesInCache ++;
			
			if (totalNodesInCache > maxCapacity) {
				// remove the last node 
				CacheNode lastNode = this.tail.prev;
				removeNode(lastNode);
				
				this.lookUpTable.remove(lastNode.key);
				totalNodesInCache --;
			}
		} else {
			node.val = value;
			moveNodeToHead(node);
		}
		
	}
	
	
	private void moveNodeToHead(CacheNode node) {
		removeNode(node);
		addToHead(node);
	}
	
	
	private void addToHead(CacheNode node) {
		node.prev = this.head;
		node.next = this.head.next;
		this.head.next.prev = node;
		this.head.next = node;
	}
	
	private void removeNode(CacheNode node) {
		CacheNode prev = node.prev;
		CacheNode next = node.next;
		prev.next = next;
		next.prev = prev;
	}
}
