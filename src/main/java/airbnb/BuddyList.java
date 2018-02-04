package airbnb;

import java.util.*;

public class BuddyList {

    //we could compare the similarity score first which takes O(n), rather than compare on the fly, which takes O(nlogn)
    //Then sorted according to the similarity score in descending order
    //exclude any buddy which has an empty list, or treat 0 as Int.MAX
    /**
     * Similarity measure is defined as |same items| / |friend total items|
     * Assume if two friends have the same number of wish items as you, sorted by differences
     * my wish list = (a,b,c)
     * friend1 = (a, b, d)
     * friend2 = (a, c, e, f)
     * then friend1 is before friend2
     *
     * @param myWishList my own wish list
     * @param buddyWishLists my friend wish lists key is the name of friends, value is the item
     * @return a sorted list of friends' name in the similarity order
     */
    public List<String> sortBySimilarity(List<String> myWishList, Map<String, List<String>> buddyWishLists) {
        //convert my list to hashset for O(1) membership test
        Set<String> myWishedItems = new HashSet<>(myWishList);
        //computer similarity score
        Map<String, Double> scores = new HashMap<>();
        for (String buddy : buddyWishLists.keySet()) {
            List<String> buddyList = buddyWishLists.get(buddy);
            int sameItems = 0;
            for (String item : buddyList) {
                if (myWishedItems.contains(item)) {
                    ++sameItems;
                }
            }
            int totalItems = buddyList.isEmpty() ? Integer.MAX_VALUE : buddyList.size();
            double score = 1.0 * sameItems / totalItems;
            scores.put(buddy, score);
        }
        //sort the answer list using similarity score
        List<String> ans = new ArrayList<>(scores.keySet());
        ans.sort((a,b) -> -Double.compare(scores.get(a), scores.get(b))); //sorted desc
        return ans;
    }

    //assume upperbound > 0
    public List<String> getRecommendations(List<String> myWishList, Map<String, List<String>> buddyWishLists, int upperbound) {
        List<String> sortedBySimilarity = sortBySimilarity(myWishList, buddyWishLists);
        Set<String> myWishListSet = new HashSet<>(myWishList);
        List<String> ans = new ArrayList<>();
        for (String buddy : sortedBySimilarity) {
            List<String> buddyList = buddyWishLists.get(buddy);
            for (String item : buddyList) {
                if (!myWishListSet.contains(item)) {
                    ans.add(item);
                }
                if (ans.size() >= upperbound) {
                    break;
                }
            }
        }
        return ans;
    }
}
