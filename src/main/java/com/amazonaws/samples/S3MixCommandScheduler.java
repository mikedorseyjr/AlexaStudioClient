package com.amazonaws.samples;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class S3MixCommandScheduler extends TimerTask
{
    public void run()
    {
        try
        {
            commands.fetchCommands();
        }
        catch(InterruptedException iex)
        {
            System.out.println("Got an interruption. Die!!!!");
            Thread.currentThread().interrupted();
            System.exit(0);
        }
        catch( IOException ex)
        {
            System.out.println("Got an exception when fetching commands. Who cares?!");
        }
        System.out.println("Just fetched commands. Sleeping....");
    }

    public static void main(String[] args) throws IOException
    {
        //interval set as per your need //
        long interval = 500; // Delay for 500 ms

        S3MixCommandScheduler scheduler = new S3MixCommandScheduler();
        Timer timer = new Timer();
        timer.schedule(scheduler, new Date(), interval);
    }

    S3MixCommands commands = new S3MixCommands();

}
