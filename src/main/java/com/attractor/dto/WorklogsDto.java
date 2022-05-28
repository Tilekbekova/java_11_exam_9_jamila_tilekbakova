package com.attractor.dto;

import com.attractor.model.Task;
import com.attractor.model.User;
import com.attractor.model.Worklogs;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class WorklogsDto {
    private Long id;
    private  LocalTime localTime;
    private String description;
    private Task task;
    private User user;

    public static WorklogsDto from(Worklogs worklogs) {
        return builder()
                .id(worklogs.getId())
                .description(worklogs.getDescription())
                .localTime(worklogs.getLocalTime())
                .task(worklogs.getTask())
                .user(worklogs.getUser())
                .build();
    }

}
