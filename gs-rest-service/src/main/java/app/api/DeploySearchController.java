package app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/search/v1")
public class DeploySearchController extends DeployBaseController {
    private static final Logger logger = LoggerFactory.getLogger(DeploySearchController.class);

	private static final String TAG = "SRC";
	
	protected Logger getLogger() {
		return logger;
	}

	protected String getTag() {
		return TAG;
	}
}
