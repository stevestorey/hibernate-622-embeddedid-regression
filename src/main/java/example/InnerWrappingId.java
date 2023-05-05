package example;


import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class InnerWrappingId {
    private Long id;

    protected InnerWrappingId() {
        // For Hibernate
    }

    protected InnerWrappingId(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static InnerWrappingId of(Long id) {
        return new InnerWrappingId(id);
    }

    @Override
    public boolean equals(Object obj) {
    	return obj instanceof InnerWrappingId other && Objects.equals(other.id, id);
    }
}
