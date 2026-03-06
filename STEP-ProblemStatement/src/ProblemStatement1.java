```java
import java.util.*;

public class ProblemStatement1 {

    static HashMap<String,Integer> freq = new HashMap<>();

    public static void main(String[] args) {

        addQuery("java tutorial");
        addQuery("javascript");
        addQuery("java download");
        addQuery("java tutorial");
        addQuery("java 21 features");

        search("jav");

        updateFrequency("java 21 features");
        updateFrequency("java 21 features");
    }

    static void addQuery(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    static void updateFrequency(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
        System.out.println(q+" -> Frequency: "+freq.get(q));
    }

    static void search(String prefix){

        List<Map.Entry<String,Integer>> list = new ArrayList<>();

        for(String q:freq.keySet()){
            if(q.startsWith(prefix)){
                list.add(new AbstractMap.SimpleEntry<>(q,freq.get(q)));
            }
        }

        list.sort((a,b)->b.getValue()-a.getValue());

        int count=0;

        for(Map.Entry<String,Integer> e:list){
            count++;
            System.out.println(count+". "+e.getKey()+" ("+e.getValue()+" searches)");
            if(count==10) break;
        }
    }
}