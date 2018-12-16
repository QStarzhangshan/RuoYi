$("#form-sale-add").validate({
    rules:{
        saleName:{
            required:true,
            remote: {
                url: ctx + "user/sale/checkSaleNameUnique",
                type: "post",
                dataType: "json",
                data: {
                    "saleName" : function() {
                        return $.trim($("#saleName").val());
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
        "saleName": {
            remote: "销售名称已经存在"
        }
    },
    submitHandler:function(form){
        add();
    }
});


function add() {
    var userLoginName = $("input[name='userLoginName']").val();
    var clientName = $("input[name='clientName']").val();
    var saleName = $("input[name='saleName']").val();
    $.ajax({
        cache : true,
        type : "POST",
        url : ctx + "user/sale/save",
        data : {
            "userLoginName": userLoginName,
            "clientName": clientName,
            "saleName": saleName
        },
        async : true,
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
