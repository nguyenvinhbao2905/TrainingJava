package homework.collection.product;

import java.util.*;

public class CategoryManager {
    private Map<String, Set<String>> subcategories;

    public CategoryManager() {
        subcategories = new HashMap<String, Set<String>>();
    }
    public void addSubcategory(String parent, String child) {
        subcategories.computeIfAbsent(parent, k -> new HashSet<>()).add(child);
    }

    public Set<String> getSubcategories(String parent) {
        return subcategories.getOrDefault(parent, Collections.emptySet());
    }
    public void printCategories() {
        subcategories.forEach((parent, subcategories) -> {
            System.out.println(parent + " -> " + subcategories);
        });
    }
}
