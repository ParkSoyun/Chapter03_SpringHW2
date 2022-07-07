// $(document).ready(function () {
//     // let result = eval('('+ ${result} +')');
//     let result = request.get;
//
//     if(result != null) {
//         alert(result);
//     }
// });



function openPasswordFormModify() {
    $('#inputPassword').attr("readonly", false);
    $('#buttonModify').attr("hidden", true);
    $('#buttonDelete').attr("hidden", true);
    $('#buttonCheckPasswordModify').attr("hidden", false);
}

function openPasswordFormDelete() {
    $('#inputPassword').attr("readonly", false);
    $('#buttonModify').attr("hidden", true);
    $('#buttonDelete').attr("hidden", true);
    $('#buttonCheckPasswordDelete').attr("hidden", false);
}

// function checkPasswordAndModify(id) {
//     let type = "modify";
//     let password = $('#inputPassword').val();
//
//     $.ajax({
//         type: "POST",
//         url: `/posts/${id}`,
//         contentType: "application/json",
//         data: JSON.stringify({type: type, password: password}),
//         success: function (response) {
//             console.log(response);
//             if(response === "/posts/modifyPost") {
//                 location.href=response;
//             } else if(response === "checkPasswordFail") {
//                 alert("비밀번호가 틀렸습니다.");
//             }
//         }
//     });
// }
//
function checkPasswordAndDelete(id) {
    let type = "delete";
    let password = $('#inputPassword').val();

    $.ajax({
        type: "DELETE",
        url: "/posts/" + id,
        data: {password: password},
        success: function (response) {
            if(response == 0) {
                alert("비밀번호가 틀렸습니다.");

                window.location.reload();
            } else {
                alert("삭제가 완료되었습니다.");

                location.href="/posts"
            }
        }
    });
}