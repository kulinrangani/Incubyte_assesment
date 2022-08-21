public class StringCalculator {

    public int add(String String_value) {
        int sum = 0;
        if (String_value.equals("")) {
            return 0;
        }
        while (String_value.length() >= 1) {
            String arr[] = String_value.split(",");

            for (String n : arr) {

                int current = Integer.parseInt(n);
                sum += current;

            }
            return sum;
        }
        return 1;
    }
}
