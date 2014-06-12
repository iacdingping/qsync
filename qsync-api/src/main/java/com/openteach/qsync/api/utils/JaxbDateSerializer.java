package com.openteach.qsync.api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JaxbDateSerializer extends XmlAdapter<String, Date> {

	
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
    @Override  
    public String marshal(Date date) throws Exception {  
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
    }  
  
    @Override  
    public Date unmarshal(String date) throws Exception {  
    	return new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(date);
    }
}
