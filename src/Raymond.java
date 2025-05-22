public static int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

public static int lcm(int a, int b) {
    return Math.abs((a * b)) / gcd(a, b);
}

public static int lcmOfArray(int[] arr) {
    if (arr.length == 0) {
        return 1;
    }
    int result = arr[0];
    for (int i = 1; i < arr.length; i++) {
        result = lcm(arr[i], result);
    }
    return result;
}

public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("raymond.dat"));
    int num = sc.nextInt();
    for (int i = 0; i < num; i++) {
        int len = sc.nextInt();
        int[] numbers = new int[len];
        for (int j = 0; j < len; j++) {
            numbers[j] = sc.nextInt();
        }
        int result = lcmOfArray(numbers);
        if (result == 1) System.out.println("LMC NUMBER 1!");
        else System.out.println("Lowest Common Multiple is  " + result);

    }


}