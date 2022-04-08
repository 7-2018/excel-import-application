package rs.rbt.excelimport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The type Api response model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseModel implements Serializable {

    private Timestamp timestamp;

    private int statusCode;

    private String route;

    private String message;
}
