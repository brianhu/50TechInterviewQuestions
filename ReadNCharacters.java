package brian;

/**
 * Created by brian on 8/30/17.
 */
public class ReadNCharacters {
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] tempBuf = new char[4];
        // file = 12345678, n = 7
        while (!eof && total < n) {
            int count = read4(tempBuf);

            eof = count < 4;
            count = Math.min(count, n - total);
            for (int i = 0; i < count; i++) {
                buf[total++] = tempBuf[i];
            }
        }
        return total;
    }

    private int read4(char[] buf) {
        // read 4 characters from a file and write them into buf
        return 4;
    }
}
