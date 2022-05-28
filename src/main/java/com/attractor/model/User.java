package com.attractor.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString
@Builder
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Size(min = 1, max = 25)
    @Column(length = 25)
    private String email;

    @NotBlank
    @Size(min = 8, max = 25)
    @Column(length = 25)
    private String password;

    @NotBlank
    @Size(min = 1, max = 25)
    @Column(length = 25)
    private String fullname;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @NotBlank
    @Size(min = 1, max = 25)
    @Column(length = 25)
    private String role = "Developer";




}