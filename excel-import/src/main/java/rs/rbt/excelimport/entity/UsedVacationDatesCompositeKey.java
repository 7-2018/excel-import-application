package rs.rbt.excelimport.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Primary key for Used Vacation Dates Entity.
 * References class{@linkplain UsedVacationDates}
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class UsedVacationDatesCompositeKey implements Serializable {

    @Column(name="EMPLOYEE_EMAIL")
    private String employeeEmail;

    @Column(name="VACATION_START_DATE")
    private LocalDate vacationStartDate;
}
