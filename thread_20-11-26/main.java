public class main{
        public static void main(String[] args) throws InterruptedException {
    //we need to add throws InterruptedException because sleep method can throw InterruptedException
    //we will use sleep method to pause the execution of the program for a specified time
       System.out.println("Task1");
        Thread.sleep(1000);
        System.out.println("Task2");
        Thread.sleep(2000);
        System.out.println("Task3");
    
      System.out.println("Task1");
       Thread t=Thread.currentThread();
       System.out.println(t.getPriority());//tells the priority of the thread
       System.out.println(t.isAlive());//tells whether the thread is alive or not
       
       //how to manuplate the get priority:
Thread t1=new Thread(()->{
    System.out.println("Thread1 is running");
});
Thread t2=new Thread(()->{
    System.out.println("Thread2 is running");
});


//here priority number doesnot change the set of exceution code whether it is lowest or highest number first t1 written so t1 will exceutes first.
//the priority is just a hint to the thread scheduler, it doesn't guarantee the order of execution
t2.setPriority(8);//setting the priority of the thread to minimum
t1.setPriority(1);//setting the priority of the thread to maximum

System.out.println(t1.getPriority());//tells the priority of the thread
t1.start();//calling the start method will call the run method of the thread
t1.getPriority();//tells the priority of the thread
System.out.println(t2.getPriority());//tells the priority of the thread
t2.start();

//Thread joins: to hold the execution of the main thread until the other threads are completed we can use join method
 Thread t1=new Thread(()->{
    System.out.println("placing order");
});
Thread t2=new Thread(()->{
    System.out.println("confirming order");
});
Thread t3=new Thread(()->{
    System.out.println("order ready to pick up"); 
});

t1.start();
t2.start();
t3.start();

t1.join();//this will make the main thread wait until t1 is finished
t2.join();//this will make the main thread wait until t2 is finished
t3.join();//this will make the main thread wait until t3 is finished
t1.getPriority();
t2.getPriority();
t3.getPriority();
System.out.println(t1.getPriority());
System.out.println(t2.getPriority());
System.out.println(t3.getPriority());
 System.out.println("ready to eat the food"); //here priority will choose for main method thread so it will print first then the other threads will print their statements


    }
}
