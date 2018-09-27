import java.util.StringTokenizer;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.print(reverseString2("This is a test"));
    }

    public static String reverseString(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int i;

        for (i = words.length - 1; i >= 0; --i) {
            sb.append(words[i]);

            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }

    public static String reverseString2(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence);
        StringBuilder sb = new StringBuilder();

        int i;

        while (st.hasMoreTokens()) {
            sb.insert(0, st.nextToken());

            if (st.hasMoreTokens()) {
                sb.insert(0, " ");
            }
        }

        return sb.toString();
    }

}
