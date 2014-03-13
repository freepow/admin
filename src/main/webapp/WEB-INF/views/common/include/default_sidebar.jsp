<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="sidebar">

    <div class="sidebar-tabs">
        <ul class="tabs-nav two-items">
            <li><a href="#general" title=""><i class="icon-reorder"></i></a></li>
            <li><a href="#stuff" title=""><i class="icon-cogs"></i></a></li>
        </ul>

        <div id="general">

            <!-- Main navigation -->
            <ul class="navigation widget">
                <li><a href="/" title=""><i class="icon-home"></i>홈으로 가기</a></li>
                <li class="active"><a href="#" title="" class="expand" id="current"><i class="icon-tasks"></i>기초 데이터 관리<strong>4</strong></a>
                    <ul>
                        <li><a href="components.html" title="">공통 코드 관리</a></li>
                        <li><a href="content_grid.html" title="">스타일(BJCP) 관리</a></li>
                        <li><a href="content_grid.html" title="">맥아(몰트) 관리</a></li>
                        <li><a href="blank.html" title="">홉 관리</a></li>
                        <li><a href="blank.html" title="">효모 관리</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /main navigation -->

        </div>

        <div id="stuff">

            <!-- Action buttons -->
            <div class="widget">
                <button class="btn btn-block btn-danger">Action button</button>
            </div>
            <!-- /action buttons -->

        </div>

    </div>
</div>