package Grabber.Writer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Grabber.Client.Resources.Job;
import Grabber.Client.Resources.Response;
import Grabber.Writer.Model.Data;
import Grabber.Writer.Model.ItemData;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import org.springframework.stereotype.Service;

@Service
public class XmlWriter implements Writer {

    @Override
    public void write(Map<String, Response> data)  {
        List<ItemData> itemDataList = new ArrayList<>();
        for (Map.Entry<String, Response> entry : data.entrySet()) {
            Response response = entry.getValue();
            if (response instanceof Job) {
                Job job = (Job) response;
                itemDataList.add(ItemData.builder().Url(entry.getKey()).ItemData(job.getTitle()).build());
            }
        }

        if (!itemDataList.isEmpty()) {
            Data model = new Data();
            model.setItem(itemDataList);
            writeXml(model);
        }
    }

    private void writeXml(Data model) {
        JAXBContext context = null;
        try {
            File file = new File("result.xml");
            context = JAXBContext.newInstance(Data.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(model, file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
