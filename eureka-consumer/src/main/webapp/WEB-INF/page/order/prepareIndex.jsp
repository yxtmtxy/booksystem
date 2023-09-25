<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>教材订购推荐信息管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
    <script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <form class="layui-form"  >
            <div class="layui-form-item layui-form">
                设置教材安全库存数量：
                <div class="layui-inline">
                    <input type="number" class="layui-input" name="num" id="num" >
                </div>
                <button  class="layui-btn" lay-submit="" lay-filter="query" >查询</button>
            </div>
        </form>

        <!--表单，查询出的数据在这里显示-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

    </div>
</div>

<script type="text/javascript">
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/prepareAll',//查询全部数据
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                //{field: 'id', width: 100, title: 'ID', sort: true},
                {field:'id', width:100,title: '序号' , align:'center'},
                {field:'bookId',width:150,title:'教材编号', align: "center"},
                {field: 'bookName', width: 150, title: '教材名称', align: "center"},
                {field: 'storage', width: 150, title: '库存数量', align: "center"},
                {field: 'needNum', width: 150, title: '征订数量', align: "center"},
                {field: 'suggestNum', width: 150, title: '建议订购数量', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,  <!--默认显示15条-->
            page: true,
            skin: 'line',
            id:'testReload'
        });

        var form = layui.form,
            layer = layui.layer;
        form.on('submit(query)', function (data) {
            data = data.field;
            if (data.num == '') {
                layer.msg('安全库存不能为空');
                return false;
            }
            else{
                var num = $("#num").val();
                $.ajax({
                    url: "queryPrepareByNum",
                    type: "POST",
                    data: {num: num},
                    success: function (data) {
                        if (data.code == 0) {//如果成功
                            layer.msg('成功', {
                                icon: 6,
                                time: 500
                            }, function () {
                                parent.window.location.reload();
                                var iframeIndex = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(iframeIndex);
                            });
                        } else {
                            layer.msg("失败");
                        }
                    }
                })
            }


        });




    });
</script>


</body>
</html>