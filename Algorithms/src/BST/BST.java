package BST;

public class BST {
	
	public class treeNode {
		
		public int val; 
		public treeNode left; 
		public treeNode right; 
		public treeNode parent; 
		
		public treeNode(int val) {
			this.val = val; 
			this.left = null; 
			this.right = null; 
			this.parent = null; 
		}
	}
	
	public treeNode root; 
	
	public BST() {
		this.root = null; 
	}
	
	public void insert(int val) {
		root = insertRec(val, root); 
	}
	
	public treeNode insertRec(int val, treeNode root) {
		if (root == null) {
			root = new treeNode(val); 
			return root; 
		} 
		if (val > root.val) {
			root.right = insertRec(val, root.right);
			root.right.parent = root; 
		} else if (val <= root.val) {
			root.left = insertRec(val, root.left);
			root.left.parent = root; 
		}
		
		return root; 
	}

	public void printTree(treeNode root) {
		if (root == null) {
			return; 
		}
		printTree(root.left); 
		System.out.println(root.val); 
		if (root.parent != null) {
			System.out.println(root.val + " has parent: " + root.parent.val); 
		} else {
			System.out.println(root.val + " has no parent"); 
		}
		printTree(root.right); 
	}
	
	public int successor(treeNode n) {
		treeNode temp = n; 
		if (temp.right != null) {
			temp = temp.right; 
			while(temp.left != null) {
				temp = temp.left; 
			}
			return temp.val; 
		} else {
			int curr = temp.val; 
			temp = temp.parent; 
			while(temp != null) {
				if (temp.val > curr) {
					return temp.val; 
				} else {
					temp = temp.parent; 
				}
			}
			return -1; 
		}
	}
	
	public boolean isBST(treeNode n) {
		return validateBST(n, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public boolean validateBST(treeNode root, int ub, int lb) {
		if (root == null) {
			return true; 
		}
		if (root.val <= ub && root.val > lb) {
			System.out.println(root.val + " is between " + ub + " and " + lb); 
			return validateBST(root.left, root.val, lb) && validateBST(root.right, ub, root.val); 
		} else 
			return false; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST t = new BST(); 
		t.insert(10);
		t.insert(5);
		t.insert(15);
		t.insert(4);
		t.insert(8);
		t.insert(13);
		t.insert(18);
		treeNode test = t.root.left.left; 
		//t.printTree(t.root);
		System.out.println(t.isBST(t.root));
	}

}