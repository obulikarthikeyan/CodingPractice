package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RansomeNoteInMagazine {
    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> magazineWords = new HashMap<>();
        System.out.println("Enter the words in the magazine");
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        while(tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if(magazineWords.containsKey(word)) {
                magazineWords.put(word, magazineWords.get(word)+1);
            } else {
                magazineWords.put(word, 1);
            }
        }

        Map<String, Integer> ransomNoteWords = new HashMap<>();
        System.out.println("Enter the words in the ransom note");
        tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        while(tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if(ransomNoteWords.containsKey(word)) {
                ransomNoteWords.put(word, ransomNoteWords.get(word)+1);
            } else {
                ransomNoteWords.put(word, 1);
            }
        }

        boolean canRandomNotBeDervied = ransomNoteWords.keySet().stream().allMatch(key -> magazineWords.get(key) == ransomNoteWords.get(key));
        if (canRandomNotBeDervied) {
            System.out.println("Yes, Ransom Note can be constructed using the words in the Magazine");
        } else {
            System.out.println("No, Ransom Note cannot be constructed using the words in the Magazine");
        }
    }
}
