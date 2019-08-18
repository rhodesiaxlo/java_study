package com.lsx.utils;

import com.lsx.domain.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        // 异常处理类

        SysException syse = null;
        if( e instanceof SysException) {
            syse = (SysException)e;
        } else {
            // 处理所有异常
            syse = new SysException(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("excep");
        mv.addObject("msg", e.getMessage());
        return mv;
    }
}
