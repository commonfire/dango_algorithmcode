package dango_algorithmcode_class2;

import java.util.ArrayList;

public class FindKthMax {
	
	private static int findKthMax(Integer[] a,int k,int low,int high){
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
			num = findKthMax(left_arr, k, ++low, left_arr.length-1);
		}
		else{
			num = findKthMax(right_arr, k-left_arr.length, 0, right_arr.length-1);
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
	
	private int findKthMax2(int[] a,int k,int low,int high){
		int ans = 0;
		if(low >= high) return a[low];
		else{
			int mid = sort(a, low, high);
			if(mid > k-1)     //注意判断条件不是>k!!
				ans = findKthMax2(a, k, low, mid-1);
			else if(mid < k-1) 
				ans = findKthMax2(a, k, mid+1, high);
			else 
				ans = a[mid];
		    return ans; 
		}	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] a = new Integer[]{1,4,3,2};
//		System.out.println(findKthMax(a, 2, 0, a.length-1));
		int[] a = new int[]{6,2,4,1};
//		System.out.println(new FindKthMax().sort(a, 0, a.length-1));
		System.out.println(new FindKthMax().findKthMax2(a, 3, 0, a.length-1));
	}

}
