package Grabber.Client;

import org.springframework.stereotype.Service;

import Grabber.Client.Resources.Response;

@Service
public interface HttpClient {
    <T> Response request(String targetUrl, Class<T> targetClass) throws Exception;
}
