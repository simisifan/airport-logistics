package com.atfcm.airportlogistics.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.atfcm.airportlogistics.common.Myexception.MyNullException;
import com.atfcm.airportlogistics.common.ResultInfo;
import com.atfcm.airportlogistics.mbg.bean.User;
import com.atfcm.airportlogistics.mbg.bean.UserRecipe;
import com.atfcm.airportlogistics.mbg.bean.UserSend;
import com.atfcm.airportlogistics.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.Socket;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    /**
    * 验证码生成
    * */
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //生成验证码图片
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        try {
            request.getSession().setAttribute("check", lineCaptcha.getCode());
            //告诉浏览器输出内容为图片
            response.setContentType("image/png");
            //禁止浏览器缓存
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            lineCaptcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户注册
     * @param user
     * @param request
     * @param info
     * @return
     * @throws MyNullException
     */
    @ResponseBody
    @PostMapping("/user")
    public ResultInfo info(User user, HttpServletRequest request, ResultInfo info, @RequestParam("check") String userCheck) throws MyNullException {
        HttpSession session = request.getSession();
        //获取session中的验证码
        String Sessioncheck = (String) session.getAttribute("check");
        //获取用户验证码
        //检查验证码
        if(userCheck==null || ("").equals(userCheck.trim())){
                throw new MyNullException();
        }
        //1.验证码正确
        if(Sessioncheck.equalsIgnoreCase(userCheck)){
            session.removeAttribute("check");
            boolean registed = userService.regist(user);
            //2.注册成功
            if(registed){
                info.setFlag(true);
            }else {
                //注册失败
                info.setFlag(false);
                info.setErrorMsg("用户名已存在");
            }
        }else {//3.验证码错误
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        }

        return info;
    }



    /**
     * 用户登录
    * */
    @ResponseBody
    @PostMapping("/user/login")
    public ResultInfo logInfo(ResultInfo resultInfo,User user,HttpServletRequest request){
        //1.登陆,成功后设置isLogin : plain_user  session属性
        Boolean login = userService.login(user,request);
        if(login){
            resultInfo.setFlag(true);
        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码错误");
        }
        return resultInfo;
    }


    @ResponseBody
    @PostMapping("/user/send")
    public ResultInfo info(UserSend userSend,UserRecipe userRecipe){
        System.out.println(userSend);
        System.out.println(userRecipe);
        return null;
    }
}
