package com.example.controller;

import com.example.common.Result;
import com.example.common.StatusCode;
import com.example.domain.MyUser;
import com.example.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    // 根据名称来获取存放到spring容器中的对象
    // @Autowired 通过类型在spring 容器中查找对象
    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    // 设置可以访问该方法的用户的权限标识， 只有该用具有该标识权限， 才可以访问
    @PreAuthorize("hasAuthority('admin')")
    public String findAllUsers(){
        System.out.println("all users ");
        return "all Users ";
    }

    @RequestMapping("/add")
    public Result<String> add(@Valid @RequestBody MyUser user, BindingResult result){
        // 判断表单验证是否正确
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            StringBuilder sb = new StringBuilder();
            allErrors.forEach(error -> sb.append(error.getDefaultMessage() + " : " ));
            String mes = sb.toString();
            return new Result<String>(false, StatusCode.ERROR,mes);
        }

        boolean bo = userService.add(user);
        return bo ? new Result<String>(true, StatusCode.OK,"注册成功~~")
                : new Result<String>(false, StatusCode.ERROR,"注册失败~~~");
    }
}
