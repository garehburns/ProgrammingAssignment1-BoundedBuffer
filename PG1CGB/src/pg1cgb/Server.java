/**
 * Name: Garrett Burns
 * Date: 23 September 2019
 * Course: Fundamentals of Computer Operating Systems (CS 350)
 * 
 * Programming Assignment #1
 * 
 * This creates the buffer and the producer and consumer threads.
 * 
 */
package pg1cgb;

public class Server {
    
    public static void main(String args[]) {
        
        // creates a buffer for each consumer/producer
        BoundedBuffer MaryJohn = new BoundedBuffer();
        BoundedBuffer BertLiz = new BoundedBuffer();

        // creates the producer threads
        Producer Mary = new Producer(MaryJohn, "Mary");
        Producer Bert = new Producer(BertLiz, "Bert");

        // creates the consumer threads
        Consumer John = new Consumer(MaryJohn, "John");
        Consumer Liz = new Consumer(BertLiz, "Liz");

        // starts both threads in their specified pair
        Mary.start();
        John.start();

        Bert.start();
        Liz.start();

    }//main
    
}//class
