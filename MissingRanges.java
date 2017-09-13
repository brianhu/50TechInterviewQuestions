package brian;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 8/28/17.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] values,
                                          int start, int end) {
        List<String> ranges = new ArrayList<>();
        int previousNumber = start - 1;
        for (int i = 0; i <= values.length; i++) {
            int current = values[i];
            if (i == values.length) {
                current = end + 1;
            }
            if (current - previousNumber >= 2) {
                int from = previousNumber + 1;
                int to = current - 1;
                String range = from + "->" + to;
                if (from == to) {
                    range = String.valueOf(from);
                }
                ranges.add(range);
            }
            previousNumber = current;
        }
        return ranges;
    }
}
