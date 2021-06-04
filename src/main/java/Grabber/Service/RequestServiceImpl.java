package Grabber.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CyclicBarrier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import Grabber.Reader.Reader;
import Grabber.Worker.Worker;
import Grabber.Writer.Writer;
import jakarta.xml.bind.JAXBException;


@Service
public class RequestServiceImpl implements RequestService {
    private final Reader reader;
    private final Writer writer;
    private final Worker worker;
    @Value("${maxThreads}")
    private Integer maxThreads;

    public class AggregatorThread implements Runnable {
        @Override
        public void run() {
            try {
                writer.write(worker.getData());
            }
            catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    RequestServiceImpl(Reader reader, Writer writer, Worker worker) {
        this.reader = reader;
        this.writer = writer;
        this.worker = worker;
    }

    @Override
    public void collectData() throws IOException {
        Queue<String> resources = new LinkedList<>(reader.read());
        CyclicBarrier barrier = new CyclicBarrier(maxThreads, new AggregatorThread());
        worker.runThreads(maxThreads, resources, barrier);
    }
}
