package rugal.sample.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;

@Controller
@RequestMapping("/sessiontest")
public class SessionCacheCheck {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity checkCache(HttpServletRequest request) {
    HttpSession session = request.getSession();
    StringBuilder response = new StringBuilder();
		Instant current = Instant.now();
    response
		    .append("{\"Current Timestamp\": ")
		    .append(current.toEpochMilli())
		    .append(",");
		response
				.append("\"Current ID\": \"")
				.append(request.getRequestURL())
				.append("\",");
		response
				.append("\"Last Update Timestamp\": ")
				.append(session.getAttribute("timestamp"))
				.append(",");
		response
				.append("\"Last Server ID\": \"")
				.append(session.getAttribute("serverName"))
				.append("\"}");
    session.setAttribute("timestamp", current.toEpochMilli());
    session.setAttribute("serverName", request.getRequestURL());
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity retVal = ResponseEntity.ok().headers(headers).body(response);
    return retVal;
	}
	
}
