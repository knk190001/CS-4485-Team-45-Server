package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.components.IDatabase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class TestController {
    @Autowired
    private IDatabase database;

    private final Log logger = LogFactory.getLog(TestController.class);

    @GetMapping("/test")
    public String getData() {
        logger.info("Received request for data");
        return database.getData();
    }

}
