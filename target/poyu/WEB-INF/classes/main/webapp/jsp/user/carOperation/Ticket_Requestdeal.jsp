<%--
  Created by IntelliJ IDEA.
  User: poyu
  Date: 2019/4/24/0024
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        body{
            background: #cccccc;
        }
        .email_content{
            text-align: center;
        }
    </style>
</head>
<body>
<section style="text-align:center;">
    <form action="UserSendEmail" method="post">
        <div>
            邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" name="receptor" class="text" maxlength="185"><br/><br>
        </div>
        <div>
            车&nbsp;&nbsp;牌&nbsp;&nbsp;号：<input type="text" name="car_number" class="text" maxlength="185"><br/><br>
        </div>
        <div>
            违章编号：<input type="text" name="unrule_record" class="text" maxlength="185"><br/><br>
        </div>
        <div class="email_content">
           <textarea type="textarea" placeholder="请在此处申请" rows="5" cols="20" name="content" class="text" maxlength="85"></textarea>
        </div>
        <div style="margin-top:10px">
            <input type="submit" value="提交"/>
            <input type="reset" value="重置"/>
        </div>
    </form>
</section>
</body>
</html>

