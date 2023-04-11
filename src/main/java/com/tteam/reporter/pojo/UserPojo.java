package com.tteam.reporter.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPojo {
    private String email;
    private String password;
    private String nickname;
}
