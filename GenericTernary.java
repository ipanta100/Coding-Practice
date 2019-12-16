
public class GenericTernary {

    public static void main(String[] args) {
        Integer[] list = new Integer[15];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        System.out.println(TernarySearch(list, 1));
        System.out.println(TernarySearch(list, 10));
        System.out.println(TernarySearch(list, 100)); /* -1 signifies that it is not in list */
    }

    public static <E extends Comparable<E>> int TernarySearch(E[] list, E key) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
}