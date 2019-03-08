package avlTree;

public class AvlTree {
	
	//ensures log(n) search time by auto-balancing the BST 
	//used heavily in operating systems
	//performance suffers if doing heavy inserting/deleting data due to the need for rebalancing
	//use when searches are performed frequently and insertion/deletion is performed rarely
	//balance factor = height(right) - height(left)
	//if balance factor is > 0 --> right heavy
	//if balance factor is < 0 --> left heavy
	/*
	 * if tree is right-heavy, balance factor > 1 {
	 * 		if right subtree is left heavy, balance factor < 0 {
	 * 			perform left-right rotation
	 * 		} else {
	 * 			perform left rotation
	 * 		}
	 * } else if tree is left-heavy, balance factor < -1 {
	 * 		if left subtree is right heavy, balance factor > 0 {
	 * 			perform right-left rotation
	 * 		} else {
	 * 			perform right rotation
	 * 		}
	 * }
	 */
	
	//Tree is balanced if the height difference between the left and right subtree is not > 1
	//height = max(heightLeftSubTree, heightRightSubTree) + 1
	//when calculating the height, you start counting at -1 because if there are no nodes, you return -1 for the height
	
	/* Four rotation cases:
	 * 		left rotation:
	 * 			Make the current root the left subtree of its right child
	 * 			Left rotation is done when the right subtree has a greater height than the left
	 * 		right rotation
	 * 			Opposite of the left rotation, done when left subtree has greater height than left
	 * 		left right rotation
	 * 			Done when root node only has a left child and that left child has a right child
	 * 			The left child's left child does not matter and will not be changed
	 * 		right left rotation
	 * 			Done when root node only has a right child and the right child has a left child
	 * 			the right child's right child does not matter and will not be changed
	 */
	
	public class AvlTreeNode {
		int data;
		int height; 
		//each node tracks its height factor
		AvlTreeNode left;
		AvlTreeNode right; 
		
		public AvlTreeNode(int data) {
			this.data = data; 
			this.left = null; 
			this.right = null; 
		}
	}
	
	AvlTreeNode root;
	
	public AvlTree() {
		this.root = null; 
	}
	
	private AvlTreeNode rotateRight(AvlTreeNode root) {
		//detach left child's right subtree
		AvlTreeNode leftsRight = root.left.right; 
		
		//rotate the left subtree to be the new root
		AvlTreeNode newRoot = root.left; 
		
		//update the old root to be the new root's right subtree
		newRoot.right = root; 
		
		//move the right subtree of the original left subtree to the old root's left subtree
		root.left = leftsRight; 
		
		//update height values for the changed nodes
		root.height = calculateHeight(root); 
		newRoot.height = calculateHeight(newRoot); 
		
		return newRoot; 
	}
	
	private AvlTreeNode rotateLeft(AvlTreeNode root) {
		//detach right nodes left subtree
		AvlTreeNode rightsLeft = root.right.left; 
		
		//make the new root the right subtree
		AvlTreeNode newRoot = root.right; 
		
		//make the left of the new root the old root
		newRoot.left = root; 
		
		//make the right of the old root the new roots former left subtree
		root.right = rightsLeft; 
		
		//recalculate heights
		root.height = calculateHeight(root); 
		newRoot.height = calculateHeight(root); 
		
		return newRoot; 
		
	}
	
	private AvlTreeNode rotateRightLeft(AvlTreeNode root) {
		//perform left rotation on left subtree then right rotation on root
		rotateLeft(root.left); 
		return rotateRight(root);
	}
	
	private AvlTreeNode rotateLeftRight(AvlTreeNode root) {
		//perform right rotation on right subtree then left rotation on root
		rotateRight(root.right); 
		return rotateRight(root);
	}
	
	public void insertNode(int value) {
		//insert like a binary search tree, then make sure the balance factor of nodes (going back to root) are not affected
		int balanceFactor; 
		if (insertHelper(root, value) == 1) {
			AvlTreeNode n = this.root;
			System.out.println("value " + value);
			//node inserted successfully so check the tree for imbalances
			while (n.data != value) {
				//check balance factor, perform rotation and break or continue down the tree
				balanceFactor = calculateHeight(n.right) - calculateHeight(n.left);
				System.out.println("currentNode: " + n.data); 
				System.out.println("balance: " + balanceFactor); 
				if (balanceFactor > 1) {
					System.out.println("right heavy");
					//right heavy
					int subtreeBF = calculateHeight(n.right.right) - calculateHeight(n.right.left); 
					if (subtreeBF < 0) {
						System.out.println("rotate Left Right");
						n = rotateLeftRight(n); 
						break;
					} else {
						System.out.println("rotate left");
						n = rotateLeft(n); 
						break;
					}
				} else if (balanceFactor < -1) {
					int subtreeBF = calculateHeight(n.left.right) - calculateHeight(n.left.left);  
					if (subtreeBF > 0) {
						n = rotateRightLeft(n); 
						break; 
					} else {
						n = rotateRight(n); 
						break;
					}
				} else {
					System.out.println("no rotation needed");
					if (value > n.data) {
						n = n.right; 
					} else {
						n = n.left; 
					}
				}
			}
		} else {
			//no rotations needed, not inserted
			System.out.println("error"); 
			return; 
		}
	}
	
	private int insertHelper(AvlTreeNode node, int value) {
		if (node == null) {
			//root will always be passed so this must be an empty tree;
			this.root = new AvlTreeNode(value); 
			return 1; 
		}
		
		if (value > node.data) {
			if (node.right == null) {
				node.right = new AvlTreeNode(value); 
				return 1; 
			} else {
				return insertHelper(node.right, value);
			}
		} else if (value < node.data) {
			if (node.left == null) {
				node.left = new AvlTreeNode(value); 
				return 1; 
			} else {
				return insertHelper(node.left, value); 
			}
		} else {
			return 0; 
		}
	}
	
	public void deleteNode(int value) {
		
	}
	
	public void printTree(AvlTreeNode root) {
		if (root == null) {
			return; 
		} else {
			printTree(root.left); 
			System.out.println(root.data); 
			printTree(root.right); 
		}
	}
	
	public int calculateHeight(AvlTreeNode root) {
		//balance factor = height of left - height of right (absolute value)
		//balanced if no two subtrees differ in height by more than 1
		if (root == null) {
			return 0; 
		} else if (root.left == null && root.right == null) {
			return 1; 
		} else {
			return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right)); 
		}
	}
	
	public static void main(String[] args) {
		AvlTree avl = new AvlTree(); 
		avl.insertNode(5); 
		avl.insertNode(10);
		avl.insertNode(11);
		avl.insertNode(3);
		avl.insertNode(4);
		avl.printTree(avl.root);
	}
}
