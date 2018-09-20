package org.minions.devfund.ronald.sd2x.hw4;


public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/


	/**
	 * First, implement the findNode method in hw4.BinarySearchTree.java. Given a value that is stored in the BST,
	 * it returns the corresponding hw6.Node that holds it. If the value does not exist in this BST, this method
	 * should return null.
	 */
	public Node findNode(E val) {
		if (val == null) return null;

		return findNode(root, val);
	}

	private Node findNode(Node node, E val) {
		if (node == null) return null;

		if (node.value.equals(val)) {
			return node;
		} else if (node.value.compareTo(val) > 0) { // node > val = return leftChild
			return findNode(node.leftChild, val);
		} else {
			return findNode(node.rightChild, val);
		}
	}

	/**
	 * Then, implement the depth method. Given a value, this method should return the “depth” of its hw6.Node,
	 * which is the number of ancestors between that node and the root, including the root but not the node itself.
	 * The depth of the root is defined to be 0; the depth of its two children (if any) is defined to be 1;
	 * the depth of the root’s grandchildren (if any) is defined to be 2; and so on. If the value is null or does not
	 * exist in this BST, this method should return -1.
	 */
	protected int depth(E val) {
		if (val == null) return -1;
		if (val.compareTo(root.value) == 0) return 0;

		return depth(root, val);
	}

	private int depth(Node node, E val) {
		int depth = 0;
		Node nodeTarget = findNode(val);
		if (nodeTarget == null) return -1;

		while (!node.equals(nodeTarget)) {
			depth ++;
			if (node.value.compareTo(nodeTarget.value) > 0) {
				node = node.leftChild;
			} else {
				node = node.rightChild;
			}
		}

		return depth;
	}

	/**
	 *Next, implement the height method. Given a value, this method should return the “height” of its hw6.Node,
	 * which is the greatest number of nodes between that node and any descendant node that is a leaf, including
	 * the leaf but not the node itself. The height of a leaf node (i.e., one which has no children)
	 * is defined to be 0. If the input value is null or does not exist in this BST, this method should return -1.
	 */
	protected int height(E val) {
		if (val == null) return -1;
		Node nodeTarget = findNode(val);
		if (nodeTarget == null) return -1;


		return height(nodeTarget);
	}

	private int height(Node node) {
		if (node == null) return -1;

		if (node.leftChild == null && node.rightChild == null) return 0;


		return 1 + Math.max(height(node.leftChild), height(node.rightChild));
	}


	// Method #4.
	protected boolean isBalanced(Node n) {

		if (n == null || findNode(n.value) == null) return false;

		Node nodeTarget = findNode(n.value);
		int height = Math.abs(height(nodeTarget.leftChild) - height(nodeTarget.rightChild));

		return height < 2;

	}
	
	// Method #5. .
	public boolean isBalanced() {

		return isAllBalanced(root);

	}

	private boolean isAllBalanced(Node n) {
		if (n == null) return false;

		boolean isBalanced = isBalanced(n);

		if (n.leftChild != null) {
			isBalanced = isBalanced && isAllBalanced(n.leftChild);
		}
		if (n.rightChild != null) {
			isBalanced = isBalanced && isAllBalanced(n.rightChild);
		}

		return isBalanced;
	}

}
