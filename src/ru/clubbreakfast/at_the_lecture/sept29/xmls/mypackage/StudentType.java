
package ru.clubbreakfast.at_the_lecture.sept29.xmls.mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StudentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StudentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentData" type="{}StudentData"/>
 *         &lt;element name="Group" type="{}GroupData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StudentType", propOrder = {
    "studentData",
    "group"
})
public class StudentType {

    @XmlElement(required = true)
    protected StudentData studentData;
    @XmlElement(name = "Group", required = true)
    protected GroupData group;

    /**
     * Gets the value of the studentData property.
     * 
     * @return
     *     possible object is
     *     {@link StudentData }
     *     
     */
    public StudentData getStudentData() {
        return studentData;
    }

    /**
     * Sets the value of the studentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentData }
     *     
     */
    public void setStudentData(StudentData value) {
        this.studentData = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link GroupData }
     *     
     */
    public GroupData getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupData }
     *     
     */
    public void setGroup(GroupData value) {
        this.group = value;
    }

}
