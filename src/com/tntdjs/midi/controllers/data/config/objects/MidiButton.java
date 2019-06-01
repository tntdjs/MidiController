package com.tntdjs.midi.controllers.data.config.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import com.tntdjs.midi.MidiTypeTypes;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"value"})
public class MidiButton {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "midi-device")
    protected String midiDevice = "LoopBe Internal MIDI";
	@XmlAttribute(name = "midi-channel")
    protected Integer midiChannel = 0;
    @XmlAttribute(name = "midi-note")    
    protected Integer midiNote = 0;
    @XmlAttribute(name = "midi-velocity")    
    protected Integer midiVelocity = 40;
    @XmlAttribute(name = "midi-duration")    
    protected Integer midiDuration = 40;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "action")
    protected String action;
    @XmlAttribute(name = "source")
    protected String source="";
    @XmlAttribute(name="enabled")
    protected Boolean enabled;    

	@XmlAttribute(name="key-mod")
    protected String keymod;    
    @XmlAttribute(name="key-pressed")
    protected String keypressed;    

    @XmlAttribute(name="cmd")
    protected String cmd;    
    
    @XmlAttribute(name="cmd-args")
    protected String cmdargs;    
    
	public MidiButton() {
    	super();
    }
    
    public MidiButton(String argId, String argValue, Integer argMidiNote, String argType, String argAction, String argEnabled, String argSource) {
    	super();
    	id = argId;
    	value = argValue;
    	midiNote = argMidiNote;
    	type = argType;
    	action = argAction;
    	enabled = new Boolean(argEnabled);
    	source = argSource;
    }
    
    public String toString() {
    	return id + "::" + value +"::" + midiNote +"::" + midiChannel +"::" + midiDevice +"::" + midiVelocity +"::" + midiDuration +"::" + "" + type +"::" + action +"::" + enabled +"::" + source;
    }
    
    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the midiNote property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMidiNote() {
        return midiNote;
    }

    /**
     * Sets the value of the midiNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMidiNote(Integer value) {
        this.midiNote = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
    	if (null == source) {
    		source = "";
    	}
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
 
	   public String getKeymod() {
			return keymod;
		}

		public void setKeymod(String keymod) {
			this.keymod = keymod;
		}

		public String getKeypressed() {
			return keypressed;
		}

		public void setKeypressed(String keypressed) {
			this.keypressed = keypressed;
		}

		public String getCmd() {
			return cmd;
		}

		public void setCmd(String cmd) {
			this.cmd = cmd;
		}

		public String getCmdargs() {
			return cmdargs;
		}

		public void setCmdargs(String cmdargs) {
			this.cmdargs = cmdargs;
		}

	    public String getMidiDevice() {
			return midiDevice;
		}

		public void setMidiDevice(String midiDevice) {
			this.midiDevice = midiDevice;
		}

		public Integer getMidiChannel() {
			return midiChannel;
		}

		public void setMidiChannel(Integer midiChannel) {
			this.midiChannel = midiChannel;
		}

		public Integer getMidiVelocity() {
			return midiVelocity;
		}

		public void setMidiVelocity(Integer midiVelocity) {
			this.midiVelocity = midiVelocity;
		}

		public Integer getMidiDuration() {
			return midiDuration;
		}

		public void setMidiDuration(Integer midiDuration) {
			this.midiDuration = midiDuration;
		}

		
		
	/**
	 * test or validate the midi button for jFX UI enable
	 * @return
	 */
	public boolean test() {
		if (getType().equalsIgnoreCase(MidiTypeTypes.bridge)) {
			return true;
		} else if (getEnabled() ) { //&& !getSource().isEmpty()
			return true;
		}
		return false;
	}
	
}