package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Assignment3Q8a {
    public static void failFast(Map<String, String> cityCode){

        Iterator<Entry<String, String>> itr = cityCode.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, String>  m1 = (Entry<String, String>) itr.next();
            System.out.println(m1.getKey()+" "+m1.getValue());

            cityCode.put("Uttrakhand","India");
        }
    }
    public static void main(String[] args) {
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("America", "USA");
        failFast(cityCode);
    }
}