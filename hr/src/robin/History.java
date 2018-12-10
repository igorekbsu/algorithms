package robin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import static robin.Ops.Order;
import static robin.Ops.money;
import static robin.Ops.toi;

public class History {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> aliases = Map.of("SIRI", "Sirius XM");
        Scanner in = new Scanner(new FileInputStream("/home/igor/src/algorithms/hr/src/robin/hist"));
        Map<String, Integer> amounts = new HashMap<>(), shares = new HashMap<>();
        TreeSet<String> companies = new TreeSet<>();
        int cash = 0;
        while (in.hasNext()) {
            String s = in.nextLine();
            try {
                Order order;
                int amount, nShares;
                if (s.startsWith("Dividend") || s.startsWith("Deposit")) {
                    in.nextLine();//date
                    cash += toi(in.nextLine());
                } else {
                    order = Ops.parse(s);
                    in.nextLine();//date
                    String price = in.nextLine();
                    if (!price.equals("Canceled")) {
                        amount = Ops.toi(price);
                        Integer sign = null;
                        if (order.side.equals("Robinhood")) {
                            String name = aliases.getOrDefault(order.name, order.name);
                            shares.put(name, shares.getOrDefault(name, 0) + 1);
                        } else {
                            nShares = Integer.parseInt(in.nextLine().split(" ", 2)[0].replace(",", ""));
                            if (order.side.equals("Sell"))
                                sign = -1;
                            else if (order.side.equals("Buy"))
                                sign = 1;
                            if (sign != null) {
                                amounts.put(order.name, amounts.getOrDefault(order.name, 0) + sign * amount);
                                shares.put(order.name, shares.getOrDefault(order.name, 0) + sign * nShares);
                                companies.add(order.name);
                                cash += -sign * amount;
                            } else System.out.println("Skip:" + s);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Failed for:" + s);
                throw e;
            }
        }
        int traded = 0, gains = 0;
        for (String incName : companies) {
            int amount = amounts.get(incName), nShares = shares.get(incName);
            traded += amount;
            System.out.println(String.format("%s %s %s", incName, nShares, amount));
            if(nShares == 0)
                gains+=-amount;
        }
        System.out.println(money(cash));
        System.out.println(money(traded));
        System.out.println(money(gains));
    }
}
