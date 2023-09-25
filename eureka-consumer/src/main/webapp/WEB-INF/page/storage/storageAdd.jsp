<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>添加入库信息</title>
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
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">订单编号</label>
        <div class="layui-input-block">
            <input type="text" name="id" lay-verify="required" lay-reqtext="订单编号" placeholder="请输入订单编号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">教材编号</label>
        <div class="layui-input-block">
            <input type="text" name="bookId" lay-verify="required" lay-reqtext="教材编号不能为空" placeholder="请输入教材编号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">教材名称</label>
        <div class="layui-input-block">
            <input type="text" name="bookName" lay-verify="required" lay-reqtext="教材名称不能为空" placeholder="请输入教材名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">数量</label>
        <div class="layui-input-block">
            <input type="number" name="number" lay-verify="required" lay-reqtext="数量不能为空" placeholder="请输入数量" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">单价</label>
        <div class="layui-input-block">
            <input type="number" step="0.01" name="price" lay-verify="required" lay-reqtext="单价不能为空" placeholder="请输入单价" autocomplete="off" class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label required">总价</label>
        <div class="layui-input-block">
            <input type="number" step="0.01" name="sum" lay-verify="required" lay-reqtext="总价不能为空" placeholder="请输入总价" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">供货商编号</label>
        <div class="layui-input-block">
            <input type="text" name="vendorId"  lay-verify="required" placeholder="请输入供货商编号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">入库时间</label>
        <div class="layui-input-block">
            <input type="datetime-local" name="date"  lay-verify="required" placeholder="请输入入库时间" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate=layui.laydate,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas=data.field;//form单中的数据信息
            //向后台发送数据提交添加
            $.ajax({
                url:"addStorageSubmit",
                type:"POST",
                //data:datas,
                contentType:'application/json',
                dataType : 'json',
                data:JSON.stringify(datas),
                success:function(result){
                    if(result.code==0){//如果成功
                        layer.msg('添加成功',{
                            icon:6,
                            time:500
                        },function(){
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    }else{
                        layer.msg("添加失败");
                    }
                }
            })
            return false;
        });
    });
</script>
</body>
</html>

