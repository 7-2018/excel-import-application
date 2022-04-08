package rs.rbt.excelimport.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The Primary key for Vacation year Entity.
 * References class{@linkplain VacationYear}
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class VacationYearCompositeKey implements Serializable {

    private static final long serialVersionUID = -1094155734587746418L;
    @Column(name="EMPLOYEE_EMAIL")
    private String employeeEmail;

    @Column(name="VACATION_YEAR")
    private int vacationYear;
}
