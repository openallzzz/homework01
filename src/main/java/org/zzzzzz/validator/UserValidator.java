package org.zzzzzz.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.zzzzzz.pojo.User;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmpty(errors, "username", "user.username.required");
        if (user.getId().length() < 3 || user.getId().length() > 12) {
            errors.rejectValue("id", "id.invalid");
        }

        if (user.getAge() <= 10 || user.getAge() >= 150) {
            errors.rejectValue("age", "age.invalid");
        }

        if (!user.getSex().equals("男") && !user.getSex().equals("女")) {
            errors.rejectValue("sex", "sex.invalid");
        }
    }
}
