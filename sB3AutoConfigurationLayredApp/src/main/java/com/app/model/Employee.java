package com.app.model;

import lombok.*;

/**
 * @author Saurabh Vaish
 * @Date 28-11-2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String email;
    private Double salary;
    private String job;

}
