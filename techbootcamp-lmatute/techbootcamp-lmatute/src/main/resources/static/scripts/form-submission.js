const minimumTitleLength = 5;
const minimumContentLength = 12;

window.onload = function() {
    onSubmitForm(); 
};

function onSubmitForm() {
    $("#createBlogForm").submit(function(event){
        event.preventDefault();

        var form = $(this)
        var title = form.find("input[name='title']").val();
        var content = form.find("textarea[name='content']").val();

        if (areValidInputs(title, content)) {
            $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                url: "http://localhost:8080/createBlogPost",
                data: JSON.stringify({'title': title, 'content': content}),
                headers: {
                    'Access-Control-Allow-Origin': '*'
                }
            });

        }
    });
}

function areValidInputs(title, content) {
    return title.length >= minimumTitleLength &&
    content.length >= minimumContentLength &&
    title &&
    content;
}
