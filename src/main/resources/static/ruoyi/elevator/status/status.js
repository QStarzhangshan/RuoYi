var prefix = ctx + "elevator/status"

$(function() {
    var columns = [{
        checkbox: true
    },
        {
            field: 'id',
            title: '电梯编号'
        },
        {
            field: 'client_name',
            title: '业主'
        },
        // {
        //     field: 'ladder_number',
        //     title: '梯号'
        // },{
        //     field: 'model',
        //     title: '型号'
        // },
        // {
        //     field: 'portal_door',
        //     title: '层站门'
        // },
        // {
        //     field: 'serial_number',
        //     title: '出厂编号'
        // },
        // {
        //     field: 'registration_code',
        //     title: '注册代码'
        // },
        // {
        //     field: 'first_certificate',
        //     title: '首次出证'
        // },
        {
            field: 'address',
            title: '地址'
        },
        {
            field: 'model',
            title: '型号'
        },
        {
            field: 'contact_name',
            title: '联系人'
        },
        {
            field: 'contact_phone',
            title: '联系电话'
        },
        // {
        //     field: 'id',
        //     title: '状态编号'
        // },
        // {
        //     field: 'province',
        //     title: '省'
        // },
        // {
        //     field: 'city',
        //     title: '市'
        // },
        // {
        //     field: 'area',
        //     title: '区'
        // },
        // {
        //     field: 'building',
        //     title: '楼'
        // },
        // {
        //     field: 'elevator_number',
        //     title: '电梯编号'
        // },
        // {
        //     field: 'service_type',
        //     title: '服务类型'
        // },
        // {
        //     field: 'run_time',
        //     title: '电梯初始运行时间'
        // },
        {
        	title: '操作 ',
            align: 'center',
            width: '150px',
            formatter: function(value, row, index) {
                var actions = [];
                actions.push('<a ' + seeFlag + '" href="#" title="查看" onclick="see(\'' + row.id + '\')">详情 </a>');
                actions.push('<a ' + modifyFlag + '" href="#" title="修改" onclick="modify(\'' + row.id + '\')">修改 </a>');
                actions.push('<a ' + editFlag + '" href="#" title="指派" mce_href="#" onclick="appoint(\'' + row.id + '\')">指派</a> ');
                
                return actions.join('');
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


function see(id) {
    var url = prefix + '/see/' + id;
   layer_showAuto("查看信息", url);
}

function modify(id){
	 var url = prefix + '/modify/' + id;
	 layer_showAuto("修改信息", url);
}

/!*角色管理-修改*!/
function appoint(id) {
    var url = prefix + '/appoint/' + id;
    layer_showAuto("指派任务", url);
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
