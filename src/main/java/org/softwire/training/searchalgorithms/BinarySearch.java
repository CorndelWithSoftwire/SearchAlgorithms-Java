package org.softwire.training.searchalgorithms;

import java.util.NoSuchElementException;

public class BinarySearch implements SearchAlgorithm {

    @Override
    public String getName() {
        return "Binary Search";
    }

    @Override
    public void find(String[] words, String target) {
        int lowerBound = 0;
        int upperBound = words.length - 1;
        int middle = upperBound / 2;

        while (!words[middle].equals(target)) {
            if (words[middle].compareTo(target) > 0) {
                upperBound = middle - 1;
            } else {
                lowerBound = middle + 1;
            }

            if (upperBound < lowerBound) {
                throw new NoSuchElementException(target);
            }

            middle = lowerBound + (upperBound - lowerBound) / 2;
        }
    }
}
