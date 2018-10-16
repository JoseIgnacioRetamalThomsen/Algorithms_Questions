
public class CommonPrefix
{
	public static void main(String[] args)
	{
		String[] array =
		{
				"flow", "flower", "flom", "fly"
		};
		System.out.println(findCommonPrefix(array));
	}

	/*
	 * Jose Retamal , on board answer
	 */
	public static String findCommonPrefix(String[] str)
	{
		String commonPre = str[0];
		for (int i = 1; i < str.length; i++)
		{
			int j;
			int min = Math.min(commonPre.length(), str[i].length());
			for (j = 0; j < min; j++)
			{
				if (commonPre.charAt(j) != str[i].charAt(j))
					break;
			}
			commonPre = str[i].substring(0,j);
		}

		return commonPre;
	}

}
