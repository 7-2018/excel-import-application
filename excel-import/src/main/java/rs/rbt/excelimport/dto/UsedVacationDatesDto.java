package rs.rbt.excelimport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.rbt.excelimport.entity.UsedVacationDates;
import rs.rbt.excelimport.entity.UsedVacationDatesCompositeKey;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Used vacation dates data transfer object.
 * References class{@linkplain UsedVacationDates}
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsedVacationDatesDto implements Serializable {

    private String employeeEmail;

    private LocalDate vacationStartDate;

    private LocalDate vacationEndDate;

    /**
     * Parses the data transfer object to Entity
     *
     * @return the parsed Entity
     */
    public UsedVacationDates toEntity() {
        return UsedVacationDates.builder()
                .usedVacationDatesCompositeKey(
                        new UsedVacationDatesCompositeKey(employeeEmail, vacationStartDate))
                .vacationEndDate(vacationEndDate)
                .build();
    }
}
