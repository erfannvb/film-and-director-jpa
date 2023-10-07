package nvb.dev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nvb.dev.base.entity.BaseEntity;

@Entity
@Table(name = "tbl_director")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Director extends BaseEntity<Long> {

    @NotNull(message = "firstName must not be null")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "lastName must not be null")
    @Column(name = "last_name")
    private String lastName;

}
