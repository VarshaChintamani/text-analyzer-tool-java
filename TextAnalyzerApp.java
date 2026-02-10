import java.util.*;

public class TextAnalyzerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a text:");
        String text = sc.nextLine();

        int charCount = countCharacters(text);
        int wordCount = countWords(text);
        int vowelCount = countVowels(text);
        int consonantCount = countConsonants(text);

        Map<String, Integer> wordFrequency = getWordFrequency(text);
        String mostFrequentWord = getMostFrequentWord(wordFrequency);
        String uniqueWordsText = removeDuplicateWords(text);
        String reversedText = reverseText(text);

        System.out.println("\n---------------- TEXT ANALYSIS ----------------");
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Words                 : " + wordCount);
        System.out.println("Vowels                : " + vowelCount);
        System.out.println("Consonants            : " + consonantCount);
        System.out.println("Most Frequent Word    : " + mostFrequentWord);

        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nText without duplicates:");
        System.out.println(uniqueWordsText);

        System.out.println("\nReversed Text:");
        System.out.println(reversedText);

        System.out.println("\nUppercase Text:");
        System.out.println(text.toUpperCase());

        System.out.println("\nLowercase Text:");
        System.out.println(text.toLowerCase());

        System.out.println("----------------------------------------------");

        sc.close();
    }

    // Count characters excluding spaces
    static int countCharacters(String text) {
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                count++;
            }
        }
        return count;
    }

    // Count words
    static int countWords(String text) {
        if (text.trim().isEmpty()) return 0;
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Count vowels
    static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (char ch : text.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    // Count consonants
    static int countConsonants(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch) && "aeiou".indexOf(ch) == -1) {
                count++;
            }
        }
        return count;
    }

    // Word frequency using HashMap
    static Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    // Most frequent word
    static String getMostFrequentWord(Map<String, Integer> frequencyMap) {
        String mostFrequent = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }

    // Remove duplicate words using HashSet
    static String removeDuplicateWords(String text) {
        String[] words = text.split("\\s+");
        Set<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));
        return String.join(" ", uniqueWords);
    }

    // Reverse text
    static String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
