<%@ page import="Model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 17301
  Date: 2020/3/9
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="icon" type="image/ico">
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/materialdesignicons.min.css" rel="stylesheet">
    <link href="./css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./js/jconfirm/jquery-confirm.min.css">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <aside class="lyear-layout-sidebar">
            <div id="logo" class="sidebar-header">
                <a style="height: 64px"><img src="./images/logo-sidebar.png"/></a>
            </div>
            <div class="lyear-layout-sidebar-scroll">
                <nav class="sidebar-main">
                    <ul class="nav nav-drawer">
                        <li class="nav-item"><a href="HomeworkListServlet">作业列表</a></li>
                        <li class="nav-item active"><a href="StudentListServlet">学生列表</a></li>
                    </ul>
                </nav>
            </div>
        </aside>

        <header class="lyear-layout-header">
            <nav class="navbar navbar-default">
                <div class="topbar">
                    <div class="topbar-left">
                        <div class="lyear-aside-toggler">
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                        </div>
                        <span class="navbar-page-title">学生列表</span>
                    </div>

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <span><%=session.getAttribute("teacher_name")%></span>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <form class="pull-right search-bar" method="post" action="AddStudentServlet" role="form">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="student_name" placeholder="请输入学生姓名">
                                        <div class="input-group-btn">
                                            <input class="btn btn-primary" type="submit" value="+ 新增" />
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center">#</th>
                                        <th style="text-align: center">学生姓名</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<Student> student_list = (List<Student>) request.getAttribute("student_list");
                                        int i = 0;
                                        for(Student student: student_list) {
                                    %>
                                    <tr style="text-align: center">
                                        <th scope="row" style="text-align: center"><%=i+1%></th>
                                        <td><%=student.getStudent_name()%></td>
                                    </tr>
                                    <%
                                            i++;
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </main>
    </div>
</div>

<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="./js/main.min.js"></script>
<script src="./js/jconfirm/jquery-confirm.min.js"></script>
<script type="text/javascript">
    $('.add_student').on('click', function () {
        $.confirm({
            title: '新增学生',
            content: '' +
                '<form action="" class="formName">' +
                '<div class="form-group">' +
                '<label>请输入学生姓名</label>' +
                '<input type="text" placeholder="学生姓名" class="student_name form-control" required />' +
                '</form>',
            buttons: {
                formSubmit: {
                    text: '添加',
                    btnClass: 'btn-primary',
                    action: function () {
                        var student_name = this.$content.find('.student_name').val();
                        if(!student_name){
                            $.confirm({
                                title: '错误',
                                content: '请输入学生姓名',
                                type: 'red',
                                typeAnimated: false,
                                buttons: {
                                    omg: {
                                        text: '确定',
                                        btnClass: 'btn-red',
                                    },
                                    close: {
                                        text: '关闭',
                                    }
                                }
                            });

                            return false;
                        }
                    }
                },
                cancel: {
                    text: '取消'
                },
            },

            onContentReady: function () {
                var jc = this;
                this.$content.find('form').on('submit', function (e) {
                    e.preventDefault();
                    jc.$$formSubmit.trigger('click');
                });
            }
        });
    });
</script>
</body>
</html>
