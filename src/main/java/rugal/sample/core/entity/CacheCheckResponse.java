package rugal.sample.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CacheCheckResponse implements Serializable {
	
	Long currentTimestamp;
	
	String currentUrl;
	
	String nodeId = System.getProperties().getProperty("jboss.node.name");
	
	public String getNodeId() {
		return nodeId;
	}
	
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public Long getCurrentTimestamp() {
		return currentTimestamp;
	}
	
	public void setCurrentTimestamp(Long currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	
	public List<UpdateElement> getUpdateElements() {
		return updateElements;
	}
	
	public void setUpdateElements(List<UpdateElement> updateElements) {
		this.updateElements = updateElements;
	}
	
	public void addUpdateElement(UpdateElement element) {
		this.updateElements.add(0, element);
	}
	
	List<UpdateElement> updateElements = new ArrayList<>();
	
}
