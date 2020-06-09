package ru.leovalter.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.leovalter.shop.HasId;

import javax.persistence.*;

@Data()
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractBaseEntity implements HasId {

    public static final int START_SEQUENCE = 1000;

    @Id
    @SequenceGenerator(name = "global_sequence", sequenceName = "global_sequence", allocationSize = 1, initialValue = START_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_sequence")
    protected Integer id;

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }
}
