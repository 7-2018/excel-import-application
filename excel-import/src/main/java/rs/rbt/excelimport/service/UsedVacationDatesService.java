package rs.rbt.excelimport.service;

import org.springframework.stereotype.Service;
import rs.rbt.excelimport.dto.UsedVacationDatesDto;
import rs.rbt.excelimport.entity.UsedVacationDates;
import rs.rbt.excelimport.repository.UsedVacationDatesRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsedVacationDatesService {

    @Resource
    private UsedVacationDatesRepository usedVacationDatesRepository;

    @Transactional
    public boolean saveUsedVacationDates (List<UsedVacationDatesDto> usedVacationDatesDto){
        List<UsedVacationDates> usedVacationDatesEntities = toEntityList(usedVacationDatesDto);
        for(UsedVacationDates usedVacationDates:usedVacationDatesEntities) {
            if(usedVacationDatesRepository.existsByUsedVacationDatesCompositeKey(
                    usedVacationDates.getUsedVacationDatesCompositeKey())){
                return false;
            }
        }
        usedVacationDatesRepository.saveAll(usedVacationDatesEntities);
        return true;
    }

    private List<UsedVacationDates> toEntityList(List<UsedVacationDatesDto> usedVacationDatesDTOs) {
        List<UsedVacationDates> usedVacationDatesEntities = new ArrayList<>();
        usedVacationDatesDTOs.forEach(usedVacationDatesDto -> usedVacationDatesEntities.add(usedVacationDatesDto.toEntity()));
        return usedVacationDatesEntities;
    }
}
