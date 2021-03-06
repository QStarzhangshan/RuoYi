$("#form-status-add").validate({
    rules:{
        elevator_number:{
            required:true,
            remote: {
                url: ctx + "elevator/status/checkElevatorStatusUnique",
                type: "post",
                dataType: "json",
                data: {
                    "elevator_number" : function() {
                        return $.trim($("#elevator_number").val());
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
        add();
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

function add() {
    var user_number = $("input[name='user_number']").val();
    var province = $("input[name='province']").val();
    var city = $("input[name='city']").val();
    var area = $("input[name='area']").val();
    var building = $("input[name='building']").val();
    var elevator_number = $("input[name='elevator_number']").val();
    var service_type = $("input[name='service_type']").val();
    var run_time = $("input[name='run_time']").val();
    $.ajax({
        cache : true,
        type : "POST",
        url : ctx + "elevator/status/save",
        data : {
            "user_number": user_number,
            "province": province,
            "city": city,
            "area": area,
            "building":building,
            "elevator_number":elevator_number,
            "service_type":service_type,
            "run_time":run_time
        },
        async : false,
        error : function(request) {
            $.modalAlert("系统错误", modal_status.FAIL);
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("新增成功,正在刷新数据请稍后……",{icon:1,time: 500,shade: [0.1,'#fff']},function(){
                    $.parentReload();
                });
            } else {
                $.modalAlert(data.msg, modal_status.FAIL);
            }

        }
    });
}
