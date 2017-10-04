package ru.clubbreakfast.at_the_lecture.sept29.xmls.MonitoringStudent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxBParser implements XParser {
    @Override
    public Object getObject(File file, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c); //создаем образец контекста и передаем Class объекта с которым будем работать
        Unmarshaller unmarshaller = context.createUnmarshaller(); //создаем анмаршаллер :-)
        Object object = unmarshaller.unmarshal(file); //сохраняем данные схемы в объект. file — файл, с которого читаются данные.

        return object;
    }

    @Override
    public void saveObject(File file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller(); //создаем маршаллер. (запись объекта в файл в виде XML)
        marshaller.marshal(o, file); //сохраняем объект o, в файл file.
    }
}


