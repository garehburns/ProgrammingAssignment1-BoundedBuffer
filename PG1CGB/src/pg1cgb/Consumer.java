/**
 * Name: Garrett Burns
 * Date: 23 September 2019
 * Course: Fundamentals of Computer Operating Systems (CS 350)
 * 
 * Programming Assignment #1
 *
 * This is the consumer thread for the bounded buffer problem.
 *
 * CALCULATIONS:
 *      range 4-6 seconds rest for consumers
 *      sum of number value taken from producer buffer
 */
package pg1cgb;

import java.util.*;

public class Consumer extends Thread {
    String name; // create variable for the consumers
    
    public Consumer(BoundedBuffer b, String n) {
        buffer = b;
        name = n; // Mary and Bert
    }

    public void run() {
        int message;

        while (true) {
            int max = 6;
            int min = 4;
            int range = max - min + 1; // makes range for consumer sleep
         
            // produces a random integer in the range of 4-6 seconds for the consumer
            int sleeptime = (int) (BoundedBuffer.NAP_TIME * Math.random() * range) + 4;
            System.out.println("Consumer " + name + " sleeping for " + sleeptime + " seconds");
         
            try { sleep(sleeptime*1000); }
            catch(InterruptedException e) {}

            // consume an item from the buffer
            System.out.println("Consumer " + name + " wants to consume.");

            message = (int)buffer.remove();

            // finds value of random number produced; calculates the ind. sum of numbers
            int sum = String.valueOf(message)
                .chars()
                .map(Character::getNumericValue)
                .sum();
            
            System.out.println("Consumer " + name + " consumed " + message + 
                    " Sum of its digits is: " + sum);
        }
    }
    private  BoundedBuffer buffer;
}


