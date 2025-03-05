package io.github.nvbao.springiocexample.excercise_3.entity;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}
