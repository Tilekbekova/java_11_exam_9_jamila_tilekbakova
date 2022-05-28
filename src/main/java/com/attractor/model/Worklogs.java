package com.attractor.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalTime;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workloqs_table")
@Getter
@Setter
@ToString
@Builder
public class Worklogs{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6,name = "dateAdd")
    LocalTime localTime;

    @Column(length = 50,name = "description")
    String description;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "task_id")
    private Task task;


    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

}
