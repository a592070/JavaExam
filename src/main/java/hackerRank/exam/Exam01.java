package hackerRank.exam;

import java.util.*;
import java.util.stream.Collectors;

public class Exam01 {
    public static int howMany(String sentence) {
        // Write your code here

        sentence = sentence.trim().replaceAll("[,.?![\\p{Space}]+]+", ",");
        System.out.println(sentence);
        String[] rs = sentence.split(",");
        System.out.println(Arrays.toString(rs));
        System.out.println(rs.length);
        int n = 0;
        for (int i = 0; i < rs.length; i++) {
            String trim = rs[i].trim();

            if(rs[i].matches("[a-zA-Z-]*?")) {
                n++;
            }
        }

        return n;
    }
    public static List<Integer> itemsSort(List<Integer> items) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            if(map.containsKey(items.get(i))){
                int n = map.get(items.get(i));
                map.put(items.get(i), n+1);
            }else{
                map.put(items.get(i), 1);
            }
        }
        map.forEach((k, v) -> {
            if(map2.containsKey(v)){
                map2.get(v).add(k);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(k);
                map2.put(v, set);
            }
        });

        List<Integer> lis = new ArrayList<>();


//        items.sort((a,b) -> a-b);
//        System.out.println(items);
        System.out.println(map);
        System.out.println(map2);


        map2.forEach((k,v) -> {
            List<Integer> collect = v.stream().sorted().collect(Collectors.toList());
            collect.forEach(ele -> {
                for (int i = 0; i < k; i++) {
                    lis.add(ele);
                }
            });
        });

        return lis;
    }

    public static void main(String[] args) {
//        System.out.println(howMany("jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj."));
//        System.out.println(howMany(" )}OJR 92ww. z )UPl 49e ]S  g. zrZEnQ  D. FoKp ]ow 1EceB 3oK }w ]CA? L 3LPbDN! trqJY 0sBmm. Nwn"));
//        System.out.println(howMany("he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?"));

        List<Integer> lis = Arrays.asList(new Integer[]{1000,101,5,3,101,1,2,101,2,4});
        System.out.println(itemsSort(lis));
    }
}
