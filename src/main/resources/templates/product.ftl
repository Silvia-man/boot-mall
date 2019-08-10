<!doctype html>
<html>
<head>
    <title>Products</title>
    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/index.css" rel="stylesheet" />
    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
    <h1>PRODUCTS</h1>
    <#list products>
    <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">NAME</th>
                <th scope="col">PRICE</th>
            </tr>
        </thead>
        <tbody>
            <#items as product>
            <tr>
                <td scope="row">${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
            </tr>
            </#items>
        </tbody>
    </table>
    <#else >
        Table is empty
    </#list>
</body>
</html>