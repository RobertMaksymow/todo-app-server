package tech.outatime.todoappserver.entities;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "todo")
public class Todo {
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private Boolean completed;

}