package rs.rbt.excelimport.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The Entity Vacation year.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="VACATION_YEAR")
public class VacationYear implements Serializable {

    @EmbeddedId
    private VacationYearCompositeKey vacationYearCompositeKey;

    @Column(name="TOTAL_VACATION_DAYS")
    private int totalVacationDays;

}
