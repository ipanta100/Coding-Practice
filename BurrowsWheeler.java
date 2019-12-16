import java.util.Arrays;

public class BurrowsWheeler {
    private static final int R = 256;

    public static void transform() {
        String s = BinaryStdIn.readString();
        CircularSuffixArray circular = new CircularSuffixArray(s);

        int len = s.length();
        for (int i = 0; i < len; i++)
            if (circular.index(i) == 0)
                BinaryStdOut.write(i);
        for (int i = 0; i < len; i++)
            BinaryStdOut.write(s.charAt((circular.index(i) + len - 1) % len), 8);

        BinaryStdOut.close();
    }

    public static void inversetransforn() {
        int first = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();

        int len = s.length();
        char[] t = s.toCharArray();
        char[] sorted = new char[len];

        int[] count = new int[R + 1];
        for (int i = 0; i < len; i++)
            count[t[i] + 1]++;
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];
        for (int i = 0; i < len; i++)
            sorted[count[t[i]]++] = t[i];

        count = new int[R + 1];
        for (int i = 0; i < len; i++)
            count[sorted[i] + 1]++;
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];

        int[] next = new int[len];
        for (int j = 0; j < len; j++) {
            int i = count[t[j]]++;
            next[i] = j;
        }

        for (int i = 0, j = first; i < len; i++) {
            BinaryStdOut.write(sorted[j]);
            j = next[j];
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if (args.length == 0) return;
        if ("-".equals(args[0]))
            encode();
        else if ("+".equals(args[0]))
            decode();
    }
}