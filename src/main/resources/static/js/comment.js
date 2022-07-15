function openModifyCommentForm() {
    $('#commentContentTextarea').attr("hidden", false);
    $('#openModifyCommentForm').attr("hidden", true);
    $('#buttonCommentModify').attr("hidden", false);
    $('#buttonCommentDelete').attr("hidden", true);
    $('#closeModifyCommentForm').attr("hidden", false);
}

function closeModifyCommentForm() {
    $('#commentContentTextarea').attr("hidden", true);
    $('#openModifyCommentForm').attr("hidden", false);
    $('#buttonCommentModify').attr("hidden", true);
    $('#buttonCommentDelete').attr("hidden", false);
    $('#closeModifyCommentForm').attr("hidden", true);
}

function modifyComment(commentId) {
    let content = $('#commentContent').val();

    $.ajax({
        type: "PATCH",
        url: "/comments/" + commentId,
        data: {content: content},
        success: function (response) {
            window.location.reload();
        }
    });
}

function deleteComment(commentId) {
    $.ajax({
        type: "DELETE",
        url: "/comments/" + commentId,
        success: function (response) {
            window.location.reload();
        }
    });
}