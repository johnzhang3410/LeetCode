import java.util.HashMap;
import java.util.Map;

public class TwoSumHash {
    // returns indices of elements which add up to target, assume only one solution
    public int[] TwoSum(int[] numbers, int target) {
        // One solution is to do a nested for loop, and check each possible combination
        // if they add up to target; but that is O(n^2) operation.

        // key is number, value is their index
        // find keys that add up to target, and return their values
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            // if difference is in hash table, it means we found 2 numbers that add up to
            // target; we simply return their indices
            int difference = target - numbers[i];

            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                break;
            }
            // hash table has no matching key that would add up to target, add current
            // element (key) to the hash table so it acts as 'difference' in future
            // iterations. I can also do an iteration to add all array numbers and their
            // index to the hash table first, but that is slower and we need to add the
            // condition && map.get(difference) != i because we may not use the same element
            // twice (must be two different numbers adding up to target).
            // Avoids case like [3, 2, 4] target 6 which would return [0, 0] if we allow
            // same index to be used (3+3=6 but we want 2+4=6 and index of 2 and 4).
            map.put(numbers[i], i);
        }
        return result;
    }
}
