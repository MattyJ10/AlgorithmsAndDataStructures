package BST;

import java.util.ArrayList;
import java.util.List;

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
	
	public void insert(int value) {
		treeNode traverse = this.root;
		if (this.root == null) {
			this.root = new treeNode(value);
			return;
		}
		findSpot(value, traverse);
	}

	public void findSpot(int value, treeNode n) {
		if (value > n.val) {
			if (n.right == null) {
				n.right = new treeNode(value); 
				return; 
			} else {
				findSpot(value, n.right); 
			}
		} else {
			if (n.left == null) {
				n.left = new treeNode(value); 
				return; 
			} else {
				findSpot(value, n.left); 
			}
		}
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
	
	//isBST
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
	
	//find second largest
	int findSecondLargest() {
		if (root.left == null && root.right == null) 
			return -1; 
		treeNode temp = root; 
		int parentVal = -1; 
		while(temp.right != null) {
			parentVal = temp.val; 
			temp = temp.right; 
		}
		if (temp.left != null) {
			temp = temp.left; 
			while(temp.right != null) {
				temp = temp.right; 
			}
			return temp.val;
		} else {
			return parentVal; 
		}
	}
	
	/*
	 * CTCI Problem 4.3: List Of Depths
	 * 		Problem Complexity: O(N)
	 */
	
	List<List<Integer>> listOfDepths(treeNode root) {
		List<List<Integer>> depths = new ArrayList<List<Integer>>();
		depths.add(new ArrayList<Integer>()); 
		depths.get(0).add(root.val);
		generateList(root.left, 1, depths);
		generateList(root.right, 1, depths);
		return depths; 
	}

	void generateList(treeNode n, int currentDepth, List<List<Integer>> depths) {
		if (n == null) {
			return;
		}
		if (depths.size() == currentDepth) {
			depths.add(new ArrayList<Integer>());
			depths.get(currentDepth).add(n.val);
			generateList(n.left, currentDepth + 1, depths);
			generateList(n.right, currentDepth + 1, depths); 
		} else {
			depths.get(currentDepth).add(n.val);
			generateList(n.left, currentDepth + 1, depths);
			generateList(n.right, currentDepth + 1, depths); 
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST t = new BST(); 
		t.insert(10);
		t.insert(15);
		t.insert(18);
		t.insert(13);
		t.insert(4);
		t.insert(5);
		t.insert(6);
		System.out.println(t.listOfDepths(t.root)); 
	}

}
