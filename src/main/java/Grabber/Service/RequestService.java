package Grabber.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public interface RequestService {
    void collectData() throws IOException, InterruptedException;
}
