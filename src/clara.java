public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("clarabelle.dat"));
    int n = sc.nextInt();
    sc.nextLine();

    while (n-- > 0) {
        String word = sc.nextLine();
        TreeSet<String> palindromes = new TreeSet<>();

        for (int i = 0; i < word.length() - 3; i++) {
            String sub = word.substring(i, i + 3);
            if (isPalindrome(sub)) {
                palindromes.add(sub);
            }
        }
        if (palindromes.isEmpty()) System.out.println("NONE");
         else System.out.println(String.join(" ", palindromes));

    }
}
//klop
private static boolean isPalindrome(String s) {
    return s.charAt(0) == s.charAt(2);
}
