package com.example.demo.account;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.example.demo.core.validator.CharTypes;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;

public record EditPasswordForm(

        @NotBlank @Length(min = 2, max = 10) @CharTypes @ToString.Exclude String newPassword,

        @NotBlank @Length(min = 2, max = 10) @CharTypes @ToString.Exclude String reNewPassword,

        @NotNull Integer versionNo

) {
    @AssertTrue(message = "{ME001}")
    public boolean isSamePassword() {
        return newPassword != null && newPassword.equals(reNewPassword);
    }

    public Account toAccount() {
        Account account = new Account();
        BeanUtils.copyProperties(this, account);
        account.setPassword(newPassword);
        return account;
    }
}
