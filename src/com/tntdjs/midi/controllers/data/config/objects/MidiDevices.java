//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.13 at 06:32:15 PM EST 
//


package com.tntdjs.midi.controllers.data.config.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"device"})
@XmlRootElement(name = "MidiDevices")
public class MidiDevices {

    @XmlElement(name = "Device", required = true)
    protected MidiDevices.Device device;
    @XmlAttribute(name = "dtype")
    protected String dtype;

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link MidiDevices.Device }
     *     
     */
    public MidiDevices.Device getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiDevices.Device }
     *     
     */
    public void setDevice(MidiDevices.Device value) {
        this.device = value;
    }

    /**
     * Gets the value of the dtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtype() {
        return dtype;
    }

    /**
     * Sets the value of the dtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtype(String value) {
        this.dtype = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "buttonGroups",
        "potentiometerGroups"
    })
    public static class Device {

        @XmlElement(name = "ButtonGroups", required = true)
        protected MidiDevices.Device.ButtonGroups buttonGroups;
        @XmlElement(name = "PotentiometerGroups", required = true)
        protected PotentiometerGroups potentiometerGroups;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "manufacturer")
        protected String manufacturer;
        @XmlAttribute(name = "MidiDevice")
        protected String midiDevice;

        /**
         * Gets the value of the buttonGroups property.
         * 
         * @return
         *     possible object is
         *     {@link MidiDevices.Device.ButtonGroups }
         *     
         */
        public MidiDevices.Device.ButtonGroups getButtonGroups() {
            return buttonGroups;
        }

        /**
         * Sets the value of the buttonGroups property.
         * 
         * @param value
         *     allowed object is
         *     {@link MidiDevices.Device.ButtonGroups }
         *     
         */
        public void setButtonGroups(MidiDevices.Device.ButtonGroups value) {
            this.buttonGroups = value;
        }

        /**
         * Gets the value of the potentiometerGroups property.
         * 
         * @return
         *     possible object is
         *     {@link MidiDevices.Device.PotentiometerGroups }
         *     
         */
        public PotentiometerGroups getPotentiometerGroups() {
            return potentiometerGroups;
        }

        /**
         * Sets the value of the potentiometerGroups property.
         * 
         * @param value
         *     allowed object is
         *     {@link MidiDevices.Device.PotentiometerGroups }
         *     
         */
        public void setPotentiometerGroups(PotentiometerGroups value) {
            this.potentiometerGroups = value;
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
         * Gets the value of the manufacturer property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getManufacturer() {
            return manufacturer;
        }

        /**
         * Sets the value of the manufacturer property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setManufacturer(String value) {
            this.manufacturer = value;
        }

        /**
         * Gets the value of the MidiDevice property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMidiDevice() {
            return midiDevice;
        }

        /**
         * Sets the value of the MidiDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMidiDevice(String value) {
            this.midiDevice = value;
        }

        
        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"buttonSet"})
        public static class ButtonGroups {

            @XmlElement(name = "ButtonSet")
            protected List<ButtonSet> buttonSet;

            /**
             * Gets the value of the buttonSet property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the buttonSet property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getButtonSet().add(newItem);
             * </pre>
			 *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link MidiDevices.Device.ButtonGroups.ButtonSet }
             * 
             * 
             */
            public List<ButtonSet> getButtonSet() {
                if (buttonSet == null) {
                    buttonSet = new ArrayList<ButtonSet>();
                }
                return this.buttonSet;
            }

            public void setButtonSet(List<ButtonSet> argButtonSet) {
            	buttonSet = argButtonSet;
            }
            
        }

    }

}