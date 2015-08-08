package dango_algorithmcode_class2;

import java.util.ArrayList;

/**
 * @author zjd
 * lintcode上题目：merge-sorted-array-ii
 * 合并两个排序的整数数组A和B变成一个新的数组。如给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 * 实际上是归并操作
 */
public class MergeSortedArray {

	 public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
	        int p_A = 0,p_B = 0;
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        while(p_A < A.size()||p_B < B.size()){
	        	if(p_A < A.size()&&(p_B >= B.size()||A.get(p_A)<=B.get(p_B))){
	        		result.add(A.get(p_A));
	        		p_A++;
	        	}
	        	else{
	        		result.add(B.get(p_B));
	        		p_B++;
	        	}
	        }
			return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>(){{add(1);add(5);}};
		ArrayList<Integer> B = new ArrayList<Integer>(){{add(2);add(3);}};
		System.out.println(new MergeSortedArray().mergeSortedArray(A, B));

	}

}
