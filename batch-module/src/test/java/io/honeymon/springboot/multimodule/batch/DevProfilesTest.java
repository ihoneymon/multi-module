package io.honeymon.springboot.multimodule.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jiheon.kim on 2018. 7. 2.
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DevProfilesTest {
    @Autowired
    Environment env;

    @Test
    public void testBatchEnabled() {
        assertThat(env.getProperty("spring.batch.job.enabled")).isEqualTo("true");
    }

    @Test
    public void testDataSourceUrl() {
        assertThat(env.getProperty("spring.datasource.url")).isEqualTo("jdbc:h2:mem:multi-dev");
    }
}
