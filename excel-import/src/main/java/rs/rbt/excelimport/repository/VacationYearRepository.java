package rs.rbt.excelimport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.rbt.excelimport.entity.VacationYear;
import rs.rbt.excelimport.entity.VacationYearCompositeKey;

/**
 * The interface Vacation year repository.
 */
@Repository
public interface VacationYearRepository extends CrudRepository<VacationYear, Long> {
    /**
     * Exists by vacation year composite key method.
     *
     * @param primaryKey the primary key
     * @return the boolean result true if the primary key exists, else return false
     */
    boolean existsByVacationYearCompositeKey(VacationYearCompositeKey primaryKey);
}
