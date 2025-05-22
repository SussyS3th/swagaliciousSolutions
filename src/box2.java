public class box2 {
    public static void main(String args[]) {
        int count = 20;
        for (int counter = 1; counter <= 20; counter++) {
            String ans = "";
            ans += "##" + counter + "##---##";
            ans += (21 - counter) + "##---##";
            ans += counter + "##\n";
            System.out.print(ans);
        }
    }
}