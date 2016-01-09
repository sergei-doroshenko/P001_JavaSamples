package _06_GenericsAndCollections;

import java.util.HashMap;
import java.util.Map;
//This program shows the usage of HashMap class
public class _6_18_SpellChecker {
      public static void main(String []args) {
            Map<String, String> misspeltWords = new HashMap<>();
            misspeltWords.put("calender", "calendar");
            misspeltWords.put("tomatos", "tomatoes");
            misspeltWords.put("existance", "existence");
            misspeltWords.put("aquaintance", "acquaintance");
            String sentence = "Buy a calender for the year 2013";
            System.out.println("The given sentence is: " + sentence);
            for(String word : sentence.split("\\W+")) {
                  if(misspeltWords.containsKey(word)) {
                        System.out.println("The correct spelling for " + word
                                    + " is: " + misspeltWords.get(word));
                  }
            }
      }
}
