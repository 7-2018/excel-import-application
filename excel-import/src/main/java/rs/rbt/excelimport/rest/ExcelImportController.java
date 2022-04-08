package rs.rbt.excelimport.rest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.rbt.excelimport.dto.UsedVacationDatesDto;
import rs.rbt.excelimport.dto.VacationYearDto;
import rs.rbt.excelimport.model.ApiResponseModel;
import rs.rbt.excelimport.service.UsedVacationDatesService;
import rs.rbt.excelimport.service.VacationYearService;
import rs.rbt.excelimport.util.CSVParseUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The Excel import controller.
 */
@RestController
@RequestMapping("/api/v1/excel-import")
public class ExcelImportController {

    @Resource
    private UsedVacationDatesService usedVacationDatesService;

    @Resource
    private VacationYearService vacationYearService;

    /**
     * Used vacation dates csv response entity.
     *
     * @param usedVacationDatesCSV the used vacation dates csv
     * @return the response entity
     */

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully parsed CSV",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponseModel.class))}),
            @ApiResponse(responseCode = "400", description = "Error while parsing CSV",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponseModel.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized request",
                    content = @Content)})
    @PostMapping(path = "/used-vacation-dates",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> usedVacationDatesCSV(@RequestPart MultipartFile usedVacationDatesCSV) {
        List<UsedVacationDatesDto> usedVacationDatesDto = CSVParseUtils.parseUsedVacationDatesCSV(usedVacationDatesCSV);
        if (!usedVacationDatesService.saveUsedVacationDates(usedVacationDatesDto)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponseModel(Timestamp.valueOf(LocalDateTime.now()),
                            400, "/api/v1/excel-import", "Error while parsing CSV"));
        }
        return ResponseEntity.ok(new ApiResponseModel(Timestamp.valueOf(LocalDateTime.now()),
                200, "/api/v1/excel-import", "Successfully parsed CSV"));
    }

    /**
     * Vacation year csv response entity.
     *
     * @param vacationYearCSV the vacation year csv
     * @return the response entity
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully parsed CSV",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponseModel.class))}),
            @ApiResponse(responseCode = "400", description = "Error while parsing CSV",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponseModel.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized request",
                    content = @Content)})
    @PostMapping(path = "/vacation-year",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> vacationYearCSV(@RequestPart MultipartFile vacationYearCSV) {
        List<VacationYearDto> vacationYearDto = CSVParseUtils.parseVacationYearCSV(vacationYearCSV);
        if (!vacationYearService.saveVacationYear(vacationYearDto)) {
            return ResponseEntity.badRequest().body(
                    new ApiResponseModel(Timestamp.valueOf(LocalDateTime.now()),
                            400, "/api/v1/excel-import", "Error while parsing CSV"));
        }
        return ResponseEntity.ok(new ApiResponseModel(Timestamp.valueOf(LocalDateTime.now()),
                200, "/api/v1/excel-import", "Successfully parsed CSV"));
    }
}

