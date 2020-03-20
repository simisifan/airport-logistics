# 机场物流管理系统

## 日志

- 数据库字段设计失败  username  自动生成javabean 属性名 username 

  - 应该修改username 为 user_name 这样自动生成时就是userName

    

- 一张表单不能有重名字段   ==修改!==

  

- 数据库设计失败三张表  phonenumber  应该设置为String 类型   ==修改!==

## 1.用户管理模块

### 1) URL映射



| URL         | 功能         | 请求方式 |
| ----------- | ------------ | -------- |
| /user       | 注册功能     | post     |
| /user/login | 登录功能     | post     |
|             |              |          |
| /user/send  | 发货表单接收 | post     |

### 2) 登录功能Service代码

```java
 /**
     * 登陆功能
     * */
    @Override
    public Boolean login(User user, HttpServletRequest request) {
        //1.检查用户名和密码是否正确
        Boolean login= userMapper.select(user).isEmpty() ? true: false;
       if(login){
           //2.用户名密码正确  session加入isLogin字段,设置true
           request.getSession().setAttribute("isLogin", "plain_user");
           return true;
       }else{
           return  false;
       }
    }
```

### 3)验证码生成代码



```java
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
```



### 4)用户注册功能代码

- controller

```java
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
            //注册
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
```

- service

  ```java
   @Transactional(rollbackFor = RuntimeException.class)
      public boolean regist(User user) {
          //1.判断用户名是否存在
          Boolean exist = userMapper.selectByUsername(user.getUsername())==null ? false: true;
  
          if(exist) {
              //2.存在失败
              return false;
          }else {
              //3.不存在插入
              userMapper.insertSelective(user);
          }
  
          return true;
      }
  ```

  

### 5)用户发送收货人表单













