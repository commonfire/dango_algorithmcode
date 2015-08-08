package dango_algorithmcode_class2;

/**
 * @author zjd
 * lintcode上题目：sort-letters-by-case
 * 给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
 */
public class SortLetters {
	
	public void sortLetters(char[] chars) {
		if(chars.length!=0){  //注意特判条件！！！
			int first = 0,last = chars.length-1;char key = chars[first];
	        while(first < last){
	        	while(first < last && chars[last]>='A'&&chars[last]<='Z') last--; 
	        		chars[first] = chars[last];
	        	while(first < last && chars[first]>='a'&&chars[first]<='z') first++;
	        		chars[last] = chars[first];
	        }
	        chars[first] = key;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[] chars = new char[]{'a','b','A','c','D'};
		char[] chars = new char[]{};  //此时chars数组没有元素，故其length=0！
		new SortLetters().sortLetters(chars);
		System.out.println(chars);
	}

}
