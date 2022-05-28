package com.attractor.dto;

import com.attractor.model.Status;
import com.attractor.model.Task;
import com.attractor.model.User;
import lombok.*;

import java.time.LocalDate;
import java.util.stream.DoubleStream;

@Data
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskDto {

        private Long id;
        private String name;
        private LocalDate localDate;
        private User user;
        private String status;

        public static com.attractor.dto.TaskDto from(Task task) {
            return builder()
                    .id(task.getId())
                    .user(task.getUser())
                    .localDate(task.getLocalDate())
                    .status(task.getStatus())
                    .build();
        }


    }

