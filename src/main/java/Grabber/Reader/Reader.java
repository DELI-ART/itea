package Grabber.Reader;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface Reader {
    public List<String> read() throws IOException;
}
