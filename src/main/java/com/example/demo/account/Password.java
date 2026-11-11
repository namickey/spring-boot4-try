package com.example.demo.account;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Password {
    @Length(max=10)
    @NotBlank
    private String newPassword;
    @Length(max=10)
    @NotBlank
    private String reNewPassword;
    @NotNull
    private Integer versionNo;
}
