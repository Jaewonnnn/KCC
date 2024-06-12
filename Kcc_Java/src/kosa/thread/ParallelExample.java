package kosa.thread;
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class ParallelExample {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> scores = new ArrayList<>();
        
        for(int i = 0; i < 100000000; i++){
            scores.add(random.nextInt(101));
        }
        double avg = 0;
        long startTime = 0;
        long endTime = 0;
        long time = 0;
        
        startTime = System.nanoTime();
        avg = scores.stream().mapToInt(i -> i.intValue()).average().getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");
        
        startTime = System.nanoTime();
        avg = scores.parallelStream().mapToInt(i -> i.intValue()).average().getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 병렬 스트림 처리 시간: " + time + "ns");
    }
}