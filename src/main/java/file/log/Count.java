package file.log;

import java.util.HashSet;
import java.util.Set;

public class Count {
	
	public static void main(String[] arg){
	    String countStr = "params:{\"mobile\":\"13910897107\"}," +
			    "params:{\"mobile\":\"13910897107\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13910897107\"}," +
			    "params:{\"mobile\":\"13823794686\"}," +
			    "params:{\"mobile\":\"13823794686\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13910897107\"}," +
			    "params:{\"mobile\":\"15010398731\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13716327099\"}," +
			    "params:{\"mobile\":\"15097399868\"}," +
			    "params:{\"mobile\":\"15097399868\"}," +
			    "params:{\"mobile\":\"15097399868\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13693642762\"}," +
			    "params:{\"mobile\":\"18271265712\"}," +
			    "params:{\"mobile\":\"18271265712\"}," +
			    "params:{\"mobile\":\"13693642762\"}," +
			    "params:{\"mobile\":\"13693642762\"}," +
			    "params:{\"mobile\":\"13693642762\"}," +
			    "params:{\"mobile\":\"15081333838\"}," +
			    "params:{\"mobile\":\"15081333838\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13931320702\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"13933995707\"}," +
			    "params:{\"mobile\":\"15803137788\"}," +
			    "params:{\"mobile\":\"15081387400\"}," +
			    "params:{\"mobile\":\"15930354945\"}," +
			    "params:{\"mobile\":\"15803137788\"}," +
			    "params:{\"mobile\":\"15011462103\"}," +
			    "params:{\"mobile\":\"15011462103\"}," +
			    "params:{\"mobile\":\"13681076740\"}," +
			    "params:{\"mobile\":\"13681076740\"}," +
			    "params:{\"mobile\":\"13930562377\"}," +
			    "params:{\"mobile\":\"15830302626\"}," +
			    "params:{\"mobile\":\"13930562377\"}," +
			    "params:{\"mobile\":\"15726670199\"}," +
			    "params:{\"mobile\":\"13930562377\"}," +
			    "params:{\"mobile\":\"13693642762\"}," +
			    "params:{\"mobile\":\"13910477758\"}," +
			    "params:{\"mobile\":\"18730366464\"}," +
			    "params:{\"mobile\":\"13681076740\"}," +
			    "params:{\"mobile\":\"18730366464\"}," +
			    "params:{\"mobile\":\"13930562377\"}," +
			    "params:{\"mobile\":\"13930562377\"}," +
			    "params:{\"mobile\":\"13681076740\"}," +
			    "params:{\"mobile\":\"15830302626\"}," +
			    "params:{\"mobile\":\"13681076740\"}," +
			    "params:{\"mobile\":\"18730366464\"}," +
			    "params:{\"mobile\":\"13831324557\"}," +
			    "params:{\"mobile\":\"13668306563\"}," +
			    "params:{\"mobile\":\"13668306563\"}," +
			    "params:{\"mobile\":\"13693642762\"}," +
			    "params:{\"mobile\":\"15097399868\"}," +
			    "params:{\"mobile\":\"15097399868\"}," +
			    "params:{\"mobile\":\"13931320702\"}," +
			    "params:{\"mobile\":\"13931320702\"}," +
			    "params:{\"mobile\":\"13931320782\"}," +
			    "params:{\"mobile\":\"13931320702\"}," +
			    "params:{\"mobile\":\"13911662933\"}," +
			    "params:{\"mobile\":\"13521206386\"}," +
			    "params:{\"mobile\":\"13521206386\"},";
		String[] split = countStr.split(",");
		Set set = new HashSet();
		for (String s : split) {
			set.add(s);
		}
		System.out.println(split.length+" , "+set.size());
		for (Object o : set) {
			
		}
	}
	
}
