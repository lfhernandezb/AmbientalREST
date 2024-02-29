package cl.dsoft.ambiental.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
The annotations used are:
@Data: This annotation is from the Lombok library and is used to automatically generate getters and setters for all fields in the class, as well as implementations of toString(), equals(), and hashCode(). This reduces the amount of boilerplate code that needs to be written.

@AllArgsConstructor: This annotation is also from Lombok and generates a constructor that takes all of the fields in the class as arguments.

@NoArgsConstructor: This annotation is also from Lombok and generates a no-argument constructor.

@Builder: This annotation is also from Lombok and generates a builder pattern for the class, which provides a convenient way to create instances of the class with default or optional values for some fields.

@Entity: This annotation is from the Java Persistence API (JPA) and marks the class as an entity that can be persisted to a database.

@Table(name = "employees"): This annotation specifies the name of the table that corresponds to this entity in the database.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "finding_states")
public class FindingState {
    @Id
    @Column(name = "id_finding_state")
    private int id;
    private String description;
}
