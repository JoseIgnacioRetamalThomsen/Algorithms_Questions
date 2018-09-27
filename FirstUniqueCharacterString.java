import java.util.Hashtable;
import java.util.LinkedList;

/*
 *	
 *	Question: 
 * 		Find the first non-repeated character in a String
 * 
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
				"s-" + firstUniqueCharA2("ssmsmuugfghfhfffsvdsatgregfsfxfgbdxfsfghhtgfgxztytyhgfbfbdtgggrtyhfgvaeN"));

		System.out.println(
				"s-" + firstUniqueCharA3("ssmsmuugfghfhfffsvdsatgregfsfxfgbdxfsfghhtgfgxztytyhgfbfbdtgggrtyhfgvaeN"));
		System.out.println("s-" + firstUniqueCharA3("sN"));

		

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
	 * Jose Retamal 
	 * Counting array
	 */
	public static char firstUniqueCharA2(String strP)
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

	/*
	 * Jose Retamal 
	 * HashTable
	 */
	
	public static char firstUniqueCharA3(String strP)
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
