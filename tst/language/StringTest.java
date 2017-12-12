package language;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    @Test
    public void testSplit() {
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        String s = strs.toString();
        System.out.println(s);
        String[] strArr = s.substring(1, s.length()-1).split(",");
        List<String> strsResult = new ArrayList<>();
        for (String str : strArr) {
            strsResult.add(str.substring(1, str.length()-1));
        }
    }
}
