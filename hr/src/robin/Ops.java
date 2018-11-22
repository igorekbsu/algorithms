package robin;
class Ops {
    static int toi(String price) {
        if (Character.isLetter(price.charAt(0)))
            return 0;
        String s = price.replace("$", "").replace(",", "").replace(".", "");
        return Integer.parseInt(s);
    }

    static String money(int amount) {
        String s = String.valueOf(amount);
        int dotIdx = s.length() - 2;
        return s.substring(0, dotIdx) + "." + s.substring(dotIdx);
    }

    static Order parse(String s) {
        int i = s.lastIndexOf(' ');
        String first = s.substring(0, i), side = s.substring(i + 1);
        i = first.lastIndexOf(' ');
        return new Order(s.substring(0, i), first.substring(i + 1), side);
    }

    static class Order {
        String name, type, side;

        Order(String name, String type, String side) {
            this.name = name;
            this.type = type;
            this.side = side;
        }
    }
}
