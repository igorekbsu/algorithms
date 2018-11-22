package robin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Port {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("/home/igor/src/algorithms/hr/src/robin/port"));
        while (in.hasNext()) {
            String name = in.nextLine(), symbol = in.nextLine(), shares = in.nextLine();
            String price = in.nextLine().replace("$", "");
            String avgCost = in.nextLine().replace("$", "");
            String totalReturn = in.nextLine().replace("$", "");
            String equity = in.nextLine().replace("$", "");
            System.out.println(equity);
        }
    }
}
