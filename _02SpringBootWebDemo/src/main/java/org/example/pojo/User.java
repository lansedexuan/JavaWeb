package org.example.pojo;

import java.time.LocalDateTime;
import java.time.LocalTime;

@lombok.Data//get set
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}
