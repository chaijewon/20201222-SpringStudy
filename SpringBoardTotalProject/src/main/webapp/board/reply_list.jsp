<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0;
let i=0;
$(function(){
	$('.updateBtn').click(function(){
		$('.updates').hide();
		$('.inserts').hide();
		let no=$(this).attr("data-no");
		if(u==0)
		{
			$('#m'+no).show();
			$(this).text("취소");
			u=1;
		}
		else
		{
			$('#m'+no).hide();
			$(this).text("수정");
			u=0;
		}
	})
	$('.insertBtn').click(function(){
		$('.updates').hide();
		$('.inserts').hide();
		let no=$(this).attr("data-no");
		if(i==0)
		{
			$(this).text("취소");
			$('#in'+no).show();
			i=1;
		}
		else
		{
			$(this).text("댓글");
			$('#in'+no).hide();
			i=0;
		}
	});
	
	// 댓글 추가
	$('#replyBtn').click(function(){
		let bno=$('#insert_bno').val();
		let page=$('#insert_page').val();
		let msg=$('#insert_msg').val();
		// val() => <input> , <select> , <textarea>
		if(msg.trim()=="")
		{
			$('#insert_msg').focus();
			return;
		}
		$.ajax({
			type:'POST',
			url:'reply_insert.do',
			data:{"bno":bno,"page":page,"msg":msg},
			success:function(result)
			{
				$('#reply_data').html(result);
			}
		})
	});
	// 댓글 수정 
	$('.uBtn').click(function(){
		let data_no=$(this).attr("data-no");
		let no=$('#update_no'+data_no).val();
		let bno=$('#update_bno'+data_no).val();
		let page=$('#update_page'+data_no).val();
		let msg=$('#update_msg'+data_no).val();
		if(msg.trim()=="")
		{
			$('#update_msg'+data_no).focus();
			return;
		}
		$.ajax({
			type:'post',
			url:'reply_update.do',
			data:{"no":no,"bno":bno,"page":page,"msg":msg},
			success:function(result)
			{
				$('#reply_data').html(result);
			}
		})
	})
	// 댓글 댓글 올리기 
	$('.rrBtn').click(function(){
		let data_no=$(this).attr("data-no");
		let pno=$('#rr_insert_pno'+data_no).val();
		let bno=$('#rr_insert_bno'+data_no).val();
		let page=$('#rr_insert_page'+data_no).val();
		let msg=$('#rr_insert_msg'+data_no).val();
		if(msg.trim()=="")
		{
			$('#rr_insert_msg'+data_no).focus();
			return;
		}
		$.ajax({
			type:'post',
			url:'reply_to_reply_insert.do',
			data:{"pno":pno,"bno":bno,"page":page,"msg":msg},
			success:function(result)
			{
				$('#reply_data').html(result);
			}
		})
	})
	// 삭제하기
	$('.delBtn').click(function(){
		
		let no=$(this).attr("data-no");
		let bno=$(this).attr("data-bno");
		let page=$(this).attr("data-page");
		$.ajax({
			type:'get',
			url:'reply_delete.do',
			data:{"no":no,"bno":bno,"page":page},
			success:function(result)
			{
				$('#reply_data').html(result);
			}
		})
	})
	
})
</script>
</head>
<body>
  <c:forEach var="rvo" items="${rList }">
       <table class="table">
        <tr>
          <td class="text-left">
           <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp;
             </c:forEach>
             <img src="re_icon.png">
           </c:if>
                       ◐${rvo.name }(${rvo.dbday })
          </td>
          <td class="text-right">
            <c:if test="${sessionScope.id!=null }">
              <c:if test="${sessionScope.id==rvo.id }">
                <span class="btn btn-xs btn-success updateBtn" data-no="${rvo.no }">수정</span>
                <span data-no="${rvo.no }" data-bno="${no}" data-page="${page}" class="btn btn-xs btn-info delBtn">삭제</span>
                
              </c:if>
              <span class="btn btn-xs btn-danger insertBtn" data-no="${rvo.no }">댓글</span>
            </c:if>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp;
             </c:forEach>
            </c:if>
            <pre style="white-space: pre-wrap;border:none;background-color:white;">${rvo.msg }</pre>
          </td>
        </tr>
        <%--수정 데이터 --%>
           <tr class="updates" style="display:none" id="m${rvo.no }">
	         <td class="text-center" colspan="2">
	           <input type="hidden" name=no value="${rvo.no }" id="update_no${rvo.no }">
	           <input type="hidden" name=bno value="${no }" id="update_bno${rvo.no }">
	           <input type="hidden" name=page value="${page }" id="update_page${rvo.no }">
	           <textarea rows="4" cols="95" name="msg" style="float: left" id="update_msg${rvo.no }">${rvo.msg }</textarea>
	           <button class="btn btn-sm btn-primary uBtn" style="height: 80px;float:left"
	            data-no="${rvo.no }"
	           >댓글수정</button>
	         </td>
	        </tr>
	     <%-- 댓글올리기 --%>
	       <tr class="inserts" style="display:none" id="in${rvo.no }">
	         <td class="text-center" colspan="2">
	          <!-- <form method="post" action="reply_to_reply_insert.do"> -->
	           <input type="hidden" name=pno value="${rvo.no }" id="rr_insert_pno${rvo.no }">
	           <input type="hidden" name=bno value="${no }" id="rr_insert_bno${rvo.no }">
	           <input type="hidden" name=page value="${page }" id="rr_insert_page${rvo.no }">
	           <textarea rows="4" cols="95" name="msg" style="float: left" id="rr_insert_msg${rvo.no }"></textarea>
	           <input type=button class="btn btn-sm btn-primary rrBtn" style="height: 80px;float:left"
	             value=댓글 data-no="${rvo.no }">
	          <!-- </form> -->
	         </td>
	        </tr>
       </table>
      </c:forEach>
      <c:if test="${sessionScope.id!=null }">
	      <table class="table">
	        <tr>
	         <td class="text-center">
	           <input type="hidden" name=bno value="${no }" id="insert_bno">
	           <input type="hidden" name=page value="${page }" id="insert_page">
	           <textarea rows="4" cols="95" name="msg" style="float: left" id="insert_msg"></textarea>
	           <input type=button class="btn btn-sm btn-primary" style="height: 80px;float:left" id="replyBtn"
	           value="댓글쓰기">
	         </td>
	        </tr>
	      </table>
      </c:if>
</body>
</html>








