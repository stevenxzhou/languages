package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class recomendFriends {
    public static int bestRecommendation(Map<Integer, List<Integer>> connections, int person) {
        List<Integer> directFriends = connections.getOrDefault(person, new ArrayList<>());
        Set<Integer> directFriendSet = new HashSet<>(directFriends);

        int maxUnionFriendCount = -1;
        int bestCandidate = -1;

        for (int friend : directFriends) {
            List<Integer> friendsOfFriend = connections.getOrDefault(friend, new ArrayList<>());

            for (int candidate : friendsOfFriend) {
                if (candidate == person || directFriendSet.contains(candidate)) {
                    continue;
                }

                List<Integer> candidateFriends = connections.getOrDefault(candidate, new ArrayList<>());
                Set<Integer> candidateFriendSet = new HashSet<>(candidateFriends);

                int mutualFriendCount = 0;
                for (int mutual : directFriends) {
                    if (candidateFriendSet.contains(mutual)) {
                        mutualFriendCount++;
                    }
                }

                if (mutualFriendCount > maxUnionFriendCount ||
                    (mutualFriendCount == maxUnionFriendCount && candidate < bestCandidate)) {
                    maxUnionFriendCount = mutualFriendCount;
                    bestCandidate = candidate;
                }
            }
        }

        return bestCandidate;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> connections = new HashMap<>();
        connections.put(0, Arrays.asList(1, 2));
        connections.put(1, Arrays.asList(0));
        connections.put(2, Arrays.asList(0));

        int recommended = bestRecommendation(connections, 0);
        System.out.println(recommended);
    }
}
