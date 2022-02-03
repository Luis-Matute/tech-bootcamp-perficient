window.onload = function() {
    loadBlogs();
};

function loadBlogs() {
    $.ajax({
        url: "http://localhost:8080/allBlogPosts",
        jsonp: "callback",
        dateType: "jsonp",
        headers: {'Access-Control-Allow-Origin': '*'},

        success: function(response) {
            console.log(response);
            var table = $("<div class='blogs'>");

            response.forEach(element => {
                
                table.append(`
                    <div class='box'>
                        <h3>${element["title"]}</h3>
                        <h5>${element["content"]}</h5>
                    </div>
                `);
            });
            
           
            table.append("</div>");

            $("#blogs-container").html(table);
        },

        error: function(response) {
            console.log(response);
        }
    });
};

// $(document).ready(function() {   
//     $.ajax({
//         url: "http://localhost:8080/allBlogPosts",
//         jsonp: "callback",
//         dateType: "jsonp",
//         headers: {'Access-Control-Allow-Origin': '*'},

//         success: function(response) {
//             console.log(response);
//             var table = $("<table><tr><th>Blog Post Data</th></tr>");

//             response.forEach(element => {
//                 table.append(
//                 `<tr>
//                     <td>
//                         Data:
//                     </td>

//                     <td>
//                         ${element["id"]}
//                     </td>

//                     <td>
//                         ${element["title"]}
//                     </td>
//                 </tr>`);
//             });
            
//             // table.append("<tr><td>Data:</td><td>" + response + "</td></tr>");
            
//             table.append("</table>");

//             $("#message").html(table);
//         },

//         error: function(response) {
//             console.log(response);
//         }
//     });


// });