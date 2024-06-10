package ca.bc.gov.educ.api.coreg.struct.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseCharacteristics implements Serializable {

    private String charID;

    private String charType;

    private String charCode;

    private String charDescription;

}
