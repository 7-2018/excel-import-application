package rs.rbt.excelimport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.rbt.excelimport.entity.UsedVacationDates;
import rs.rbt.excelimport.entity.UsedVacationDatesCompositeKey;


/**
 * The interface Used vacation dates repository.
 */
@Repository
public interface UsedVacationDatesRepository extends CrudRepository<UsedVacationDates, Long> {
    /**
     * Exists by used vacation dates composite key method.
     *
     * @param primaryKey the primary key
     * @return the boolean result true if the primary key exists, else return false
     */
    boolean existsByUsedVacationDatesCompositeKey(UsedVacationDatesCompositeKey primaryKey);
}
