package com.attractor.repository;

import com.attractor.model.Task;
import com.attractor.model.Worklogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeRepository extends JpaRepository<Worklogs,Long> {
    @Query("select w FROM Worklogs w inner join User u on w.user.id = u.id where u.email = :email")
    List<Worklogs> finds (String email);

}
