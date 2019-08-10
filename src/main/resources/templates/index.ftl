<!doctype html>
<html>
<head>
        <title>Index page</title>

        <link href="/css/index.css" rel="stylesheet">
        <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
        <h1 id="title"> ${title}</h1>

        <p></p>
        <p></p>
        <p></p>
        <p></p>
        <p></p>


    </body>

    <script>
        $(function () {
            $("#title").click(function () {
                $.ajax({
                        url:"http://localhost:8020/api/hello",
                        type:"POST",
                        data{
                            name:"guoman"
                        },
                        success:function (data,status) {
                            console.log(status);
                            $('p').html(data.action + " " + data.name);
                        },
                    error: function (error) {
                            alert(error);
                    }
                })

            });
        });
    </script>
</html>