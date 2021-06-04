package Grabber.Client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import Grabber.Client.Resources.ResourcesMapping;
import Grabber.Client.Resources.Response;
import feign.Feign;
import feign.gson.GsonDecoder;

@Service
public class HttpClientImpl implements HttpClient {

    @Override
    public <T> Response request(String targetResource, Class<T> targetClass) throws Exception {
        ResourcesMapping client = Feign.builder().decoder(new GsonDecoder()).target(ResourcesMapping.class, targetResource);
        try {
            Method method = client.getClass().getMethod(targetClass.getSimpleName());
            return (Response) method.invoke(client);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new Exception(e.getMessage());
        }
    }
}
