package ca.bc.gov.educ.api.coreg.controller.v1;

import ca.bc.gov.educ.api.coreg.endpoint.v1.CourseInformationAPIEndpoint;
import ca.bc.gov.educ.api.coreg.mapper.v1.CourseInformationMapper;
import ca.bc.gov.educ.api.coreg.service.v1.CourseInformationService;
import ca.bc.gov.educ.api.coreg.struct.v1.Courses;
import ca.bc.gov.educ.api.coreg.exception.EntityNotFoundException;
import ca.bc.gov.educ.api.coreg.exception.InvalidPayloadException;
import ca.bc.gov.educ.api.coreg.exception.errors.ApiError;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@Slf4j
public class CourseInformationAPIController implements CourseInformationAPIEndpoint {

  private static final CourseInformationMapper mapper = CourseInformationMapper.mapper;
  @Getter(AccessLevel.PRIVATE)
  private final CourseInformationService courseInformationService;

  @Autowired
  public CourseInformationAPIController(final CourseInformationService courseInformationService) {
    this.courseInformationService = courseInformationService;
  }


  private void validatePayload(Supplier<List<FieldError>> validator) {
    val validationResult = validator.get();
    if (!validationResult.isEmpty()) {
      ApiError error = ApiError.builder().timestamp(LocalDateTime.now()).message("Payload contains invalid data.").status(BAD_REQUEST).build();
      error.addValidationErrors(validationResult);
      throw new InvalidPayloadException(error);
    }
  }


  @Override
  public Courses getCourseInformation(String courseID) {
    var courseInfo = getCourseInformationService().getCourseInformation(courseID);
    if(courseInfo != null){
      return mapper.toStructure(courseInfo.get());
    }else{
      throw new EntityNotFoundException();
    }  }
}
