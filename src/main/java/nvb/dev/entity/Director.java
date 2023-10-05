package nvb.dev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
