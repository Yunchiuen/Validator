package com.example.validator.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "用戶名稱不能為空")
    @Size(min = 1, max = 20, message = "用户名稱必须是1-20")
    private String username;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_time;

    @PrePersist
    protected void onCreate() {
        create_time = new Date();
        update_time = new Date();
    }
}

