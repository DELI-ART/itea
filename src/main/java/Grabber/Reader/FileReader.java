package Grabber.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FileReader implements Reader{
    @Value("classpath:data/resources.txt")
    Resource file;

    @Override
    public List<String> read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        List<String> list = reader.lines().collect(Collectors.toList());
        reader.close();
        return list;
    }
}
