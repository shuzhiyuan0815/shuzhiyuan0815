package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		/*
		Math.random();//[0,1)
		Random rand = new Random();
		rand.nextInt();//整个int范围
		rand.nextInt(100);//[0,100)
		*/
		/*
		 * 大写字母：[65,65+26]
		 * 小写字母：[97,97+26]
		 * 数字：[48,48+9]
		 */
		//如果直接用Random或Math.random()不太方便控制范围
		
		//换一种思路
		char[] letters = new char[26+26+10];//62
		for (int i = 0; i < letters.length; i++) {
//			letters[0]~letters[9]  存'0'-'9'
//			letters[10]~letters[10+25]  存'A'-'Z'
//			letters[36]~letters[36+25]  存'a'-'z'
			if(i>=0 && i<=9){
				letters[i] = (char)('0' + i);
			}else if(i>=10 && i<=35){
				letters[i] = (char)('A' + (i-10));
			}else if(i>=36 && i<=61){
				letters[i] = (char)('a' + (i-36));
			}
		}
		
		System.out.println(Arrays.toString(letters));
		Random rand = new Random();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {//表示生成10组验证码
			String str = "";
			for (int j = 0; j < 6; j++) {//每一组验证码有6位
				int index = rand.nextInt(letters.length);
				str += letters[index];
			}
			list.add(str);
		}
		
		for (String string : list) {
			System.out.println("随机验证码：" + string);
		}
	}
}
