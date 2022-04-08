package rs.rbt.excelimport.service;

import org.springframework.stereotype.Service;
import rs.rbt.excelimport.dto.VacationYearDto;
import rs.rbt.excelimport.entity.VacationYear;
import rs.rbt.excelimport.repository.VacationYearRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VacationYearService {

    @Resource
    private VacationYearRepository vacationYearRepository;

    @Transactional
    public boolean saveVacationYear(List<VacationYearDto> vacationYearDto) {
        List<VacationYear> vacationYearEntities = toEntityList(vacationYearDto);
        for(VacationYear vacationYear:vacationYearEntities) {
            if(vacationYearRepository.existsByVacationYearCompositeKey(vacationYear.getVacationYearCompositeKey())){
                return false;
            }
        }
        vacationYearRepository.saveAll(vacationYearEntities);
        return true;
    }

    private List<VacationYear> toEntityList(List<VacationYearDto> vacationYearDTOs) {
        List<VacationYear> vacationYearEntities = new ArrayList<>();
        vacationYearDTOs.forEach(vacationYearDto -> vacationYearEntities.add(vacationYearDto.toEntity()));
        return vacationYearEntities;
    }

}
