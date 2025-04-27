package components;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InvertedIndex {

    private final Map<String, Set<Integer>> wordToDocIds = new ConcurrentHashMap<>();
    private final Map<Integer, Set<String>> docIdToDoc = new ConcurrentHashMap<>();

    public InvertedIndex() {}

    public void addDocument(int id, List<String> doc) {

        if (doc == null || doc.isEmpty()) {
            return;
        }

        docIdToDoc.computeIfAbsent(id, k -> new HashSet<>(doc));

        // Loop words from doc
        // Add id to {word: set<String>}
        for (String word : doc) {
            String lowerCaseWord = word.toLowerCase();
            wordToDocIds.computeIfAbsent(lowerCaseWord, k -> new HashSet<>());
            wordToDocIds.get(lowerCaseWord).add(id);
        }
    }

    public List<Integer> search(String word) {
        String lowerCaseWord = word.toLowerCase();
        if (!wordToDocIds.containsKey(lowerCaseWord)) {
            return  new ArrayList<>();
        }
        
        return new ArrayList<>(wordToDocIds.get(lowerCaseWord));
    }

    public void deleteDocument(int id) {
        // loop hashMap, remove each ids. 
        if (!docIdToDoc.containsKey(id)) {
            return;
        }

        List<String> doc = new ArrayList<>(docIdToDoc.get(id));
        docIdToDoc.remove(id);

        for (String word : doc) {
            String lowerCaseWord = word.toLowerCase();
            Set<Integer> ids =  wordToDocIds.get(lowerCaseWord);
            if (ids == null || ids.isEmpty()) {
                continue;
            }
            ids.remove(id);
            if (ids.size() == 0) {
                wordToDocIds.remove(lowerCaseWord);
            }
        }
    }

    public static void main(String[] args)
    {
        InvertedIndex index = new InvertedIndex();

        // Add documents
        index.addDocument(1, Arrays.asList("apple", "banana", "orange"));
        index.addDocument(2, Arrays.asList("apple", "grape", "pear"));
        index.addDocument(3, Arrays.asList("banana", "orange", "kiwi"));

        // Search for words
        System.out.println(index.search("apple")); // Output: [1, 2]
        System.out.println(index.search("banana")); // Output: [1, 3]

        // Delete a document
        index.deleteDocument(1);

        // Search again
        System.out.println(index.search("apple")); // Output: [2]
        System.out.println(index.search("banana")); // Output: [3]
    }
}