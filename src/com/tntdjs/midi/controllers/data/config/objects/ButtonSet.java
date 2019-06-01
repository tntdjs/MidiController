package com.tntdjs.midi.controllers.data.config.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"midiButton"})
public class ButtonSet {

    @XmlElement(name = "MidiButton")
    protected List<MidiButton> midiButton;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "bank")
    protected Integer bank;

    /**
     * Gets the value of the midiButton property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the midiButton property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMidiButton().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MidiDevices.Device.ButtonGroups.ButtonSet.MidiButton }
     * 
     * 
     */
    public List<MidiButton> getMidiButtons() {
        if (midiButton == null) {
            midiButton = new ArrayList<MidiButton>();
        }
        return this.midiButton;
    }
    
    public void setMidiButtons(List<MidiButton> argMidiButton) {
    	midiButton = argMidiButton;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBank(Integer value) {
        this.bank = value;
    }
}
