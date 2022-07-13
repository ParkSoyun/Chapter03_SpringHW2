
    autosize(document.getElementById('exampleFormControlTextarea1'));

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

function checkPasswordAndDelete(id) {
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