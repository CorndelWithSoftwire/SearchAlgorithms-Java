package org.softwire.training.searchalgorithms;

import java.util.Arrays;
import java.util.NoSuchElementException;

class JavaApiBinarySearch implements SearchAlgorithm {
    @Override
    public String getName() {
        return "Binary Search (Java API)";
    }

    @Override
    public void find(String[] words, String target) {
        int index = Arrays.binarySearch(words, target);
        if (index == -1) {
            throw new NoSuchElementException(target);
        }
    }
}
