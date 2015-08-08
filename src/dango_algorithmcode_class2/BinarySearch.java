package dango_algorithmcode_class2;

/**
 * @author zjd
 * lintcode上题目：binary-search
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），
 * 如果target不存在于数组中，返回-1。
 */
public class BinarySearch {
	
	public int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right){
			int mid = (left+right)/2;
			if(target < nums[mid]) right = mid-1;
			else if(target > nums[mid]) left = mid+1;
			else{
				while(mid!=0&&nums[mid]==nums[mid-1]){   //用于获取第一次出现target值的位置，target可能出现多次
					mid--;
				}
				return mid;
			}
				
		}
		return -1;
    }
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,2,2,3,3,4,4,4,5,5};
		System.out.println(new BinarySearch().binarySearch(a, 1));
	}
}

