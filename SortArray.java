import java.util.ArrayList;

public class SortArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list); /* print out regular list */
        SortArray.shuffle(list); /* shuffle the list */
        System.out.println(list); /* print out shuffled list */
        sort(list); /* sort the shuffled list */
        System.out.println(list); /* print out sorted list */
    }
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            E Minimum = list.get(i);
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(Minimum) < 0) {
                    Minimum = list.get(j);
                    min = j;
                }
            }
            if (min != i) {
                list.set(min, list.get(i));
                list.set(i, Minimum);
            }
        }
    }
    
    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int rand = (int) (Math.random() * list.size());
            E temp = list.get(rand);
            list.set(rand, list.get(i));
            list.set(i, temp);
        }
    }
    
}