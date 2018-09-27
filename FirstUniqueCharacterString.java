import java.util.Hashtable;
import java.util.LinkedList;

/*
 *	Jose Ignacio Retamal Thomsen: Interview Question.
 *	
 *	Question: 
 * 		Find the first non-repeated character in a String
 * 
 * 	First Approach:
 * 		-No case sensitive (a=A).
 *		
 * 
 */

public class FirstUniqueCharacterString
{
	public static void main(String[] args)
	{
		System.out.println(
				"s-" + firstUniqueCharA1("ssmsmuugfghfhfffsvdsatgregfsfxnfgbdxfsfghhtgfgxztytyhgfbfbdtgggrtyhfgvae"));

		System.out.println(
				"s-" + firstUniqueCharA2("ssmsmuugfghfhfffsvdsatgregfsfxnfgbdxfsfghhtgfgxztytyhgfbfbdtgggrtyhfgvae"));

		System.out.println(
				"s-" + firstUniqueCharA3("ssmsmuugfghfhfffsvdsatgregfsfxfgbdxfsfghhtgfgxztytyhgfbfbdtgggrtyhfgvaeN"));

		System.out.println(
				"s-" + firstUniqueCharA4("ssmsmuugfghfhfffsvdsatgregfsfxfgbdxfsfghhtgfgxztytyhgfbfbdtgggrtyhfgvaeN"));
		System.out.println("s-" + firstUniqueCharA4("sN"));

		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		System.out.println("x" + ht.put('a', 1));
		System.out.println(ht.put('a', 3));
		System.out.println(ht.get('a'));

	}

	/*
	 * First Approach: - no data structure, O(N^2)
	 * 
	 * 1) convert string to lower case 2)Compare each character of the string with
	 * the first one, if they are all different the first character is the first
	 * unique. Do this for each character in the string.
	 * 
	 */
	public static char firstUniqueCharA1(String strP)
	{
		String str = strP.toLowerCase();

		char temp;

		for (int i = 0; i < str.length(); i++)
		{

			temp = str.charAt(i);

			int j = 0;

			for (; j < str.length(); j++)
			{

				if (j == i)
					continue;

				if (temp == str.charAt(j))
					break;

			}

			if (j == str.length())
				return temp;

		}

		return 0;
	}

	/*
	 * Using Hashtable and array
	 * 
	 * 1)Count how many appearance of each character. 2) create a hashtable with all
	 * unique character and the position of then 3) find the character with smaller
	 * position in the hash table
	 */
	public static char firstUniqueCharA2(String strP)
	{
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();

		int a[] = new int[26];

		String str = strP.toUpperCase();

		for (int i = 0; i < str.length(); i++)
		{
			if (a[str.charAt(i) - 'A'] == 0)
			{
				ht.put(str.charAt(i), i);
				a[str.charAt(i) - 'A']++;
			} else
			{
				a[str.charAt(i) - 'A']++;
				ht.remove(str.charAt(i));
			}

		}

		char firstUnique = 0;

		int firstIndex = str.length();

		for (char c : ht.keySet())
		{
			if (ht.get(c) < firstIndex)
			{
				firstIndex = ht.get(c);
				firstUnique = c;
			}
		}

		return firstUnique;
	}

	public static char firstUniqueCharA3(String strP)
	{
		int a[] = new int[26];

		String str = strP.toUpperCase();

		for (int i = 0; i < str.length(); i++)
		{
			if (a[str.charAt(i) - 'A'] == 0)
			{

				a[str.charAt(i) - 'A'] = i + 1;

			} else if (a[str.charAt(i) - 'A'] > 0)
			{
				a[str.charAt(i) - 'A'] = -1;
			}

		}

		char firstUnique = 0;

		int firstIndex = str.length() + 2;

		for (int i = 0; i < 26; i++)
		{

			if (a[i] < firstIndex && a[i] > 0)
			{
				firstIndex = a[i];
				firstUnique = (char) (i + 'A');
			}
		}

		return firstUnique;

	}

	public static char firstUniqueCharA4(String strP)
	{
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();

		String str = strP.toUpperCase();

		for (int i = 0; i < str.length(); i++)
		{
			if (ht.put(str.charAt(i), i + 1) != null)
			{
				ht.put(str.charAt(i), -1);

			}
		}

		char firstUnique = 0;

		int firstIndex = str.length() + 2;

		for (char c : ht.keySet())
		{
			if (ht.get(c) < firstIndex && ht.get(c) > 0)
			{
				firstIndex = ht.get(c);
				firstUnique = c;
			}
		}

		return firstUnique;
	}
}
