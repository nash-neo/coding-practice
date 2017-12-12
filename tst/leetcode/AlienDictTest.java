package leetcode;

import org.junit.Test;

public class AlienDictTest {

    private AlienDict alienDict = new AlienDict();

    @Test
    public void test() {
        System.out.println(alienDict.alienOrder(new String[]{"za","zb","ca","cb"}));
    }
}
