
function checkExistId(id) {
    $.ajax({
        type: "GET",
        url: "/users/signup/" + id,
        success: function (response) {
            if(!response) {
                if(document.getElementById('id').classList.contains('is-invalid')) {
                    document.getElementById('id').classList.replace('is-invalid', 'is-valid');
                } else {
                    document.getElementById('id').classList.add('is-valid');
                }

                $('#check-duplication-success').attr("hidden", false);
                $('#check-duplication-fail').attr("hidden", true);
            } else {
                if(document.getElementById('id').classList.contains('is-valid')) {
                    document.getElementById('id').classList.replace('is-valid', 'is-invalid');
                } else {
                    document.getElementById('id').classList.add('is-invalid');
                }

                $('#check-duplication-fail').attr("hidden", false);
                $('#check-duplication-success').attr("hidden", true);
            }

        }
    });
}

function checkDuplicationResult() {
    if(document.getElementById('id').classList.contains('is-valid')) {
        return true;
    } else if(document.getElementById('id').classList.contains('is-invalid')) {
        alert("이미 존재하는 아이디입니다.");

        return false;
    } else {
        alert("아이디 중복 체크를 해주세요.");

        return false;
    }
}