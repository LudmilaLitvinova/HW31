package com.example.hw31.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ludmila Litvinova on 09.02.23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;

    private String name;

    private Integer cost;

}
