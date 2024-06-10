package ca.bc.gov.educ.api.coreg.service.v1;

import java.util.Optional;

import ca.bc.gov.educ.api.coreg.repository.v1.CourseInformationRepository;
import ca.bc.gov.educ.api.coreg.model.v1.CoursesEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseInformationService {

    private final CourseInformationRepository courseInformationRepository;

    public CourseInformationService(CourseInformationRepository courseInformationRepository) {
        this.courseInformationRepository = courseInformationRepository;
    }

    public Optional<CoursesEntity> getCourseInformation(String courseID) {
        return courseInformationRepository.findById(courseID);

    }
}
