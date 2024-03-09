package com.deepmetis.sandwichordermanagement.config.aspects;

import com.deepmetis.sandwichordermanagement.config.annotations.HasRole;
import com.deepmetis.sandwichordermanagement.config.exceptions.BadRequestException;
import com.deepmetis.sandwichordermanagement.domain.entities.User;
import com.deepmetis.sandwichordermanagement.services.JwtService;
import com.deepmetis.sandwichordermanagement.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Component
@Aspect
@RequiredArgsConstructor
public class RoleAspect {

    private final JwtService tokenService;
    private final UserService userService;

    @Before("@annotation(hasRole)")
    public void verifyRole(JoinPoint joinPoint, HasRole hasRole) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Objects.requireNonNull(attributes);
        HttpServletRequest request = attributes.getRequest();
        String jwtToken = request.getHeader("Authorization").substring(7);
        String email = tokenService.extractUsername(jwtToken);
        User user = userService.findByEmail(email);
        String authority = user.getAuthorities().iterator().next().getAuthority();
        if (!Objects.equals(hasRole.value(), authority)) {
            throw new BadRequestException("You do not have the right permission");
        }
    }

}
