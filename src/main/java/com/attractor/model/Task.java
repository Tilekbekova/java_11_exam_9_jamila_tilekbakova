package com.attractor.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task_table")
@Getter
@Setter
@ToString
@Builder
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(length = 20)
   private String name;

   @Column(name = "dateAdd")
   private LocalDate localDate;

   @ManyToOne()
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JoinColumn(name = "user_id")
   private User user;


   @JoinColumn(name = "status")
   private String status;

}
