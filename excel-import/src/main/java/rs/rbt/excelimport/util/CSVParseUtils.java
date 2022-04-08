package rs.rbt.excelimport.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import rs.rbt.excelimport.dto.UsedVacationDatesDto;
import rs.rbt.excelimport.dto.VacationYearDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVParseUtils {

    private CSVParseUtils(){

    }

    public static List<VacationYearDto> parseVacationYearCSV(MultipartFile vacationYearCSV) {
            List<VacationYearDto> vacationYearDTOs = new ArrayList<>();
            List<CSVRecord> csvRecords = loadCSVRecords(vacationYearCSV);
            int vacationYear = Integer.parseInt(csvRecords.get(0).get(1));
            csvRecords.remove(0);
            csvRecords.remove(0);
            for (CSVRecord csvRecord : csvRecords) {
                VacationYearDto vacationYearDto = new VacationYearDto(
                        csvRecord.get(0),
                        vacationYear,
                        Integer.parseInt(csvRecord.get(1)));
                vacationYearDTOs.add(vacationYearDto);
            }
            return vacationYearDTOs;
    }

    public static List<UsedVacationDatesDto> parseUsedVacationDatesCSV(MultipartFile usedVacationDatesCSV) {
        List<UsedVacationDatesDto> usedVacationDatesDTOs = new ArrayList<>();
        List<CSVRecord> csvRecords = loadCSVRecords(usedVacationDatesCSV);
        csvRecords.remove(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        for (CSVRecord csvRecord : csvRecords) {
           UsedVacationDatesDto usedVacationDatesDto = new UsedVacationDatesDto(
                   csvRecord.get(0),
                   LocalDate.parse(csvRecord.get(1), formatter),
                   LocalDate.parse(csvRecord.get(2), formatter));

            usedVacationDatesDTOs.add(usedVacationDatesDto);
        }
        return usedVacationDatesDTOs;
    }

    private static List<CSVRecord> loadCSVRecords(MultipartFile csvFile){
        try (BufferedReader fileReader = new BufferedReader
                (new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8))){
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            return csvParser.getRecords();
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
