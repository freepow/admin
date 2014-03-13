<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
    function getBirthMonth(userBirthYear){
        $.ajax({
            type: 'get',
            dataType : "json",
            url : '/common/getBirthMonth',
            contentType: "application/json",
            success:function(result){
                //월 세팅 selectbox 초기화
                $("#userBirthMonth").find("option").remove().end().append("<option value=''>- 선택 -</option>");

                //결과 갯수 만큼 날짜 세팅
                $.each(result, function(i){
                    $("#userBirthMonth").append("<option value='"+result[i].code+"'>"+result[i].codeName+"</option>")
                });
            },
            error:function(xhr,statue,error){
               alert(error);
            }
        });
    }

    function getBirthDate(userBirthYear, userBirthMonth){
        $.ajax({
            type: 'get',
            dataType : "json",
            url : '/common/getBirthDate/'+userBirthYear+"/"+userBirthMonth,
            contentType: "application/json",
            success:function(result){
                //월 세팅 selectbox 초기화
                $("#userBirthDay").find("option").remove().end().append("<option value=''>- 선택 -</option>");

                //결과 갯수 만큼 날짜 세팅
                $.each(result, function(i){
                    $("#userBirthDay").append("<option value='"+result[i]+"'>"+result[i]+"일</option>")
                });
            },
            error:function(xhr,statue,error){
                alert(error);
            }
        });
    }

    $(document).ready(function() {

        //키 세팅
        $( "#slider-range-min, #slider-range-min1" ).slider({
            range: "min",
            value: ${profile.userHeight},
            min: 100,
            max: 220,
            slide: function( event, ui ) {
                $( "#min-amount, #userHeight" ).val( ui.value + "cm" );
            }
        });
        $( "#min-amount, #userHeight" ).val($( "#slider-range-min, #slider-range-min1" ).slider( "value" ) + "cm");

        //키 세팅
        $( "#slider-range-min, #slider-range-min2" ).slider({
            range: "min",
            value: ${profile.userWeight},
            min: 30,
            max: 150,
            slide: function( event, ui ) {
                $( "#min-amount, #userWeight" ).val( ui.value + "kg"  );
            }
        });
        $( "#min-amount, #userWeight" ).val($( "#slider-range-min, #slider-range-min2" ).slider( "value" ) + "kg");

        $('#userBirthYear').change(function (){
            var userBirthYear = $("#userBirthYear option:selected").val();
            getBirthMonth(userBirthYear);
        });

        $('#userBirthMonth').change(function (){
            var userBirthYear  = $("#userBirthYear option:selected").val();
            var userBirthMonth = $("#userBirthMonth option:selected").val();
            getBirthDate(userBirthYear, userBirthMonth);
        });

    });
