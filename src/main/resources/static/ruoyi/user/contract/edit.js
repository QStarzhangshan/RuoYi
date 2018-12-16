// 树结构初始化加载
var setting = {
	check:{enable:true,nocheckInherit:true,chkboxType:{"Y":"ps","N":"ps"}},
	view:{selectedMulti:false,nameIsHTML: true},
	data:{simpleData:{enable:true},key:{title:"title"}},
	callback:{
		beforeClick: function (treeId, treeNode, clickFlag) {
			var menuTrees = $.fn.zTree.getZTreeObj(treeId);
			menuTrees.checkNode(treeNode, !treeNode.checked, true, true);
			return false;
		}
	}
}, menuTrees, loadTree = function(){
	$.get(ctx + "system/menu/roleMenuTreeData?roleId=" + $("#roleId").val(), function(data) {
		menuTrees = $.fn.zTree.init($("#menuTrees"), setting, data); //.expandAll(true);
	}, null, null, "正在加载，请稍后...");
};loadTree();

$("#form-contract-edit").validate({
	rules:{
		roleName:{
			required:true,
			remote: {
                url: ctx + "system/role/checkRoleNameUnique",
                type: "post",
                dataType: "json",
                data: {
					"roleId": function() {
					    return $("input[name='roleId']").val();
					},
					"roleName": function() {
					    return $("input[name='roleName']").val();
					}
                },
                dataFilter: function(data, type) {
                    if (data == "0") return true;
                    else return false;
                }
            }
		},
		roleKey:{
			required:true,
		},
		roleSort:{
			required:true,
		},
	},
	messages: {
        "roleName": {
            remote: "角色已经存在"
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
	var contractId = $("input[name='contractId']").val();
	var contractClient = $("input[name='contractClient']").val();
	var contractTopic = $("input[name='contractTopic']").val();
	var contractOwner = $("input[name='contractOwner']").val();
	$.ajax({
		cache : true,
		type : "POST",
		url : ctx + "user/contract/save",
		data : {
			"contractId": contractId,
			"contractClient": contractClient,
			"contractTopic": contractTopic,
			"contractOwner": contractOwner
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
