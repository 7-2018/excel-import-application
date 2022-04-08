package rs.rbt.excelimport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.rbt.excelimport.entity.VacationYear;
import rs.rbt.excelimport.entity.VacationYearCompositeKey;

import java.io.Serializable;

/**
 * The Vacation year data transfer object.
 * References class{@linkplain VacationYear}
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VacationYearDto implements Serializable {

    private String employeeEmail;

    private int vacationYear;

    private int totalVacationDays;

    /**
     * Parses the data transfer object to Entity
     *
     * @return the parsed Entity
     */
    public VacationYear toEntity() {
        return VacationYear.builder()
                .vacationYearCompositeKey(
                        new VacationYearCompositeKey(employeeEmail, vacationYear))
                .totalVacationDays(totalVacationDays)
                .build();
    }
}
