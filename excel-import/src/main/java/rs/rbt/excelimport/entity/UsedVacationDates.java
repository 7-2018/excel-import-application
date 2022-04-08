package rs.rbt.excelimport.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Entity Used vacation dates.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="USED_VACATION_DATES")
public class UsedVacationDates implements Serializable {

    @EmbeddedId
    private UsedVacationDatesCompositeKey usedVacationDatesCompositeKey;

    @Column(name="VACATION_END_DATE")
    private LocalDate vacationEndDate;
}
