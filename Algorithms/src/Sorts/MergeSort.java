package Sorts;

public class MergeSort {
	
	public static void mergeSort(int[] arr, int low, int high) {
		
		if (low < high) {
			int middleIndex = (low + high)/2; 
			//sort left and right half respectively
			mergeSort(arr, low, middleIndex); 
			mergeSort(arr, middleIndex+1, high); 
		
			//merge the two sorted halves
			merge(arr, low, middleIndex, high); 
		}
		
	}
	
	public static void merge(int[] arr, int low, int mid, int high) {
		
		//get lengths of sub-arrays
		int lengthLeft = mid - low + 1; 
		int lengthRight = high - mid;
		//create temporary arrays
		int[] L = new int[lengthLeft]; 
		int[] R = new int[lengthRight];
		//initialize temp arrays
		for (int i = 0; i < lengthLeft; i++) {
			L[i] = arr[low+i]; 
		}
		for (int i = 0; i < lengthRight; i++) {
			R[i] = arr[i+mid+1]; 
		}
		
		int i = 0, j = 0; 
		int k = low;
		
		//loop through left and right arrays and add in the lowest value
		while (i < lengthLeft && j < lengthRight) {
			if (L[i] <= R[j]) {
				arr[k] = L[i]; 
				i++;
			} else {
				arr[k] = R[j]; 
				j++; 
			}
			k++; 
		}
		
		//Get the last value(s) that are leftoever from either the left or the right;
		while (i < lengthLeft) {
			arr[k] = L[i]; 
			i++;
			k++; 
		} 
		while(j < lengthRight) {
			arr[k] = R[j]; 
			j++;
			k++; 
		}
	}
	
}
