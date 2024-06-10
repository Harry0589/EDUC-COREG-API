package ca.bc.gov.educ.api.coreg.model.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "CRSE_COURSES" , schema = "COREG")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoursesEntity {
  @Id
  @Column(name = "CRS_ID", unique = true, updatable = false)
  private String courseID;
  @Basic
  @Column(name = "SIF_SUBJECT_CHAR_ID")
  private String sifSubjectCode;
  @Basic
  @Column(name = "COURSE_TITLE")
  private String courseTitle;
  @PastOrPresent
  @Column(name = "START_DATE")
  private LocalDateTime startDate;
  @Basic
  @Column(name = "END_DATE")
  private LocalDateTime endDate;
  @Basic
  @Column(name = "COURSE_CATEGORY_CHAR_ID")
  private String courseCategory;
  @Basic
  @Column(name = "PROGRAM_GUIDE_TITLE")
  private String programGuideTitle;

  @Basic
  @Column(name = "LANGUAGE_TYPE_CHAR_ID")
  private String instructionLanguage;

  @Basic
  @Column(name = "EXTERNAL_INDICATOR")
  private String externalIndicator;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "coursesEntity", fetch = FetchType.EAGER, cascade = CascadeType.DETACH, targetEntity = CourseCodeEntity.class)
  private Set<CourseCodeEntity> courseCode;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "charID", fetch = FetchType.EAGER, cascade = CascadeType.DETACH, targetEntity = CourseCharacteristicsEntity.class)
  private Set<CourseCharacteristicsEntity> courseCharacteristics;
}
