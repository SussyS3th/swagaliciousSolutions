import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Remy {
    public static String mostFrequentIP(ArrayList<String[]> totalRequests) {
        HashMap<String, Integer> ipCount = new HashMap<>();
        for (String[] request : totalRequests) {
            String ipAddress = request[2];
            ipCount.put(ipAddress, ipCount.getOrDefault(ipAddress, 0) + 1);
        }
        Map.Entry<String, Integer> mostFrequent = Collections.max(ipCount.entrySet(), Map.Entry.comparingByValue());
        return mostFrequent.getKey() + " (" + mostFrequent.getValue() + " requests)";
    }

    public static double errorRate(ArrayList<String[]> totalRequests) {
        int errorCount = 0;
        for (String[] request : totalRequests) {
            if (request[5].equals("404") || request[5].equals("500")) {
                errorCount++;
            }
        }
        return 100.0 * errorCount / totalRequests.size();
    }

    public static String mostFrequentURL(ArrayList<String[]> totalRequests) {
        HashMap<String, Integer> urlCount = new HashMap<>();
        for (String[] request : totalRequests) {
            String url = request[4];
            urlCount.put(url, urlCount.getOrDefault(url, 0) + 1);
        }
        Map.Entry<String, Integer> mostFrequent = Collections.max(urlCount.entrySet(), Map.Entry.comparingByValue());
        return mostFrequent.getKey() + " (" + mostFrequent.getValue() + " requests)";
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("remy.dat"));
        ArrayList<String[]> totalRequests = new ArrayList<>();
        ArrayList<String> uniqueIPA = new ArrayList<>();

        // Read input until there are no more lines
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            totalRequests.add(input);
        }

        for (String[] s : totalRequests) {
            if (s.length > 0 && s[0] != null && !s[0].isEmpty()) {
                String ipAddress = s[2];

                if (!ipAddress.isEmpty() && !uniqueIPA.contains(ipAddress)) {
                    uniqueIPA.add(ipAddress);
                }
            }
        }

        System.out.println("Total Requests: " + totalRequests.size()); // total requests
        System.out.println("Unique IP Addresses: " + uniqueIPA.size()); // unique IP addresses
        System.out.println("Most frequent IP address: " + mostFrequentIP(totalRequests)); // most frequent IP address
        System.out.println("Error rate: " + String.format("%.2f", errorRate(totalRequests)) + "%"); // error
        System.out.println("Most frequent URL: " + mostFrequentURL(totalRequests)); // most frequent URL
    }
}