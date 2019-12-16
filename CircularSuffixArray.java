import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CircularSuffixArray {
    private static final int R = 256;
    private static final int M = 30;
    private final int N;
    private int[] indices;
    private OffsetString[] aux;

    public CircularSuffixArray(String s) {
        if (s == null) throw new NullPointerException();

        N = s.length();
        indices = new int[N];
        Set<Character> alphabet = new HashSet<>();

        OffsetString[] suffix = new OffsetString[N];
        for (int offset = 0; offset < N; offset++) {
            suffix[offset] = new OffsetString(s, offset);
            alphabet.add(s.charAt(offset));
        }

        if (alphabet.size() > 7)
            msdSort(suffix);
        else if (alphabet.size() > 1)
            Quick3way.sort(suffix);

        for (int i = 0; i < N; i++)
            indices[i] = suffix[i].getOffset();
    }

    public int length() {
        return N;
    }

    public int index(int i) {
        if (i < 0 || i >= N) throw new IndexOutOfBoundsException();
        return indices[i];
    }

    public static void main(String[] args) {
        CircularSuffixArray c = new CircularSuffixArray("ABRACADABRA!");
        for (int i = 0; i < 12; i++)
            System.out.println(c.index(i));
    }
}