package test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {

    public static void main(String [] args){
        String data = "\\s A Stream is a sequence of elements from a source (like a Collection or array) that supports aggregate operations. It is not a data structure, but rather a way to process data. transforms each element into a stream of zero or more elements, then flattens these individual streams into a single stream. It is used when you have a stream of collections and want to combine all elements into a single stream.";
        List<String> names = List.of(data.split("\\s"));
        long startParallel = System.currentTimeMillis();
        List<String> cap = names.parallelStream().map(String::toUpperCase).toList();

        System.out.println("parallel time taken "+(System.currentTimeMillis()-startParallel));

        long startStream = System.currentTimeMillis();

        List<String> cap2 = names.stream().map(String::toUpperCase).toList();
        System.out.println("stream time taken "+(System.currentTimeMillis()-startStream));


        try {
            FileOutputStream fileOutputStream = new FileOutputStream("serialize.text");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cap2.stream().collect(Collectors.joining(",")));


            FileInputStream fileInputStream = new FileInputStream("serialize.text");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object val = objectInputStream.readObject();
            System.out.println("val "+((String) val));
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
