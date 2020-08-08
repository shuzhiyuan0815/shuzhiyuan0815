package Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {
		String str = "Your future depends on your dreams, so go to sleep.";
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		str = str.replaceAll("[^a-zA-Z]", "");
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])){
				Integer count = map.get(arr[i]);
				map.put(arr[i], count+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			System.out.println(entry);
		}
		
		//找value最大值
		Collection<Integer> values = map.values();
		Integer max = Collections.max(values);
		
		//看哪些字母的次数和max一样，就显示
		System.out.println("出现最多的字母和次数：");
		for (Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue() == max){
				System.out.println(entry);
			}
		}
	}
	
}
