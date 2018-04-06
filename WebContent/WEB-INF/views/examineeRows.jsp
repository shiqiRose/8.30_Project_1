<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.lingzhuo.vo.*"%>
                   <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核报名信息</title>
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
    $(function(){
  	  //点击查询
  	  $("#searchExaBtn").click(function(){
  		  $("#searchForm").attr("action","pageControl.do?action=page&pageNow=1").submit();
  		  
  	  });
  	  
    });
  /*   function  mainPage(){//查询首页
    	var form=document.getElementById("searchForm");
    	form.setAttribute("action","pageControl?action=page&pageNow=1");
    	form.submit();
    } 
    function lastPage(pageNow){//查询上一页
    	var form =document.getElementById("searchForm");
    	if(pageNow==1){
    		form.setAttribute("action","pageControl?action=page&pageNow=1");
    	}else{
    		form.setAttribute("action","pageControl?action=page&pageNow="+(parseInt(pageNow)-1));
    	}
    	form.submit();
    }
   function  nextPage(pageNow,pageTotal){//查询下一页
    	  var form =document.getElementById("searchForm");
    	  if(pageNow==pageTotal){
    	      form.setAttribute("action","pageControl?action=page&pageNow="+pageTotal);
    	   }else{
    	      form.setAttribute("action","pageControl?action=page&pageNow="+(parseInt(pageNow)+1));
    	   }
    	  form.submit();
    }
   function totalPage(pageTotal){
	   var form=document.getElementById("searchForm");
   	   form.setAttribute("action","pageControl?action=page&pageNow="+pageTotal);
       form.submit();
   } */
   //点击首页
   function mainPage( ){
 	  $("#searchForm").attr("action","pageControl.do?action=page&pageNow=1").submit();
 	  
 	 // $("#searchForm").attr("action","pageControl?action=page&pageNow=1").submit();
   }
   //点击上一页
   function lastPage(pageNow){
 	  
 	  if(pageNow=="1"){
 		  $("#searchForm").attr("action","pageControl.do?action=page&pageNow=1").submit();
 	  }else{
 		  $("#searchForm").attr("action","pageControl.do?action=page&pageNow="+(parseInt(pageNow)-1)).submit();
 	  }
   }
   //下一页
 function nextPage(pageNow,pageTotal){
 	  
 	  if(pageNow==pageTotal){
 		  $("#searchForm").attr("action","pageControl.do?action=page&pageNow="+pageTotal).submit();
 	  }else{
 		  $("#searchForm").attr("action","pageControl.do?action=page&pageNow="+(parseInt(pageNow)+1)).submit();
 	  }
   }

   //尾页
 function totalPage(pageTotal){
  
 		  $("#searchForm").attr("action","pageControl.do?action=page&pageNow="+pageTotal).submit();
 	  
 }
   //审核已通过操作
