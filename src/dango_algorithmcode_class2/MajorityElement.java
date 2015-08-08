package dango_algorithmcode_class2;

/**
 * @author zjd
 * 找出数组中出现的次数超过一半的数字
 */
public class MajorityElement {
	
	/**
	 * 找出数组中出现的次数超过一半的数字
	 * @param numbers    给定数组
	 * @return           找出的数字
	 */
	private static int majorityElement(int[] numbers){
		int num = 0;
		int counter = 0;
		for(int i = 0;i<numbers.length;i++){
			if(counter == 0){
				num = numbers[i];
				counter = 1;
			}
			else if(num == numbers[i]) counter++;
			else counter--;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,2,2,2,3};
		System.out.println(majorityElement(a));
	}
}
