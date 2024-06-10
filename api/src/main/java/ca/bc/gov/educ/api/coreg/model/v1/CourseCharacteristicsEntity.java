package ca.bc.gov.educ.api.coreg.model.v1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
@Table(name = "CRSE_CHARACTERISTICS" , schema = "COREG")
public class CourseCharacteristicsEntity {

    @Id
    @ManyToOne(optional = true, targetEntity = CoursesEntity.class)
    @JoinColumn(name = "CHAR_ID", insertable=false, updatable=false)
    String charID;

    @Basic
    @Column(name = "CHAR_TYPE")
    private String charType;

    @Basic
    @Column(name = "CODE")
    private String charCode;

    @Basic
    @Column(name = "DESCRIPTION")
    private String charDescription;


}
