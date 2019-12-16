import java.util.LinkedList;

public class MoveToFront {
    private static int lgR = 8;

    public static void encode() {
        LinkedList<Integer> alphabet = new LinkedList<>();
        for (int i = 0; i < 256; i++)
            alphabet.add(i);

        while (!BinaryStdIn.isEmpty()) {
            int c = BinaryStdIn.readChar();
            int index = alphabet.indexOf(c);
            BinaryStdOut.write(index, lgR);

            alphabet.remove(index);
            alphabet.add(0, c);
        }
        BinaryStdOut.close();
    }

    public static void decode() {
        LinkedList<Integer> alphabet = new LinkedList<>();
        for (int i = 0; i < 256; i++)
            alphabet.add(i);

        while (!BinaryStdIn.isEmpty()) {
            int index = BinaryStdIn.readChar();
            int c = alphabet.get(index);
            BinaryStdOut.write(c, lgR);

            alphabet.remove(index);
            alphabet.add(0, c);
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