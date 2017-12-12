package leetcode;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] length = new int[n]; //length of each word
        int[] nextIndex = new int[n]; //the beginning index of next line
        int[] count = new int[n]; //the number of sentence completed in the current line
        int counter = 0;
        for (int i = 0; i < n; ++i) {
            length[i] = sentence[i].length();
        }
        for (int i = 0; i < n; ++i) {
            int col = cols; //remaining cols in the current line
            int j = i;
            int end = 0;
            while (col - length[j] >= 0) { //word[j] could be fi
                col -= length[j];
                if (col > 0) {
                    --col;
                }
                ++j;
                if (j == n) { //reached end of sentence
                    ++end;
                    j = 0;
                }
            }
            nextIndex[i] = j;
            count[i] = end;
        }
        for (int row = 0, i = 0; row < rows; ++row) {
            counter += count[i];
            i = nextIndex[i];
        }
        return counter;
    }
}