
public class divideAndConquer {
	public static int max(int[] arr , int low, int high) {
		int mid, left, right;
		mid = (low+high)/2;
		if(low==high) return arr[low];
		
		left=max(arr,low,mid);
		right=max(arr,mid+1,high);
		return (left>right)?left:right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6, 2, 9, 8, 1, 4, 17, 5};
		
		System.out.println(max(arr,0,arr.length-1));
	}

}
