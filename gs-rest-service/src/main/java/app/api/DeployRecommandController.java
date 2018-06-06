package app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/recommand/v1")
public class DeployRecommandController extends DeployBaseController {
    private static final Logger logger = LoggerFactory.getLogger(DeployRecommandController.class);

	private static final String TAG = "REC";
	
	protected Logger getLogger() {
		return logger;
	}

	protected String getTag() {
		return TAG;
	}
}
