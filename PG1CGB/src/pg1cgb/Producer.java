/**
 * Name: Garrett Burns
 * Date: 23 September 2019
 * Course: Fundamentals of Computer Operating Systems (CS 350)
 * 
 * Programming Assignment #1
 * 
 * This is the producer thread for the bounded buffer problem.
 * 
 * CALCULATIONS:
 *      range 3-7 seconds rest for producers
 *      produce random int in range 8000-50000 and send to buffer for consumer
 */
package pg1cgb;

import java.util.*;

public class Producer extends Thread {
    String name; // create variable for the producers
    
    public Producer(BoundedBuffer b, String n) {
        buffer = b;
        name = n; // John and Liz
    }
    public void run() {
        int message;

        while (true) {
            int max = 7;
            int min = 3;
            int range = max - min + 1; // makes range for producer sleep
         
            // produces a random integer in the range of 3-7 seconds for the producer
            int sleeptime = (int) (BoundedBuffer.NAP_TIME * Math.random() * range) + 3;
            System.out.println("Producer " + name + " sleeping for " + sleeptime + " seconds");
         
            try { sleep(sleeptime*1000); }
            catch(InterruptedException e) {}
         
            // calculates random integer value in specified range of 8000-50000
            message = (int) (Math.random() * ((50000 - 8000) + 1) + min);
            System.out.println("Producer " + name + " produced " + message);
            
            buffer.enter(message); // puts item into buffer
        }
    }
    private  BoundedBuffer buffer;
}