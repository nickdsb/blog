<!DOCTYPE html>
<html>
<#include "../common/head.ftl">
<head>
    <style type="text/css">
        body {
            background-color: #DADADA;
        }

        body > .grid {
            height: 100%;
        }

        .image {
            margin-top: -100px;
        }

        .column {
            max-width: 450px;
        }
    </style>
</head>
<body>

<div class="ui middle aligned center aligned grid">
    <div class="column">
        <h2 class="ui teal image header">
            <img src="assets/images/logo.png" class="image">
            <div class="content">
                Register to your account
            </div>
        </h2>
        <form class="ui large form" action="/addUser">
            <div class="ui stacked segment">
                <div class="field">
                    <div class="ui left icon input">
                        <i class="user icon"></i>
                        <input type="text" name="id" placeholder="E-mail 用户帐号">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="password" name="name" placeholder="用户昵称">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input  type="password" name="password1" placeholder="密码">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="password" name="password2" placeholder="重复密码">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="password" name="verificationCode" placeholder="验证码">
                    </div>
                </div>
                <div class="ui fluid large teal submit button">注册</div>
            </div>

            <div class="ui error message"></div>

        </form>

        <div class="ui message">
            已有账号? 去<a href="/login">登录</a>
        </div>
    </div>
</div>

<#include "../common/script.ftl">
<script>
    $(document)
            .ready(function () {
                $('.ui.form')
                        .form({
                            fields: {
                                match: {
                                    identifier  : 'password2',
                                    rules: [
                                        {
                                            type   : 'match[password1]',
                                            prompt : '再次密码不一样'
                                        }
                                    ]
                                }
                            }
                        })
                ;
            })
    ;
</script>
</body>

</html>
