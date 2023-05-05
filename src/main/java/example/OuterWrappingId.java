package example;

import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Composite class to hold the ArtifactId and embedded type information.
 */
@Embeddable
public class OuterWrappingId {
    private InnerWrappingId artifactId;
    private String idType;

    public static OuterWrappingId of(InnerWrappingId id) {
        return new OuterWrappingId(id);
    }

    private OuterWrappingId() {
        // For Hibernate
    }

    public OuterWrappingId(InnerWrappingId artifactId) {
        this();
        this.artifactId = artifactId;
        this.idType = artifactId.getClass().getSimpleName();
    }

    public String getIdType() {
        return idType;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof OuterWrappingId other && Objects.equals(artifactId, other.artifactId) && Objects.equals(idType, other.idType);
    }
}
