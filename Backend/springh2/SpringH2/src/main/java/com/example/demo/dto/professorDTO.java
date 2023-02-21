package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class professorDTO {

        private int id;
        private String firstname;
        private String lastname;
        private String departmentName;
}