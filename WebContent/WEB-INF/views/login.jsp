<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
               <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>Insert title here</title> 
   <link rel="styleshete" href="">
   <script type="text/javascript" src="<%=basePath %>js/jquery-1.11.1.min.js"></script>
 <link href="<%=basePath %>bootstrap/css/bootstrap.css" rel="stylesheet">
  <link href="<%=basePath %>css/login.css"   rel="stylesheet">
   
 <script type="text/javascript" src="<%=basePath %>bootstrap/js/bootstrap.js"></script>
 <script type="text/javascript" src="<%=basePath %>js/bootstrap-validator/dist/js/bootstrapValidator.min.js"></script>
 <link href="<%=basePath %>js/bootstrap-validator/dist/css/bootstrapValidator.css"   rel="stylesheet">
 <script   type="text/javascript">
  
 $(function(){
	 
	 $('#loginForm').bootstrapValidator({
		 message:'默认错误提示信息',
		 feedbackIcons: {
             valid: 'glyphicon glyphicon-ok',//图标验证提示
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
         },
         fields: {
             username: {
                 validators: {
                     notEmpty: {
                         message: '用户名不能为空！'
                     }
                 }
             },
             password: {
                 validators: {
                     notEmpty: {
                         message: '密码不能为空！'
                     },
                     stringLength: {
                         min: 5,
                         max: 8,
                         message: '长度5-8位'
                     },
                     regexp: {
                         regexp: /^[a-zA-Z0-9_\.]{4,8}$/,
                         message: '密码为._a-zA-Z0-9字符5-8位长度'
                     },
                 }
             },
             authCode: {
                 validators: {
                     notEmpty: {
                         message: '验证码不能为空！'
                     },
                     //注意该验证码其他验证规则通过，则才发送ajax请求校验
                     remote: {
                         url: 'login.do?action=validateAuthCode',
                         message: '验证码错误',
                         type:"post",
                         //提交数据
                         data: function(validator) {
                             return {
                           	  authCode: $("#authCode").val()    
                             };
                          } 
                           

                         
                     }
                 }
             }   
         }
		 });
	 
 });
 //点击改变图片的值
 function changeCode(obj){
	 obj.src="authCodeControl.do?"+(new Date());
 }
 
 </script>
</head>
<body>
  <div class="container" style="width:300px">

     <form class="form-signin" id="loginForm" action="login.do?action=userLogin" method="post">
        <h2 class="form-signin-heading">网上报名平台</h2>
       
         <div class="form-group">
	        <label  >用户名</label>
	        <input type="text"  name="username" class="form-control" placeholder="请输入用户名"  requited autofocus>
        </div>
       
        <div class="form-group">
	        <label  >密码</label>
	        <input type="password" name="password" class="form-control" placeholder="请输入密码" >
        </div>
        <div class="form-group">
           <label>角色</label>
           <select class="form-control" style="width:120px;" name="role">
             <option value="101">考生</option>
             <option value="102">考务人员</option>
             <option value="103">系统管理员</option>
           </select>
        </div>
         
        <div class="form-group">
	        <label>验证码</label>
	        <input type="text"  id="authCode" name="authCode" class="form-control" placeholder="请输入验证码">
	        <img src="authCodeControl.do"  onclick="changeCode(this)"></img>
        </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" name="rememberMe"> 是否记住密码
          </label>
       </div>
       <div class="form-group">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
       <a href="examineeRegistControl.do?action=load" class="btn btn-lg btn-primary btn-block" type="button">注册</a>
       </div>
      </form> 
     

    </div> <!-- /container -->
</body>
</html>

