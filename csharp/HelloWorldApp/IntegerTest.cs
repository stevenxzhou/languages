using System.Globalization;

class IntegerTest
{
    public static void Test()
    {
        // Parsing "12" as an integer using NumberStyles.Integer for clarity and future extensibility.
        var targetNum = int.Parse("12", NumberStyles.Integer);
        Console.WriteLine(targetNum);
    }
}