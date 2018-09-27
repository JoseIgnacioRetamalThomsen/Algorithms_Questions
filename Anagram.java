import java.util.Arrays;
/*
 *  Interview question : Find if two strings are anagram.
 */
public class Anagram
{

	public static void main(String[] args)
	{

		System.out.println(findAnagram("William Shakespeare", "I am a weakish speller"));
		System.out.println(findAnagram1("William Shakespeare", "I am a weakish speller"));
	}

	/*
	 * Jose Ignacio Retamal
	 * 
	 */
	public static boolean findAnagram(String s1, String s2)
	{
		
		
		char[] s1Char = s1.toLowerCase().toCharArray();
		char[] s2Char = s2.toLowerCase().toCharArray();

		Arrays.sort(s1Char);
		Arrays.sort(s2Char);

		int i = 0, j = 0;

		while (s1Char[i] == ' ')
		{
			i++;
		}

		while (s2Char[j] == ' ')
		{
			j++;
		}

		if (s1Char.length - i != s2Char.length - j)
		{
			return false;

		}

		while (i < s1Char.length)
		{
			if (s1Char[i++] != s2Char[j++])
			{
				return false;
			}
		}

		return true;
	}

	/*
	 * Sorting
	 */
	public static boolean findAnagram1(String s1, String s2)
	{
		int letterCountS1[] = new int[26];
		int letterCountS2[] = new int[26];

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		for (int i = 0; i < s1.length(); i++)
		{
			if (s1.charAt(i) == ' ')
				continue;

			letterCountS1[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++)
		{
			if (s2.charAt(i) == ' ')
				continue;

			letterCountS2[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++)
		{
			if (letterCountS1[i] != letterCountS2[i])
			{
				return false;
			}
		}

		return true;
	}
}
