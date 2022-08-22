public class StringCalculator {

    public String getDelimeter(String s) {
        int delimiter_Index = s.indexOf("//");
        int String_Index = s.indexOf("\n");
        String delimiter = s.substring(delimiter_Index + 2, String_Index);
        return delimiter;
    }

    public String getSubString(String s) {
        int String_Index = s.indexOf("\n");
        String String_value = s.substring(String_Index + 1);
        return String_value;
    }

    public int add(String String_value) {
        int sum = 0;
        String negative_String = "";
        String_value = String_value.replaceAll(" ", "");

        if (String_value.startsWith("0//") || String_value.startsWith("1//")) {
            int index = 0;
            if (String_value.startsWith("1")) {
                index = 0;
            } else
                index = 1;
            String subString = getSubString(String_value);
            String[] s = subString.split(",");

            for (int i = index; i < s.length; i += 2) {
                sum += Integer.parseInt(s[i]);
            }
            return sum;
        }
        // Hanling Delimiers
        else if (String_value.startsWith("//")) {
            String delimiter = getDelimeter(String_value);
            String_value = getSubString(String_value);
            String[] arr = String_value.split(delimiter);
            for (String n : arr) {
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
