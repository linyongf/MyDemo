package com.linyf.demo.lombok;

import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)
@ToString(exclude={"sex"})
@NoArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ArgsDemo {
    @NonNull private String name;
    private Integer age;
    private Integer sex;
}
