public class albertious_Prime {
    public static void printYear() {
        String[] digit2 = {
                " ___  ",
                "|__ \\ ",
                "   ) |",
                "  / / ",
                " / /_ ",
                "|____|"
        };

        String[] digit0 = {
                "  ___  ",
                " / _ \\ ",
                "| | | |",
                "| | | |",
                "| |_| |",
                " \\___/ "
        };

        String[] digit5 = {
                " _____ ",
                "| ____|",
                "| |__  ",
                "|___ \\ ",
                " ___) |",
                "|____/ "
        };

        for (int i = 0; i < 6; i++) {
            System.out.println(digit2[i] + digit0[i] + digit2[i] + digit5[i]);
        }
    }

    public static void main(String[] args) {
        printYear();
    }
}