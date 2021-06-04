package Grabber.Writer.Model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {
    @XmlElement
    List<ItemData> item;

    public void setItem(List<ItemData> itemData) {
        this.item = itemData;
    }
}
