package rugal.sample.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rugal.sample.core.entity.CacheCheckResponse;
import rugal.sample.core.entity.UpdateElement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;

@Controller
@RequestMapping("/sessiontest")
public class SessionCacheCheck {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CacheCheckResponse> checkCache(HttpServletRequest request) {
    HttpSession session = request.getSession();
    CacheCheckResponse response = (CacheCheckResponse) session.getAttribute("updates");
		if (response == null) {
			response = new CacheCheckResponse();
		}
		UpdateElement newElement = new UpdateElement(Instant.now().toEpochMilli(), request.getRequestURL().toString());
		response.setCurrentUrl(newElement.getRequestUrl());
		response.setCurrentTimestamp(newElement.getRequestTimestamp());
		response.addUpdateElement(newElement);
		session.setAttribute("updates", response);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		return ResponseEntity.ok().headers(headers).body(response);
	}
	
}
