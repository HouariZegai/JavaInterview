package TwoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumDemo {
    public static void main(String[] args) {
        int[] table = {1, 2, 10, 15, 7, 3, 20, 100, 25, 96, 4, 5, 6, 8, 9, 11};
        int target = 13;
        int[] result = findTwoSumMap(table, target);
        if (result != null)
            System.out.println(target + " = " + table[result[0]] + " + " + table[result[1]]);

    }

    // solution #1: using brute force (complexity: O(n²))
    public static int[] findTwoSumBruteForce(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    continue;
                if (array[i] + array[j] == n) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // solution #2: using map data structure (complexity: O(n))
    public static int[] findTwoSumMap(int[] array, int target) {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int neededNum = target - array[i];
            if(visitedNumbers.containsKey(neededNum)) {
                return new int[]{i, visitedNumbers.get(neededNum)};
            }
            visitedNumbers.put(array[i], i);
        }
        return null;
    }

    // solution #3: using set data structure (complexity: O(n))
    public static int[] findTwoSumSet(int[] array, int n) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            numbers.add(array[i]);
        }

        int firstIndice = -1, target = -1;
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {
            target = n - array[i];

            if (target == array[i] || target < 0)
                continue;

            if (numbers.contains(target)) {
                isFound = true;
                firstIndice = i;
                break;
            }
        }

        if (isFound) {
            for (int i = 0; i < array.length; i++) {
                if (target == array[i])
                    return new int[]{firstIndice, i};
            }
        }

        return null;
    }

}
