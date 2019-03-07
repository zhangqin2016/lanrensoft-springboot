package com.lanrensoft.api.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lanrensoft.common.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author zhangqin
 * @description:
 * @date 2019/3/7 23:40
 */
@Aspect
@Component
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());



    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws JsonProcessingException {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
        try {
            log.info("{} start request:{}", IPUtils.getIpAddr(request),requestURI);
            result = point.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
        }

        long time = System.currentTimeMillis() - beginTime;
        log.info("end request:{},耗时:{}毫秒",requestURI,time);
        return result;
    }
}
