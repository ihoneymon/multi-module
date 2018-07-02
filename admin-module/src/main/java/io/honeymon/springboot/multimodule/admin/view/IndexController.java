package io.honeymon.springboot.multimodule.admin.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

/**
 * @author jiheon.kim on 2018. 7. 2.
 */
@Slf4j
@Controller
public class IndexController {
    @Value("${spring.thymeleaf.cache}")
    private boolean thymeleafCache;
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @PostConstruct
    public void setUp() {
        log.debug("Batch enabled? {}", thymeleafCache);
        log.debug("Spring database url: {}", databaseUrl);
        log.info("BatchJob Enabled: {}, Spring Database URL: {}", thymeleafCache, databaseUrl);
    }

    @GetMapping("/")
    private String index() {
        return "index";
    }
}
