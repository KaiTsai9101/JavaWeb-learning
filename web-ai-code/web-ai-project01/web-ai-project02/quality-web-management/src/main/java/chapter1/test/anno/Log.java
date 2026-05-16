package chapter1.test.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)     // 方法注解：表示此注解类只能用于方法
@Retention(RetentionPolicy.RUNTIME)         // 运行时注解：表示此注解类在运行时保留，运行结束后会被删除
public @interface Log {
}
