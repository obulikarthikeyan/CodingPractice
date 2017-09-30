package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 *
 * Note: All inputs will be in lower-case.
 */

public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(List<String> anagrams) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String a : anagrams) {
            char[] c = new char[256];
            for(int i=0; i<a.length(); i++) {
                c[a.charAt(i)]++;
            }

            String s = new String(c);

            if(map.containsKey(s)) {
                map.get(s).add(a);
            } else {
                List<String> list = new ArrayList<>();
                list.add(a);
                map.put(s, list);
            }
        }

        result.addAll(map.values());
        return result;
    }

    static class Word {
        String word;
        int index;

        public Word(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public static List<List<String>> groupAnagramsUsingPriorityQueues(List<String> anagrams) {
        PriorityQueue<Word> words = new PriorityQueue<>((a, b) -> a.word.compareTo(b.word));

        for (int i=0; i<anagrams.size(); i++) {
            words.add(new Word(Stream.of(anagrams.get(i).split("")).sorted().collect(Collectors.joining()), i));
        }

        List<List<String>> result = new ArrayList<>();
        Word w = words.poll();
        List<String> tmp = new ArrayList<>();
        tmp.add(anagrams.get(w.index));
        result.add(tmp);
        while (!words.isEmpty()) {
            if(w.word.equals(words.peek().word)) {
                w = words.poll();
                int size = result.size();
                tmp = result.get(size-1);
                tmp.add(anagrams.get(w.index));
            } else {
                w = words.poll();
                tmp = new ArrayList<>();
                tmp.add(anagrams.get(w.index));
                result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String ...args) {
        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input:\n\n" + Arrays.toString(anagrams));
        List<List<String>> result = groupAnagrams(Arrays.asList(anagrams));
        System.out.println("\nOutput:\n");
        for(List<String> group : result) {
            System.out.println(group.stream().collect(Collectors.joining(", ")));
        }
        System.out.println("\nOutput 2:\n");
        result = groupAnagramsUsingPriorityQueues(Arrays.asList(anagrams));
        for(List<String> group : result) {
            System.out.println(group.stream().collect(Collectors.joining(", ")));
        }
    }
}
