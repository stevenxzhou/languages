using System;

class Animal
{
    protected string name = "name";
    private string sex = "male";

    public Animal()
    {
        this.name = "name";
        this.sex = "male";
    }
}

class Dog : Animal
{

    public void getName()
    {
        Console.WriteLine(this.name);
    }

}

class Program
{
    static void Main(string[] args)
    {
        Dog dog = new Dog();
        dog.getName();
        Console.ReadLine(); // Wait for user input before closing
    }
}