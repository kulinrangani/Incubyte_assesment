public class StringCalculator {

    public int add(String String_value) {
        int sum = 0;
        String negative_String = "";
        String_value = String_value.replaceAll(" ", "");
        int delimiter_Index = String_value.indexOf("//");
        int String_Index = String_value.indexOf("\n");

        if (String_value.startsWith("0//") || String_value.startsWith("1//")) {
            int index = 0;
            if (String_value.startsWith("1")) {
                index = 0;
            } else
                index = 1;
            String subString = String_value.substring(3);
            String[] s = subString.split(",");

            for (int i = index; i < s.length; i += 2) {
                sum += Integer.parseInt(s[i]);
            }
            return sum;
        }
        // Hanling Delimiers
        else if (delimiter_Index != -1) {
            String delimiter = String_value.substring(delimiter_Index + 2, String_Index);
            String_value = String_value.substring(String_Index + 1);
            String[] arr1 = String_value.split(delimiter);
            for (String n : arr1) {
                Integer current = Integer.parseInt(n);
                sum += current;
            }
            return sum;
        }

        else if (String_value.equals("")) {
            return 0;
        }
        while (String_value.length() >= 1) {
            String arr[] = String_value.split("[,\n]");
            for (String n : arr) {
                if (n.matches("[a-z]")) {
                    sum += n.codePointAt(0) - 96;
                } else {
                    int current = Integer.parseInt(n);
                    if (current > 1000) {
                        continue;
                    } else if (current < 0) {
                        negative_String += (String.valueOf(current) + " ");
                    }
                    sum += current;
                }
            }

            if (negative_String != "") {
                throw new RuntimeException("Negatives not allowed -> " + negative_String);
            }
            return sum;
        }
        return 1;
    }
}
