package Heaps;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = {5,4,6,7,3,2};
		int n = 6;
		heapSort(arr, n);
		for(int i : arr) {
			System.out.println(i);
		}
	}

	private static void heapSort(int[] arr, int n) {
		
		for(int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		int size = n;
		while(size > 0) {
			swap(arr, size - 1, 0);
			heapify(arr, size - 1, 0);
			size--;
		}
		
	}
	
	private static void heapify(int arr[], int n, int p) {
		int max = p;
		int l = 2 * p + 1, r = 2 * p + 2;
		if(l < n && arr[max] < arr[l]) {
			max = l;
		}
		if(r < n && arr[max] < arr[r]) {
			max = r;
		}
		if(max != p) {
			swap(arr, p, max);
			heapify(arr, n, max);
		}
		
	}

	private static void swap(int[] arr, int p, int max) {
		int temp = arr[p];
		arr[p] = arr[max];
		arr[max] = temp;		
	}

}
