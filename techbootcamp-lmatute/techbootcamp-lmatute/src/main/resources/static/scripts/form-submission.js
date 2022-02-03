window.onload = function() {
    onSubmitForm();
};

function onSubmitForm() {
    $("#createBlogForm").submit(function(event){
        event.preventDefault();

        var form = $(this)
        var title = form.find("input[name='title']").val();
        var content = form.find("textarea[name='content']").val();

        var data = {
            "title": title,
            "content": content
        };

        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8080/createBlogPost",
            data: JSON.stringify({'title': title, 'content': content}),
            headers: {
                'Access-Control-Allow-Origin': '*'
            }
        });
    });
}