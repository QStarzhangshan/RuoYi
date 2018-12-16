var prefix = ctx + "user/client"

$(function() {
    var columns = [{
        checkbox: true
    },
        {
            field: 'clientId',
            title: '客户编号'
        },
        {
            field: 'saleId',
            title: '销售ID'
        },
        {
            field: 'clientName',
            title: '客户名称'
        },
        {
            field: 'clientOwnerLoginName',
            title: '客户所有者'
        },
        {
            title: '操作',
            align: 'center',
            formatter: function(value, row, index) {
                var actions = [];
                actions.push('<a class="btn btn-primary btn-sm ' + editFlag + '" href="#" title="编辑" mce_href="#" onclick="edit(\'' + row.clientId + '\')"><i class="fa fa-edit"></i></a> ');
                /*actions.push('<a class="btn btn-warning btn-sm ' + removeFlag + '" href="#" title="删除" onclick="remove(\'' + row.roleId + '\')"><i class="fa fa-remove"></i></a>');
                */return actions.join('');
            }
        }];
    var url = prefix + "/list";
    $.initTable(columns, url);
});

/*角色管理-新增*/
function add() {
    var url = prefix + '/add';
    layer_showAuto("新增客户", url);
}
/!*角色管理-修改*!/
function edit(clientId) {
    var url = prefix + '/edit/' + clientId;
    layer_showAuto("客户修改", url);
}


/*


// 单条删除
function remove(id) {
    $.modalConfirm("确定要删除选中角色吗？", function() {
        _ajax(prefix + "/remove/" + id, "", "post");
    })
}
 */
// 批量删除
function batchRemove() {
    var rows = $.getSelections("clientId");
    if (rows.length == 0) {
        $.modalMsg("请选择要删除的数据", modal_status.WARNING);
        return;
    }
    $.modalConfirm("确认要删除选中的" + rows.length + "条数据吗?", function() {
        _ajax(prefix + '/batchRemove', { "ids": rows }, "post");

    });

}
