
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <style>
        .container{
            width: 500px;
            padding-top: 50px;
        }
        .form-control{
            margin-bottom: 10px;
        }
        .panel-title{
            padding:10px;
        }
        .error{
            color:red;
            font-size: 12px;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">用户登录</h3>
        </div>
        <div class="panel-body">
            <form class="form-signin" method="post" action="/user/login">
                <label  class="sr-only">用户名:</label>
                <input type="text"  name="username" class="form-control" placeholder="输入用户名" required autofocus>
                <label class="sr-only">密码</label>
                <input type="password" name="password" class="form-control" placeholder="输入密码" required>
                <span class="error">${message}</span>
                <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
            </form>
        </div>
    </div>


</div> <!-- /container -->
</body>
</html>