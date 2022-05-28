package com.attractor.dto;

import com.attractor.model.Status;
import com.attractor.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TaskAdd {
    private Long id;
    private String name;
    private LocalDate localDate;
    private User user;
    private String status;
}