function examinee(id){
	   $.ajax({
		   url:"pageControl.do?action=examinee",
	       type:"post",
	       data:{exid:id},
	       dataType:"html",
	       success:function(res){
	    	   alert(res);
	    	   if(res=="1"){
	    		   $("#"+id).find("td:eq(9)").html("已通过");//根据tr 找到td(从0开始)，给td第9 列赋值 
	    	   }else if(res=="2"){
	    		   alert("该记录已审核，不能再次审核！");
	    	   }else{
	    		   alert("操作失败!");
	    	   }
	       },error:function(){
	    	   alert("服务器响应失败！");
	       }
		   
	   });
   }
   //审核未通过校验
   function noexaminee(id){
	   $.ajax({
		   url:"pageControl.do?action=noexaminee",
		   type:"post",
		   data:{exid:id},
		   dataType:"json",
		   success:function(res){
			   if(res.flag){
				   $("#exid").val(id);
				   $("#myModal").modal("show");
			   }else{
				   alert(res.msg);
			   }
		   },error:function(){
			   alert("服务器响应失败1！");
		   }
		   
	   });
   }
   
   
   
   

   function examinN(){
	  $.ajax({
		  url:"pageControl.do?action=noExamineCommit",
		  data:{exid:$("#exid").val(),examineMsg:$("#examineMsg").val()},
	      type:"post",
	      dataType:"json",
	      success:function(res){
	    	 
	    	  if(res.flag){//审核不通过操作成功
	    		  $("#"+$("#exid").val()).find("td:eq(9)").html("未通过");
	    		  $("#myModal").modal("hide");//隐藏遮罩层
	    		  $("#examineMsg").val("");//清空文本域
	    	  }else{
	    		  alert(res.msg);
	    	  }
	      },error:function(){
			   alert("服务器响应失败2！");
		   }
		  
	  });
   } 
   
   

   
    
  
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
              <h3 class="panel-title"  style="height:15px;">
              <span  style="display:block;float:left;">报名信息查看</span>
              <span  style="display:block;float:right;">考务人员-${user.username }  在线人数${onlineUserTotal }</span>
              </h3>
            </div>
            
            <div class="panel-body">
            <form method="post"  class="form-inline" id="searchForm">
               <table id="rows" class="table table-bordered table-hover">
	              <tr>
	              <div class="form-group">
		               <label>姓名：</label>  
		               <input type="text" name="rname" value="${rname }" class="form-control input-sm" >
		          </div>
	              <div class="form-group">
		               <label> 身份证号： </label> 
		               <input type="text"  name="cardno" value="${cardno }" class="form-control input-sm">
	               </div>
	                <div class="form-group">
		              <label> 报考级别： </label>
		             
		              <select name="leve" class="form-control input-sm"  style="width:150px">
		                   <option value="">--全部--</option>
		                   <option value="1"  <c:if test="${leve=='1' }">selected</c:if>>一等级</option>
		                   <option value="2"  <c:if test="${leve=='2' }">selected</c:if>>二等级</option>
		                   <option value="3"  <c:if test="${leve=='3' }">selected</c:if>>三等级</option>
		                   
		               </select>
	               </div>
	                <div class="form-group">
		               <label>审核状态： </label>  
		               <select name="state" class="form-control input-sm"  style="width:150px">
		                   <option value="">--全部--</option>
		                   <option value="Y"  <c:if test="${state=='Y' }">selected</c:if>>已通过</option>
		                   <option value="N"  <c:if test="${state=='N' }">selected</c:if>>未通过</option>
		                   <option value="F"  <c:if test="${state=='F' }">selected</c:if>>待审核</option>
	
		               </select>
		               <button type="button" class="btn btn-sm btn-primary" id="searchExaBtn">查询</button>
	               </div>                 
	                  </form>                    
	              </tr>
                  <tr>
                   
                    <th>序号</th><th>姓名</th><th>身份证号码</th><th>性别</th><th>邮箱</th>
                    <th>报考级别</th><th>报考省份</th><th>出生年月</th><th>报考时间</th><th>审核状态</th><th>操作</th>
                  </tr>
                 <c:forEach  items="${Rows }"  var="e" varStatus="a" >
                
                   <tr id="${e.exaId}">
                  
                    <td>${a.count }</td>
                    <td>${e.rname }</td> 
                    <td>${e.cardno }</td> 
                    <td>
                       <c:if test="${e.sex=='1' }">男</c:if>
                       <c:if test="${e.sex=='0' }">女</c:if> 
                    </td> 
                    <td>${e.email }</td> 
                    <td>
                        <c:if test="${e.exaLeve=='1' }">一等级</c:if>
	                    <c:if test="${e.exaLeve=='2' }">二等级</c:if>
	                    <c:if test="${e.exaLeve=='3' }">三等级</c:if>
                    </td> 
                    <td>${e.province }</td> 
                    <td>${e.birthday }</td> 
                    <td>${e.exaTime }</td> 
                    <td>
                        <c:if test="${e.examinestate=='Y' }">已通过</c:if>
	                    <c:if test="${e.examinestate=='N' }">未通过</c:if>
	                    <c:if test="${e.examinestate=='F'||e.examinestate==null }">待审核</c:if>
                     </td> 
                    <td>
                    
                             <div class="dropup">
								  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								            审核/删除
								    <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
								    <li><a href="javascript:void(0)" onclick="examinee('${e.exaId }')">通过审核</a></li>
								    <li><a href="javascript:void(0)" onclick="noexaminee('${e.exaId }')"  data-toggle="modal" >未通过审核</a></li>
								  <!--   <li><a href="javaScript:void(0)" onclick="deleteItems()">删除</a></li> -->
			                       <li><a href="pageControl.do?action=deleteItems&exaId=${e.exaId }">删除</a></li> 
			                       <li><a href="#">取消</a></li>
								  </ul>
								  
								  <c:if test="${e.examinestate=='N' }">
								  <input type="button"  class="btn btn-default input-sm" value="查看原因" data-content="${e.unauditedReason }" data-original-title="未通过审核原因：">
								  </c:if>
							</div>
                    
                    </td>  
                    
                  </tr> 
                  </c:forEach>
			   </table>
			  
			   <nav aria-label="...">
				  <ul class="pager">
			        <li><a href="javaScript:void(0)" onclick="mainPage()">首页</a></li>
			        <li><a href="javaScript:void(0)" onclick="lastPage('${pageVo.pageNow}')">上一页 </a></li>
			        <li><a href="javaScript:void(0)" onclick="nextPage('${pageVo.pageNow}','${pageVo.pageTotal }')">下一页 </a></li>
			        <li> <a href="javaScript:void(0)" onclick="totalPage('${pageVo.pageTotal}')">尾页</a></li>
				     <li>&nbsp;&nbsp;&nbsp; 第${pageVo.pageNow }页&nbsp;&nbsp;&nbsp; </li>
				     <li>&nbsp;&nbsp;&nbsp;共${pageVo.pageTotal }页&nbsp;&nbsp;&nbsp; </li>
				     <li>&nbsp;&nbsp;&nbsp;共${pageVo.total }行&nbsp;&nbsp;&nbsp; </li>
				  </ul>
				  <div class="col-sm-10 text-center">		        
					        <a href="exitControl.do" type="button" class="btn btn-primary">退出</a>
					       
					   </div>	 
				</nav>
            </div>
          </div>
          
        </div><!-- /.col-sm-4 -->
         
      </div>
    </div>
    <!-- ------ -->
    <div class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
        <p>One fine body&hellip;</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
    <script type="text/javascript">
    $('#myModal').on('shown.bs.modal', function () {
    	  $('#myInput').focus()
    	})
   </script>
      <!-- --未审核通过遮罩，添加未审核原因---- -->
    <div class="container-fluid text-center">
 
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  >
				 <div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								  &times;
							 </button>
							 <h4 class="modal-title" id="myModalLabel">
								填写未审核原因：
							</h4>
						</div>
						<div class="modal-body">
						     <form method="post" id="examineForm"  >
						       <input  type="hidden"  name="exid" id="exid">
							   <textarea class="form-control" rows="3" name="examineMsg" id="examineMsg"></textarea>
							 </form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消
                            </button>
							<button type="button" class="btn btn-primary" onclick="examinN()">
                            		   提交
                        </button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
			
			<script>
$(function (){ 
	
	  $("#rows tr").each(function(){
		if($(this).find("td:last :button:last").val()=="查看原因"){
			$(this).find("td:last :button:last").popover({placement:'left'});
		}
		
	});  
	 
	/* $("#example_left").popover({placement:'left'});
	$("#example_top").popover({placement:'top'});
	$("#example_bottom").popover({placement:'bottom'}); */
});
</script>
</body>
</html>