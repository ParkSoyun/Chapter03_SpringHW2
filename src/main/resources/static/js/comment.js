function openModifyCommentForm() {
    console.log("hihi");
    $("#openModifyCommentForm").attr("hidden", true);
    $("#buttonCommentModify").attr("hidden", false);
    $("#buttonCommentDelete").attr("hidden", true);
    $("#closeModifyCommentForm").attr("hidden", false);
    $("#commentContent").attr("hidden", true);
    $("#modifyCommentContentTr").attr("hidden", false);
}

function closeModifyCommentForm() {
    $("#openModifyCommentForm").attr("hidden", false);
    $("#buttonCommentModify").attr("hidden", true);
    $("#buttonCommentDelete").attr("hidden", false);
    $("#closeModifyCommentForm").attr("hidden", true);
    $("#commentContent").attr("hidden", false);
    $("#modifyCommentContentTr").attr("hidden", true);
}

function modifyComment(commentId) {
    let content = $('#modifyCommentContent').val();

    $.ajax({
        type: "PATCH",
        url: "/comments/" + commentId,
        contentType: "application/json",
        data: JSON.stringify({content: content}),
        success: function (response) {
            alert("댓글 수정이 완료되었습니다.")

            window.location.reload();
        }
    });
}

function deleteComment(commentId) {
    $.ajax({
        type: "DELETE",
        url: "/comments/" + commentId,
        success: function (response) {
            alert("댓글 삭제가 완료되었습니다.")
            window.location.reload();
        }
    });
}