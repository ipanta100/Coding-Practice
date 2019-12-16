import java.lang.*;
import java.util.Comparator;
import java.util.Arrays;

public class Autocomplete {
 public Term[] queries;

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
     if (terms == null) {
      throw new java.lang.NullPointerException();
     }
     this.queries = terms;
     Arrays.sort(queries);
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
     if (prefix == null) {
      throw new java.lang.NullPointerException();
     }
     Term temporary = new Term(prefix, 0);
    
     int x = BinarySearchDeluxe.firstIndexOf(queries, temporary, Term.byPrefixOrder(prefix.length()));
     int y = BinarySearchDeluxe.lastIndexOf(queries, temporary, Term.byPrefixOrder(prefix.length()));
     
     if (x == -1 || y == -1) {
      throw new java.lang.NullPointerException();
     }
  Term[] matches = new Term[y - x + 1];
  matches = Arrays.copyOfRange(queries, x, y);
  Arrays.sort(matches, Term.byReverseWeightOrder());
  return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
     if (prefix == null) {
      throw new java.lang.NullPointerException();
     }
     Term temp = new Term(prefix, 0);
     int x = BinarySearchDeluxe.firstIndexOf(queries, temporary, Term.byPrefixOrder(prefix.length()));
     int y = BinarySearchDeluxe.lastIndexOf(queries, temporary, Term.byPrefixOrder(prefix.length()));
  return y - x + 1;
    }

    //unit testing (required)
    public static void main(String[] args) {

    String filename = args[0];
    In in = new In(filename);
    int N = in.readInt();
    Term[] terms = new Term[N];
    for (int x = 0; x < N; x++) {
        long weight = in.readLong();       
        in.readChar();                         
        String query = in.readLine();          
        terms[x] = new Term(query, weight);    
    }
    int k = Integer.parseInt(args[1]);
    Autocomplete autocomplete = new Autocomplete(terms);
    while (StdIn.hasNextLine()) {
        String prefix = StdIn.readLine();
        Term[] results = autocomplete.allMatches(prefix);
        for (int x = 0; x < Math.min(k, results.length); x++)
            StdOut.println(results[x]);
    }
  }
}