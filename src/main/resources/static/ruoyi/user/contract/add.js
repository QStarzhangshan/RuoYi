$("#form-contract-add").validate({
    rules:{
        contractTopic:{
            required:true,
            remote: {
                url: ctx + "user/contract/checkContractNameUnique",
                type: "post",
                dataType: "json",
                data: {
                    "contractTopic" : function() {
                        return $.trim($("#contractTopic").val());
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
        "contractTopic": {
            remote: "合同主题已经存在"
        }
    },
    submitHandler:function(form){
        add();
    }
});


function add() {
    var contractClient = $("input[name='contractClient']").val();
    var contractTopic = $("input[name='contractTopic']").val();
    var contractOwner = $("input[name='contractOwner']").val();
    $.ajax({
        cache : true,
        type : "POST",
        url : ctx + "user/contract/save",
        data : {
            "contractClient": contractClient,
            "contractTopic": contractTopic,
            "contractOwner": contractOwner
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
