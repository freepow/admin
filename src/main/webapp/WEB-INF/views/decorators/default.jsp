<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/include/default_header.jsp"%>

<body>

<!-- Fixed top -->
<%@include file="/WEB-INF/views/common/include/default_topnavybar.jsp"%>




<!-- Content container -->
<div id="container">
    <%@include file="/WEB-INF/views/common/include/default_sidebar.jsp"%>
    <!-- Sidebar -->

    <!-- Content -->
    <div id="content">

        <!-- Content wrapper -->
        <div class="wrapper">

            <decorator:body />

        </div>
        <!-- /content wrapper -->

    </div>
    <!-- /content -->

</div>
<!-- /content container -->


<!-- Footer -->
<div id="footer">
    <div class="copyrights">&copy;  Brought to you by Eugene Kopyov.</div>
    <ul class="footer-links">
        <li><a href="" title=""><i class="icon-cogs"></i>Contact admin</a></li>
        <li><a href="" title=""><i class="icon-screenshot"></i>Report bug</a></li>
    </ul>
</div>
<!-- /footer -->

</body>
</html>