package example;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "domain_entity")
public class DomainEntity {
    @EmbeddedId
    private OuterWrappingId id;

    private String name;

    private DomainEntity() {
        // Do nothing - required for Hibernate
    }

    public DomainEntity(InnerWrappingId artifactId, String name) {
        this();
        this.id = new OuterWrappingId(artifactId);
        this.name = name;
    }

    public OuterWrappingId getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}