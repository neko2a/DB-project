package org.fit.kaminskii.domain;

import lombok.Data;
import org.fit.kaminskii.converters.CategoryConverter;
import org.fit.kaminskii.converters.SexConverter;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.TeacherCategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "Teacher", schema = "public", catalog = "postgres")
public class TeacherEntity {
    @Id
    @GeneratedValue
    @Column(name = "teacher_code", nullable = false)
    private int teacherCode;
    @Basic
    @Column(name = "second_name", nullable = true, length = -1)
    private String secondName;
    @Basic
    @Column(name = "first_name", nullable = true, length = -1)
    private String firstName;
    @Basic
    @Column(name = "third_name", nullable = true, length = -1)
    private String thirdName;
    @Basic
    @Column(name = "teacher_category", nullable = true, length = -1)
    @Convert(converter = CategoryConverter.class)
    private TeacherCategory category;
    @Basic
    @Column(name = "sex", nullable = true, length = -1)
    @Convert(converter = SexConverter.class)
    private Sex sex;
    @Basic
    @Column(name = "birthday", nullable = true, length = -1)
    private Date birthday;
    @Basic
    @Column(name = "age", nullable = true, length = -1)
    private Integer age;
    @Basic
    @Column(name = "number_of_children", nullable = true, length = -1)
    private Integer numberOfChildren;
    @Basic
    @Column(name = "salary", nullable = true, length = -1)
    private BigDecimal salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherByScientificDirectorCode")
    private Collection<DiplomaEntity> diplomasByTeacherCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherCode")
    private Collection<GroupClassesEntity> groupClassesByTeacherCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherByTeacherCode")
    private Collection<StudentRecordEntity> studentRecordsByTeacherCode;
    @ManyToOne
    @JoinColumn(name = "Faculty", referencedColumnName = "faculty_name", insertable = false, updatable = false)
    private FacultyEntity faculty;
    @ManyToOne
    @JoinColumn(name = "the_department", referencedColumnName = "the_department_name", insertable = false, updatable = false)
    private TheDepartmentEntity theDepartment;
    @ManyToOne
    @JoinColumn(name = "Doctoral", referencedColumnName = "doctoral_name", insertable = false, updatable = false)
    private DoctoralEntity doctoral;
    @ManyToOne
    @JoinColumn(name = "Candidate", referencedColumnName = "candidate_name", insertable = false, updatable = false)
    private CandidateEntity candidate;
}