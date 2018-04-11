package file.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberMatch {
	public static void main(String[] arg){

		String str1 = "13521206386\n" +
				"13668306563\n" +
				"13681076740\n" +
				"13693642762\n" +
				"13716327099\n" +
				"13823794686\n" +
				"13831324557\n" +
				"13910477758\n" +
				"13910897107\n" +
				"13911662933\n" +
				"13930562377\n" +
				"13931320702\n" +
				"13931320782\n" +
				"13933995707\n" +
				"15010398731\n" +
				"15011462103\n" +
				"15081333838\n" +
				"15081387400\n" +
				"15097399868\n" +
				"15726670199\n" +
				"15803137788\n" +
				"15830302626\n" +
				"15930354945\n" +
				"18271265712\n" +
				"18730366464\n";
		String str2 = "13668306563\n" +
				"13681076740\n" +
				"13693642762\n" +
				"13716327099\n" +
				"13823794686\n" +
				"13831324557\n" +
				"13910477758\n" +
				"13910897107\n" +
				"13930562377\n" +
				"13931320702\n" +
				"13933995707\n" +
				"15011462103\n" +
				"15081333838\n" +
				"15081387400\n" +
				"15803137788\n" +
				"15830302626\n" +
				"15930354945\n" +
				"17895047727\n" +
				"18159325306\n" +
				"18159412442\n" +
				"18160685486\n" +
				"18162372456\n" +
				"18271265712\n" +
				"18730366464";
		String[] split1 = str1.split("\n");
		String[] split2 = str2.split("\n");
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		for (String s : split1) {
			list1.add(s);
		}
		for (String s : split2) {
			list2.add(s);
		}
		list2.removeAll(list1);

		for (String s : list2) {
			System.out.println(s);
		}
//		list1.removeAll(list2);
//
//		for (String s : list1) {
//			System.out.println(s);
//		}

	}

}
