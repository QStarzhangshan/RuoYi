$("#form-client-edit").validate({
	rules:{
		clientName:{
			required:true,
			remote: {
                url: ctx + "user/client/checkClientNameUnique",
                type: "post",
                dataType: "json",
                data: {
					"clientId": function() {
					    return $("input[name='clientId']").val();
					},
					"clientName": function() {
					    return $("input[name='clientName']").val();
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
        "clientName": {
            remote: "客户已经存在"
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
	var clientId = $("input[name='clientId']").val();
	var saleId = $("input[name='saleId']").val();
	var clientName = $("input[name='clientName']").val();
	var clientOwnerLoginName = $("input[name='clientOwnerLoginName']").val();
	$.ajax({
		cache : true,
		type : "POST",
		url : ctx + "user/client/save",
		data : {
			"clientId": clientId,
			"saleId": saleId,
			"clientName": clientName,
			"clientOwnerLoginName": clientOwnerLoginName
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
