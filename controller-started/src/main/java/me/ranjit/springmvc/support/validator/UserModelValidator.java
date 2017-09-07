package me.ranjit.springmvc.support.validator;

import me.ranjit.springmvc.model.UserModel;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by suzh on 8/30/2017.
 */
public class UserModelValidator implements Validator {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z]\\w{4,19}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]{5,20}");
    private static final Set<String> FORBINDDEN_WORD_SET = new HashSet<String>();
    static {
        FORBINDDEN_WORD_SET.add("fuc k"); //删掉空格
        FORBINDDEN_WORD_SET.add("admin");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class == clazz;//表示只对UserModel类型的目标对象实施验证
    }
    @Override
    public void validate(Object target, Errors errors) {

        //表示如果目标对象的username属性数据为空，则添加它的错误码；
        //内部通过（value == null || !StringUtils.hasLength(value.toString())）实现判断value是否为空，从而简化代码。
        ValidationUtils.rejectIfEmpty(errors, "username", "username.not.empty");

        UserModel user = (UserModel) target;

        if(!USERNAME_PATTERN.matcher(user.getUsername()).matches()) {
            errors.rejectValue("username", "username.not.illegal");//如果用户名不合法
        }

        for(String forbiddenWord : FORBINDDEN_WORD_SET) {
            if(user.getUsername().contains(forbiddenWord)) {
                errors.rejectValue("username", "username.forbidden", new Object[]{forbiddenWord}, "您的用户名包含非法关键词");//用户名包含屏蔽关键字
                break;
            }
        }
        if(!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
            errors.rejectValue("password","password.not.illegal", "密码不合法");//密码不合法
        }
    }
}
