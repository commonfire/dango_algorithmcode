package dango_algorithmcode_class2;

/**
 * @author zjd
 * 自己实现选择排序，插入排序，冒泡排序，快速排序，归并排序
 */
public class SortPractice {
	
	//交换数组中a,b位置元素
	private static void swap(int[] c,int a,int b){  
		int tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
	
	/**
	 * 选择排序
	 * @param a  待排序的数组
	 * @return   排好序的数组
	 */
	private static int[] selectSort(int[] a){
		for(int i=0;i<a.length;i++){
			int min = a[i];        //初始化“最小”值
			int position = i;      //初始化“最小”位置
			for(int j=i+1;j<a.length;j++){
				if(a[j]<min){
					min = a[j];     //更新“最小”值
					position = j;   //更新“最小”位置
				}
				a[position] = a[i];
				a[i] = min; 
			}
		}	
		return a;
	}
	
	/**
	 * 插入排序
	 * @param a   待排序的数组
	 * @return    排好序的数组
	 */
	private static int[] insertSort(int[] a){
		for(int i =1;i<a.length;i++){
			for(int j=i;j>=1;j--){
				if(a[j]<a[j-1]) swap(a, j, j-1);
				else break;
			}
		}
		return a;
	}
	
	/**
	 * 冒泡排序
	 * @param a  待排序的数组
	 * @return   排好序的数组
	 */
	private static int[] bubbleSort(int[] a){
		for(int i = 0;i+1<a.length;i++){
			for(int j=1;j+i<a.length;j++){
				if(a[j]<a[j-1]) swap(a, j, j-1);
			}
		}
		return a;
	}
	
	/**
	 * 快速排序
	 * @param a     待排序的数组
	 * @param low   数组的起点
	 * @param high  数组的结束点
	 */
	private static void quickSort(int[] a,int low,int high){
		if(low >= high) return;
		int first = low,last = high,key = a[first];
		while(first < last){
			while(first < last&&a[last] >= key) --last;   //注意key是选择的first位置的，所以要从last开始，不能从first开始。
			a[first] = a[last];                           //同时first<last是对内层while的限制，不与外层while的first<last冲突
			while(first < last&&a[first] <= key) ++first;
			a[last] = a[first];
		}
		a[first] = key;  //此时first=last,将key赋值回数组
		quickSort(a, low, first-1);
		quickSort(a, last+1, high);
	}
	
	/**
	 * 归并排序
	 * @param a       待排序数组
	 * @param tmp     额外空间数组
	 * @param left    数组左起点
	 * @param right   数组右终点
	 */
	private static void mergeSort(int[] a,int[] tmp,int left,int right){
		if(left >= right) return;
		int mid = (left + right)/2;
		mergeSort(a, tmp, left, mid);        //获得左边有序子序列
		mergeSort(a, tmp, mid+1, right);     //获得右边有序子序列
		int p_final = left,p_left = left,p_right = mid + 1;
		while(p_left<=mid||p_right<=right){   //此处用或，考虑到左子序列或右子序列可能为空
			if(p_left<=mid&&(p_right>right||a[p_left]<=a[p_right])){
				tmp[p_final] = a[p_left];     //取左边子序列中最小的赋值到tmp
				p_final++;
				p_left++;
			}
			else{
				tmp[p_final] = a[p_right];    //取右边子序列中最小的赋值到tmp
				p_final++;
				p_right++;
			}
		}
		for(int i = left;i<=right;i++){   //将tmp数组copy回原来的数组中
			a[i]=tmp[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = selectSort(new int[]{2,5,4,1});
		//int[] a = insertSort(new int[]{2,5,4,1,3});
		//int[] a = bubbleSort(new int[]{2,5,4,1,3});
		int[] a = new int[]{2,6,4,1,3};
		//quickSort(a, 0, a.length-1);
		int[] tmp = new int[a.length];
		mergeSort(a, tmp, 0, a.length-1);
		for(int i: a){
			System.out.println(i);	
		}
		
	}

}
