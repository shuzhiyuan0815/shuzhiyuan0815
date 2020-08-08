package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * 案例：

​	1、随机生成10个[1,100]之间的整数，放到List集合中，遍历显示

​	2、找出前3名最大值，删除它们，注意可能重复

​	3、显示删除后的结果
 */
public class Test05 {
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(rand.nextInt(100)+1);
		}
		System.out.println(list);
		
		Collections.sort(list);
		
		for (int i = 0; i < 3; i++) {
			list.remove(list.size()-1);
		}
		System.out.println(list);
	}
}
