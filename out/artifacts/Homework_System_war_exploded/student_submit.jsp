<%@ page import="Model.Homework" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Student" %>
<%@ page import="Jdbc.StudentJdbc" %><%--
  Created by IntelliJ IDEA.
  User: 17301
  Date: 2020/3/9
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看作业</title>
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
                        <li class="nav-item active"><a href="StudentHomeworkListServlet">作业列表</a></li>
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
                            <span><%=request.getSession().getAttribute("student_name")%></span>
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
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th style="text-align: center">#</th>
                                        <th style="text-align: center">作业名称</th>
                                        <th style="text-align: center">老师</th>
                                        <th style="text-align: center"></th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <%
                                        List<Homework> homework_list = (List<Homework>) request.getAttribute("homework_list");
                                        String student_name = (String) request.getSession().getAttribute("student_name");
                                        Student student = new Student(student_name);
                                        StudentJdbc student_jdbc = new StudentJdbc();
                                        int i = 0;
                                        for(Homework homework: homework_list) {
                                            Boolean no_submit = student_jdbc.QuerySubmit(student, homework.getHomework_title(), homework.getTeacher_name());
                                    %>
                                    <tr style="text-align: center">
                                        <th scope="row" style="text-align: center"><%=i+1%></th>
                                        <td><%=homework.getHomework_title()%></td>
                                        <td><%=homework.getTeacher_name()%></td>
                                        <td>
                                            <a type="submit" class="btn btn-primary btn-xs" href="edit_homework.jsp?homework_title=<%=homework.getHomework_title()%>&teacher_name=<%=homework.getTeacher_name()%>" <%if(!no_submit) {%> disabled style="pointer-events: none" <%}%>>上传作业</a>
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
