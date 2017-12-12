package leetcode;

import org.junit.*;
import org.junit.Test;

public class WordSearchIITest {

    private WordSearchII wordSearchII = new WordSearchII();

    @Test
    public void test() {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(wordSearchII.findWords(board, words));
    }
}
