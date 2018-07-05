var autonumAjax = autonumTimer =  null;
var gSelectKeywordIndex = -1;
var gAjaxObject = null;
var gQueryType = 1;
var postid = $("#postid");
var nu = GetQueryString("nu");
var sortType = -1;
var coms = [];
var express = [];
var lock = false;
var isInternational = false;
var resultNum = requestNum = notFoundNum = 0;
var queryHistoryFrame = $("<iframe width=\"0\" height=\"0\" frameborder=\"0\" scrolling=\"0\"></iframe>");
$(function(){
    if(!getcookie('closeCodepre') || getcookie('closeCodepre') == 'undefined'){
        $("#miniProgram").show();
    }
    queryHistoryFrame.appendTo('body');
    if (nu != null && nu != "") {
        postid.val(nu);
        query();
    }
    //example nu
    $.ajax({
        type: "post",
        url: "/sysapi.do",
        data: "method=demonu",
        success: function (result) {
            $("#useTips").text(result);
        }
    });
    getExpress()
    postid.keyup(function (e) {
        var keycode = e.keyCode ? e.keyCode : e.which;
        if (keycode != 13 && keycode != 40 && keycode != 38) {
            autonumTimer && clearTimeout(autonumTimer);
            autonumTimer = setTimeout(function(){
                getKeyword();
            },500);
        } else if (keycode == 40) {
            if (!$("#inputTips").is(":hidden")) {
                if (gSelectKeywordIndex == -1 || gSelectKeywordIndex == $("#inputTips li.selection:last").attr("data-index")) {
                    gSelectKeywordIndex = 0;
                } else {
                    gSelectKeywordIndex++;
                }
                $("#inputTips li.selection").removeClass("hover");
                $("#inputTips li.selection:eq(" + gSelectKeywordIndex + ")").addClass("hover");
            }
        } else if (keycode == 38) {
            if (!$("#inputTips").is(":hidden")) {
                if (gSelectKeywordIndex == -1 || gSelectKeywordIndex == 0) {
                    gSelectKeywordIndex = $("#inputTips li.selection:last").attr("data-index");
                }else {
                    gSelectKeywordIndex--;
                }
                $("#inputTips li.selection").removeClass("hover");
                $("#inputTips li.selection:eq(" + gSelectKeywordIndex + ")").addClass("hover");
            }
        } else if(keycode == 13){
            query();
        }
    }).click(function (e) {
        var num = $("#postid").val().Trim();
        e.stopPropagation();
        if (num == "") {
            getqueryHistory();
        } else if (num.length >= 5) {
            getKeyword();
        }
    }).bind('input propertychange', function () {
        var keyword = postid.val();
        postid.css("font-size", keyword == "" ? "16px" : "22px")
    });
    //监听查询框粘贴事件
    $.fn.pasteEvents = function (delay) {
        if (delay == undefined) delay = 20;
        return $(this).each(function () {
            var $el = $(this);
            $el.on("paste", function () {
                $el.trigger("prepaste");
                setTimeout(function () {
                    $el.trigger("postpaste");
                }, delay);
            });
        });
    };
    $("#postid").on("postpaste", function () {
        var numArr = {'１':1,'２':2,'３':3,'４':4,'５':5,'６':6,'７':7,'８':8,'９':9,'０':0};
        var num = $("#postid").val().Trim();
        num = num.replace(/-|\s|-|－|　/g,'');
        for(var i in numArr){
            num = num.replace(new RegExp(i,'g'),numArr[i]);
        }
        gLastNum = num;
        if (gLastNum.length < 5) {
            return false;
        }
        getKeyword()
    }).pasteEvents();
    $(document).click(function () {
        $("#inputTips").hide();
    });
    $("#query").click(function(){
        if(lock) return;
        query()
    });
    //input tips
    $("#inputTips").delegate("li.selection", "mouseenter", function () {
        $("#inputTips li").removeClass("hover");
        $(this).addClass("hover");
        gSelectKeywordIndex = $(this).attr("data-index");
    }).delegate("li.selection", "click", function () {
        postid.val($(this).data('num')).css({"color": "#323232", "font-size": "22px"}).focus();
        var code = $(this).attr("data-code");
        $("#selectComBtn img").attr("data-code", code)
        query();
    }).delegate("a.delhistory", "click", function (e) {
        var code = $(this).parent().attr("data-code");
        var nu = $(this).parent().attr("data-num");
        var history = querycookie;
        for (var i = 0; i < history.length && i < 10; i++) {
            if (history[i].nu == nu && history[i].code == code) {
                history.splice(i, 0);
                queryHistoryFrame.attr("src", "//cache.kuaidi100.com/index.html?option=remove&gCompanyCode=" + history[i].code + "&gKuaidiNumber=" + history[i].nu);
            }
        }
        $(this).parent().remove();
        e.stopPropagation();
    });
    $("#delList").live("click", function () {
        queryHistoryFrame.attr("src", "//cache.kuaidi100.com/index.html?option=empty");
        $("#inputTips li").remove();
        $("#inputTips").hide();
    })
    $("#useTips,#useTips2").click(function () {
        postid.val($(this).text()).css({"color": "#323232", "font-size": "22px"}).trigger("click");
    });
    $("#expressMap").on('click', '.header-close', function(event) {
        event.preventDefault();
        $("#expressMap").hide()
        $(".header-search").val('').change();
    }).on('keyup onpropertychange input change', '.header-search', function(event) {
        event.preventDefault();
        var val = $(this).val();
        for(var i in express){
            if(express[i].com.indexOf(val) != -1 || express[i].enname.indexOf(val) != -1 || express[i].cnname.indexOf(val) != -1){
                $("#expressList li").eq(i).show();
            } else {
                $("#expressList li").eq(i).hide()
            }
        }
    }).on('click', 'li', function(event) {
        event.preventDefault();
        var index = $(this).index();
        var dom = $(".result-wrap").eq($('#expressList').data('index'));
        dom.find('.select-name i').css('background-image',$(this).find('.left-image').css('background-image'))
        dom.find('[role=country]').attr('title',express[index].country_name).text(express[index].country_name.slice(0,5))
        dom.find('.select-name a').text(express[index].cnname);
        if(express[index].phone){
            dom.find('.ico-tel').text(express[index].phone).show()
        } else {
            dom.find('.ico-tel').hide()
        }
        if(express[index].web){
            dom.find('.result-companyurl').attr('href',express[index].web).show()
        }  else {
            dom.find('.result-companyurl').hide()
        }
        $('#expressMap').hide();
        getOnlyReust(express[index].com,dom.data('nu'),dom);
    });
    //open selectCom
    $("#selectComBtn").click(function () {
        $("#errorTips,#example,#queryResult").hide();
        $("#queryWait").hide()
        $("#queryPs").hide();
        $("#notFindTip").hide()
        $("#shareBox").hide()
        $("#comList").toggle();
        _hmt.push(['_trackEvent', "company", "company-open"]);
    });
    //click selectCom
    $("#comList .com-list").delegate("a", "click", function () {
        var companyCode = $(this).attr("data-code");
        var num = postid.val();
        if (companyCode == "default") {
            $("#selectComBtn img").attr("data-code", companyCode).attr("src", "https://cdn.kuaidi100.com/images/sz/default.png");
        } else {
            if (companyCode != null && companyCode != "") {
                $("#selectComBtn img").attr("data-code", companyCode).attr("src", "https://cdn.kuaidi100.com/images/all/56/" + companyCode + ".png");
            }
        }
        hideTips();
        $("#comList").hide();
        query();
    });
    //share
    $("#queryResult").on('click','.a-share',function(){
        var parent = $(this).closest('.result-wrap');
        showShare(parent.data('name'),parent.data('result'))
        $("#shareBox").show().css("z-index","98");
        $("#sendHistory").css("margin-top", ($(window).height() -160) / 2 + "px");
    }).on('click', '.a-print', function(event) {
        event.preventDefault();
        var parent = $(this).closest('.result-wrap');
        $("#companyName").addClass("font16px");
        $("#companyNum").addClass("font16px");
        var queryResult = $('#orderPrint').html() + "<br/>" +parent.find('.result-top').html() + "<br/>" + parent.find('table').html();
        var newwindow = window.open("", "_blank");
        newwindow.window.document.head.innerHTML = '<link rel="stylesheet" href="https://cdn.kuaidi100.com/css/query_v4.css?version=201707191039" />';
        newwindow.window.document.body.innerHTML = queryResult;
        setTimeout(function () {
            newwindow.window.print();
        }, 50);
    }).on('click', '.result-close', function(event) {
        event.preventDefault();
        $(this).closest('.result-wrap').remove();
        !$(".result-wrap").size() && $("#closeResult").click()
    }).on('click', '.a-rss', function(event) {
        var parent = $(this).closest('.result-wrap').data('result');
        event.preventDefault();
        setcookie_kuaidi100("addcom", parent.com);
        setcookie_kuaidi100("addnu", parent.nu);
        window.location.href = "//buyer.kuaidi100.com";
    }).on('click', '[role=sort]', function(event) {
        event.preventDefault();
        sortType = ~sortType + 1;
        $("#queryResult .result-wrap").each(function(index, el) {
            var result = $(el).data('result');
            result.data = result.data.reverse();
            showTable($(el).find('table'),result);
            $(el).find('[role=sort]').toggleClass('col1-down');
            $(el).find('table').toggleClass('result-info-down');
        });
    }).on('click', '.select-name', function(event) {
        event.preventDefault();
        $("#expressMap").show();
        $("#expressList").data('index',$(".result-wrap").index($(this).closest('.result-wrap')));
    }).on('click', '.ico-refresh', function(event) {
        event.preventDefault();
        var dom = $(this).closest('.result-wrap');
        getOnlyReust(dom.data('result').com,dom.data('result').nu,dom);
    });
    $('#closeResult').on('click', function(event) {
        event.preventDefault();
        $('#shareBox').hide()
        $("#queryResult").hide();
        $("#queryPs").hide();
    });
    $("#shareClose").click(function () {
        closeHisCtrl();
        $("#shareBox").hide();
        $("#shareBox").css("z-index","95");
    });
    $(".close-preCode").click(function () {
        setcookie("closeCodepre","1");
        $("#miniProgram").hide();
    })
})
//autonumber
function getKeyword() {
    var num = $("#postid").val().Trim();
    if(num.length >= 5){
        autonumAjax && autonumAjax.abort();
        autonumAjax = $.ajax({
            type: "post",
            url: "/autonumber/autoComNum?resultv2=1&text=" + num,
            dataType: "json",
            success: function (resultJson) {
                gSelectKeywordIndex = -1;
                addSuggestion(resultJson);
            }
        });
    }
}

