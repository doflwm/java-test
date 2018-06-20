package app.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public abstract class DeployBaseController {
    private static final Logger contentLogger = LoggerFactory.getLogger("ContentLogger");
    private static final Logger prettyLogger = LoggerFactory.getLogger("PrettyLogger");
    
	protected abstract Logger getLogger();
	protected abstract String getTag();

    @RequestMapping(
    		value= {
    				"info/asset"
    				, "info/superasset"
    				, "info/series"
    				, "info/category"
    				, "info/basecategory"
    				, "info/channel"
    				, "info/product"
    				, "info/channelSchedules"
    				, "info/basecategoryAndChildren"
    				}
    		, method = {RequestMethod.GET, RequestMethod.POST})
    public String process(@RequestBody String in) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	String uri = request.getRequestURI().toString();
    	getLogger().info(getTag() + "[" + uri + "]:" + in);
    	
    	String baseUrl = uri.substring(uri.indexOf("/v1"));

    	log(baseUrl, in);
    	logJson(baseUrl, in);
    	
    	return ("OK");
    }
    
    @RequestMapping(
    		value= {"/**"}
    		, method = {RequestMethod.GET, RequestMethod.POST})
    public String warn(@RequestBody String in) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	String uri = request.getRequestURI().toString();
    	getLogger().warn(getTag() + "[" + uri + "]:" + in);
    	
    	String baseUrl = uri.substring(uri.indexOf("/v1"));

    	log(baseUrl, in);
    	logJson(baseUrl, in);
    	
    	return ("OK");
    }

    protected void log(String baseUrl, String in) {
    	contentLogger.info(baseUrl);
    	contentLogger.info(in);
    }
    
    protected void logJson(String baseUrl, String json) {
    	JsonParser jp = new JsonParser();
    	JsonElement je = jp.parse(json);
    	
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String prettyJson = gson.toJson(je);

    	prettyLogger.info(baseUrl);
    	prettyLogger.info(prettyJson);
    }
}
