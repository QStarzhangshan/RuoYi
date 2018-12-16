$("#form-status-edit").validate({
	rules:{
        elevator_number:{
			required:true,
			remote: {
                url: ctx + "elevator/status/checkElevatorStatusUnique",
                type: "post",
                dataType: "json",
                data: {
					"elevator_number": function() {
					    return $("input[name='elevator_number']").val();
					}
                },
                dataFilter: function(data, type) {
                    if (data == 0) return true;
                    else return false;
                }
            }
		},

	},
	messages: {
        "elevator_number": {
            remote: "电梯已经存在"
        }
    },
	submitHandler:function(form){
		update();
	}
});

function getCheckeds() {
    var menuIds = "";
    var treeNodes = menuTrees.getCheckedNodes(true);
    for (var i = 0; i < treeNodes.length; i++) {
        if (0 == i) {
        	menuIds = treeNodes[i].id;
        } else {
        	menuIds += ("," + treeNodes[i].id);
        }
    }
    return menuIds;
}

function update() {
	var sys_serviceId = $("input[name='sys_serviceId']").val();
    var user_loginname = $("input[name='user_loginname']").val();
	var task_createtime = $("input[name='task_createtime']").val();
	var task_endtime = $("input[name='task_endtime']").val();
	$.ajax({
		cache : true,
		type : "POST",
		url : ctx + "elevator/status/appoint",
		data : {
			"sys_serviceId": sys_serviceId,
			"user_loginname": user_loginname,
			"task_createtime": task_createtime,
			"task_endtime": task_endtime
		},
		async : false,
		error : function(request) {
			$.modalAlert("系统错误", modal_status.FAIL);
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("修改成功,正在刷新数据请稍后……",{icon:1,time: 500,shade: [0.1,'#fff']},function(){
					$.parentReload();
				});
			} else {
				$.modalAlert(data.msg, modal_status.FAIL);
			}

		}
	});
}
