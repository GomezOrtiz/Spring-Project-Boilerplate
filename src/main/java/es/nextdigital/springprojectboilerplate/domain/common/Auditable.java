package es.nextdigital.springprojectboilerplate.domain.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad abstracta que define
 * los campos de auditoría de una
 * entidad auditable
 */
@Data
@MappedSuperclass
public abstract class Auditable {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "created_at")
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    private LocalDateTime createdAt;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "updated_at")
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
