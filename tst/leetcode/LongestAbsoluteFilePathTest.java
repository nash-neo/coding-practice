package leetcode;

import org.junit.Test;

public class LongestAbsoluteFilePathTest {

    private LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();

    @Test
    public void test() {
        String dir = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
//        String dir = "dir\n\tfile.txt";
        System.out.println(solution.lengthLongestPath(dir));
    }
}
