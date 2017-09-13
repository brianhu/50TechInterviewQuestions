package brian;

/**
 * Created by brian on 8/31/17.
 */
public class ReadNCharacters2 {
    private char[] tempBuff = new char[4];
    private int tempBuffCount = 0;
    private int tempBuffPointer = 0;
    public int read(char[] buf, int n) {
        int total = 0;
        while (n > total) {
            if (tempBuffPointer == 0) {
                tempBuffCount = read4(tempBuff);
            }
            if (tempBuffCount == 0) break;
            while (n > total && tempBuffPointer < tempBuffCount) {
                buf[total++] = tempBuff[tempBuffPointer++];
            }
            if (tempBuffPointer >= tempBuffCount) {
                tempBuffPointer = 0;
            }
        }
        return total;
    }

    private int read4(char[] buf) {
        // read 4 characters from a file and write them into buf
        return 4;
    }
}
