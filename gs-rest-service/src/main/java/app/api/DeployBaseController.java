package app.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class DeployBaseController {
    private static final Logger contentLogger = LoggerFactory.getLogger("ContentLogger");
    
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
    	
    	contentLogger.info(uri.substring(uri.indexOf("/v1")));
    	contentLogger.info(in);
    	
    	return ("OK");
    }

    @RequestMapping(
    		value= {"/**"}
    		, method = {RequestMethod.GET, RequestMethod.POST})
    public String warn(@RequestBody String in) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	String uri = request.getRequestURI().toString();
    	getLogger().warn(getTag() + "[" + uri + "]:" + in);
    	
    	contentLogger.info(uri.substring(uri.indexOf("/v1")));
    	contentLogger.info(in);
    	
    	return ("OK");
    }

}
