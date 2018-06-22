package app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/src/v1")
public class DeploySchController extends DeployBaseController {
    private static final Logger logger = LoggerFactory.getLogger(DeploySchController.class);

	private static final String TAG = "SCH";
	
	protected Logger getLogger() {
		return logger;
	}

	protected String getTag() {
		return TAG;
	}
}
