package com.attractor.service;

import com.attractor.advice.ResourceNotFoundException;
import com.attractor.dto.TaskAdd;
import com.attractor.dto.TaskDto;
import com.attractor.dto.WorklogsDto;
import com.attractor.model.Task;
import com.attractor.model.Worklogs;
import com.attractor.repository.TaskRepository;
import com.attractor.repository.TimeRepository;
import com.attractor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository repository;
    private final TimeRepository timeRepository;

    public TaskDto addTask(Long user, TaskAdd form) {
        var users = repository.findById(user)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with email = " + user));


        var task = Task.builder()
                .user(users)
                .localDate(LocalDate.now())
                .name(form.getName())
                .status(form.getStatus())
                .build();

       taskRepository.save(task);

        return TaskDto.from(task);
    }

    public List<TaskDto> findByEmail(String email) {
        return taskRepository.find(email)
                .stream()
                .map(TaskDto::from)
                .collect(Collectors.toList());
    }

    public TaskDto changeTask(String email,Long id) {
        var users = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with email = " + email));
        var task = taskRepository.findById(id);

        task.ifPresent(s -> {
            if(s.getStatus().equals("Backlog")) {
                s.setStatus("Progress");
            } else if (s.getStatus().equals("Progress")) {
                s.setStatus("Done");
            }


        });


        taskRepository.save(task.get());

        return TaskDto.from(task.get());
    }

    public WorklogsDto time(String email,String description,String name) {

        var task = taskRepository.findByName(name);
        var users = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with email = " + email));

        var time = Worklogs.builder()
                .task(task.get())
                .user(users)
                .description(description)
                .localTime(LocalTime.now())
                .build();
        timeRepository.save(time);
        return WorklogsDto.from(time);
    }

}
