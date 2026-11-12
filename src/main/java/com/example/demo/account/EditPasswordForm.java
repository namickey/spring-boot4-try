package com.example.demo.account;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditPasswordForm {

    @NotBlank
    @Length(max = 10)
    private String newPassword;

    @NotBlank
    @Length(max = 10)
    private String reNewPassword;

    @NotNull
    private Integer versionNo;

    @AssertTrue(message = "{ME001}")
    public boolean isSamePassword() {
        return newPassword != null && newPassword.equals(reNewPassword);
    }

    public Account toAccount() {
        Account account = new Account();
        BeanUtils.copyProperties(this, account);
        return account;
    }
}
