import java.util.Arrays;

public class StringMethods{

    public static void main(String[] args) {
        String text = "We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative";

        System.out.println("charAt(20): " + text.charAt(20));

        String str2 = "Bombay";
        int comparison = text.compareTo(str2);
        System.out.println("compareTo(str2): " + comparison);

        String str3 = " Ratan Tata";
        String concatenatedString = text.concat(str3);
        System.out.println("concat(str3): " + concatenatedString);

        boolean containsText = text.contains("their");
        System.out.println("contains(their): " + containsText);

        boolean endsWithAlternative = text.endsWith("alternative");
        System.out.println("endsWith(alternative): " + endsWithAlternative);

        boolean isEqual = text.equals("We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative");
        System.out.println("equals(text): " + isEqual);

        boolean equalsIgnoreCase = text.equalsIgnoreCase("We realizes that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative");
        System.out.println("equalsIgnoreCase(text): " + equalsIgnoreCase);

        String formattedString = String.format("The world's cheapest car, the %s, was launched at a starting price of only Rs %d lakh.", "Tata Nano", 1);
        System.out.println("format(): " + formattedString);

        byte[] byteArray = text.getBytes();
        System.out.println("getBytes(): " + Arrays.toString(byteArray));

        char[] charArray = new char[text.length()];
        text.getChars(0, text.length(), charArray, 0);
        System.out.println("getChars(): " + Arrays.toString(charArray));

        int indexOfText = text.indexOf("were");
        System.out.println("indexOf(were): " + indexOfText);

        String internedString = text.intern();
        System.out.println("intern(): " + internedString);

        boolean isEmpty = text.isEmpty();
        System.out.println("isEmpty(): " + isEmpty);

        String joinedString = String.join(", ", "Tata", "Nano", "car");
        System.out.println("join(',', 'Tata', 'Nano', 'car'): " + joinedString);

        int lastIndexOfAlternative = text.lastIndexOf("alternative");
        System.out.println("lastIndexOf(alternative): " + lastIndexOfAlternative);

        int length = text.length();
        System.out.println("length(): " + length);

        String replacedString = text.replace("workers", "employees");
        System.out.println("replace(workers, employees): " + replacedString);

        String replacedAllString = text.replaceAll("for", "fro");
        System.out.println("replaceAll(for, fro): " + replacedAllString);

        String[] splittedWords = text.split(" ");
        System.out.println("split( ): " + Arrays.toString(splittedWords));

        boolean startsText = text.startsWith("We");
        System.out.println("startsWith(We): " + startsText);

        String substring1 = text.substring(30);
        String substring2 = text.substring(17, 20);
        System.out.println("substring(30): " + substring1);
        System.out.println("substring(17, 20): " + substring2);

        System.out.println("toCharArray(): " + Arrays.toString(text.toCharArray()));

        String toLowerCaseString = text.toLowerCase();
        System.out.println("toLowerCase(): " + toLowerCaseString);

        String toUpperCaseString = text.toUpperCase();
        System.out.println("toUpperCase(): " + toUpperCaseString);

        String trimmedString = text.trim();
        System.out.println("trim(): " + trimmedString);

        int intVal = 10;
        String valueOfString = String.valueOf(intVal);
        System.out.println("valueOf(10): " + valueOfString);
    }
}
