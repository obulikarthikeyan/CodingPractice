package leetcode;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * The idea is to use BFS.
 * We start from the given start word, traverse all words that adjacent (differ by one character) to it and keep doing so until we find the target word or we have traversed all words.
 */

public class WordLadderBFS {

    class Node {
        String word;
        int len;

        Node(String word, int len) {
            this.word = word;
            this.len = len;
        }

        public String toString() {
            return "Word = " + this.word + " len = " + len;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(new Node(beginWord, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i=0; i<wordList.size(); i++)  {
                String dictWord = wordList.get(i);
                if(isTransformable(current.word, dictWord)) {
                    wordList.remove(i);
                    current.len++;
                    current.word = dictWord;
                    queue.offer(current);
                    i--;

                    if(current.word.equals(endWord)) {
                        return current.len;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isTransformable(String word, String transformWord) {

        int count = 0;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) != transformWord.charAt(i)) {
                count++;
            }
            if(count > 1) return false;
        }
        return (count == 1);
    }

    public int minLadderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(new Node(beginWord, 1));

        int len = 1;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int n = current.word.length();

            if(current.word.equals(endWord)) {
                return current.len;
            }

            char[] cArray = current.word.toCharArray();
            for(int i=0; i<n; i++) {
                for(char c='a'; c <= 'z'; c++) {
                    char temp = cArray[i];
                    cArray[i] = c;
                    String word = new String(cArray);

                    if(wordList.contains(word)) {
                        queue.offer(new Node(word, current.len+1));
                        System.out.println("Transformed word = " + word);
                        System.out.println(current.toString());
                        wordList.remove(word);
                        len++;
                        System.out.println("Len = " + len);
                    }
                    cArray[i] = temp;
                }
            }
        }
        return 0;

//        Queue<String> queue = new LinkedList<String>();
//        queue.add(beginWord);
//        queue.add(null);
//
//        // Mark visited word
//        Set<String> visited = new HashSet<String>();
//        visited.add(beginWord);
//
//        int level = 1;
//
//        while (!queue.isEmpty()) {
//            String str = queue.poll();
//
//            if (str != null) {
//                // Modify str's each character (so word distance is 1)
//                for (int i = 0; i < str.length(); i++) {
//                    char[] chars = str.toCharArray();
//
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        chars[i] = c;
//
//                        String word = new String(chars);
//
//                        // Found the end word
//                        if (word.equals(endWord)) return level + 1;
//
//                        // Put it to the queue
//                        if (wordList.contains(word) && !visited.contains(word)) {
//                            queue.add(word);
//                            visited.add(word);
//                        }
//                    }
//                }
//            } else {
//                level++;
//
//                if (!queue.isEmpty()) {
//                    queue.add(null);
//                }
//            }
//       }
//
//        return 0;

        /*LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord, 1));

        //wordList.add(endWord);

        while(!queue.isEmpty()){
            Node top = queue.remove();
            String word = top.word;

            if(word.equals(endWord)){
                return top.len;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(wordList.contains(newWord)){
                        queue.add(new Node(newWord, top.len+1));
                        wordList.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;*/
    }

    public static void main(String ...args) {
        String startWord = "toon";
        String endWord = "plea";
        List<String> dict = new ArrayList<>();
        dict.add("poon");
        dict.add("plee");
        dict.add("same");
        dict.add("poie");
        dict.add("plie");
        dict.add("poin");
        dict.add("plea");

        System.out.println("StartWord: " + startWord);
        System.out.println("EndWord: " + endWord);
        System.out.println("Dictionary: " + dict.toString());

        System.out.println("\nOutput: " + new WordLadderBFS().ladderLength(startWord, endWord, dict));

        startWord = "hit";
        endWord = "cog";
        dict.clear();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");

        System.out.println("\nStartWord: " + startWord);
        System.out.println("EndWord: " + endWord);
        System.out.println("Dictionary: " + dict.toString());

        System.out.println("\nOutput: " + new WordLadderBFS().ladderLength(startWord, endWord, dict));
        dict.clear();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        System.out.println("\nOutput: " + new WordLadderBFS().minLadderLength(startWord, endWord, dict));

    }
}
