<%@ page import="Model.Homework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 17301
  Date: 2020/3/9
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业列表</title>
    <link rel="icon" type="image/ico">
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/materialdesignicons.min.css" rel="stylesheet">
    <link href="./css/style.min.css" rel="stylesheet">
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
                        <li class="nav-item active"><a href="HomeworkListServlet">作业列表</a></li>
                        <li class="nav-item"><a href="StudentListServlet">学生列表</a></li>
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
                        <span class="navbar-page-title">作业列表</span>
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
                                <form class="pull-right search-bar" method="post" action="AddHomeworkServlet" role="form">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="homework_title" placeholder="请输入作业名称">
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
                                        <th style="text-align: center">作业名称</th>
                                        <th style="text-align: center"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<Homework> homework_list = (List<Homework>) request.getAttribute("homework_list");
                                        int i = 0;
                                        for(Homework homework: homework_list) {
                                    %>
                                    <tr style="text-align: center">
                                        <th scope="row" style="text-align: center"><%=i+1%></th>
                                        <td><%=homework.getHomework_title()%></td>
                                        <td>
                                            <a type="button" class="btn btn-info btn-xs" href="TeacherHomeworkSubmitServlet?homework_title=<%=homework.getHomework_title()%>">查看已提交名单</a>
                                        </td>
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
</body>
</html>