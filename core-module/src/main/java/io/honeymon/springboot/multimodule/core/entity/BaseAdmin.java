package io.honeymon.springboot.multimodule.core.entity;


import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * @author jiheon.kim on 2018. 6. 29.
 */
@Getter
@Entity
@MappedSuperclass
public abstract class BaseAdmin extends AbstractPersistable<Long> {
    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;


}
