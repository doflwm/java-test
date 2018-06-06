package app.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class DeployBaseController {
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
    				}
    		, method = {RequestMethod.GET, RequestMethod.POST})
    public String process(@RequestBody String in) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	String uri = request.getRequestURI().toString();
    	getLogger().info(getTag() + "[" + uri + "]:" + in);
    	return ("OK");
    }

    @RequestMapping(
    		value= {"/**"}
    		, method = {RequestMethod.GET, RequestMethod.POST})
    public String warn(@RequestBody String in) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	String uri = request.getRequestURI().toString();
    	getLogger().warn(getTag() + "[" + uri + "]:" + in);
    	return ("OK");
    }

}
