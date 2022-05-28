package com.attractor.controller;

import com.attractor.dto.TaskAdd;
import com.attractor.model.Task;
import com.attractor.model.Worklogs;
import com.attractor.repository.TaskRepository;
import com.attractor.repository.TimeRepository;
import com.attractor.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.WebContext;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class TaskController {
    private final TaskService service;
    private final TaskRepository repository;
    private final TimeRepository timeRepository;

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/task")
    public String Task(Model model) {
        if (!model.containsAttribute("dto")) {

            model.addAttribute("dto", new TaskAdd());
        }

        return "Task";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/task")
    public String addBasket(
            @RequestParam(required = false) Long user,
                            @Valid TaskAdd taskAdd,
                            Model attributes,

                            BindingResult validationResult
                            ) {
        if (validationResult.hasFieldErrors()) {
            attributes.addAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/task";
        }
        var TaskAdd1 = service.addTask(user, taskAdd);
        attributes.addAttribute("dto", TaskAdd1);


        return "redirect:/task";
    }


    @GetMapping("/showTask")
    public String findTask(Model model, Principal principal
    , @RequestParam(required = false,defaultValue = "") String status,
                           @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
      List<Task> tasks;

        if (status != null && !status.isEmpty()) {
            tasks = repository.findByStatusOrderById(status);
        } else {
            tasks = repository.find(principal.getName());
        }
        var find = timeRepository.finds(principal.getName());
        model.addAttribute("find",find);
        model.addAttribute("dto", tasks);
        model.addAttribute("status", status);

        return "TaskS";
    }



    @GetMapping("/")
    public String main(Model model,
                       @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
                       @RequestParam(required = false,defaultValue = "") String status
    ) {
        Page<Task> page;
        if (status != null && !status.isEmpty()) {
            page = repository.findByStatusOrderById(status,pageable);
        } else {
            page = repository.findAllBy(pageable);
        }
        model.addAttribute("status",status);
        model.addAttribute("pageable",pageable);
        model.addAttribute("dto", page.getContent());
        return "product";
    }


    @GetMapping("/change/{id}")
    public String change(Model model,
                         @PathVariable() Long id,

                         Principal principal
    ) {
       var change = service.changeTask(principal.getName(), id);

        model.addAttribute("products", change);

        model.addAttribute("products", change);
        return "change";
    }


    @GetMapping("/time/{name}")
    public String mains(
        Model model,
        @PathVariable() String name,
        @RequestParam(required = false,defaultValue = "") String description,
        Principal principal
    ) {
            var change = service.time(principal.getName(),description,name);

            model.addAttribute("products", change);

            return "time";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/show")
    public String show(Model model,
                       @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
                       @RequestParam(required = false,defaultValue = "") String status
    ) {
        Page<Task> page;
        if (status != null && !status.isEmpty()) {
            page = repository.findByStatusOrderById(status,pageable);
        } else {
            page = repository.findAllBy(pageable);
        }
        model.addAttribute("status",status);
        model.addAttribute("pageable",pageable);
        model.addAttribute("dto", page.getContent());
        return "show";
    }


    @RequestMapping(value = "/details/pdf", method = RequestMethod.GET)
    public ModelAndView showPriceInPDF(Model model,
                                       Pageable pageable,
                                       @RequestParam(required = false,defaultValue = "") String status) {

        Page<Task> page;
        if (status != null && !status.isEmpty()) {
            page = repository.findByStatusOrderById(status,pageable);
        } else {
            page = repository.findAllBy(pageable);
        }
        model.addAttribute("status",status);
        model.addAttribute("pageable",pageable);
        model.addAttribute("dto", page.getContent());

        return new ModelAndView("pdfView", "phonesList",  page);
    }


}
