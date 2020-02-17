

@Controller
public class TestController {

	
	
	public static Map<Integer,String[]> map = new HashMap<Integer,String[]>();
	
	public static List<String> getCombination(Integer[] arr,Integer i,List<String> list) {
		if(i == arr.length) {
			return list;
		}
		List<String> list2 = new ArrayList<String>();
		if(list == null || list.size()==0) {
			Integer number = arr[i]; //数字
			String[] letters = map.get(number); //数组
			if(letters!=null) {
				for(String letter : letters) {
					list2.add(letter);
				}
			}
			i++;
		}else {
			Integer number = arr[i]; //数字
			String[] letters = map.get(number); //数组
			if(letters!=null) {
				for(String letter : letters) {
					for(String str : list) {
						list2.add(str+letter);
					}
				}
			}
			i++;
		}
		List<String> list3 = getCombination(arr,i,list2);
		return list3;
	}
	
	public static void main(String[] args) {

			Integer[] arr = {2,3};
			
			map.put(2, new String[] {"a","b","c"});
			map.put(3, new String[] {"d","e","f"});
			map.put(4, new String[] {"g","h","i"});
			map.put(5, new String[] {"j","k","l"});
			map.put(6, new String[] {"m","n","o"});
			map.put(7, new String[] {"p","q","r","s"});
			map.put(8, new String[] {"t","u","v"});
			map.put(9, new String[] {"w","x","y","z"});
			
			Map<String,Object> strMap = new HashMap<String,Object>();
			List<String> list = getCombination(arr,0,null);

			if(list!=null && list.size()>0) {
				for(String str : list) {
					System.out.println(str);
				}
			}
		}
}
