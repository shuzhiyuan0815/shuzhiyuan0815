package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/*
 * 开发提示：

​	（1）用String[] nums = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };存储数字

​			String[] colors = { "方片", "梅花", "红桃", "黑桃" };存储花色

​	（2）单独处理大王、小王

​	（3）将54张牌的索引[1,54]数字依次存储到一个ArrayList中

​	（4）用nums和colors数组的组合，将54张牌存储的一个Map中，key是索引，范围是1-54，value是牌面，例如：(1,黑桃3),...(54,小王)

​	（5）对ArrayList进行洗牌打乱顺序

​	（6）依次取list中的索引，发给四位牌友，四位牌友的牌可以用TreeSet存储，这样可以按照索引大小排序，索引大小就是牌的大小

​	（7）遍历结果，TreeSet中存储的是牌的索引，显示的时候从Map中取出牌显示
 */
public class Test04 {
	public static void main(String[] args) {
		String[] nums = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
		String[] colors = { "方片", "梅花", "红桃", "黑桃" };
		String[] wang = {"大王","小王"};
		
		//存了54个索引在all中
		ArrayList<Integer> all = new ArrayList<Integer>();
		for (int i = 1; i <= 54; i++) {
			all.add(i);
		}
		
		//存储了54张牌到map中
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int index = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < colors.length; j++) {
				map.put(index++, colors[j]+nums[i]);
			}
		}
		map.put(index++, wang[0]);
		map.put(index++, wang[1]);
		
		//洗牌
		Collections.shuffle(all);
		
		TreeSet<String> up = new TreeSet<String>();
		TreeSet<String> left = new TreeSet<String>();
		TreeSet<String> me = new TreeSet<String>();
		TreeSet<String> right = new TreeSet<String>();
		for (int i = 0; i < 13; i++) {
			up.add(map.get(all.remove(0)));
			left.add(map.get(all.remove(0)));
			me.add(map.get(all.remove(0)));
			right.add(map.get(all.remove(0)));
		}
		
		System.out.println("上面的玩家：" + up);
		System.out.println("左面的玩家：" + left);
		System.out.println("本人的玩家：" + me);
		System.out.println("右面的玩家：" + right);
		
		System.out.print("底牌：");
		for (Integer i : all) {
			System.out.print("" + map.get(i) + ",");
		}
	}
}
