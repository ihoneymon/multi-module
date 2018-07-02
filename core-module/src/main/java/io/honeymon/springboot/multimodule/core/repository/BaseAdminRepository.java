package io.honeymon.springboot.multimodule.core.repository;

import io.honeymon.springboot.multimodule.core.entity.BaseAdmin;
import io.honeymon.springboot.multimodule.core.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jiheon.kim on 2018. 7. 2.
 */
public interface BaseAdminRepository<E extends BaseAdmin> extends JpaRepository<E, Long> {
}
