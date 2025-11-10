using System;

class DictionaryTest
{
    public static void Test()
    {
        Dictionary<string, int> dict = new Dictionary<string, int>();

        dict.Add("1", 1);
        dict.Add("2", 2);

        foreach (KeyValuePair<string, int> kvp in dict)
        {
            Console.WriteLine(kvp.Key);
            Console.WriteLine(kvp.Value);
        }
    }
}