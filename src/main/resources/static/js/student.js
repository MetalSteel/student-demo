/**
 * Created by MetalSteel on 2017/8/29.
 */
$(function () {
    // 初始化Bootstrap-Table
    $('#tables').bootstrapTable({
        method: 'POST',
        contentType: "application/x-www-form-urlencoded",
        url:"getAllStudents",//要请求数据的文件路径
        toolbar: '#toolbar',//指定工具栏
        striped: true, //是否显示行间隔色
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination:true,//是否分页
        sidePagination:'client',//此处指定客户端分页
        pageSize:10,//单页记录数
        pageList:[5,10,20,30],//分页步进值
        showRefresh:true,//刷新按钮
        showColumns:true,
        clickToSelect: true,//是否启用点击选中行
        toolbarAlign:'left',//工具栏对齐方式
        buttonsAlign:'right',//按钮对齐方式
        showToggle:true, //是否显示详细视图和列表视图的切换按钮
        minimumCountColumns: 2, //最少允许的列数
        toolbar:'#toolbar',//指定工作栏
        columns:[
            {
                title:'全选',
                field:'select',
                //复选框
                checkbox:true,
                width:25,
                align:'center',
                valign:'middle'
            },
            {
                title:'主键',
                field:'id',
                sortable:true
            },
            {
                title:'姓名',
                field:'name',
            },
            {
                title:'性别',
                field:'sex',
            },
            {
                title:'住址',
                field:'address',
            },
            {
                title:'语文',
                field:'chinese'
            },
            {
                title:'数学',
                field:'math'
            },
            {
                title:'英语',
                field:'english'
            }
        ],
        locale:'zh-CN',//中文支持
        responseHandler:function(res){
            //在ajax获取到数据，渲染表格之前，修改数据源
            return res;
        }
    });
});
// 查询
$("#btn_query").click(function () {
    $('#tables').bootstrapTable('refresh');
});
// 添加学生
$("#submitStudentForm").click(function () {
    $.ajax({
        url:"/student-demo/addStudent",
        type:"POST",
        data:$("#addStudentForm").serialize(),
        async:"false",
        success:function (data) {
            alert(data.msg);
            $('#tables').bootstrapTable('refresh');
        }
    });
})
// 删除学生
$("#btn_delete").click(function () {
    var rows = $('#tables').bootstrapTable('getSelections');
    if(rows.length==1){
        var obj = rows[0];
        var id = obj.id;
        $.ajax({
            url:"/student-demo/deleteStudent/"+id,
            type:"DELETE",
            success:function (data) {
                alert(data.msg);
                $('#tables').bootstrapTable('refresh');
            }
        });
    }else{
        alert("请选中一行删除")
    }
})
// 更新学生
$("#btn_update").click(function () {
    var rows = $('#tables').bootstrapTable('getSelections');
    if(rows.length==1){
        var obj = rows[0];
        $("#edu_modal").modal('toggle');
    }else{
        alert("请先选中一行")
    }
})

