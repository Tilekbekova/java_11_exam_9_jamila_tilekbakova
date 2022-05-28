package com.attractor.repository;

import com.attractor.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {


    @Query("select t FROM Task t inner join User u on t.user.id = u.id where u.email = :email")
    List<Task> find (String email);
    Page<Task> findAllBy(Pageable pageable);


    @Query("select t from Task t where t.name in :name")
    Optional<Task> findByName(String name);


    List<Task> findByStatusOrderById(String status);

    Page<Task> findByStatusOrderById(String status,Pageable pageable);
}
