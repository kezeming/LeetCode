package main.solution;
//课本上总说 deep copy 和 shallow copy，似懂非懂的，不觉得这东西有什么用。慢慢地，
//发现 deep copy背后隐藏的逻辑其实是一种对象图（Object Graph）的遍历行为——这东西广泛出现在各语言的垃圾回收、序列化机制里。
//内存里各个对象存储空间中放置的引用域/指针就好像有向图里一条边，你沿着它去到达内存中的每个角落、去到当前对象所有的关联对象。
//题设里的neibours就像一道开胃菜，它可以是其他collection、甚至object，学会这个deep copy，你也就学会了GC里的可达性分析、
//你也就学会了如何把RAM中的数据固化到硬盘里。
//
//深拷贝 *对象图*

import main.resources.Node;

import java.util.ArrayList;
import java.util.HashMap;

class Solution133 {
	private HashMap<Node, Node> visited = new HashMap<>();
	public Node cloneGraph(Node node) {
		if(node == null) {
			return node;
		}
		// 若该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点并返回
		if(visited.containsKey(node)) {
			return visited.get(node);
		}
		// 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
		Node cloneNode = new Node(node.val, new ArrayList<Node>());
		// 哈希表存储
		visited.put(node, cloneNode);

		// 遍历节点的邻居并更新克隆节点的邻居列表
		for(Node neighbor : node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbor));
		}
		return cloneNode;
	}
}