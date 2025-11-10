// See https://aka.ms/new-console-template for more information

class Animal
{
    protected string name = "name";
    private string sex = "male";

    public Animal(string name)
    {
        this.name = name;
        this.sex = "male";
    }
}

class Dog : Animal
{
    public Dog() : base("123")
    {

    }

    public void setName()
    {
        Console.WriteLine("H");
    }

    public void getName()
    {
        Console.WriteLine(this.name);
        setName();
    }

}

class Program
{
    static void Main(string[] args)
    {
        string firstName = "John";
        string lastName = "Doe";
        string fullName = String.Format("My name is {0} {1}", firstName, lastName);
        Console.WriteLine(fullName);
    }
}
