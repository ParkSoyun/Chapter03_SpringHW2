function deletePost(id) {
    $.ajax({
        type: "DELETE",
        url: "/posts/" + id,
        success: function (response) {
            alert("게시글 삭제가 완료되었습니다.");

            location.href="/posts"
        }
    });
}