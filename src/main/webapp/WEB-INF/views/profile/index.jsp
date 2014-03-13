<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>


    $(document).ready(function() {
        $('#update').click(function (){
            location.href= "/profile/update";
        });
    });
</script>
<div class="wrapper">
<br/>
<!-- Invoice -->
<div class="widget">
    <div class="navbar">
        <div class="navbar-inner">
            <h6>프로필</h6>
            <button id="update" type="button" class="btn btn-success pull-right">수정</button>
            <button type="button" class="btn btn-danger pull-right">공개 설정</button>
        </div>
    </div>

    <div class="well invoice">
        <div class="row-fluid">
            <div class="span6">
                <div class="invoice-from pull-left">
                    <a href="index.html" title="invoice" class="invoice-logo"><img src="http://tv03.search.naver.net/nhnsvc?size=120x150&quality=9&q=http://sstatic.naver.net/people/portrait/201011/20101122195818179.jpg" alt="logo" /></a>
                </div>
            </div>
            <div class="span6">
                <div class="total pull-right">
                    <strong class="text-info">이병헌</strong>
                    <span>영화배우, 탤런트</span>
                </div>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span12">
                <div class="invoice-from pull-left">
                    <ul class="plus-list">
                        <li>출생 : 1970년 7월 12일 (서울특별시)</li>
                        <li>신체 : 177cm, 72kg</li>
                        <li>소속사 : BH엔터테인먼트</li>
                        <li>가족 : 동생 이은희</li>
                        <li>데뷔 : 1991년 KBS 14기 공채 탤런트</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="widget">
            <div class="tabbable"><!-- default tabs -->
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab1" data-toggle="tab">학력</a></li>
                    <li><a href="#tab2" data-toggle="tab">경력</a></li>
                    <li><a href="#tab3" data-toggle="tab">수상내역</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tab1">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th colspan="2">학력</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1989 ~</td>
                                <td>한양대학교 ERICA캠퍼스 불어불문학 학사</td>
                            </tr>
                            <tr>
                                <td> </td>
                                <td>중동고등학교</td>
                            </tr>
                            <tr>
                                <td> </td>
                                <td>영동중학교</td>
                            </tr>
                            <tr>
                                <td> </td>
                                <td>대왕초등학교</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="tab2">
                        <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th colspan="2">경력</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>2012.07</td>
                            <td>광주비엔날레 명예홍보대사</td>
                        </tr>
                        <tr>
                            <td>2010.11</td>
                            <td>서울특별시 글로벌 홍보대사</td>
                        </tr>
                        <tr>
                            <td>2010.09</td>
                            <td>캘리포니아 관광홍보대사</td>
                        </tr>
                        <tr>
                            <td>2009.12</td>
                            <td>국가정보원 명예요원</td>
                        </tr>
                        <tr>
                            <td>2007.01</td>
                            <td>BH엔터테인먼트 설립</td>
                        </tr>
                        <tr>
                            <td>2005.12</td>
                            <td>유니세프 특별대표</td>
                        </tr>
                        <tr>
                            <td>1999.07	</td>
                            <td>제주국제자유도시 명예홍보대사/td>
                        </tr>
                        <tr>
                            <td>1991</td>
                            <td>KBS 14기 공채 탤런트</td>
                        </tr>
                        </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="tab3">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th colspan="2">경력</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>2012.07</td>
                                <td>제9회 훠딩어워즈 최고해외배우상</td>
                            </tr>
                            <tr>
                                <td>2010.11</td>
                                <td>한국영화배우협회 송년의 밤 공로상</td>
                            </tr>
                            <tr>
                                <td>2010.09</td>
                                <td>캘리포니아 관광홍보대사</td>
                            </tr>
                            <tr>
                                <td>2009.12</td>
                                <td>국가정보원 명예요원</td>
                            </tr>
                            <tr>
                                <td>2007.01</td>
                                <td>BH엔터테인먼트 설립</td>
                            </tr>
                            <tr>
                                <td>2005.12</td>
                                <td>유니세프 특별대표</td>
                            </tr>
                            <tr>
                                <td>1999.07	</td>
                                <td>제주국제자유도시 명예홍보대사/td>
                            </tr>
                            <tr>
                                <td>1991</td>
                                <td>KBS 14기 공채 탤런트</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="invoice-footer">
            <span class="footer-note">현재 이병헌님은 5개의 뱃지를 획득하셨습니다.</span>
            <ul class="cards">
                <li class="discover"></li>
                <li class="visa"></li>
                <li class="mc"></li>
                <li class="pp"></li>
                <li class="amex"></li>
            </ul>
        </div>

</div>
<!-- /invoice -->


</div>
<!-- // Modal END -->
</div>