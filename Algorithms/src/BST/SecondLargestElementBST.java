package BST;

import BST.BST.treeNode;

public class SecondLargestElementBST {

	int findSecondLargest(treeNode root) {
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
	
}
