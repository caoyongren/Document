import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	
	public static void main(String args[]) {
		/*
		 * 思路：
		 *     1.先讲集合list遍历，然后再 去除集合中的 数字字符串，并将数字字符串放入一个新的 集合  listNum
		 *     
		 *     2.然后将集合list中的元素放入数组中。
		 *     
		 *     3.对数组进行排序。
		 *     
		 *     4.对listNum  进行排序
		 *     
		 *     5.然后先输出 listNum   后输出 list
		 *     
		 *     
		 * 
		 * */
		String[] arrays = new String[] {"g曹yu", "sdf", "zf", "大同", "大到", 
				"地方", "三等分aa", "的人", "反dd对高铁", 
				"泛代数", "上的投入", "15","1","2","10" };
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		Arrays.sort(arrays,com);
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0;i<arrays.length;i++) {
			int chr = arrays[i].charAt(0);
			if (chr<48 || chr>78) {
				// 则不是数字
			} else {
				//是数字
				String str = arrays[i];
				list.add(Integer.parseInt(str)) ;
			}
		}
		Collections.sort(list);
		for (Integer item:list) {
			 System.out.print(item+" ");
	}
  }
}
