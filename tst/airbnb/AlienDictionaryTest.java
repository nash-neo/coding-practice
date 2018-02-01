package airbnb;

import org.junit.Test;

public class AlienDictionaryTest {

    AlienDictionary alienDictionary = new AlienDictionary();

    @Test
    public void test0() {
        String[] dict = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienDictionary.alienOrder(dict));
    }

    @Test
    public void test1() {
        String[] dict = {"w","w"};
        System.out.println(alienDictionary.alienOrder(dict));
    }
}
