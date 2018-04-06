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
<title>报名注册</title>
 <script type="text/javascript" src="<%=basePath %>js/jquery-1.11.1.min.js"></script>
 
 <link href="<%=basePath %>bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript" src="<%=basePath %>bootstrap/js/bootstrap.js"></script>
 <link href="<%=basePath %>css/login.css" rel="stylesheet">
 
 <!-- bootstrap-validator -->
 <link href="<%=basePath %>js/bootstrap-validator/dist/css/bootstrapValidator.css" rel="stylesheet">
 <script type="text/javascript" src="<%=basePath %>js/bootstrap-validator/dist/js/bootstrapValidator.min.js"></script>
 
 
 
<script type="text/javascript" src="<%=basePath %>js/bootstrap-fileinput-master/js/fileinput.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap-fileinput-master/js/locales/zh.js"></script>
<link type="text/css" rel="stylesheet" href="<%=basePath %>js/bootstrap-fileinput-master/css/fileinput.css" />
  
<!--   日期控件 -->
<script type="text/javascript" src="<%=basePath %>bootstrap/bootstrap-datatimePicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=basePath %>bootstrap/bootstrap-datatimePicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<link href="<%=basePath %>bootstrap/bootstrap-datatimePicker/css/bootstrap-datetimepicker.css" type="text/css"  rel="stylesheet">



  <style type="text/css">
    .panel-body .cl_0{ width:150px;}
    .form-group{padding-top:5px;padding-left:165px; padding-bottom:5px;}
    .form-group>label{width:100px;text-align:right;}
  </style>
  <script type="text/javascript">
    $(function(){
    	
	//日期控件
	   $(".form_datetime").datetimepicker({
	        weekStart: 1,
	        todayBtn: 2, 
			todayHighlight: 1,
			startView: 3,
			minView: 2,
			forceParse: 1,
			format: "yyyy-mm-dd",
		    autoclose: true,
		    language:'zh-CN',
		    pickerPosition:"bottom-right" 
	    });
	   $('#registerForm').bootstrapValidator({
		   message:'默认错误提示信息',
		   feedbackIcons: {
	              valid: 'glyphicon glyphicon-ok',
	              invalid: 'glyphicon glyphicon-remove',
	              validating: 'glyphicon glyphicon-refresh'
	          },
	          fields:{
	        	  username:{
	        		  validators:{
	        			  notEmpty:{
	        				  message:'姓名不能为空！'
	        			  }
	        		  }
	        	  },
	        	  pwd:{
	        		 validators:{
	        			 notEmpty:{
	        				 message:'密码不能为空!'
	        			 }
	        		 } 
	        	  },
	        	  rname:{
	        		  validators:{
	        			  notEmpty:{
	        				  message:'姓名不能为空！'
	        			  }
	        		  }
	        	  },
	        	  cardno:{
	        		 validators:{
	        			 notEmpty:{
	        				 message:'身份证号不能为空!'
	        			 },
	        			 regexp:{
	        				 regexp: /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,
	        				 message:'身份证号格式错误！'
	        			 }
	        	      } 
	        	  },
	        	  email:{
	        		  validators:{
	        			 notEmpty:{
	        				 message:'邮箱不能为空！'
	        			 },
	        			 regexp:{
	        				 regexp:/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
	        				 message:'邮箱格式错误！'
	        			 }
	        		  }
	        	  },
	        	  phone:{
	        		  validators:{
	        			  notEmpty:{
	        				  message:'手机号不能为空！'
	        			  },
	        			  regexp:{
	        				  regexp:/^1[34578]\d{9}$/,
	        				  message:'手机号格式错误'
	        			  }
	        		  }
	        	  }
	        	  
	          }
	          
	   });
    });
 
  </script>
