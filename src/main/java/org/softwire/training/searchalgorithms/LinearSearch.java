package org.softwire.training.searchalgorithms;

import java.util.NoSuchElementException;

public class LinearSearch implements SearchAlgorithm {

    @Override
    public String getName() {
        return "Linear Search";
    }

    @Override
    public void find(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return;
            }
        }
        throw new NoSuchElementException(target);
    }
}
