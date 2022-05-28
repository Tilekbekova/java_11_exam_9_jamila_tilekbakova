package com.attractor.dto;

import com.attractor.model.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class UserDto {

    private Long id;
    private String fullname;
    private String email;
    private String role;

    public static UserDto from(User user) {
        return builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }


}
