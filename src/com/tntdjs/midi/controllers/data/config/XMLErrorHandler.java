package com.tntdjs.midi.controllers.data.config;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * 
 * @author tsenauskas
 *
 */
public class XMLErrorHandler implements ErrorHandler {

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		throw exception;
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		throw exception;

	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		throw exception;

	}

}
