<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>征订信息汇总管理</title>
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
                订单类型：
                <div class="layui-inline">
                    <select id="type" name="type" class="layui-input">
                        <option value="">请选择</option>
                        <option value="0">学生征订</option>
                        <option value="1">教师征订</option>
                    </select>
                </div>
                订单状态：
                <div class="layui-inline">
                    <select id="state" name="type" class="layui-input">
                        <option value="">请选择</option>
                        <option value="0">待发出</option>
                        <option value="1">已发出</option>
                        <option value="2">已完成</option>
                    </select>
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
            </div>
        </div>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="prepareBtn"> 教材订购推荐 </button>
            </div>
        </script>

        <!--表单，查询出的数据在这里显示-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-pass" lay-event="pass">确认发出</a>
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
            url: '${pageContext.request.contextPath}/orderAll',//查询全部数据
            toolbar: '#toolbarDemo',
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
                {field:'type',width:150,title:'订单类型', align: "center",templet:function (res) {
                        if (res.type == '0') {
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: orangered;">教师征订</span>';
                        } else if (res.type == '1') {
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: orange;">学生征订</span>';
                        }
                    }},
                {field: 'reId', width: 150, title: '负责人编号', align: "center"},
                {field: 'state', width: 150, title: '订单状态', align: "center",templet:function (res) {
                        if (res.state == '0'){
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: purple;">待发出</span>';
                        }
                        else if (res.state == '1'){
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: palevioletred;">已发出</span>';
                        }
                        else if (res.state == '2'){
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: deeppink;">已完成</span>';
                        }
                    }},
                {field: 'store', width: 150, title: '库存数量', align: "center"},
                {field: 'number',width: 150,title: '订单数量',align: "center"},
                {field: 'startDate', width: 250, title: '发出时间', align: "center",templet: "<div>{{layui.util.toDateString(d.date, 'yyyy-MM-dd HH:mm:ss')}}</div>"},

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
                var state = $('#state').val();
                console.log(name)
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        bookId: bookId,
                        type:type,
                        state:state
                    }
                }, 'data');
            }
        };

        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'prepareBtn') {  // 监听添加操作
                var index = layer.open({
                    title: '教材订购建议',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '${pageContext.request.contextPath}/prepareIndex',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            }
        });

            $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'pass') {// 监听通过操作
                if (data.number>data.store){
                    layer.msg("库存不足");
                }
                else{
                    $.ajax({
                        url: "updateOrderSubmit",
                        type: "POST",
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (result) {
                            if(result.code==0){//如果成功
                                layer.msg('修改成功',{
                                    icon:6,
                                    time:500
                                }, function () {
                                    parent.window.location.reload();
                                    var iframeIndex = parent.layer.getFrameIndex(window.name);
                                    parent.layer.close(iframeIndex);
                                });
                            }else{
                                layer.msg("修改失败");
                            }
                        }
                    })
                }

            }
        });
    });
</script>

</body>
</html>