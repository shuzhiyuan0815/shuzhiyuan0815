package Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * 模拟乐透号码。
* 随机生成10个号码放到集合中，范围1-50，作为乐透号码。不能重复。
* 键盘录入10个整数放到集合中，范围1-50，不能重复。
* 录入的整数与乐透号码对比，统计猜中了几个。
 */
public class Test03 {
	public static void main(String[] args) {
		ArrayList<Integer> le = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; ) {
			int num = rand.nextInt(50)+1;
			if(!le.contains(num)){
				le.add(num);
				i++;
			}
		}
		System.out.println(le);
		
		ArrayList<Integer> shu = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 10; ) {
			System.out.println("请输入第" + (i+1) + "个数字：");
			int num = input.nextInt();
			if(!shu.contains(num)){
				shu.add(num);
				i++;
			}else{
				System.out.println("号码重复了");
			}
		}
		input.close();
		System.out.println(shu);
		
		//方式一：遍历shu集合，看是否包含在le集合中
/*		int count = 0;
		for (Integer num : shu) {
			if(le.contains(num)){
				count++;
			}
		}*/
		
		//方式二：求交集
		le.retainAll(shu);
		System.out.println("猜中了：" + le.size());
	}
}
