package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        return new ArrayList(Stream.of(strings).collect(Collectors.groupingBy(
                s -> s.chars().mapToObj(c -> (c - s.charAt(0) + 26) % 26)
                        .collect(Collectors.toList())
        )).values());
    }
}