//autonumber selection
function addSuggestion(resultJson) {
    $("#suggestList").empty();
    $("#inputTips").empty();
    var i = 0;
    var num = resultJson.num;
    if (resultJson.auto && resultJson.auto.length > 0) {
        $("#suggestList").append("<span class=\"li-title\">推荐</span>");
        for (i = 0; i < resultJson.auto.length; i++) {
            var comCode = resultJson.auto[i].comCode;
            for (var j in jsoncom.company) {
                if (comCode == jsoncom.company[j].number) {
                    $("#suggestList").append("<a data-code=\"" + comCode + "\" data-num=\"" + num + "\">" + jsoncom.company[j].shortName + "</a>");
                    if (i <= 2) {
                        $("#inputTips").append("<li class=\"selection selection" + i + "\" data-index=\"" + i + "\" data-code=\"" + comCode + "\" data-num=\"" + num + "\"><span>" + num + "</span>" + jsoncom.company[j].name + "</li>");
                    }
                }
            }
        }
        if (i > 2) i = 3;
        $("#inputTips").show();
    } else {
        $("#inputTips").hide();
    }
    $("#inputTips").append("<li class=\"selection selection" + i + "\" data-index=\"" + i + "\" data-code=\"other\" title=\"识别有误？请手动选择！\"><span>" + num + "</span>其它快递</li>");
    $("#inputTips").append("<li class=\"tips_bottom\">快递100大数据为您提供智能识别</li>");
    $("#suggestList").show();
}
//history
function jsoncallback(data) {
    querycookie = eval('(' + decodeURIComponent(data) + ')');
    gethistory(querycookie);
}
function getqueryHistory() {
    $.ajax({
        url: "//cache.kuaidi100.com/querycookie.jsp",
        type: "GET",
        dataType: 'jsonp',
        jsonp: 'jsoncallback'
    });
    return true;
}
function gethistory(querycookie) {
    var history = querycookie;
    $("#inputTips").empty();
    $("#inputTips").hide();
    // queryHistoryFrame.attr("src", "//cache.kuaidi100.com/index.html?option=all");
    //var history = kdHistory.all();
    if (history != null && history != "") {
        $("#inputTips").show();
        // $("#suggestList").append("<span class=\"li-title\">推荐</span>");
        for (var i = 0; i < history.length && i < 10; i++) {
            for (var j in jsoncom.company) {
                if (history[i].code == jsoncom.company[j].number) {
                    $("#inputTips").append("<li class=\"selection selection" + i + "\" data-index=\"" + i + "\" data-code=\"" + history[i].code + "\" data-num=\"" + history[i].nu + "\"><a title=\"删除\" class=\"hidden delhistory\"></a><span>" + history[i].nu + "</span>" + jsoncom.company[j].name + "</li>");
                }
            }
        }
        if (getcookie("TOKEN") && getcookie("loginSession") == "1") {
            $("#inputTips").append("<li class=\"histips_bottom\"><a class=\"del-list\" id=\"delList\">全部清除</a>最近十条查询记录。<a class=\"login-tips\" href=\"//buyer.kuaidi100.com/\">查看更多&gt;&gt;</a></li>");
        } else {
            $("#inputTips").append("<li class=\"histips_bottom\"><a class=\"del-list\" id=\"delList\">全部清除</a>最近十条查询记录。需要永久保存？更多功能？<a class=\"login-tips\" href=\"http://sso.kuaidi100.com/\">马上登录试试</a></li>");
        }
    }
}
//query
function query() {
    coms = [];
    resultNum = requestNum = notFoundNum = 0;
    isInternational = false;
    if(gSelectKeywordIndex > -1 && postid.val() == ''){
        postid.val($("#inputTips li").eq(gSelectKeywordIndex).data('num'))
    }
    $("#postid").blur();
    $("#queryResult .result-wrap").remove();
    var numArr = {'１':1,'２':2,'３':3,'４':4,'５':5,'６':6,'７':7,'８':8,'９':9,'０':0};
    var num = postid.val().Trim();
    num = num.replace(/-|\s|-|－|　/g,'');
    for(var i in numArr){
        num = num.replace(new RegExp(i,'g'),numArr[i]);
    }
    var reg = new RegExp("^[0-9a-zA-Z]{4,}$");
    if (num == "") {
        $("#comList,#queryPs,#example,#notFindTip").hide();
        $("#errorTips").show();
        $("#errorMessage").html("请输入快递单号。");
        postid.focus();
    } else if (reg.test(num)) {
        lock = true;
        $("#example,#comList,#errorTips,#queryPs,#notFindTip,#shareBox").hide();
        if (gSelectKeywordIndex >= 0) {
            //控制输入框中的下拉的快递公司
            var selection = $("#inputTips li.selection:eq(" + gSelectKeywordIndex + ")");
            var code = selection.attr("data-code");
            $("#selectComBtn img").attr("src","https://cdn.kuaidi100.com/images/all/56/" + code + ".png")
            if (code != "other") {
                postid.val(selection.attr("data-num"));
                if (validateKuaidiNumber()) {
                    resultNum = 1;
                    getResult(code, selection.attr("data-num"));
                }
                _hmt.push(['_trackEvent', "autoCom", "click"]);
            } else {
                postid.val(selection.find("span").text());
                $("#comList").show();
                _hmt.push(['_trackEvent', "otherCom", "click"]);
            }
        } else {
            $("#inputTips").hide();
            $(".logo-model").show();
            var companyCode = $("#selectComBtn img").attr("data-code");
            if (companyCode == "default") {
                $.ajax({
                    type: "post",
                    url: "/autonumber/autoComNum?resultv2=1&text=" + num,
                    dataType: "json",
                    success: function (resultJson) {
                        $(".logo-model").hide();
                        if(resultJson.auto && resultJson.auto.length || resultJson.autoDest && resultJson.autoDest.length){
                            if(resultJson.autoDest && resultJson.autoDest.length){//国际单
                                isInternational = true;
                            }
                            postid.val(resultJson.num);
                            if(!validateKuaidiNumber()) return;
                            if (resultJson.auto && resultJson.auto.length) {
                                $("#selectComBtn img").attr("src","https://cdn.kuaidi100.com/images/all/56/" + resultJson.auto[0].comCode + ".png")
                                resultNum++;
                                getResult(resultJson.auto[0].comCode, resultJson.num);
                            }
                            if (resultJson.autoDest  && resultJson.autoDest.length) {
                                resultNum++;
                                getResult(resultJson.autoDest[0].comCode, resultJson.num,'autoDest');
                                $("#selectComBtn img").attr("src","https://cdn.kuaidi100.com/images/all/56/default.png")
                            }
                        }else {
                            lock = false;
                            postid.select();
                            $("#queryResult").hide();
                            $("#selectComBtn img").attr("src", "https://cdn.kuaidi100.com/images/all/56/default.png");
                            $("#notFindTip").show();
                            $("#notFindRight").hide();
                        }
                    },
                    error: function(){
                        lock = false;
                    }
                });
            } else {
                $(".logo-model").hide();
                $("#queryWait").hide();
                if (validateKuaidiNumber()) {
                    resultNum = 1;
                    getResult(companyCode, num);
                }
            }

            _hmt.push(['_trackEvent', "query", "click"]);
        }
        gSelectKeywordIndex = -1;
    } else {
        $("#comList,#queryPs,#example,#notFindTip").hide();
        $("#errorTips").show();
        $("#errorMessage").html("快递单号格式错误");
        //window.open("https://www.kuaidi100.com/sz/sent.shtml?searchText=" + encodeURIComponent(num));
    }
}
//查询前单号验证
function validateKuaidiNumber() {
    return true;
    if ($("#queryWait").is(":visible")) { // 正在查询中->返回
        return false;
    }
    gKuaidiNumber = $("#postid").val().Trim();
    if (gCompanyCode == "rufengda" && checkRegOfcompany(gKuaidiNumber, "^\\d{16}$")) {
        gKuaidiNumber = "DD" + gKuaidiNumber;
    }
    $("#postid").val(gKuaidiNumber);
    gValiCode = $("#valicode").val().Trim(); // 验证
    var errorListName = "";
    if ($("#companyListType").val() != null && $("#companyListType").val() == "wuliuCompanyList") {
        errorListName = "物流";
    } else {
        errorListName = "快递";
    }
    if (gCompanyCode == "") {
        $("#errorTips").show();
        if (gQueryType == 13 || gQueryType == 14) {
            $("#errorMessage").html("请您在上方选择一家" + errorListName + "公司");
        } else {
            $("#errorMessage").html("请您在左侧列表中选择一家" + errorListName + "公司");
        }
        return false;
    }
    if (gKuaidiNumber == "" || gKuaidiNumber == $("#postid").attr("placeholder")) {
        $("#errorTips").show();
        $("#errorMessage").html("请您填写" + errorListName + "单号。");
        $("#postid").focus();
        return false;
    }
    if (!isNumberLetterFuhao(gKuaidiNumber)) {
        $("#errorTips").show();
        $("#errorMessage").html("单号仅能由数字、字母和特殊符号组合，请您查证。");
        $("#postid").focus();
        return false;
    }
    if (gKuaidiNumber.length < 5) {
        $("#errorTips").show();
        $("#errorMessage").html("单号不能小于5个字符，请您查证。");
        $("#postid").focus();
        return false;
    }
    if (gKuaidiNumber.length > 40) {
        $("#errorTips").show();
        $("#errorMessage").html("单号不能超过40个字符，请您查证。");
        $("#postid").focus();
        return false;
    }
    if (gCheckStr != '' && gCheckStr != null) {
        if (!checkRegOfcompany(gKuaidiNumber, gCheckStr)) {
            $("#errorTips").show();
            $("#errorMessage").html(gCheckInfo);
            $("#postid").focus();
            return false;
        }
    }
    return true;
}
//查询
function getResult(companyCode, kuaidiNumber,type) {
    // if(companyCode == "shunfeng") {
    //   lock = false;
    //   window.open("http://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/"+kuaidiNumber);
    //   return;
    // }
    //在线寄快递-广告
    gSelectKeywordIndex = -1;
    coms.push(companyCode);
    var info = getCompanyInfo(companyCode);
    var url = "/query";
    var agrs = "type=" + companyCode + "&postid=" + kuaidiNumber + "&temp=" + Math.random();
    url = url + "?" + agrs;
    $("#queryWait,.logo-model").show();
    $("#comList,#example").hide();
    $.ajax({
        type: "GET",
        url: url,
        dataType: 'json',
        timeout: 30000,
        success: function (resultJson) {
            postid.select();
            $("#queryWait,.logo-model,#sendHistory").hide();
            if (resultJson.status == 200) { //成功
                showResult(resultJson,type);
                $("#example").hide();
                $("#shareBox,#shareBtn,#queryPs").show();
                $("#inputTips").hide();
            } else if (resultJson.status == 700) {
                queryFromUrl(info,kuaidiNumber);
            } else {
                notFoundNum++;
                if(notFoundNum == resultNum){//所有识别到的快递号都查询不到
                    var str = [];
                    for(var i in coms){
                        var info = getCompanyInfo(coms[i]);
                        if(info.name && info.siteUrl){
                            str.push('<a target="_blank" href="'+info.siteUrl+'">[<span class="span-shortname">'+info.name+'</span>官网]</a>')
                        }
                    }
                    $("#links").html(str.join('、'));
                    $("#notFindTip").show();
                    $("#shareBtn,#queryResult").hide();
                    $("#example,#queryPs").hide();
                }
            }
            queryHistoryFrame.attr("src", "//cache.kuaidi100.com/index.html?option=add&gCompanyCode=" + companyCode + "&gKuaidiNumber=" + kuaidiNumber + "&gIsCheck=0");
        },
        error: function (xmlHttpRequest, error) {
            if (error == "timeout") {
                onTimeout();
            }
        },
        complete: function(){
            requestNum++;
            if(requestNum == resultNum) {
                setTimeout(function(){
                    lock = false;
                },500)
            }
        }
    });
}
function getOnlyReust(companyCode,kuaidiNumber,dom){
    dom.data('result',{com: companyCode, nu: kuaidiNumber});
    dom.find('table').empty();
    dom.find('.result-top').hide()
    var loading = dom.find('table').siblings('.inner-loading').show();
    var tip = loading.siblings('.inner-tip').hide();
    var url = "query?type=" + companyCode + "&postid=" + kuaidiNumber + "&temp=" + Math.random();
    var pageUrl=encodeURIComponent("https://m.kuaidi100.com/result.jsp?com="+companyCode+"&nu="+kuaidiNumber+"&ordersource=pc_result&w=90&h=90")
    var img="https://www.kuaidi100.com/twoCode.do?method=global&&qrcodesize=140&&content="+pageUrl;
    dom.find('.query-code img').attr('src', img);
    $.ajax({
        type: "GET",
        url: url,
        dataType: 'json',
        timeout: 30000,
        success: function (resultJson) {
            if (resultJson.status == 200) { //成功
                showTable(dom.find('table'),resultJson);
                dom.data('result', resultJson)
                tip.hide();
                dom.find('.result-top,.a-print,.a-rss,.a-share').show();
            }else {
                var message = '没有查到结果，请检查快递单号和快递公司是否正确或稍后再试';
                tip.text(message).show();
                dom.find('.result-top,.a-print,.a-rss,.a-share').hide();
            }
            queryHistoryFrame.attr("src", "//cache.kuaidi100.com/index.html?option=add&gCompanyCode=" + companyCode + "&gKuaidiNumber=" + kuaidiNumber + "&gIsCheck=0");
        },
        error: function (xmlHttpRequest, error) {
            var message = error == 'timeout' ? '查询超时，请稍后再试' : '系统繁忙，请稍后再试';
            tip.text(message).show();
            loading.hide();
            dom.find('.result-top,.a-print,.a-rss,.a-share').hide();
        },
        complete: function(){
            loading.hide();
        }
    });
}
function showResult(data,type){
    var html = '',resultData = data.data,ischeck = data.ischeck;
    var comInfo = getCompanyInfo(data.com);
    var pageUrl=encodeURIComponent("https://m.kuaidi100.com/result.jsp?com="+data.com+"&nu="+data.nu+"&ordersource=pc_result&w=90&h=90")
    var img="https://www.kuaidi100.com/twoCode.do?method=global&&qrcodesize=140&&content="+pageUrl
    var code = '\
    <div class="query-code">\
        <p>'+data.nu+'</p>\
        <pa>微信扫一扫</p>\
        <p>同步到小程序</p>\
        <img width="90" height="90"  src="'+img+'" alt="小程序二维码"/>\
    </div>';
    html = $('<div class="result-wrap" data-name="'+comInfo.name+'" data-nu="'+data.nu+'">\
    <div class="select-com relative">\
       <p class="head-control"><a class="tips-close result-close" title="关闭查询结果"></a>\
       <a class="a-bindtel hidden" href="https://sso.kuaidi100.com/user/account.jsp" target="_blank" role="bind-btn">手机绑定</a>\
       <a class="a-print">打印查询结果</a>\
       <a class="a-share">分享</a>\
       <a class="a-rss">订阅</a></p>\
       '+(!isInternational ? '<span class="single-name">'+comInfo.name+'</span>\
       ':'<span class="select-name">\
          <i style="background-image:url(https://cdn.kuaidi100.com/images/all/56/'+data.com+'.png)"></i>\
          <a>'+comInfo.name+'</a>\
       </span>')+'\
       <a  target="_blank" class="mr10px result-companyurl" rel="nofollow" href="'+comInfo.siteUrl+'">官网</a>\
       <span class="ico-tel">'+(comInfo.contactTel || '')+'</span>\
       <span role="companyService" class="ico-online hidden"><a href="###" target="_blank">在线客服</a></span>\
       <!--<span class="ico-refresh" title="刷新"></span> -->\
       <a role="sent-order" href="https://www.postpony.com/usps/discount/kuaidi100?share=kuaidi100" target="_blank" class="mr10px sent-order hidden" rel="nofollow">【美国省钱寄快递】</a>\
       <span role="timeCost" class="ico-clock hidden"></span>\
       <span role="arrTime" class="ico-date hidden"></span>\
    </div>\
    <div class="relative query-box">\
       <div class="result-top" id="resultTop"><span class="col1'+(sortType == 1 ? ' col1-down' : '')+'" title="切换排序" role="sort">时间</span><span class="col2">地点和跟踪进度</span></div>\
       <table class="result-info'+(sortType == 1 ? ' result-info-down' : '')+'" cellspacing="0"></table>\
    </div></div>');
    html.data('result',data).prepend(code);
    var resultTable = html.find("table");
    isInternational && $('<div class="inner-loading hidden"><img src="https://cdn.kuaidi100.com/images/loading.gif"></div><div class="inner-tip"></div>').insertAfter(resultTable)
    showTable(resultTable,data);

    if(type == 'autoDest'){
        html.insertBefore('#resultFlag');
    } else {
        html.insertAfter('#resultFlag');
    }
    if(isInternational){
        var text = type == 'autoDest' ? '目的国家' : '发件国家';
        //html.find('[role=sort]').click()
        $("<span style='padding-left:4px;'>"+text+'<b title="'+getCoutry(data.com)+'" role="country">'+getCoutry(data.com).slice(0,5)+"</b></span>").insertBefore(html.find('.select-name'))
    }
    $("#queryRight,#queryResult").show();
    var loginMobile = getcookie("loginMobile");
    if (loginMobile == "" || loginMobile == "null") {
        $("[role=bind-btn]").show();
    }
    if(data.com=="usps"){
        html.find('[role=sent-order]').show();
    }else{
        html.find('[role=sent-order]').hide();
    }
    //中通特殊处理
    if(data.com == 'zhongtong'){
        html.find("[role=companyService]").show().find("a").attr('href',' http://kefu.jx.zto.com/webim/im.html?tenantId=27801&to=systemkefu18&appKey=ssy%23chat&xmppServer=im-api.jx.zto.com:5280&restServer=a1.jx.zto.com&billCode='+data.nu);
    } else {
        html.find("[role=companyService]").hide()
    }
}
function showTable(resultTable, data){
    var resultData = data.data, ischeck = data.ischeck;
    resultTable.empty();
    for(var i = 0,len = resultData.length; i < len; i++){
        var className = "status";
        if (resultData.length == 1 && ischeck == 0) {
            className += " status-wait";
        } else if (resultData.length == 1 && ischeck == 1) {
            className += " status-check";
        } else if (i == 0 && ischeck == 0) {
            className += sortType == -1 ? " status-wait" : " status-first";
        } else if (i == 0 && ischeck == 1 && sortType == -1 || i == len -1 && ischeck == 1 && sortType == 1) {
            className = "status status-check";
        } else if( i == 0){
            className += sortType == -1 ? " status-wait" : " status-first";
        } else if (i == resultData.length - 1) {
            className += sortType == 1 ? " status-wait" : " status-first";
        } else {
            className = "status";
        }
        var context = resultData[i].context;
        context = getJumpNetContext(context, data.com, "fonter1");
        context = getTelContext(context);
        var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        var dateStr = resultData[i].time
        var myDate = new Date(Date.parse(dateStr.replace(/-/g, "/")));
        var week = (weekDay[myDate.getDay()]);
        var day = resultData[i].time.substring(0, 10).replace(/-/g, ".");
        if (i < resultData.length - 1) {
            var preday = resultData[i + 1].time.substring(0, 10).replace(/-/g, ".");
        }
        var time = resultData[i].ftime.substring(11, 16)
        if (i == 0) {
            resultTable.append('<tr '+(sortType == -1 ? 'class="last"' : "")+'><td class="row1"><span class="day">' + day + '</span><span class="time">' + time + '</span>&nbsp;<span class="week">' + week + '</span></td><td class="' + className + '">&nbsp;<div class="col2"><span class="step"><span class="line1"></span><span class="line2"></span></span></div></td><td class="contex"t>' + context + '</td></tr>');
        } else if (i == resultData.length - 1) {
            resultTable.append('<tr '+(sortType == 1 ? 'class="last"' : "")+'><td class="row1"><span class="day">' + day + '</span><span class="time">' + time + '</span>&nbsp;&nbsp;<span class="week">' + week + '</span></td><td class="' + className + '">&nbsp;</td><td class="context">' + context + "</td></tr>");
        } else {
            if (day != preday) {
                resultTable.append('<tr><td class="row1"><span class="day">' + day + '</span><span class="time">' + time + '</span>&nbsp;&nbsp;<span class="week">' + week + '</span></td><td class="' + className + '">&nbsp;<div class="col2"><span class="step"><span class="line1"></span><span class="line2"></span></span></div></td><td class="context">' + context + "</td></tr>");
            } else {
                resultTable.append('<tr><td class="row1"><span class="day">' + day + '</span><span class="time">' + time + '</span></td><td class="' + className + '">&nbsp;<div class="col2"><span class="step"><span class="line1"></span><span class="line2"></span></span></div></td><td class="context">' + context + "</td></tr>");
            }
        }
    }
}
//获取网点连接
function getJumpNetContext(context, com, flag) {
    var beforeKeyword = "(?:(?!的|员|型|是).|^)";
    var keyword = ".?到达.?|.?问题.?|.?派件.?|.?签收.?|.?疑难.?|.?扫描.?|.?装袋.?|.?装包.?|.?妥投.?|.?操作员.?|.?审核.?|.?备注.?|.?客服.?|.?网点经理.?|.?员工.?|.?门卫.?|.?本人.?|.?草签.?|.?图片.?|.?分拨中心.?";
    var companyNetworkCodes = {
        "shentong": "5",
        "huitongkuaidi": "6",
        "huiqiangkuaidi": "27",
        "tiantian": "7",
        "zhaijisong": "12",
        "quanfengkuaidi": "23",
        "longbanwuliu": "24",
        "guotongkuaidi": "20",
        "kuaijiesudi": "18",
        "debangwuliu": "1",
        "zhongtong": "3",
        "yunda": "2"
    }
    switch (com) {
        case ("shentong"):
        case ("huitongkuaidi"):
        case ("huiqiangkuaidi"):
        case ("tiantian"):
        case ("quanfengkuaidi"):
        case ("longbanwuliu"):
        case ("guotongkuaidi"):
        case ("kuaijiesudi"): {
            var pattern = beforeKeyword + "【((?:(?!" + keyword + ")[^\\s\\d【]){2,})】";
            var reg = new RegExp(pattern, "gi");
            context = context.replace(reg, function ($0, $1, $2) {
                return "【<a href=\"https://www.kuaidi100.com/network/?from=" + flag + "&searchText=" + encodeURIComponent($1) + "&company=" + companyNetworkCodes[com] + "\" target=\"_blank\">" + $1 + "</a>】";
            });
            break;
        }
        case ("debangwuliu"):
        case ("zhaijisong"):
        case ("zhongtong"):
        case ("yunda"): {
            var pattern = beforeKeyword + "\\[((?:(?!" + keyword + ")[^\\s\\d【]){2,})\\]";
            var reg = new RegExp(pattern, "gi");
            context = context.replace(reg, function ($0, $1, $2) {
                return "[<a href=\"https://www.kuaidi100.com/network/?from=" + flag + "&searchText=" + encodeURIComponent($1) + "&company=" + companyNetworkCodes[com] + "\" target=\"_blank\">" + $1 + "</a>]";
            });
            break;
        }
    }
    return context;
}
//获取快递员连接
function getTelContext(context) {
    var reg = new RegExp("1\\d{10}", "gi");
    return context.replace(reg, function ($0) {
        var html = "";
        $.ajax({
            type: "post",
            url: "/courier/searchapi.do",
            data: "method=courierinfobyphone&json={%22phone%22:%22" + $0 + "%22}",
            dataType: "json",
            async: false,
            success: function (resultJson) {
                if (resultJson.status == 200) {
                    html = "<a target=\"_blank\" href=\"https://www.kuaidi100.com/courier/detail_" + resultJson.guid + ".html\">" + $0 + "</a>";
                } else {
                    html = $0;
                }
            }
        });
        return html;
    });
}
function getCompanyInfo(companyCode){
    var result = {};
    for (var i = 0; i < jsoncom.company.length; i++) {
        if (companyCode == jsoncom.company[i].number) {
            result = jsoncom.company[i];
            break;
        }
    }
    return result;
}
//隐藏查询提示和内容
function hideTips() {
    $("#inputTips").hide();
    $("#queryWait").hide();
    $(".logo-model").hide();
    $("#errorTips").hide();
    $("#queryPs").hide();
    $("#notFindTip").hide();
    $("#notFindRight").show();
}
function getCoutry(com){
    var name = '';
    for(var i in express){
        if(com == express[i].com) {
            name = express[i].country_name;
            break;
        }
    }
    return name;
}
function showShare(comName,data) {
    var shorturl;
    var frameName = $("#frameName").val();
    if(frameName == null) frameName = "";
    $("#sendMsg").html("");
    var url=encodeURIComponent("https://www.kuaidi100.com/chaxun?from=" + frameName + "&com=" + data.com + "&nu=" + data.nu);
    var longurl="//www.kuaidi100.com/buildshortlink?m=build&url="+url;
    $.get(longurl,function(resultData){
        shorturl=resultData;
        $("#sendUrl").val(shorturl);
        $("#sendContent").val(comName + "[" + data.nu + "]最新跟踪信息:\n" + translateTotext(data, 2) + "查看全部："+shorturl);
    })
    $('#sendHistoryBtn').hide();
    $('#sendHistory').show();
    $('#weixin').hide();
    $('#sendUrl').blur();
    $('#sendContent').blur();
    $("#selectedTag").removeClass("pos1").addClass("pos2").show();
    goWechatCode(data.com,data.nu)
}
function goWechatCode(com,num){
    //普通二维码转小程序
    var pageUrl=encodeURIComponent("https://m.kuaidi100.com/result.jsp?com="+com+"&nu="+num+"&ordersource=pc_result&w=90&h=90")
    var shareUrl=encodeURIComponent("https://m.kuaidi100.com/result.jsp?com="+com+"&nu="+num+"&ordersource=pc_result&w=190&h=190")
    var img="https://www.kuaidi100.com/twoCode.do?method=global&&qrcodesize=140&&content="+pageUrl
    var shareImg="https://www.kuaidi100.com/twoCode.do?method=global&&qrcodesize=240&&content="+shareUrl
    $("#xcxCode").attr("src",img );
    $("#shareCode").attr("src",shareImg );
    $("#codeNu").text(num)
}
//官网查询
function queryFromUrl(info,kuaidiNumber) {
    $("#sendHistory").hide();
    $("#notFindTip").show();
    $("#notFindRight").hide();
    $(".span-shortname").text(info.name);
    queryHistoryFrame.attr("src", "//cache.kuaidi100.com/index.html?option=add&gCompanyCode=" + info.number + "&gKuaidiNumber=" + kuaidiNumber + "&gIsCheck=0");
}
function onTimeout() {
    if ($("#queryWait").is(":visible")) {
        $("#queryWait").hide();
        $(".logo-model").hide();
        $("#errorTips").show();
        $("#errorMessage").html("查询时间过长，请您稍后查询。");
        $("#queryResult").hide()
    }
}
function getExpress(){
    $.ajax({
        type: "post",
        url: "/globalauto.do?method=coms",
        success: function (rs) {
            if(1 == rs.status) {
                express = rs.data;
                var coms = "";
                for(var i = 0; i < rs.data.length; ++i) {
                    coms += '<li><a>';
                    if('' != rs.data[i].logo) {
                        coms += '<span class="left-image" style="background-image: url(https://cdn.kuaidi100.com/images/all/global/' + rs.data[i].logo + ');"></span>';
                    } else {
                        coms += '<span class="left-image" style="background-image: url(https://cdn.kuaidi100.com/images/all/global/default.png);"></span>';
                    }
                    if('' == rs.data[i].enname) {
                        coms += '<span class="right-word">' + rs.data[i].cnname + '</span>';
                    } else {
                        coms += '<span class="right-word"><em>' + rs.data[i].cnname + '</em><em>' + rs.data[i].enname + '</em></span>';
                    }
                    coms += '</a></li>';
                    coms[i] = rs.data[i];
                }
                $('#expressList').html(coms);
            }
        },
    });
}
//istel
String.prototype.isTel = function () {
    return (/^([0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^[0-9]{3,12}$)|(^((\(\d{3}\))|(\d{3}\-))?1[3578]\d{9})$/.test(this.Trim()));
}

//isMobile
String.prototype.isMobile = function () {
    return (/^(?:13\d|14\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/.test(this.Trim()));
}

//Trim
String.prototype.Trim = function () {
    return this.replace(/\s/g, "");
}
function Banner(index){
    var current = 0, size = $(".section-bg").size() - 1,timer = null;
    var indicators = '';
    for(var i = 0; i<=size;i++){
        indicators += '<span'+(i==0 ? ' class="active"': '')+'></span>'
    }
    $(".section-bg").eq(0).show().siblings('.section-bg').hide();
    $(".indicator").append(indicators);
    $(".section-bg").each(function(index, el) {
        $(el).attr('href') && $(el).css('cursor','pointer');
    });
    $(".section-bg").click(function(event) {
        $(this).attr('href') && window.open($(this).attr('href'));
    });
    $(".indicator span").click(function(event) {
        var index = $(this).index();
        $(this).addClass('active').siblings('span').removeClass('active');
        current = index;
        if(timer) {
            clearInterval(timer);
            timer = null;
        }
        $(".section-bg").stop(true,true).hide();
        $(".section-bg").eq(current).fadeIn(1200);
        setTimeout(function(){
            timer = setInterval(animate,5000)
        },0)

    });
    function animate(){
        current = ++current > size ? 0 : current;
        $(".indicator span").eq(current).addClass('active').siblings('span').removeClass('active');
        $(".section-bg").eq(current).fadeIn(1200).siblings('.section-bg').fadeOut(1200);

    }
    timer = setInterval(animate,5000)
}
new Banner()