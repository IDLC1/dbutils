


$("#loginBtn").click(function(){
    let mData = {
        account: $("#acc").val(),
        password: $("#pwd").val()
    };
    $.ajax({
        url: "/user/login",
        contentType:"application/json",
        dataType:"json",
        data: JSON.stringify(mData),
        type:"post",
        success: function (res) {
            console.log(res);
            if(res.code !== 0) alert(res.msg);
        }
    })
});


// $("#regBtn").click(function(){
//     let mData = {
//         account: $("#regAcc").val(),
//         password: $("#regPwd").val()
//     };
//     console.log(JSON.stringify(mData))
//     $.ajax({
//         url: "/user/register",
//         contentType: "application/json",
//         data: JSON.stringify(mData),
//         dataType:"json",
//         type:"POST",
//         success: function (res) {
//             if(res.code !== 0) alert(res.msg);
//         }
//     })
// });
