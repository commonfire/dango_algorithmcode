package dango_algorithmcode_class2;

import java.util.ArrayList;

/**
 * @author zjd
 * 找序列中第K大的数
 */
public class FindKthSmallest {
	
	private static int findKthSmallest(Integer[] a,int k,int low,int high){
		int num = 0;
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();	 
		int key;
		if(low<a.length) key = a[low];
		else {key = a[0];low = 0;}
		for(int i=0;i<a.length;i++){
			if(a[i]<=key) left.add(a[i]);
			else right.add(a[i]);
		}
		Integer[] left_arr = left.toArray(new Integer[1]);
		Integer[] right_arr = right.toArray(new Integer[1]);
		if(left.size() == k) return key;
	
		if(left.size()>k){
			num = findKthSmallest(left_arr, k, ++low, left_arr.length-1);
		}
		else{
			num = findKthSmallest(right_arr, k-left_arr.length, 0, right_arr.length-1);
		}
		return num;
	}
/////////////////////////////////////////////////////////////////////////////////////
	private int sort(int[] a,int low,int high){
		int key = a[low];
		while(low<high){
			while(low < high&&a[high] >= key) high--;
			a[low] = a[high];
			while(low < high&&a[low] <= key) low++;
			a[high] = a[low];
		}
		a[low] = key;
		return low;	
	}
	
	private int findKthSmallest2(int[] a,int k,int low,int high){
		int ans = 0;
		if(low >= high) return a[low];
		else{
			int mid = sort(a, low, high);
			if(mid > k-1)     //注意判断条件不是>k!!  注意第k大等价于n-k+1小，其中n为数组长度！！leetcode上有求第K大的数，用此方法
				ans = findKthSmallest2(a, k, low, mid-1);
			else if(mid < k-1) 
				ans = findKthSmallest2(a, k, mid+1, high);
			else 
				ans = a[mid];
		    return ans; 
		}	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] a = new Integer[]{6,2,4,1};
//		System.out.println(findKthSmallest(a, 2, 0, a.length-1));
		int[] a = new int[]{6,2,4,1};
		System.out.println(new FindKthSmallest().findKthSmallest2(a, 1, 0, a.length-1));
	}

}
