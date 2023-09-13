package rugal.sample.core.entity;

public class UpdateElement {
	
	public UpdateElement(Long currentTimestamp, String currentUrl) {
		this.requestTimestamp = currentTimestamp;
		this.requestUrl = currentUrl;
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
	
	String requestUrl;
	
	Long requestTimestamp;
}
