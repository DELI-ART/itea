package Grabber.Client.Resources;

import feign.RequestLine;

public interface ResourcesMapping {
    @RequestLine("GET")
    Job Job();
}
