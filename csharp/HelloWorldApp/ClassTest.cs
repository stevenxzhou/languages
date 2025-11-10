class ClassTest
{
    int a;

    public ClassTest()
    {
        this.a = 15;
    }

    public void Test()
    {
        Console.WriteLine(a);
        a = 12;
        Console.WriteLine(this.a);
    }
}