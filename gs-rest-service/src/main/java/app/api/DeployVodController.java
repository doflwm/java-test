package app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/vod/v1")
public class DeployVodController extends DeployBaseController {
    private static final Logger logger = LoggerFactory.getLogger(DeployVodController.class);

	private static final String TAG = "VOD";
	
	protected Logger getLogger() {
		return logger;
	}

	protected String getTag() {
		return TAG;
	}
}
