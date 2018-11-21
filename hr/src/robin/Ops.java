package robin;
class Ops {
    static int toi(String price) {
        if(Character.isLetter(price.charAt(0)))
            return 0;
        String s = price.replace("$", "").replace(",", "").replace(".", "");
        return Integer.parseInt(s);
    }

    static String money(int amount) {
        String s = String.valueOf(amount);
        int dotIdx = s.length() - 2;
        return s.substring(0, dotIdx) + "." + s.substring(dotIdx);
    }
}
