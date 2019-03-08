package Sorts;

public class QuickSort {
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int sortedElemIndex = partition(arr, low, high); 
			
			quickSort(arr, low, sortedElemIndex - 1);//sort left side
			quickSort(arr, sortedElemIndex + 1, high); //sort right
			
		}
		///printArray(arr); 
	}
	
	private static int partition(int[] arr, int low, int high) {
		
		int pivotIndex = high;
		int pivot = arr[pivotIndex]; 
		
		//start i one behind the first element we loop over
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				//incremenet i and swap with arr[j]; 
				i++;
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		}
		
		//swap pivot
		//place pivot in correct spot
		int temp = arr[i+1]; 
		arr[i+1] = arr[pivotIndex]; 
		arr[pivotIndex] = temp; 
		
		//return the index of the pivot element
		return i+1; 
		
		
	}
	
	public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 2, 8, 3, 17, 1}; 
		MergeSort.mergeSort(arr, 0, 5);
		printArray(arr); 

	}

}
