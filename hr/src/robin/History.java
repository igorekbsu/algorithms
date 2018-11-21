package robin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class History {
    static int cash = 7000000 + 3066 + 264 - 14400 - 800;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("/home/igor/src/algorithms/hr/src/robin/hist"));
        Map<String, Integer> amounts = new HashMap<>(), shares = new HashMap<>();
        TreeSet<String> companies = new TreeSet<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.endsWith("Market Buy") || s.endsWith("Limit Buy")) {
                in.nextLine();
                String price = in.nextLine();
                if (!price.equals("Canceled")) {
                    int amount = Ops.toi(price);
                    String incName = incName(s);
                    companies.add(incName);
                    update(incName, amount, amounts);
                    shares.put(incName, shares.getOrDefault(incName, 0) + shares(in.nextLine()));
                }
            } else if (s.endsWith("Market Sell") || s.endsWith("Limit Sell")) {
                in.nextLine();
                String price = in.nextLine();
                if (!price.equals("Canceled")) {
                    int amount = Ops.toi(price);
                    String incName = incName(s);
                    companies.add(incName);
                    update(incName, -amount, amounts);
                    shares.put(incName, shares.getOrDefault(incName, 0) - shares(in.nextLine()));
                }
            } else System.out.println("skipping: " + s);
        }
        int traded = 0;
        for (String incName : companies) {
            int amount = amounts.get(incName), nShares = shares.get(incName);
            traded += amount;
            System.out.println(String.format("%s %s %s", incName, nShares, Ops.money(amount)));
        }
        System.out.println(Ops.money(cash));
        System.out.println(Ops.money(traded));
    }

    static String incName(String s) {
        int i = s.lastIndexOf(" ");
        i = s.substring(0, i).lastIndexOf(" ");
        return s.substring(0, i);
    }

    static int shares(String s) {
        try {
            return Integer.parseInt(s.substring(0, s.indexOf(' ')));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    static void update(String key, int amount, Map<String, Integer> positions) {
        cash -= amount;
        positions.put(key, positions.getOrDefault(key, 0) + amount);
    }
}
