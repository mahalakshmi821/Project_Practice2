package com.Project_practice.demo_Practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponce {

       private Long id;
       private String name;
       private String gender;
       private String rollno;
       

}
