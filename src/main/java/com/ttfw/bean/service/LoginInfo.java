package com.ttfw.bean.service;

import lombok.Data;

@Data
public class LoginInfo {

    private Long loginId;

    private Long userId;
    private boolean enableLogin;
    private Long permissionType;

}
