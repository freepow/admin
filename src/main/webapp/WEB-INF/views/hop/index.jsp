<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
$(function() {
    $( "#spinner-default" ).spinner();

    $( "#range-slider, #range-slider1" ).slider({
        range: true,
        min: 0,
        max: 100,
        values: [ 0, 100 ],
        slide: function( event, ui ) {
            $( "#price-amount, #price-amount1" ).val(  ui.values[ 0 ] + " %" + " - " + ui.values[ 1 ] + " %" );
        }
    });

    $( "#price-amount, #price-amount1" ).val(  $( "#range-slider, #range-slider1" ).slider( "values", 0 ) + " %"+
            " - " + $( "#range-slider, #range-slider1" ).slider( "values", 1 ) + " %" )
});

</script>
<!-- Breadcrumbs line -->
<div class="crumbs">
    <ul id="breadcrumbs" class="breadcrumb">
        <li><a href="index.html">기초 데이터 관리 </a></li>
        <li class="active"><a href="calendar.html" title="">Calendar</a></li>
    </ul>

    <ul class="alt-buttons">
        <li><a href="#" title=""><i class="icon-signal"></i><span>Stats</span></a></li>
        <li><a href="#" title=""><i class="icon-comments"></i><span>Messages</span></a></li>
        <li class="dropdown"><a href="#" title="" data-toggle="dropdown"><i class="icon-tasks"></i><span>Tasks</span> <strong>(+16)</strong></a>
            <ul class="dropdown-menu pull-right">
                <li><a href="#" title=""><i class="icon-plus"></i>Add new task</a></li>
                <li><a href="#" title=""><i class="icon-reorder"></i>Statement</a></li>
                <li><a href="#" title=""><i class="icon-cog"></i>Settings</a></li>
            </ul>
        </li>
    </ul>
</div>
<!-- /breadcrumbs line -->

<!-- Page header -->
<div class="page-header">
    <div class="page-title">
        <h5>홉 관리</h5>
        <span>Hops</span>
    </div>
</div>

<div class="widget">
    <div class="navbar"><div class="navbar-inner">
        <a href="#" class="btn btn-primary pull-right popover-test" title="A Title">조회</a>
        <a href="#" class="btn btn-danger pull-right popover-test" title="A Title">추가</a>
    </div></div>
    <div class="table-overflow">
        <table class="table table-bordered">
            <tr>
                <td>이름</td>
                <td><input type="text" value="" placeholder="홉 이름" /></td>
                <td>타입</td>
                <td>
                    <input class="validate[minCheckbox[2]] styled" type="checkbox" name="group[group]" id="maxcheck1" value="5" data-prompt-position="topLeft:-1,-5"/> 전체
                    <input class="validate[minCheckbox[2]] styled" type="checkbox" name="group[group]" id="maxcheck2" value="5" data-prompt-position="topLeft:-1,-5"/> Aroma
                    <input class="validate[minCheckbox[2]] styled" type="checkbox" name="group[group]" id="maxcheck3" value="5" data-prompt-position="topLeft:-1,-5"/> Bittering
                </td>
                <td>원산지</td>
                <td>
                    <select name="select2" class="styled" >
                        <option value="opt1">전체</option>
                        <option value="opt2">미국</option>
                        <option value="opt3">독일</option>
                        <option value="opt4">영국</option>
                        <option value="opt5">뉴질랜드</option>
                        <option value="opt6">호주</option>
                        <option value="opt7">슬로베니아</option>
                        <option value="opt8">체코</option>
                        <option value="opt8">기타</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="slider-controls">
                        <label for="price-amount1">알파 (ALPHA)</label>
                        <input type="text" id="price-amount1" />
                    </div>
                    <div id="range-slider1"></div>
                </td>
                <td>베타 (BETA)</td>
                <td>

                </td>
                <td>HSI</td>
                <td>
                    <input type="text" id="spinner-default" value="10" /> 이상
                </td>
            </tr>
        </table>
    </div>
</div>

<!-- Full size widget -->
<div class="widget">
    <div class="table-overflow">
        <table class="table table-striped table-bordered" id="data-table">
            <thead>
            <tr>
                <th>이름</th>
                <th>타입</th>
                <th>알파</th>
                <th>베타</th>
                <th>HSI</th>
                <th>노트</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>@mdo</td>
                <td>@mdo</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<!-- /default datatable -->
<!-- /full size widget -->