<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报名个人信息查看</title>
 <script type="text/javascript" src="<%=basePath %>js/jquery-1.11.1.min.js"></script>
 
 <link href="<%=basePath %>bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript" src="<%=basePath %>bootstrap/js/bootstrap.js"></script>
 
 <link href="<%=basePath %>css/login.css" rel="stylesheet">
 
 
<script type="text/javascript" src="<%=basePath %>js/bootstrap-fileinput-master/js/fileinput.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap-fileinput-master/js/locales/zh.js"></script>
<link type="text/css" rel="stylesheet" href="<%=basePath %>js/bootstrap-fileinput-master/css/fileinput.css" />
  
  <style type="text/css">
    .panel-body .cl_0{ width:150px;}
    .form-group{padding-top:5px; padding-bottom:5px;}
    .form-group>label{width:100px;text-align:right;}
  </style>
   <script type="text/javascript">
  /*   function deleteItems(){
       var item=document.getElementsByName("exaId").value;	
       window.location="pageControl?action=deleteItems&exaId="+item;
    	
    } */
  
    </script>
</head>
<body>
 <div class="container">
 <div class="page-header" >
        <h1>网上报名</h1>
  </div>
      <div class="row" >
        <div >
          <div class="panel panel-default">
          
            <div class="panel-heading">
              <h3 class="panel-title"  style="height:20px;">
             <span  style="display:block;float:left;">查看个人报名信息</span>
               <span  style="display:block;float:right;">考生-${user.username }  在线人数${onlineUserTotal }</span>
               
               </h3>
            </div>
           
            <div class="panel-body">
            
                <form   class="form-inline" id="searchForm" action="ExamineeInfo.do" method="post">  
	               <div class="form-group">
					    <label>姓名：</label>
					    <p class="form-control-static">${user.rname }</p>     
				  </div>
	              <div class="form-group">
			        		<label>身份证号码:</label>
			        		<p class="form-control-static">${user.cardno }</p>  
				  </div>
				 
            	  <div class="form-group">
		        		<label>报考等级：</label>
		        		<select class="form-control" style="width:150px;" disabled="disabled">
					  		<option  <c:if test="${user.exaLeve=='1' }"></c:if>selected> 一等级</option>
					  		<option  <c:if test="${user.exaLeve=='2' }"></c:if>selected> 二等级</option>
					  		<option  <c:if test="${user.exaLeve=='3' }"></c:if>selected> 三等级</option>
						</select>
				  </div>
				  <div class="form-group">
		        			<label>出生日期:</label>
		        		 	<p class="form-control-static">${user.birthday }</p>  
				  </div>
				   <br>
				  <div class="form-group">
				     	 <label>性别:</label>
		        	 	 <p class="form-control-static">
		        	 	  <c:if test="${user.sex=='0' }">女</c:if>
		        	 	  <c:if test="${user.sex=='1' }">男</c:if>
		        	 	 </p>  
				  </div>
				<div class="form-group">
		        		<label>手机号码:</label>
		        		<p class="form-control-static">${user.phone }</p>  
				</div>
				<div class="form-group">
		        		<label  >E-mail:</label>
		        		<p class="form-control-static">${user.email }</p>  
				</div>
				 
				<div class="form-group">
				    <label>报考省份:</label>
		        	<select class="form-control" style="width:150px;" disabled="disabled">
					  	
					  		<option>${user.province } </option>
					  		
					 </select> 
				</div>
				 
				<div class="form-group">
				    <label>审核状态:</label>
		        	<select class="form-control" style="width:150px;" disabled="disabled">
					  	
					  	   <option   <c:if test="${state=='Y' }">selected</c:if>>已通过</option>
		                   <option   <c:if test="${state=='N' }">selected</c:if>>未通过</option>
		                   <option   <c:if test="${state=='F' }">selected</c:if>>待审核</option>
					  		
					 </select> 
				</div>
				 
				 
			    <!-- 照片 -->
   						<div class="panel panel-default" style="width:300px;height:300px;margin-left:50px;">
	   						 <div class="panel-heading">
	              				<h3 class="panel-title">照片</h3>
	            			</div>
	            			<div class="panel-body">
	            			   <img src="${user.photoURL }/${user.photo}" style="width:200px;height:200px;margin-left:30px;"></img>
	            			
	   						</div>
   						</div>
					    
   					  <div class="col-sm-10 text-center">		        
					        <a href="exitControl.do" type="button" class="btn btn-primary">退出</a>
					       
					   </div>	 
				</form>
				
            </div>
          </div>
          
        </div><!-- /.col-sm-4 -->
               
      </div>
    </div>
    <script type="text/javascript">
 $("#myFile").fileinput({
     language : 'zh',
     uploadUrl : "UploadFileControl",
     autoReplace : true,
     maxFileCount : 1,
     allowedFileExtensions : [ "jpg", "png", "gif" ],
     browseClass : "btn btn-primary", //按钮样式 
     previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
 }).on("fileuploaded", function(e, data) {
     var res = data.response;
     alert(res.success);
     $("#logo").attr("value", res.success);
 })
 </script>
</body>
</html>