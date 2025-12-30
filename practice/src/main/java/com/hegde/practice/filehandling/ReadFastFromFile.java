package com.hegde.practice.filehandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Math.toIntExact;

public class ReadFastFromFile implements Runnable {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\Learn\\codeforces\\com\\hegde\\problemsolve\\Test.txt");
        FileChannel channel = fileInputStream.getChannel();
        long remainingSize = channel.size(); //get the total number of bytes in the file
        long chunkSize = remainingSize / 4; //file_size/threads

        //Max allocation size allowed is ~2GB
        if (chunkSize > (Integer.MAX_VALUE - 5)) {
            chunkSize = (Integer.MAX_VALUE - 5);
        }

        //thread pool
        ExecutorService executor = Executors.newFixedThreadPool(4);

        long startLoc = 0;//file pointer
        int i = 0; //loop counter
        while (remainingSize >= chunkSize) {
            //launches a new thread
            executor.execute(new ReadFastFromFile(startLoc, toIntExact(chunkSize), channel, i));
            remainingSize = remainingSize - chunkSize;
            startLoc = startLoc + chunkSize;
            i++;
        }

        //load the last remaining piece
        executor.execute(new ReadFastFromFile(startLoc, toIntExact(remainingSize), channel, i));

        //Tear Down
        executor.shutdown();

        //Wait for all threads to finish
        while (!executor.isTerminated()) {
            //wait for infinity time
        }
        System.out.println("Finished all threads");
        fileInputStream.close();

    }

    private FileChannel channel;
    private long startLocation;
    private int size;
    int sequenceNumber;

    public ReadFastFromFile(long loc, int size, FileChannel chnl, int sequence) {
        startLocation = loc;
        this.size = size;
        channel = chnl;
        sequenceNumber = sequence;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread : " + Thread.currentThread() + " - Reading the channel: " + startLocation + ":" + size);

            //allocate memory
            ByteBuffer buff = ByteBuffer.allocate(size);

            //Read file chunk to RAM
            channel.read(buff, startLocation);

            //chunk to String
            String stringChunk = new String(buff.array(), Charset.forName("UTF-8"));
            System.out.println(stringChunk);

            System.out.println("Done Reading the channel: " + startLocation + ":" + size);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


