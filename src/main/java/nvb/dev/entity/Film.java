package nvb.dev.entity;

import jakarta.persistence.*;
import lombok.*;
import nvb.dev.base.entity.BaseEntity;

@Entity
@Table(name = "tbl_film")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Film extends BaseEntity<Long> {

    private String title;

    private String language;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;

    private float rate;

    private int length;

}
