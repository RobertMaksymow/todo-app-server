package tech.outatime.todoappserver.entities;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "todos_all")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id1", nullable = false)
    private Long id1;

    @Column(name = "id")
    private Long id;

    @Column(name = "todo")
    private String todo;

    @Column(name = "is_completed")
    private Boolean is_completed;

    @Column(name = "priority")
    private Integer priority;
}