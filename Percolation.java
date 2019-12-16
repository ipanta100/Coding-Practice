import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    public boolean[][] grid;
    private int NumberOfSites;
    public QuickUnionUF qunion;
    private ArrayList<Point> point;
   
    
    public Percolation(int N)
    {
        grid = new boolean[N][N];
        numberOfSites = N;
        qunion = new QuickUnionUF(N * N);
        point = new ArrayList<Point>();
        
        for (int x = 0; x < N; x++) 
        {
            for (int y = 0; y < N; y++) 
            {
                Point p = new Point(x + 1, y + 1);
                grid[x][y] = false;
                point.add(p);
            }
        }
    }
    public void open (int x, int y)
    {
           grid[x - 1][y - 1] = true;
           if (x - 2 >= 0 && isOpen(x - 1, y)) 
           {
               qunion.union((y - 1) * numberOfSites + x - 1, (y - 1) * numberOfSites + x - 2);
           }
           if (x < numberOfSites && isOpen(x + 1, y))
           {
                       qunion.union((y - 1) * numberOfSites + x - 1, (y - 1) * numberOfSites + x);
           }
           if (y - 2 >= 0 && isOpen(x, y - 1))
           {
               qunion.union((y - 2) * numberOfSites + x - 1, (y - 1) * numberOfSites + x - 1); 
           }
           if (y < numberOfSites && isOpen(x, y + 1))
           {
                   qunion.union((y - 1) * numberOfSites + x - 1, y * numberOfSites + x - 1);
           }
    }
    
    public boolean isOpen(int x, int y)
    {
        return grid[x - 1][y - 1];
    }
    
    public boolean isFull(int x, int y)
    {
        return grid[x - 1][y - 1] == false;
    }
    public int numberOfOpenSites()
    {
        return numberOfSites;
    }
    
    public boolean percolates() 
    {
        for (int x = (numberOfSites * (numberOfSites - 1)); x < (numberOfSites * numberOfSites); x++) 
        {
            for (int x2 = 0; x2 < numberOfSites; x2++) 
            {
                if (qunion.connected(x, x2)) return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) 
    {
        int N = 10;
        Percolation p = new Percolation(N);
        for (int y = 0; y <= N - 1; y++) 
        {
            for (int x = 0; x <= N - 1; x++) 
            {
                 System.out.print(p.grid[x][y]);
                 System.out.print("\t");
            }
        }
    }
}