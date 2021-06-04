package Grabber.Worker;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import org.springframework.stereotype.Service;
import Grabber.Client.HttpClient;
import Grabber.Client.Resources.Job;
import Grabber.Client.Resources.Response;

@Service
public class Worker implements Runnable {
    Map<String,Response> data = new LinkedHashMap<>();
    Queue <String> resources;
    CyclicBarrier barrier;
    HttpClient client;

    public Worker(HttpClient client) {
        this.client = client;
    }

    public void runThreads(int count, Queue<String> resources, CyclicBarrier barrier) {
        this.resources = resources;
        this.barrier = barrier;

        for (int i = 1; i <= count; i++) {
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    public Map<String,Response> getData() {
        return data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String resource = resources.remove();
                Response response = client.request(resource, Job.class);
                data.put(resource, response);
            } catch (NoSuchElementException e) {
                System.out.println("Queue is empty...");
                try {
                    barrier.await();
                    break;
                }
                catch (InterruptedException | BrokenBarrierException exception) {
                    System.out.println("Oops!");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
