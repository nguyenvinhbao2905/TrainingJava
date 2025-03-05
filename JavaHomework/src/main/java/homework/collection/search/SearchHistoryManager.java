package homework.collection.search;

import java.util.LinkedList;

public class SearchHistoryManager {
    private static final int MAX_HISTORY_SIZE = 10;
    private LinkedList<String> searchHistory;

    public SearchHistoryManager() {
        searchHistory = new LinkedList<>();
    }

    public void addSearch(String query) {
        if (searchHistory.size() >= MAX_HISTORY_SIZE) {
            searchHistory.removeFirst();
        }
        searchHistory.addFirst(query);
    }

    public void printHistory() {
        System.out.println("History: ");
        for (String s : searchHistory) {
            System.out.println(" - " + s);
        }
    }

    public LinkedList<String> getSearchHistory() {
        return new LinkedList<>(searchHistory);
    }
}
