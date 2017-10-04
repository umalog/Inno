package ru.clubbreakfast.at_the_lecture.sept29.xmls.MonitoringStudent;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface XParser {
    Object getObject(File file, Class c) throws JAXBException;
    void saveObject(File file, Object o) throws JAXBException;

}
