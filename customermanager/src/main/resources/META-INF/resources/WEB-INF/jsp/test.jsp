<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<button type="button" id="API1"> 1번 기능</button><br>
<button type="button" id="API2"> 2번 기능</button><br>
<button type="button" id="API3"> 3번 기능</button><br>
지점명 : <input type="text" id="brName">
<button type="button" id="API4"> 4번 기능 확인</button>

<div id="result"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){

    $("#API1").click(function() {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                type: "GET",
                url: "/MaxSumAmountCustomer",
                success: function(data) {
                    $("#result").html(data);
                }
            });
    });

    $("#API2").click(function() {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                type: "GET",
                url: "/NoneTransactionCustomer",
                success: function(data) {
                    $("#result").html(data);
                }
            });
    });

    $("#API3").click(function() {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                type: "GET",
                url: "/MaxSumAmountBranch",
                success: function(data) {
                    $("#result").html(data);
                }
            });
    });

    $("#API4").click(function() {
        if($('#brName').val().length == 0){
              alert("ex) 판교점, 분당점, 을지로점, 강남점, 잠실점을 입력해주세요");
              return;
        }

        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "GET",
            url: "/SumAmountBranch",
            data: {"brName" : $('#brName').val()},
            success: function(data) {
                $("#result").html(data);
            }
        });
    });
});

</script>