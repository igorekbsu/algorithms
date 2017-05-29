import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = in.next(), email = in.next();
            if (email.endsWith("@gmail.com")) names.add(name);
        }
        for (String name : names.stream().sorted().collect(Collectors.toList()))
            System.out.println(name);
    }
}
