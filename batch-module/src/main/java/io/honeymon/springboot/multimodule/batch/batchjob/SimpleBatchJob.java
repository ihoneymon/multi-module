package io.honeymon.springboot.multimodule.batch.batchjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author jiheon.kim on 2018. 7. 2.
 */
@Slf4j
@Component
public class SimpleBatchJob {
    @Value("${spring.batch.job.enabled}")
    private boolean batchJobEnabled;
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @PostConstruct
    public void setUp() {
       log.debug("Batch enabled? {}", batchJobEnabled);
       log.debug("Spring database url: {}", databaseUrl);
       log.info("BatchJob Enabled: {}, Spring Database URL: {}", batchJobEnabled, databaseUrl);
    }
}
