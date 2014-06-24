package com.openteach.qsync.api.goods.response.secondery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.XmlResponse;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class PersonalGoodsSeconderyResponse extends XmlResponse {

}