</head>
<body>
 <div class="container">
 <div class="page-header" >
        <h1>网上报名</h1>
  </div>
      <div class="row" >
        <div>
          <div class="panel panel-default">
            <!-- panel标题 -->
            <div class="panel-heading">
              <h3 class="panel-title">个人报考信息注册</h3>
            </div>
            <!-- panel内容部分 -->
            <div class="panel-body">
            
                <form action="examineeRegistControl.do?action=register"  id="registerForm" method="post" class="form-inline">  
                       <div class="form-group">
				        		<label>用户名:</label>
				       		 	<input type="text" name="username"  class="form-control cl_0" placeholder="请输入用户名" requited autofocus>
		           		</div>
		           		 <div class="form-group">
				        		<label>密码:</label>
				       		 	<input type="text"   name="pwd"  class="form-control cl_0" placeholder="请输入密码" >
		           		</div>
		            	<br>
		            	
		                <div class="form-group">
				        		<label>姓名:</label>
				       		 	<input type="text" name="rname"  class="form-control cl_0" placeholder="请输入姓名" >
		           		</div>
		            	<div class="form-group">
				        		<label>身份证号码:</label>
				        		<input type="text" name="cardno"  class="form-control cl_0" placeholder="请输入证件号码" >
						</div>
						<br>
						
		            	<div class="form-group">
				        		<label>报考等级：</label>
				        		<select class="form-control" style="width:150px;" name="leve">
							  		<option value="1">一级</option>
							  		<option value="2">二级</option>
							  		<option value="3">三级</option>
								</select>
						</div>
						 <!-- 采用日期控件 -->
			                <div   class="form-group control-group controls input-append date form_datetime"     data-date-format="yyyy-MM-dd" data-link-field="dtp_input1">
			                    <label>出生日期:</label> <input size="16" name="birthday" class="form-control cl_0" type="text"   placeholder="请输入出生年月日"  >
			                    <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-th"></i></span>
			                </div>         
						 <br>
				 
						<div class="form-group">
						    <label>性别:</label>
				        	<label class="checkbox cl_0" >
		  						男：<input type="radio" checked value="1" name="sex">
		  						女：<input type="radio" value="0" name='sex'>  
							</label>	 
						</div>
						<div class="form-group">
				        		<label>手机号码:</label>
				        		<input type="text" name="phone"  class="form-control cl_0" placeholder="请输入电话号码" >
						</div>
						<br>
						
						<div class="form-group">
				        		<label>E-mail:</label>
				        		<input type="text"  name="email" class="form-control cl_0" placeholder="请输入E-mail" required>
						</div> 
						<div class="form-group">
						    <label>报考省份:</label>
				        	<select class="form-control" style="width:150px;" name="province">
							  		<option value="北京">北京</option>
							  		<option value="河北省">河北省</option>
							  		<option value="山西省">山西省</option> 
								</select> 
						</div>
						<br>
						
						 <div class="form-group" id="uploadPhoto">
		   					   <label>照片</label>
							   <div class="col-sm-10">
							      <input id="myFile" type="file" name="myPhoto" class="fileloading">
							   </div>
		 						 <div class="col-sm-10" id="uploadError"></div>
		  				</div>
		  				<div class="form-group" id="showPhoto" style="display:none">
		   					   <label>照片</label>
							   <div class="col-sm-10">
							      <img id="showPhotoImg" style="border:1px solid #999;padding:5px;width:150px;height:150px"></img>
							   </div>
		 						 <input type="hidden" name="photoUrl" id="photoUrl">
		  				</div>
		  				
		  				
  				 
   					  <div class="col-sm-10 text-center">
					        <button type="submit" class="btn btn-primary">注册</button>
					        <button type="button" class="btn btn-primary">重置</button>
					   </div>	 
				</form>
				
            </div>
          </div>
          
        </div> 
        
      </div>
    </div>
   <script type="text/javascript">
 $("#myFile").fileinput({
     language : 'zh',
     uploadUrl : "examineeRegistControl.do?action=uploadPhoto",
     autoReplace : true,
     maxFileCount : 5,
     //showRemove:false,//是否显示移除按钮
     showUpload:false,//是否显示上传按钮
     enctype: 'multipart/form-data',/* 是设置表单的MIME编码。默认情况，这个编码格式是application/x-www-form-urlencoded，不能用于文件上传；
	 只有使用了multipart/form-data，才能完整的传递文件数据，进行下面的操作.  */
	 uploadExtraData:function(previewId, index) {
         return {"username": "测试字符串"}
     },//给input隐藏域赋值，照片的存储路径
     allowedFileExtensions : [ "jpg", "png", "gif" ],
     browseClass : "btn btn-primary", //按钮样式 
     previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
 }).on("fileuploaded", function(e, data) {//上传完毕后触发的回调函数
     var res = data.response;
     if(res.flag){//
    
    	 $("#uploadPhoto").hide();
    	 $("#showPhotoImg").attr("src",res.msg);
    	 $("#photoUrl").val(res.msg);
    	 $("#showPhoto").show();
     }else{
    	 $("#uploadError").html("系统异常！")
     }
    /*  alert(res.success);
     $("#logo").attr("value", res.success); */
 });
 </script> 

</body>
</html>