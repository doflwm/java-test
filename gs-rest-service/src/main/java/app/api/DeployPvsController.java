package app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/pvs/v1")
public class DeployPvsController extends DeployBaseController {
    private static final Logger logger = LoggerFactory.getLogger(DeployPvsController.class);

	private static final String TAG = "PVS";
	
	protected Logger getLogger() {
		return logger;
	}

	protected String getTag() {
		return TAG;
	}
}
