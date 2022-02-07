const minimumTitleLength = 5;
const minimumContentLength = 12;

window.onload = function() {
    onSubmitForm(); 
    onCreateFormSubmission();
    onLoginSubmission();
};

function onSubmitForm() {
    $("#createBlogForm").submit(function(event){
        event.preventDefault();

        var form = $(this)
        var title = form.find("input[name='title']").val();
        var content = form.find("textarea[name='content']").val();

        var author = {
            "id": 1
        }

        if (areValidInputs(title, content)) {
            $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                url: "http://localhost:8080/createBlogPost",
                data: JSON.stringify({'title': title, 'content': content, "author": author}),
                headers: {
                    'Access-Control-Allow-Origin': '*'
                }
            });

        }
    });
}

function onCreateFormSubmission() {
    $("#createAccountForm").submit(function(event){
        event.preventDefault();

        var form = $(this)
        var username = form.find("input[name='username']").val();
        var password = form.find("input[name='password']").val();
        var confirmPassword = form.find("input[name='confirm-password']").val();

        if (areValidCredentials(username, password) && passwordsMatch(password, confirmPassword)) {

            $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                url: "http://localhost:8080/createAuthor",
                data: JSON.stringify({'username': username, 'password': password}),
                headers: {
                    'Access-Control-Allow-Origin': '*'
                }
            });

            
        } else if (!passwordsMatch) {
            var message = $("<h2>Passwords do not match!</h2>");
            $("#error-message").html(message);
        }
    });
}

function onLoginSubmission() {
    $("#loginForm").submit(function(event){
        event.preventDefault();

        var form = $(this)
        var username = form.find("input[name='username']").val();
        var password = form.find("input[name='password']").val();

        
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8080/createBlogPost",
            data: JSON.stringify({'title': username, 'content': password, "author": author}),
            headers: {
                'Access-Control-Allow-Origin': '*'
            },
            success: function(response) {
                // Initiate session
            }
        });
    });
}

function areValidCredentials(username, password) {
    return username.length >= 5 &&
    password.length >= 8 &&
    username &&
    password;
}   

function passwordsMatch(password1, password2) {
    return password1 === password2;
}

function areValidInputs(title, content) {
    return title.length >= minimumTitleLength &&
    content.length >= minimumContentLength &&
    title &&
    content;
}
