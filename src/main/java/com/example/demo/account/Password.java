package com.example.demo.account;

import lombok.Data;

@Data
public class Password {
    private String newPassword;
    private String reNewPassword;
    private Integer versionNo;
}