</script>
<div class="wrapper">
<br/>
    <!-- Invoice -->
    <div class="widget">
        <div class="navbar">
            <div class="navbar-inner">
                <h6>프로필 수정</h6>
                <button type="button" class="btn btn-success pull-right">프로필 보기</button>
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
                    <div class="control-group">
                        <div class="controls">
                            <input type="file" class="styled">
                            <button type="submit" class="btn btn-primary glyphicons circle_okbtn-large">프로필 사진 업로드</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="widget">
                <div class="tabbable"><!-- default tabs -->
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab1" data-toggle="tab">기본정보</a></li>
                        <li><a href="#tab2" data-toggle="tab">사진 / 동영상</a></li>
                        <li><a href="#tab3" data-toggle="tab">경력</a></li>
                        <li><a href="#tab4" data-toggle="tab">학력</a></li>
                        <li><a href="#tab5" data-toggle="tab">기타</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tab1">
                            <form:form action="/profile/update_bio" id="update_bio" method="post" modelAttribute="profile">
                                <!-- Row -->
                                <div class="row-fluid">

                                    <!-- Column -->
                                    <div class="span6">

                                        <!-- Group -->
                                        <div class="control-group">
                                            <label class="control-label">한글 이름</label>
                                            <div class="controls">
                                                <form:input path="userName" type="text" value="${profile.userName}" class="span4"/>
                                            </div>
                                        </div>
                                        <!-- // Group END -->

                                        <!-- Group -->
                                        <div class="control-group">
                                            <label class="control-label">생년월일</label>
                                            <div class="controls">
                                                <select name="userBirthYear" id="userBirthYear" title="년도 선택" class="span3">
                                                    <option value=''>년도</option>
                                                    <option value='1999'>1999년</option>
                                                    <option value='1998'>1998년</option>
                                                    <option value='1997'>1997년</option>
                                                    <option value='1996'>1996년</option>
                                                    <option value='1995'>1995년</option>
                                                    <option value='1994'>1994년</option>
                                                    <option value='1993'>1993년</option>
                                                    <option value='1992'>1992년</option>
                                                    <option value='1991'>1991년</option>
                                                    <option value='1990'>1990년</option>
                                                    <option value='1989'>1989년</option>
                                                    <option value='1988'>1988년</option>
                                                    <option value='1987'>1987년</option>
                                                    <option value='1986'>1986년</option>
                                                    <option value='1985'>1985년</option>
                                                    <option value='1984'>1984년</option>
                                                    <option value='1983'>1983년</option>
                                                    <option value='1982'>1982년</option>
                                                    <option value='1981'>1981년</option>
                                                    <option value='1980'>1980년</option>
                                                    <option value='1979'>1979년</option>
                                                    <option value='1978'>1978년</option>
                                                    <option value='1977'>1977년</option>
                                                    <option value='1976'>1976년</option>
                                                    <option value='1975'>1975년</option>
                                                    <option value='1974'>1974년</option>
                                                    <option value='1973'>1973년</option>
                                                    <option value='1972'>1972년</option>
                                                    <option value='1971'>1971년</option>
                                                    <option value='1970'>1970년</option>
                                                    <option value='1969'>1969년</option>
                                                    <option value='1968'>1968년</option>
                                                    <option value='1967'>1967년</option>
                                                    <option value='1966'>1966년</option>
                                                    <option value='1965'>1965년</option>
                                                    <option value='1964'>1964년</option>
                                                    <option value='1963'>1963년</option>
                                                    <option value='1962'>1962년</option>
                                                    <option value='1961'>1961년</option>
                                                    <option value='1960'>1960년</option>
                                                    <option value='1959'>1959년</option>
                                                    <option value='1958'>1958년</option>
                                                    <option value='1957'>1957년</option>
                                                    <option value='1956'>1956년</option>
                                                    <option value='1955'>1955년</option>
                                                    <option value='1954'>1954년</option>
                                                    <option value='1953'>1953년</option>
                                                    <option value='1952'>1952년</option>
                                                    <option value='1951'>1951년</option>
                                                    <option value='1950'>1950년</option>
                                                    <option value='1949'>1949년</option>
                                                    <option value='1948'>1948년</option>
                                                    <option value='1947'>1947년</option>
                                                    <option value='1946'>1946년</option>
                                                    <option value='1945'>1945년</option>
                                                    <option value='1944'>1944년</option>
                                                    <option value='1943'>1943년</option>
                                                    <option value='1942'>1942년</option>
                                                    <option value='1941'>1941년</option>
                                                    <option value='1940'>1940년</option>
                                                    <option value='1939'>1939년</option>
                                                    <option value='1938'>1938년</option>
                                                    <option value='1937'>1937년</option>
                                                    <option value='1936'>1936년</option>
                                                    <option value='1935'>1935년</option>
                                                    <option value='1934'>1934년</option>
                                                    <option value='1933'>1933년</option>
                                                    <option value='1932'>1932년</option>
                                                    <option value='1931'>1931년</option>
                                                    <option value='1930'>1930년</option>
                                                    <option value='1929'>1929년</option>
                                                    <option value='1928'>1928년</option>
                                                    <option value='1927'>1927년</option>
                                                    <option value='1926'>1926년</option>
                                                    <option value='1925'>1925년</option>
                                                    <option value='1924'>1924년</option>
                                                    <option value='1923'>1923년</option>
                                                    <option value='1922'>1922년</option>
                                                    <option value='1921'>1921년</option>
                                                    <option value='1920'>1920년</option>
                                                    <option value='1919'>1919년</option>
                                                    <option value='1918'>1918년</option>
                                                    <option value='1917'>1917년</option>
                                                    <option value='1916'>1916년</option>
                                                    <option value='1915'>1915년</option>
                                                    <option value='1914'>1914년</option>
                                                    <option value='1913'>1913년</option>
                                                    <option value='1912'>1912년</option>
                                                    <option value='1911'>1911년</option>
                                                    <option value='1910'>1910년</option>
                                                    <option value='1909'>1909년</option>
                                                    <option value='1908'>1908년</option>
                                                    <option value='1907'>1907년</option>
                                                    <option value='1906'>1906년</option>
                                                    <option value='1905'>1905년</option>
                                                    <option value='1904'>1904년</option>
                                                    <option value='1903'>1903년</option>
                                                    <option value='1902'>1902년</option>
                                                    <option value='1901'>1901년</option>
                                                    <option value='1900'>1900년</option>
                                                </select>
                                                <select name="userBirthMonth" id="userBirthMonth"  class="span2">
                                                    <option value=''>월</option>
                                                </select>
                                                <select name="userBirthDay" id="userBirthDay" class="span2">
                                                    <option value=''>일</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- // Group END -->
                                        <br/> <br/>
                                        <!-- Group -->
                                        <div class="control-group">
                                            <label class="control-label">특기</label>
                                            <div class="controls"><input type="text" id="tags3" class="tags-autocomplete" value="영화배우, 탤런트" /></div>
                                        </div>
                                        <!-- // Group END -->

                                    </div>
                                    <!-- // Column END -->

                                    <!-- Column -->
                                    <div class="span6">

                                        <!-- Group -->
                                        <div class="control-group">
                                            <label class="control-label">성별</label>
                                            <div class="controls">
                                                <label class="radio">
                                                    <form:radiobutton path="userGender" value="1" class="styled"  />
                                                    남자
                                                    <form:radiobutton path="userGender" value="2" class="styled"  />
                                                    여자
                                                    <form:radiobutton path="userGender" value="3" class="styled"  />
                                                    기타
                                                </label>
                                            </div>
                                        </div>
                                        <!-- // Group END -->

                                        <!-- Group -->
                                        <div class="control-group">
                                            <div class="controls">
                                                <div class="controls">
                                                    <div class="slider-controls">
                                                    <label>키 :</label>
                                                    <form:input path="userHeight" type="text" value="${profile.userHeight}" />
                                                </div>
                                                    <div id="slider-range-min1"></div>
                                                </div>
                                            </div>
                                            <div class="controls">
                                                <div class="controls">
                                                    <div class="slider-controls">
                                                        <label >몸무게 :</label>
                                                        <form:input path="userWeight" type="text" value="${profile.userWeight}" />
                                                    </div>
                                                    <div id="slider-range-min2"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- // Group END -->

                                    </div>
                                    <!-- // Column END -->

                                </div>
                                <!-- // Row END -->

                                <!-- Form actions -->
                                <div class="form-actions" style="margin: 0;">
                                    <button type="submit" class="btn btn-primary glyphicons circle_okbtn-large">수정</button>
                                    <button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>취소</button>
                                </div>

                            </form:form>
                            <!-- // Form actions END -->
                        </div>
                        <!-- 사진 -->
                        <div class="tab-pane" id="tab2">  2

                        </div>
                        <!-- 경력 -->
                        <div class="tab-pane" id="tab3">   3

                        </div>
                        <!-- 학력 -->
                        <div class="tab-pane" id="tab4">
                            <div class="widget">
                                <ul class="nav nav-pills pull-right">
                                    <li><a href="#"><i class="icon-plus"></i>추가하기</a></li>
                                    <li><a href="#"><i class="icon-plus"></i>삭제하기</a></li>
                                </ul>
                                <div class="table-overflow">
                                    <table class="table table-bordered table-checks">
                                        <thead>
                                        <tr>
                                            <th></th>
                                            <th>학교이름</th>
                                            <th>재학기간</th>
                                            <th>학위</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td><input type="checkbox" name="checkRow" class="styled" /></td>
                                            <td><input type="text" name="g3" placeholder="학교 이름"/></td>
                                            <td><select name="start" id="start" title="-" class="span2">
                                                <option value=''>년도</option>
                                                <option value='1999'>1999년</option>
                                                <option value='1998'>1998년</option>
                                                <option value='1997'>1997년</option>
                                                <option value='1996'>1996년</option>
                                                <option value='1995'>1995년</option>
                                                <option value='1994'>1994년</option>
                                                <option value='1993'>1993년</option>
                                                <option value='1992'>1992년</option>
                                                <option value='1991'>1991년</option>
                                                <option value='1990'>1990년</option>
                                                <option value='1989'>1989년</option>
                                                <option value='1988'>1988년</option>
                                                <option value='1987'>1987년</option>
                                                <option value='1986'>1986년</option>
                                                <option value='1985'>1985년</option>
                                                <option value='1984'>1984년</option>
                                                <option value='1983'>1983년</option>
                                                <option value='1982'>1982년</option>
                                                <option value='1981'>1981년</option>
                                                <option value='1980'>1980년</option>
                                            </select> ~
                                                <select name="start" id="start2" title="-" class="span2">
                                                    <option value=''>년도</option>
                                                    <option value='1999'>1999년</option>
                                                    <option value='1998'>1998년</option>
                                                    <option value='1997'>1997년</option>
                                                    <option value='1996'>1996년</option>
                                                    <option value='1995'>1995년</option>
                                                    <option value='1994'>1994년</option>
                                                    <option value='1993'>1993년</option>
                                                    <option value='1992'>1992년</option>
                                                    <option value='1991'>1991년</option>
                                                    <option value='1990'>1990년</option>
                                                    <option value='1989'>1989년</option>
                                                    <option value='1988'>1988년</option>
                                                    <option value='1987'>1987년</option>
                                                    <option value='1986'>1986년</option>
                                                    <option value='1985'>1985년</option>
                                                    <option value='1984'>1984년</option>
                                                    <option value='1983'>1983년</option>
                                                    <option value='1982'>1982년</option>
                                                    <option value='1981'>1981년</option>
                                                    <option value='1980'>1980년</option>
                                                </select></td>
                                            <td><span class="span3"><input type="text" name="g3" class="span12" placeholder="학위" /></span></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <!-- Form actions -->
                                    <div class="form-actions" style="margin: 0;">
                                        <button type="submit" class="btn btn-primary glyphicons circle_okbtn-large">저장</button>
                                        <button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>취소</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="tab5">    5

                        </div>
                    </div>
                </div>
            </div>
        </div>
    <!-- /invoice -->
    </div>

</div>