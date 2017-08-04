package me.demo;

import lombok.*;

/**
 * author: Flyli
 * date: 2017/7/24
 * description:
 */
@Data
@NoArgsConstructor(staticName = "instance")
@Builder()
@AllArgsConstructor(staticName = "instance")
public class User {
    private String name;
    private String password;
    private int age;

    public void salt(@NonNull String salt) {
        this.password = password + salt;
    }
}
