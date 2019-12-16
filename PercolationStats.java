public class PercolationStats {
    private int trialsCount;
    private Percolation percolation;
    private double[] proportion;
    
    public PercolationStats(int N, int T) 
    {
        if (N <= 0 || T <= 0) 
        {
            throw new IllegalArgumentException("Given N <= 0 || T <= 0");
        }
        trialsCount = T;
        proportion = new double[trialsCount];
        for (int trialNum = 0; trialNum < trialsCount; trialNum++) 
        {
            percolation = new Percolation(N);
            int openedSites = 0;
            while (!percolation.percolates()) 
            {
                int x = StdRandom.uniform(1, N + 1);
                int y = StdRandom.uniform(1, N + 1);
                if (!percolation.isOpen(x, y)) 
                {
                    percolation.open(x, y);
                    openedSites++;
                }
            }
            double proportion = (double) openedSites / (N * N);
            proportion[trialNum] = proportion;
        }
    }
    
    public double mean() 
    {
        return StdStats.mean(proportion);
    }

    public double stddev() 
    {
        return StdStats.stddev(proportion);
    }

    public double confidenceLow() 
    {
        return mean() - ((1.96 * stddev()) / Math.sqrt(trialsCount));
    }

    public double confidenceHigh() 
    {
        return mean() + ((1.96 * stddev()) / Math.sqrt(trialsCount));
    }

    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats perstats = new PercolationStats(N, T);

        String confidence = perstats.confidenceLow() + ", " + perstats.confidenceHigh();
        StdOut.println("mean                    = " + perstats.mean());
        StdOut.println("stddev                  = " + perstats.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}