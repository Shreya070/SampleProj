package lambda;

import java.util.HashMap;



public class Assignment4Q7 {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("shree",1);
        map.put("raj",2);
        map.put("shreya",3);

        Assignment4Q7 assignment4Q7 = new Assignment4Q7();
        assignment4Q7.convertKeyValueToString(map);

    }
    public String convertKeyValueToString(HashMap<String, Integer> map) {

        StringBuilder str = new StringBuilder();
        for(HashMap.Entry<String,Integer> mp: map.entrySet()) {
    		str.append(mp.getKey()+mp.getValue());
    	}

        System.out.println(str);
        return str.toString();


    }
}