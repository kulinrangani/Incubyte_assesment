public class StringCalculator {

    public int add(String String_value) {
        int sum = 0;
        String_value = String_value.replaceAll(" ", "");
        if (String_value.equals("")) {
            return 0;
        }
        while (String_value.length() >= 1) {
            String arr[] = String_value.split("[,\n]");
            for (String n : arr) {
                int current = Integer.parseInt(n);
                if (current > 1000) {
                    continue;
                }
                sum += current;
            }
            return sum;
        }
        return 1;
    }
}
