package com.amazonaws.samples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class S3MixCommands
{
    public void fetchCommands() throws InterruptedException, IOException
    {
    /*
         * Create your credentials file at ~/.aws/credentials (C:\Users\USER_NAME\.aws\credentials for Windows users)
         * and save the following lines after replacing the underlined values with your own.
         *
         * [default]
         * aws_access_key_id = YOUR_ACCESS_KEY_ID
         * aws_secret_access_key = YOUR_SECRET_ACCESS_KEY
         */

        AmazonS3 s3 = new AmazonS3Client();
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        s3.setRegion(usWest2);

        String bucketName = "mixstudiocommands";
        String key = "commands";
        System.out.println("Downloading an object");
        S3Object object;
        try
        {
            object = s3.getObject(new GetObjectRequest(bucketName, key));
        }
        catch(Exception ex)
        {
            return;
        }
        String commandString = getCommandFromS3(object.getObjectContent());
        if (commandString == null || commandString == "")
        {
            return;
        }

        // EXECUTE COMMAND HERE

        System.out.println("Executing macro command for " + commandString);

        // Delete file from S3
        s3.deleteObject(bucketName, key);
    }

    private String getCommandFromS3(InputStream input) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true)
        {
            String line = reader.readLine();
            if (line == null) return "";
            return line;
        }
    }
}
