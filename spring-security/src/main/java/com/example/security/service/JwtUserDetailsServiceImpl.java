package com.example.security.service;



import com.example.domain.MyUser;
import com.example.security.entity.JwtUser;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 根据用户名查询数据库，返回JwtUser对象
 * 用户名，昵称，密码，头像，角色
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser user = userService.selectByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }

        String role = user.getRole();
        return new JwtUser(user.getUserName(),user.getNickName(), user.getPassword(), user.getAvatar(),AuthorityUtils.commaSeparatedStringToAuthorityList(role));
    }
}
