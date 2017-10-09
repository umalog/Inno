
package ru.clubbreakfast.at_the_lecture.sept29.xmls.mypackage;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.clubbreakfast.at_the_lecture.sept29.xmls.mypackage package.
 * <p>An XMLFactory allows you to programatically
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {



    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Students }
     * 
     */
    public Students createStudents() {
        return new Students();
    }

    /**
     * Create an instance of {@link StudentType }
     * 
     */
    public StudentType createStudentType() {
        return new StudentType();
    }

    /**
     * Create an instance of {@link StudentData }
     * 
     */
    public StudentData createStudentData() {
        return new StudentData();
    }

    /**
     * Create an instance of {@link GroupType }
     * 
     */
    public GroupType createGroupType() {
        return new GroupType();
    }

    /**
     * Create an instance of {@link GroupData }
     * 
     */
    public GroupData createGroupData() {
        return new GroupData();
    }

}
