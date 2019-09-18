
public class Quick {
	
	public static int partition(int[] arr, int start, int finish) {
		int pivotVal=arr[(start+finish)/2];
		int left = start;
		int right = finish;
		int temp;
		
		while( left<=right ) {
			while( arr[left]<pivotVal ) left++;
			while( arr[right]>pivotVal ) right--;
			
			if( left<=right ) {
				temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				
				left++;
				right--;
			}
		}
		
		
		return left;
		
	}
	public static void quicksort(int[] arr , int start, int finish) {
		if(start<finish) {
			int mid = partition(arr, start, finish);
			
			quicksort(arr, start, mid-1);
			quicksort(arr, mid, finish);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,2,6,2,1,6};
		
		quicksort(nums, 0, nums.length-1);
		
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}

}
