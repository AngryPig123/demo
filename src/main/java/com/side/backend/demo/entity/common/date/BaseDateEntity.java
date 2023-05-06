package com.side.backend.demo.entity.common.date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

//  모든 컬럼에 들어갈 수 있는 created, updated 날짜 필드를 셋팅한다.
@MappedSuperclass
public abstract class BaseDateEntity {


    @Column(name = "created_date", updatable = false)
    protected LocalDateTime createDateTime;

    @Column(name = "updated_date", updatable = true)
    protected LocalDateTime updateDateTime;

    @PrePersist
    protected void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createDateTime = now;
        updateDateTime = now;
    }

    @PreUpdate
    protected void preUpdate() {
        updateDateTime = LocalDateTime.now();
    }

}
