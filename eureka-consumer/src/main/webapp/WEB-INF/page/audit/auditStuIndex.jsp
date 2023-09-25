<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生教材申请信息管理</title>
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
        <div class="demoTable">
            <div class="layui-form-item layui-form">
                教材编号：
                <div class="layui-inline">
                    <input class="layui-input" name="bookId" id="bookId" autocomplete="off">
                </div>
                审核状态：
                <div class="layui-inline">
                    <select id="type" name="type" class="layui-input">
                        <option value="">请选择</option>
                        <option value="0">等待审核</option>
                        <option value="1">申请通过</option>
                        <option value="2">申请驳回</option>
                    </select>
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
            </div>
        </div>

        <!--表单，查询出的数据在这里显示-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-pass" lay-event="pass">通过</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-pass" lay-event="back">驳回</a>
        </script>

    </div>
</div>

<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/auditStuAll',//查询全部数据
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                //{field: 'id', width: 100, title: 'ID', sort: true},
                {field:'id', width:100,title: '序号' , align:'center'},
                {field:'bookId',width:150,title:'教材编号', align: "center"},
                {field: 'bookName', width: 150, title: '教材名称', align: "center"},
                {field:'courseId',width:150,title:'课程编号', align: "center"},
                {field: 'courseName', width: 150, title: '课程名称', align: "center"},
                {field: 'grade', width: 150, title: '班级', align: "center"},
                {field: 'stuId', width: 150, title: '学生学号', align: "center"},
                {field: 'stuName', width: 150, title: '学生姓名', align: "center"},
                {field: 'number', width: 150, title: '申请数量', align: "center"},
                {field: 'price', width: 150, title: '教材单价', align: "center"},
                {field: 'sum', width: 150, title: '教材总价', align: "center"},
                {field: 'date', width: 250, title: '申请时间', align: "center",templet: "<div>{{layui.util.toDateString(d.date, 'yyyy-MM-dd HH:mm:ss')}}</div>"},
                {field: 'type', width: 150, title: '审核状态', align: "center",templet:function (res) {
                        if (res.type == '0'){
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs">正在审核</span>';
                        }
                        else if (res.type == '1'){
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: orangered;">申请通过</span>';
                        }
                        else if (res.type == '2'){
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: purple;">申请驳回</span>';
                        }
                    }},

                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,  <!--默认显示15条-->
            page: true,
            skin: 'line',
            id:'testReload'
        });

        var $ = layui.$, active = {
            reload: function(){
                var bookId = $('#bookId').val();
                var type = $('#type').val();
                console.log(name)
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        bookId: bookId,
                        type:type
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        /**
         * tool操作栏监听事件
         */
        table.on('tool(currentTableFilter)', function (obj) {
            var data=obj.data;
            if (obj.event === 'pass') {  // 监听通过操作
                $.ajax({
                    url:"updateAuditStuSubmit1",
                    type:"POST",
                    contentType:'application/json',
                    data:JSON.stringify(data),
                    success:function(result){
                        if(result.code==0){//如果成功
                            layer.msg('修改成功',{
                                icon:6,
                                time:500
                            })
                        }else{
                            layer.msg("修改失败");
                        }
                    }
                })
            }
            else if (obj.event === 'back') {// 监听驳回操作
                $.ajax({
                    url:"updateAuditStuSubmit2",
                    type:"POST",
                    contentType:'application/json',
                    data:JSON.stringify(data),
                    success:function(result){
                        if(result.code==0){//如果成功
                            layer.msg('修改成功',{
                                icon:6,
                                time:500
                            })
                        }else{
                            layer.msg("修改失败");
                        }
                    }
                })


            }
        });

    });
</script>

</body>
</html>
