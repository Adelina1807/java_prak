package org.prac327.minorscms.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teachers_courses",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"teacher_id", "course_id"})
        }
)
@Getter
@Setter
//@ToString
@NoArgsConstructor
public class Teachers2Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "teach_cour_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    @ToString.Exclude
    @NonNull
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", nullable = false)
    @ToString.Exclude
    @NonNull
    private Teacher teacher;
//
//    @OneToMany(mappedBy = "teachCour", fetch = FetchType.LAZY)
//    private List<Schedule> schedules;

    public Teachers2Courses(@NonNull Teacher teacher, @NonNull Course course) {
        this.teacher = teacher;
        this.course = course;
    }
}