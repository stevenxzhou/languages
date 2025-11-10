using System;

class PriorityQueueTest
{
    public static void Test()
    {
        PriorityQueue<int, int> pq = new PriorityQueue<int, int>(Comparer<int>.Create((a, b) => b - a));
        pq.Enqueue(1, 2);
        pq.Enqueue(3, 1);

        Console.WriteLine(pq.Dequeue());
    }
}