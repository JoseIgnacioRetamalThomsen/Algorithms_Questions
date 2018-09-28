import java.util.StringTokenizer;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseString2("This is a test"));
        System.out.println(reverseString3("This is a test"));
    }

    /*
	 * Ronan
	 */
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

    /*
	 * Ronan
	 */
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

    /*
	 * Jose - On white board answer
	 */

	public static String reverseString3(String str)
	{
		LinkedList<String> stack = new LinkedList<String>();

		StringBuilder result = new StringBuilder();

		int startNewWord = 0;

		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == ' ')
			{
				stack.push(str.substring(startNewWord, i));
				startNewWord = i;
			}
			if (i == str.length() - 1)//mistake when doing in whiteboard -1 added, was better maybe add this before the loop
			{
				stack.push(str.substring(startNewWord, i + 1)); //same here +1 added
			}
		}

		while (!stack.isEmpty())
		{
			result.append(stack.pop() + " ");
		}

		return result.toString().trim();
		
	}
}
