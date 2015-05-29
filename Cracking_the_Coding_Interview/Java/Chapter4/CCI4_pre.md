这里给出二叉查找树的广度遍历和深度遍历，可以参考[二叉查找树的实现](http://jemoii.github.io/blog/binary-search-tree/)中给出的内容。

```java
public class BST<E extends java.lang.Comparable<E>> {
	// 内部树节点类
	class TreeNode<E> {
		E value;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E e) {
			value = e;
		}
	}
	// 根节点
	protected TreeNode<E> root;

    public BST() {

    }
	// 由数组构建二叉查找树
	public BST(E[] array) {
		root = new TreeNode<E>(array[0]);

		for(int i = 1; i < array.length; i++) {
			TreeNode<E> parent = root;
			while(parent.left != null && array[i].compareTo(parent.value) < 0)
				parent = parent.left;
			while(parent.right != null && array[i].compareTo(parent.value) > 0)
				parent = parent.right;

			if(array[i].compareTo(parent.value) < 0)
				parent.left = new TreeNode<E>(array[i]);
			else if(array[i].compareTo(parent.value) > 0)
				parent.right = new TreeNode<E>(array[i]);
			else
				;// 重复元素不予操作
		}
	}
	// 二叉查找树的广度遍历（队列实现）
	public java.util.ArrayList<E> BFS() {
		java.util.Queue<TreeNode<E>> q = new java.util.LinkedList<TreeNode<E>>();
		java.util.ArrayList<E> bfs = new java.util.ArrayList<E>();

		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode<E> node = q.remove();
			bfs.add(node.value);

			if(node.left != null)
				q.offer(node.left);
			if(node.right != null)
				q.offer(node.right);
		}

		return bfs;
	}
	// 二叉查找树的深度遍历（栈实现）
	public java.util.ArrayList<E> DFS_Stack() {
		java.util.Stack<TreeNode<E>> s = new java.util.Stack<TreeNode<E>>();
		java.util.ArrayList<E> dfs_stack = new java.util.ArrayList<E>();

		s.push(root);
		while(s.peek().left != null)
			s.push(s.peek().left);

		while(!s.isEmpty()) {
			TreeNode<E> node = s.pop();
			dfs_stack.add(node.value);

			if(node.right != null) {
				s.push(node.right);
				while(s.peek().left != null)
					s.push(s.peek().left);
			}
		}

		return dfs_stack;
	}
	// 二叉查找树的深度遍历（递归实现）
	protected java.util.ArrayList<E> dfs_rec = new java.util.ArrayList<E>();

	public java.util.ArrayList<E> DFS_Rec() {
		DFS_Rec(root);

		return dfs_rec;
	}

	protected void DFS_Rec(TreeNode<E> node) {
		if(node == null)
			return;
		DFS_Rec(node.left);
		dfs_rec.add(node.value);
		DFS_Rec(node.right);
	}
}
```