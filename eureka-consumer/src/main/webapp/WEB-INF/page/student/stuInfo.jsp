<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <title>个人信息详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>个人信息一览</legend>
</fieldset>

<div class="layui-collapse" lay-filter="test">
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">
            学号：
            <span>${requestScope.stuId}</span>
        </h2>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">
            姓名：
            <span>${requestScope.stuName}</span>
        </h2>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">
            性别：
            <span>${requestScope.stuSex}</span>
        </h2>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">
            院系：
            <span>${requestScope.stuFaculty}</span>
        </h2>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">
            专业：
            <span>${requestScope.stuMajor}</span>
        </h2>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">
            班级：
            <span>${requestScope.stuClass}</span>
        </h2>
    </div>
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">
            联系方式：
            <span>${requestScope.stuPhone}</span>
        </h2>
    </div>
</div>

</body>
</html>

