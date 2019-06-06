<%--
  Created by IntelliJ IDEA.
  User: Le Hoang Anh
  Date: 6/6/2019
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="/member/login" method="post">
    <div class="main-form">
        <i class="logo"></i>
        <input type="text" name="username">
        <input type="password" name="password">
        <label>
            <input type="checkbox"> Remember me
        </label>
        <input type="submit" value="Submit">
        <a href="#" title="">Forgot your password?</a>
        <div>
            <a href="#" title="">Don't have an account?</a>
            <a href="/member/register" title="">Sign Up</a>
        </div>
    </div>
</form>
</body>
</html>

<style>
    /* Based on a Dribbble shot by Andreas Storm
   http://dribbble.com/shots/1127916-Sign-in
*/

    *{
        -webkit-box-sizing:border-box;
        -moz-box-sizing:border-box;
        box-sizing:border-box;
    }
    body{
        background: url(https://i.imgur.com/MQB99sg.jpg) #a9b89e;
        font-family:Arial;
        font-size:12px;
        color:#C4BCB0;
    }
    input[type="text"],
    input[type="password"]{
        background:#EAE6E1;
        border:0;
        font-weight:bold;
        padding:10px;
        border-radius:3px;
        width:100%;
        margin:5px 0;
        outline:medium none;
        color:#838383;
    }
    input[type="checkbox"]{
        -webkit-appearance:none;
        width:10px;
        height:10px;
        position:relative;
        outline:medium none;
        margin-right:10px;
    }
    input[type="checkbox"]::before{
        width:9px;
        height:9px;
        content:"";
        display:block;
        border:3px solid #C4BCB0;
        border-radius: 9px;
        position:absolute;
    }
    input[type="checkbox"]:checked::after{
        width:5px;
        height:5px;
        content:"";
        display:block;
        background: #C4BCB0;
        border-radius: 5px;
        position:absolute;
        left:5px;
        top:5px;
    }
    input[type="submit"]{
        display:block;
        padding:10px;
        background:#50BFA4;
        border:0;
        border-radius:3px;
        font-weight:bold;
        width:100%;
        color:#fff;
        cursor:pointer;
        -webkit-transition:all 0.3s;
        -moz-transition:all 0.3s;
        transition:all 0.3s;
    }
    input[type="submit"]:hover{
        background:#58CCB0;
    }
    .main-form{
        width:350px;
        margin: 100px auto;
        padding:50px;
        border: 1px solid rgba(0,0,0,0.1);
        -webkit-box-shadow:0 1px 2px rgba(0,0,0,0.2);
        background:#fff;
    }
    .logo{
        background:#50BFA4;
        width:40px;
        height:40px;
        display:block;
        margin:0 auto 30px;
        border-top-left-radius:20px;
        border-top-right-radius:20px;
        border-bottom-left-radius:20px;
        position:relative;
        -webkit-transform: rotate(45deg);
        -moz-transform: rotate(45deg);
        transform: rotate(45deg);
    }
    .logo::before{
        width:14px;
        height:14px;
        display:block;
        border:5px solid #F7F5F2;
        content:"";
        position:absolute;
        border-radius:14px;
        top:8px;
        left:8px;
    }
    .main-form > label{
        display:block;
        margin:10px 0 15px;
        line-height:15px;
        cursor:pointer;
    }
    .main-form > div{
        margin-top:20px;
    }
    a{
        color:#C4BCB0;
        text-decoration:none;
    }
    .main-form > a{
        font-size:11px;
        display:block;
        text-align:center;
        margin:10px 0;
    }
    .main-form > div >a:first-child{
        font-weight:bold;
    }
    .main-form > div >a:nth-child(2){
        border:1px solid #3DA087;
        display:inline-block;
        border-radius:3px;
        color:#3DA087;
        font-weight:bold;
        padding:7px 15px;
        margin-left:28px;
        -webkit-transition:all 0.3s;
        -moz-transition:all 0.3s;
        transition:all 0.3s;
    }
    .main-form > div >a:nth-child(2):hover{
        background:#3DA087;
        color:#fff;
    }
</style>
