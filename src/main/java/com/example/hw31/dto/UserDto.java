package com.example.hw31.dto;

import com.example.hw31.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ludmila Litvinova on 09.02.23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String password;
    private UserRole userRole;
}
