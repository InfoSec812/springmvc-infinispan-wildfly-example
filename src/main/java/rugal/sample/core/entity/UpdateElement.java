package rugal.sample.core.entity;

import java.io.Serializable;

public class UpdateElement implements Serializable {
	
	public UpdateElement(Long currentTimestamp, String currentUrl) {
		this.requestTimestamp = currentTimestamp;
		this.requestUrl = currentUrl;
		this.nodeId = System.getProperties().getProperty("jboss.node.name");
	}
	
	public String getRequestUrl() {
		return requestUrl;
	}
	
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
	public Long getRequestTimestamp() {
		return requestTimestamp;
	}
	
	public void setRequestTimestamp(Long requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}
	
	public String getNodeId() {
		return nodeId;
	}
	
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public Integer getCreatedStudent() {
		return createdStudent;
	}
	
	public void setCreatedStudent(Integer createdStudent) {
		this.createdStudent = createdStudent;
	}
	
	String requestUrl;
	
	Long requestTimestamp;
	
	String nodeId;
	
	Integer createdStudent;
}
