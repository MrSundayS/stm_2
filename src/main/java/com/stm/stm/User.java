package com.stm.stm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime = LocalDateTime.now();
    private boolean status = false;
    @OneToMany
    @JoinTable(
            name = "user_to_tasks",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "task_Id")
    )
    private Set<Task> tasks = new HashSet<>();

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDateTime = registrationDateTime;
        this.status = status;
    }
}