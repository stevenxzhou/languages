package algorithms;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InvertedIndex {

    private final Map<Integer, Set<String>> docId2Doc = new ConcurrentHashMap<>();
    private final Map<String, Set<Integer>> word2DocId = new ConcurrentHashMap<>();

    public InvertedIndex() {}

    public void addDocument(int id, List<String> doc) {
        if (doc == null || doc.size() == 0) {
            return;
        }

        docId2Doc.computeIfAbsent(id, k -> new HashSet<String>()).addAll(doc.stream().map(word -> word.toLowerCase()).collect(Collectors.toList()));

        for (String word : doc) {
            word2DocId.computeIfAbsent(word.toLowerCase(), k -> new HashSet<Integer>()).add(id);
        }
    };

    public List<Integer> search(String word) {
        String lowerWord = word.toLowerCase();
        if (!word2DocId.containsKey(lowerWord)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(word2DocId.get(lowerWord));
    }

    public void deleteDocument(int id) {
        if (!docId2Doc.containsKey(id)) {
            return;
        }

        Set<String> doc = docId2Doc.get(id);
        docId2Doc.remove(id);

        for (String word : doc) {
            if (!word2DocId.containsKey(word)) {
                continue;
            }
            word2DocId.get(word).remove(id);

            if (word2DocId.get(word).isEmpty()) {
                word2DocId.remove(word);
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