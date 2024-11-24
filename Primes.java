public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] primes = new boolean[n + 1];
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        int currIndex = 2;
        while (currIndex < Math.sqrt(n)) {
            for (int i = currIndex + 1; i < n + 1; i++) {
                if (i % currIndex == 0) {
                    primes[i] = false;
                }
            }
            for (int i = currIndex + 1; i < n + 1; i++) {
                if (primes[i] == true || i >= Math.sqrt(n)) {
                    currIndex = i;
                    i = n;
                }
            }
        }
        System.out.println("Prime numbers up to " + n + ":");
        int count = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                count++;
                System.out.println(i);
            }
        }
        System.out.printf("There are %d primes between 2 and %d (%d%% are primes)",
                count, n, 100 * count / n);
    }
}