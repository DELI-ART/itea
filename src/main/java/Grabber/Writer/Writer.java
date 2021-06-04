package Grabber.Writer;

import java.util.Map;

import org.springframework.stereotype.Service;

import Grabber.Client.Resources.Response;
import jakarta.xml.bind.JAXBException;

@Service
public interface Writer {
    void write(Map<String, Response> data) throws JAXBException;
}
