package chapter1.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       // 因为引入了lombok，所以就不需要写getter和setter了
@AllArgsConstructor     // 有参构造
@NoArgsConstructor      // 无参构造
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
}
