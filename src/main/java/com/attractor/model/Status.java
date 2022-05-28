package com.attractor.model;

import lombok.*;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "status_table")
@Getter
@Setter
@ToString
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String status;
}
