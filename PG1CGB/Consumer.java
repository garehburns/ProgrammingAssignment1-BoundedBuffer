/**
 * Consumer.java
 *
 * This is the consumer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class Consumer extends Thread
{
   public Consumer(BoundedBuffer b)
   {
      buffer = b;
   }

   public void run()
   {
   Date message;

     while (true)
      {
         int sleeptime = (int) (BoundedBuffer.NAP_TIME * Math.random()) +1;

         System.out.println("Consumer sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // consume an item from the buffer
         System.out.println("Consumer wants to consume.");

         message = (Date)buffer.remove();

         System.out.println("Consumer consumed."+message);
      }
   }

   private  BoundedBuffer buffer;

}


