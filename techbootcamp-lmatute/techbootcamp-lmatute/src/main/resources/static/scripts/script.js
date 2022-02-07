window.onload = function() {

    if($("#blogs-container").length) {
        loadBlogs();
    }

    if ($("#authors-container").length) {
        loadAuthors();
    }
};

function loadBlogs() {
    $.ajax({
        url: "http://localhost:8080/allBlogPosts",
        jsonp: "callback",
        dateType: "jsonp",
        headers: {'Access-Control-Allow-Origin': '*'},

        success: function(response) {
            var blogs = $("<div class='blogs'>");

            response.forEach(element => {
                
                blogs.append(`
                    <div class='box'>
                        <h3>${element["title"]}</h3>
                        <h5>${element["content"]}</h5>
                    </div>
                `);
            });
            
           
            blogs.append("</div>");

            $("#blogs-container").html(blogs);
        },

        error: function(response) {
            console.log(response);
        }
    });
};

function loadAuthors() {
    $.ajax({
        url: "http://localhost:8080/allAuthors",
        jsonp: "callback",
        dateType: "jsonp",
        headers: {'Access-Control-Allow-Origin': '*'},

        success: function(response) {    
            var authors = $("<div class='authors'>");
           
            response.forEach(element => {
                authors.append(`
                    <div class='author-container'>
                        <h3 class='author-username'>${element["username"]}</h3>
                        <h5 class='author-description'>${element["description"] ? element["description"] : ''}</h5>
                    </div>
                `);
                
                authors.append("<h5>Author's blog posts:</h5>");
                
                element["blogPosts"].forEach(blogPost => {
                    authors.append(`
                        <div class='box'>
                            <h3>${blogPost["title"]}</h3>
                            <h5>${blogPost["content"]}</h5>
                        </div>`);
                });
            });
              
            authors.append("</div>");
            console.log(authors);
            $("#authors-container").html(authors);
        },

        error: function(response) {
            console.log(response);
        }
    });
};
