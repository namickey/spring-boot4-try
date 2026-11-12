package com.example.demo.account;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditPasswordForm {
    
    @NotBlank
    @Length(max=10)
    private String newPassword;
    
    @NotBlank
    @Length(max=10)
    private String reNewPassword;
    
    @NotNull
    private Integer versionNo;
}
