import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author Jignesh Sadiya
 *
 */
public class Java8ForEach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer>map= new HashMap();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		
		
		map.forEach((k,v)-> {System.out.println("Key :" + k + "Value :"+v );
		
				if("C".equals(k)){
					System.out.println("hello c");
				}	
				}
				);
		
		List<Integer> mylist= new ArrayList<>();
		for(int i=0; i<10; i++){
			mylist.add(i);
		}
		
		Stream<Integer> streamapi= mylist.stream();
		mylist.forEach(System.out::println);


	}

}
