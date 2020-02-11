package java8;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class UserInfo {
    private String name;
    private String email;

}
