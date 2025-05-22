public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("melina.dat"));
    int num = sc.nextInt();
    sc.nextLine();

    while (num-- > 0) {
        double a = sc.nextDouble(); // Amount paid
        double t = sc.nextDouble(); // Amount due
        double change = Math.round((a - t) * 100.0);
        sc.nextLine();


        int[] denominations = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(d -> (int) Math.round(Double.parseDouble(d) * 100))
                .toArray();

        int target = (int) change;
        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int coin : denominations) {
            for (int j = coin; j <= target; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[target]);


    }
}
