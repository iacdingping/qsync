package com.openteach.qsync.api.goods.response.secondery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.openteach.qsync.api.CommonXmlResponseHead;
import com.openteach.qsync.api.XmlResponse;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="mo")
@XmlType(name = "mo", propOrder = {"head", "body"})
public class PersonalGoodsSeconderyResponse extends XmlResponse {
	@XmlElement(required = true)
	private CommonXmlResponseHead head;
	@XmlElement(required = true)
	private GoodsSeconderyResponseBody body;
	public CommonXmlResponseHead getHead() {
		return head;
	}
	public void setHead(CommonXmlResponseHead head) {
		this.head = head;
	}
	public GoodsSeconderyResponseBody getBody() {
		return body;
	}
	public void setBody(GoodsSeconderyResponseBody body) {
		this.body = body;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "body")
	public static class GoodsSeconderyResponseBody {
		@XmlElement(required = true)
		private JkfSign jkfSign;
		
		@XmlElement(required = true)
		private JkfGoodsDeclar jkfGoodsDeclar;
		
		public JkfSign getJkfSign() {
			return jkfSign;
		}
		public void setJkfSign(JkfSign jkfSign) {
			this.jkfSign = jkfSign;
		}
		public JkfGoodsDeclar getJkfGoodsDeclar() {
			return jkfGoodsDeclar;
		}
		public void setJkfGoodsDeclar(JkfGoodsDeclar jkfGoodsDeclar) {
			this.jkfGoodsDeclar = jkfGoodsDeclar;
		}
		
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "jkfSign")
	public static class JkfSign {
		@XmlElement(required = true)
		private String companyCode;
		@XmlElement(required = true)
		private String businessNo;
		public String getCompanyCode() {
			return companyCode;
		}
		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}
		public String getBusinessNo() {
			return businessNo;
		}
		public void setBusinessNo(String businessNo) {
			this.businessNo = businessNo;
		}
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "jkfGoodsDeclar")
	public static class JkfGoodsDeclar {
		@XmlElement(required = true)
		private String personalGoodsFormNo;
		@XmlElement(required = true)
		private Integer approveResult;
		@XmlElement(required = true)
		private String approveComment;
		@XmlElement(required = true)
		private String processTime;
		public String getPersonalGoodsFormNo() {
			return personalGoodsFormNo;
		}
		public void setPersonalGoodsFormNo(String personalGoodsFormNo) {
			this.personalGoodsFormNo = personalGoodsFormNo;
		}
		public Integer getApproveResult() {
			return approveResult;
		}
		public void setApproveResult(Integer approveResult) {
			this.approveResult = approveResult;
		}
		public String getApproveComment() {
			return approveComment;
		}
		public void setApproveComment(String approveComment) {
			this.approveComment = approveComment;
		}
		public String getProcessTime() {
			return processTime;
		}
		public void setProcessTime(String processTime) {
			this.processTime = processTime;
		}
	}
}
