public class Fibo2 {


    public static long fibo(int n) {
        long[] lut = new long[n+1];
        for(int i=0; i<=n; i++) lut[i] = -1;
        return fiboRec(n, lut);
    }

    public static long fiboRec(int n, long[] lut) {
        if(lut[n] != -1) return lut[n]; // já temos, não recalcula
        if(n==0) return 0;
        if(n==1) return 1;
        else {
            long fib = fiboRec(n-1,lut) + fiboRec(n-2,lut);
            lut[n] = fib;
            return fib;
        }
    }

    public static void main(String[] args) {

        for(int i=1; i<=50; i++)
            System.out.println(i+": "+fibo(i));
    }
}

