_pt_sp_2.push('setDomain,seofangfa.com');
_pt_sp_2.push('setServer,0');
_pt_sp_2.push('setEventReport,true');
/*event open*/
!function (a) {
    window["edc7uo"] = [];

    function b() {
        this.eventName = "", this.eventType = 0, this.elementType = 0, this.properties = [], this.errors = [], this.rules = {
            eventName: {
                lengthLimit: function (a) {
                    return a > 60
                }
            }, key: {lengthLimit: 12, regex: /^[a-zA-Z\d_]*$/}, value: {lengthLimit: 50}
        }
    }

    function c() {
        function b(a) {
            if (aa) return !1;
            if (location.href.match(/(utm_campaign|utm_source|utm_medium|utm_term|utm_content)/)) return !0;
            for (var b = 0; b < a.length; b++) if (location.search.match(new RegExp("[?/&](" + a[b] + ")="))) return !0;
            return !1
        }

        function c() {
            for (var a = ["(wap|www|m|m5).baidu.com", "www.baidu.jp", "(hao|so).360.cn", "www.360(soso|sou).com", "(www|m).so.com", "www.google.", "(blogsearch|books|images|news|scholar).google.com", "bing.com", "(search|tw.search).yahoo.com", "www.yahoo.cn", "search.yahoo.co.jp", "(www|jp).ask.com", "(cn|jp).indeed.com", "search.biglobe.ne.jp", "search.(goo|smt.docomo).ne.jp", "search.nifty.com", "websearch.rakuten.co.jp", "www.so-net.ne.jp"], b = 0; b < a.length; b++) if (ua.referrer.match(new RegExp(a[b]))) return !0;
            return !1
        }

        function f(a, b) {
            for (var c = 0; c < T.length; c++) if (a.indexOf(T[c]) > -1 && b.referrer.indexOf(T[c]) > -1) return 0;
            return 1
        }

        function h(a, b, c) {
            a.addEventListener ? a.addEventListener(b, c, !0) : a.attachEvent && a.attachEvent("on" + b, c)
        }

        function i(a, b) {
            var c = a;
            "object" == typeof b && (c = b);
            var d = "";
            try {
                d = Ba.getCssPathOld(c)
            } catch (a) {
            }
            var e, f = [];
            if (la.length > 0) for (var g = 0; g < la.length; g++) try {
                var h = la[g];
                if (h.length >= 10) {
                    for (var i = r(h[7], h[9]), k = 0, l = i.length; k < l; k++) if (j(a, i[k])) {
                        f.push(h[3] + ":1:0");
                        break
                    }
                } else if ("function" == typeof jQuery && jQuery(h[7])[0] == c || "function" != typeof jQuery && h[7] == d) {
                    var m = h;
                    e = m.slice(1, 5)
                }
            } catch (a) {
            }
            return {newEventTriggerList: f, oldEventTrigger: e}
        }

        function j(a, b) {
            return a === b || "body" !== a.nodeName.toLowerCase() && j(a.parentNode, b)
        }

        function k(a) {
            if (!a) return !1;
            var b, c;
            return a.newEventTriggerList && a.newEventTriggerList.length && (b = a.newEventTriggerList.join(",")), a.oldEventTrigger && (c = a.oldEventTrigger.join(".")), !(!b && !c) && {
                eid: b || "",
                stat: c || ""
            }
        }

        function l() {
            if (/windows|win32/i.test(ta.userAgent) && /msie|trident|edge/i.test(ta.userAgent)) ka = "click"; else for (var a = 0; a < V.length; a++) for (var b = document.getElementsByTagName(V[a]), c = 0; c < b.length; c++) h(b[c], "focus", function (a) {
                Ya = xa.getSrcElement(a);
                var b = i(Ya), c = k(b);
                if (c) {
                    var d = "", e = ca + "." + da + "." + Ha + "." + Ra + "." + Ta, f = Ea;
                    d = "?id=" + e, c.stat && (d += "&stat=" + c.stat), c.eid && (d += "&eid=" + c.eid), Ja = +Ja + 1, d += "&pvn=" + Ja, d += "&ptif=" + f, Ba.sendMsgByScript(D + d)
                }
            })
        }

        function m() {
            if (null == Ya) return !1;
            var b = Ya.nodeName.toLowerCase();
            if ("html" == b) return !1;
            var c = 0, d = Ba.parentA(Ya), e = xa.getOffset(Ya);
            Za = e.left, $a = e.top;
            var f = "";
            try {
                f = Ba.getCssPath(Ya)
            } catch (a) {
            }
            var h = (new Date).getTime();
            if (h - ra < J && "a" != b) return !1;
            if ("object" == typeof d) {
                var j = d.getAttribute("onclick");
                if (j && j.indexOf("_pt_sp_2") > -1 && d.onclick && -1 == d.onclick.toString().indexOf("_pt_sp_2")) for (var l = j.split(";"), m = 0; m < l.length; m++) if (l[m].indexOf("setPVTag") > -1 && _pt_sp_2.push(l[m].replace("_pt_sp_2.push('", "").replace('_pt_sp_2.push("', "").replace("')", "").replace('")', "")), l[m].indexOf("setTrackEvent") > -1) {
                    var n = l[m].split(",");
                    8 == n.length && n.pop(), _pt_sp_2.push(n.join("").replace("_pt_sp_2.push('", "").replace('_pt_sp_2.push("', "").replace("')", "").replace('")', ""))
                }
                var p = function () {
                    var a = "", b = "object" == typeof d.href ? d.href.animVal : d.href,
                        c = ya.encode(b, !1).replace(/\(/g, "%28").replace(/\)/g, "%29").replace(/\./g, "%2E");
                    if ("" == b) ; else if (b.match(/mailto:/)) "true" == ga.mailSendings && (a = "Mail,Mailto," + c.toLowerCase() + ",0"); else if (b.toLowerCase().match(/\.(msi|pdf|apk|ipa|jar|umd|jad|epub|mobi|iso|tar|zip|rar|gzip|gz|dmg|doc|docx|xls|xlsx|csv|ppt|pptx|exe|txt|pdf|key|numbers|pages)/)) {
                        if ("true" == ga.fileDownloads) {
                            var e = b.toLowerCase().match(/\.(msi|pdf|apk|ipa|jar|umd|jad|epub|mobi|iso|tar|zip|rar|gzip|gz|dmg|doc|docx|xls|xlsx|csv|ppt|pptx|exe|txt|pdf|key|numbers|pages)/)[1];
                            c = c.replace(/(^https?:\/\/)([^\/]+)/i, function (a) {
                                return a.toLowerCase()
                            }), a = "Downloads," + e + "," + c + ",0"
                        }
                    } else if (0 == b.toLowerCase().indexOf("http") && "true" == ga.outboundLinks) {
                        for (var f = !0, g = 0; g < T.length; g++) if (b.toLowerCase().indexOf(T[g]) > 0) {
                            f = !1;
                            break
                        }
                        f && (c = c.replace(/(^https?:\/\/)([^\/]+)/i, function (a) {
                            return a.toLowerCase()
                        }), a = "Outbound%20Links,Exit," + c + ",0")
                    }
                    return a
                }();
                "" != p && ba && _pt_sp_2.push("setTrackEvent," + p + ",false")
            }
            var q;
            if (function () {
                    if ("focus" == ka) for (var a = 0; a < V.length; a++) if (V[a] == b) return;
                    q = i(Ya, d)
                }(), !("3bfec6ad" == ca && navigator.userAgent.indexOf("MSIE") > -1 && ".focus-menu .current " == f)) {
                var r = 0;
                r = "a" == b || "input" == b || "select" == b || "embed" == b || "object" == b || "textarea" == b || "button" == b ? 1 : Ya.onclick ? 1 : 0 == Ya.childNodes.length || 1 == Ya.childNodes.length && 1 != Ya.childNodes[0].nodeType ? 2 : 0;
                var s = r + ha[2] + ya.encode(f, !1).replace(/\(/g, "%28").replace(/\)/g, "%29").replace(/\./g, "%2E");
                if (za.readCookies(), 1 != za.getValueFromCookies("to_flag") && za.isActive()) ((c = h - qa - cb * H) < 0 || c > 1.5 * H) && (c = H); else {
                    if (1 == za.getValueFromCookies("to_flag") || +h - +za.getValueFromCookies("sact") > +I) return g("pn"), !1;
                    if (za.isNewVisit(Ha, h)) return void g("pv");
                    ib = !0, c = L
                }
                Ua = za.plPrc(Ra), pa = h, qa = h, ra = h, Ja = za.getValueFromCookies("pvn"), kb && (clearInterval(window._pt_hb_interval), window._pt_hb_interval = setInterval(function () {
                    o()
                }, H), cb = 0), za.writeCookies();
                var t = xa.getYMax();
                Fa = va.orientation == a || 0 == va.orientation ? 1 : -1, 1 == Fa && t > ab ? ab = t : 1 != Fa && t > bb && (bb = t);
                var u = ca + "." + da + "." + Ha + "." + Ra + "." + Ta,
                    v = +(Xa.x + ha[0]) * Fa + "." + Math.ceil((Xa.y + ha[1]) * Fa * Da) + "." + xa.getViewWidth() + "." + xa.getViewHeight() + "." + s + ".0." + (1 == Fa ? xa.getScrollY() : (xa.getScrollY() + 1) * Fa) + "." + (1 == Fa ? ab : -1 * bb) + "." + c + "." + (Za + ha[0]) + "." + ($a + ha[1]),
                    w = Ea, x = k(q), y = "";
                x ? (y = "?id=" + u, x.stat && (y += "&stat=" + x.stat), x.eid && (y += "&eid=" + x.eid), kb && (y += "&ocstat=" + v), Ja = +Ja + 1, y += "&pvn=" + Ja, y += "&ptif=" + w, Ba.sendMsgByScript(D + y)) : kb && (y = "?id=" + u + "&stat=" + v + "&ptif=" + w, Za = 0, $a = 0, ha = [0, 0, ""], Ba.sendMsgByScript(A + y))
            }
        }

        function n() {
            for (var a, b, c = ua.getElementsByTagName("a"), d = "", e = 0; e < c.length; e++) (a = c[e].getAttribute("href")) && (d = a.match(/[\#|\?|\&]_pt_link=[^#|^&]*/)) && (a = a.split(d), b = a[0] + (a[1] ? a[1] : ""), c[e].setAttribute("href", b))
        }

        function o() {
            if (za.readCookies(), !za.isActive()) return void(ib = !1);
            if (!((new Date).getTime() - qa > I + +H && (!U || "519aa7cd" != ca && "4d304c7a" != ca || n(), clearInterval(window._pt_hb_interval), jb = 1, ib = !1, za.writeCookies(), (cb + 5) * +H < I))) {
                cb++;
                var b = xa.getYMax();
                Fa = va.orientation == a || 0 == va.orientation ? 1 : -1, 1 == Fa && b > ab ? ab = b : 1 != Fa && b > bb && (bb = b);
                var c = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&stat=" + (1 == Fa ? xa.getScrollY() : (xa.getScrollY() + 1) * Fa) + "." + (1 == Fa ? ab : -1 * bb) + "." + xa.getViewHeight() + "." + (1 == jb ? -1 * I + 1 : H) + "&ptif=" + Ea;
                Ba.sendMsg(C + c)
            }
        }

        if (!wa.href.match(/^https?:\/\/.*/) || wa.href.indexOf("#_pt_capture") > -1) return !1;
        if (["7918662e", "613dedb9", "67c0f6ac", "3fca011a", "6ed7a454", "7a192cf9", "4c40caae", "3b32cedc"].join(",").indexOf(ca) < 0) {
            var p = /^http[s]?:\/\/((?!datatest).)+\.(miapex|ptengine|ptmind)\.(com|jp|cn)/;
            if (p.test(wa.href) || p.test(ua.referrer)) return !1
        }
        if (location.href.indexOf("ptengine=") > -1) return !1;
        if (location.href.indexOf(ja) > -1 || ua.referrer && ua.referrer.indexOf(ja) > -1) return !1;
        switch (Ba.valFunction("heatmap", window.edc7uo) && (kb = !0), Ea) {
            case 2:
            case 3:
                I = 18e5
        }
        if ("cellant" == O && (2 == Ea || 3 == Ea)) return !1;
        if (Pa = xa.getPage(), Qa = Pa, Ra = ya.createID(Pa), Aa.clearOtherCookie(), za.readCookies(), R = !(!za.cookiesValue || !R), R && (G = 864e5, Ca = xa.getRef(), preVID = za.getValueFromCookies("vid")), function () {
                function a(a) {
                    function b(a, b, c) {
                        var d = new Date;
                        d.setTime(d.getTime() - 1e4), document.cookie = a + "='';expires=" + d.toGMTString() + ";domain=" + b + ";path=" + c + ";", document.cookie = a + "='';expires=" + d.toGMTString() + ";domain=" + b + ";path=" + c + "/;"
                    }

                    b(a, "", "");
                    for (var c = document.location.hostname.split("."), d = document.location.pathname.split("/"), e = 0; e < c.length; e++) for (var f = 0; f < d.length; f++) b(a, c.slice(e).join("."), d.slice(0, parseInt(f) + 1).join("/"))
                }

                for (var b = ua.cookie.split(";"), c = 0; c < b.length; c++) if (b[c] = b[c].split("="), b[c][0].indexOf(tb) > -1) za.cookiesValue = b[c].slice(1).join("="), a(b[c][0]); else if (b[c][0].indexOf(ub) > -1) {
                    var d = ub + "=" + b[c].slice(1).join("=") + ";domain=" + E + ";path=/;";
                    a(b[c][0])
                }
                d && (document.cookie = d)
            }(), ya.isNull(za.cookiesValue) || !za.checkCookiesValue()) if (Aa.setValue(ub, db, {expires: ""}), za.cookiesValue = "", da = ya.createID(xa.getUidStr()), da || (da = ya.createID((new Date).getTime() + "" + Math.random())), Oa = "1", Ia = 0, eb) {
            var q = eb.split(".");
            da = q[0], Oa = q[1], Ha = q[2], pa = q[3], Ia = q[4], Ja = q[5], Na = q[6].replace(/\*\_\*/g, ".").replace(/\*\_wh\_\*/g, "?"), Ga = "0"
        } else Ga = "1", Na = Ca.referrer; else if (b(_) || c()) if (eb) {
            var q = eb.split(".");
            da = q[0], Oa = q[1], Ha = q[2], pa = q[3], Ia = q[4], Ja = q[5], Na = q[6].replace(/\*\_\*/g, ".").replace(/\*\_wh\_\*/g, "?"), Ga = "0"
        } else da = za.getValueFromCookies("uid"), da || (da = ya.createID((new Date).getTime() + "" + Math.random())), Oa = za.getIsNID(), Ia = za.getValueFromCookies("vn"), Ga = "1", Na = Ca.referrer; else if (Wa = Aa.getValue(ub), hb = Va ? Wa ? 1 : 0 : -1, eb) q = eb.split("."), da = q[0], Oa = q[1], Ha = q[2], pa = q[3], Ia = q[4], Ja = q[5], Na = q[6].replace(/\*\_\*/g, ".").replace(/\*\_wh\_\*/g, "?"), Ua = "", Ga = "0", Aa.setValue(ub, db, {expires: ""}); else {
            da = za.getValueFromCookies("uid"), da || (da = ya.createID((new Date).getTime() + "" + Math.random())), Oa = za.getIsNID(), 1 == za.getIsRefresh(db) && (Ca = {
                flag: 0,
                referrer: ""
            }), Ga = 1 == Ca.flag ? "1" : za.getIsNV(db), "cellant" == O && Y && (Ga = "1"), "cellant" == O && hb && !Z && (Z = Wa.split("cad=")[1]) && (Z = Z.split("&")[0]), Ia = za.getValueFromCookies("vn");
            var s = za.getValueFromCookies("pvn");
            Ja = "1" == Ga ? 0 : s || 1, Ua = "1" == Ga ? "" : za.getValueFromCookies("pl"), Na = "1" == Ga ? Ca.referrer : va.localStorage && "function" == typeof va.localStorage.removeItem ? va.localStorage.getItem(Ka) : "", "1" == Ga && Aa.setValue(ub, db, {expires: ""})
        }
        if (gb && /^\d+$/.test(gb)) {
            for (var t = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-/", u = da.substr(1, 2) + da.substr(5, 1) + da.substr(8, 1) + da.substr(10, 1) + da.substr(13, 1) + da.substr(15, 1) + da.substr(19, 1), v = 0, w = 0; v < 8;) {
                var x = u.charAt(7 - v);
                w += t.indexOf(x) * Math.pow(64, v), v++
            }
            if (w % gb != 0) return
        }
        oa = db, pa = eb ? pa : db, qa = db, Ha = eb ? Ha : "1" == Ga ? ya.createID(da + Pa + pa + "v") : za.getValueFromCookies("vid"), R && preVID && Ha != preVID && (Ha = preVID), Ia = "1" == Ga ? +Ia + 1 : 0 == +Ia ? 1 : +Ia, Ja = +Ja + 1, Ta = ya.createID(da + Ha + Pa + oa + "v"), Ua = za.plPrc(Ra), za.writeCookies(), function () {
            if (nb || "7f21ceb9" == ca) for (var a = document.getElementsByTagName("iframe"), b = 0; b < a.length; b++) a[b].onload = function (b) {
                return function (c) {
                    this.contentWindow.document.onclick = function (c) {
                        var d = xa.getOffset(a[b]);
                        ha[0] = d.left, ha[1] = d.top;
                        var e = "";
                        try {
                            e = Ba.getCssPath(a[b])
                        } catch (a) {
                        }
                        ha[2] = encodeURIComponent(e), Xa = xa.getMouseRC1(c), xa.getPageHeight() > 0 && (Xa.x <= 0 || Xa.y <= 0 || Xa.x > +xa.getPageWidth() || Xa.y > +xa.getPageHeight()) || (Ya = xa.getSrcElement(c), m())
                    }
                }
            }(b)
        }();
        var F = -1 != window._pt_lt ? (new Date).getTime() - window._pt_lt : 0;
        F < 0 && (F = 0), sa = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&stat=" + ("1" == Ga ? Ia : Ja) + "." + (1 == Fa ? xa.getScrollY() : (xa.getScrollY() + 1) * Fa) + "." + _a * Fa + "." + xa.getViewHeight() + "." + F + "." + ("1" == Ga ? Ca.flag : xa.getRefType(Na)) + ("1" == Ga ? "" : "." + Ia) + "&ref=" + ya.encode(Ca.referrer.replace(/&/g, "*&*").replace(/\+/g, "*+*"), !1) + ("1" != Ga ? "&vref=" + ya.encode(Na, !1) : "") + "&p=" + ya.encode(Pa.replace(/&/g, "*&*"), !1) + "&tl=" + Sa + (Z ? "&cad=" + Z : "") + "&ptif=" + Ea, sa += xa.getSysInfo(), sa += d();
        for (var M = 0; M < fa.length; M++) if ("cookie" == fa[M][2]) {
            var N = Aa.getValue(fa[M][1]);
            "rakuten-sec" == O ? N ? "00000" == N.slice(5, 10) ? sa += "&" + fa[M][0] + "=1" : sa += "&" + fa[M][0] + "=2" : sa += "&" + fa[M][0] + "=0" : N && (sa += "&" + fa[M][0] + "=" + ya.encode(N, !1))
        } else sa += "&" + fa[M][0] + "=" + ya.encode(fa[M][1], !1);
        "1" == Ga ? !U || "519aa7cd" != ca && "4d304c7a" != ca || "allManual" == Q || "" == Ca.referrer || !f(wa.href, Ca) || 0 != xa.getRefType(Ca.referrer) || wa.href.match(/[\#|\?|\&]_pt_link=[^#|^&]*/) ? Ba.sendMsg(y + sa) : (Ra = ya.createID(Ca.referrer), Ta = ya.createID(da + Ha + Ca.referrer + oa + "v"), sa = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&stat=" + ("1" == Ga ? Ia : Ja) + "." + (1 == Fa ? xa.getScrollY() : (xa.getScrollY() + 1) * Fa) + "." + _a * Fa + "." + xa.getViewHeight() + "." + F + ".0&ref=&p=" + ya.encode(Ca.referrer.replace(/&/g, "*&*"), !1) + "&tl=" + Sa + (Z ? "&cad=" + Z : "") + "&ptif=" + Ea, sa += xa.getSysInfo(), Ba.sendMsg(y + sa), function () {
            Ra = ya.createID(Pa), Ta = ya.createID(da + Ha + Pa + oa + "v"), Ja = +Ja + 1, sa = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&stat=" + Ja + "." + (1 == Fa ? xa.getScrollY() : (xa.getScrollY() + 1) * Fa) + "." + _a * Fa + "." + xa.getViewHeight() + "." + F + "." + xa.getRefType(Na) + "." + Ia + "&ref=" + ya.encode(Ca.referrer.replace(/&/g, "*&*").replace(/\+/g, "*+*"), !1) + "&vref=&p=" + ya.encode(Pa.replace(/&/g, "*&*"), !1) + "&tl=" + Sa + (Z ? "&cad=" + Z : "") + "&ptif=" + Ea, sa += xa.getSysInfo(), Ba.sendMsg(z + sa)
        }()) : Ba.sendMsg(z + sa);
        var P = "vt=" + db + "&cad=" + Z;
        if (Aa.setValue(ub, P, {expires: ""}), "1" == Ga && va.localStorage && "function" == typeof va.localStorage.removeItem && (va.localStorage.removeItem(Ka), va.localStorage.setItem(Ka, Na)), U) if ("complete" == ua.readyState) e(); else {
            var S = va.onload;
            va.onload = function () {
                S && S(), e()
            }
        }
        var V = ["input", "textarea", "select", "embed"];
        "interactive" === document.readyState.toLowerCase() || "complete" === document.readyState.toLowerCase() ? l() : document.onreadystatechange = function () {
            "complete" === document.readyState.toLowerCase() && l()
        }, h(va, "onorientationchange", function (b) {
            Fa = va.orientation == a || 0 == va.orientation ? 1 : -1
        }), h(ua, "touchmove", function (a) {
            fb = !0
        }), h(ua, "touchstart", function (a) {
            a = a || va.event, Ya = xa.getSrcElement(a), Xa = xa.getMouseRC(a)
        });
        var W, X = !1;
        h(ua, "click", function (a) {
            a = a || va.event, Xa = xa.getMouseRC1(a), xa.getPageHeight() > 0 && (Xa.x <= 0 || Xa.y <= 0 || Xa.x > +xa.getPageWidth() || Xa.y > +xa.getPageHeight()) || (Ya = xa.getSrcElement(a), X || m())
        }), h(ua, "touchend", function (a) {
            if (fb) return void(fb = !1);
            Xa.x <= 0 || Xa.y <= 0 || 0 == Xa.x && 0 == Xa.y || Xa.x < 0 || Xa.x > xa.getPageWidth() || Xa.y > xa.getPageHeight() || (m(), X = !0, W && clearTimeout(W), W = setTimeout(function () {
                X = !1
            }, 500))
        });
        var $, ea = db, ia = 0;
        return h(va, "scroll", function (b) {
            function c() {
                var a = !0;
                return 0 == ua.body.clientHeight ? a = !1 : xa.getScrollY() <= 1 ? a = !1 : xa.getScrollY() + xa.getBrowserHeight() + 1 >= xa.getPageHeight() && (a = !1), a
            }

            var d = (new Date).getTime();
            if ($ = d, (ia = $ - ea) < +K) return void(ea = $);
            var e = "";
            if (za.readCookies(), 1 != za.getValueFromCookies("to_flag") && za.isActive()) ((e = d - qa - cb * H) < 0 || e > 1.5 * H) && (e = H); else {
                if (1 == za.getValueFromCookies("to_flag") || +d - +za.getValueFromCookies("sact") > +I) return void g("pn");
                if (za.isNewVisit(Ha, d)) return void g("pv");
                ib = !0, e = L
            }
            Ua = za.plPrc(Ra), pa = d, qa = d, Ja = za.getValueFromCookies("pvn"), kb && (clearInterval(window._pt_hb_interval), window._pt_hb_interval = setInterval(function () {
                o()
            }, H), cb = 0), za.writeCookies();
            var f = xa.getYMax();
            if (Fa = va.orientation == a || 0 == va.orientation ? 1 : -1, 1 == Fa && f > ab ? ab = f : 1 != Fa && f > bb && (bb = f), c() && kb) {
                var h = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&stat=" + (1 == Fa ? xa.getScrollY() : (xa.getScrollY() + 1) * Fa) + "." + (1 == Fa ? ab : -1 * bb) + "." + (xa.getViewHeight() > 1500 ? 1500 : xa.getViewHeight()) + "." + e + "&ptif=" + Ea;
                Ba.sendMsg(B + h)
            }
            ea = $
        }), window._pt_hb_interval = setInterval(function () {
            o()
        }, H), !1
    }

    function d() {
        var a = "";
        if (lb) switch (mb) {
            case"GoogleOptimize":
                window.gaData && window.gaData.expId && window.gaData.expVar && (a += gaData.expId + "|p||p|" + gaData.expVar + "|p||p|" + mb);
                break;
            case"OptimizelyX":
                if ("object" == typeof window.optimizely && "function" == typeof window.optimizely.get) {
                    var b = window.optimizely.get("state");
                    if (b) for (var c = b.getActiveExperimentIds(), d = 0; d < c.length; d++) {
                        var e = c[d], f = b.getExperimentStates({isActive: !0})[e].experimentName || "",
                            g = b.getVariationMap()[e], h = g.id, i = g.name || "";
                        a += 0 == d ? "" : "|o|", a += e + "|p|" + f.substr(0, 100) + "|p|" + h + "|p|" + i.substr(0, 100), a += "|p|" + mb
                    }
                }
                break;
            case"Optimizely":
            default:
                if ("object" == typeof optimizely) {
                    var j = optimizely.activeExperiments;
                    if (j && j.length > 0) for (var d = 0; d < j.length; d++) a += 0 == d ? "" : "|o|", a += j[d] + "|p|" + optimizely.data.experiments[j[d]].name.substr(0, 100) + "|p|" + optimizely.variationIdsMap[j[d]][0] + "|p|" + optimizely.variationNamesMap[j[d]].substr(0, 100), a += "|p|" + mb
                }
        }
        return a ? "&op=" + ya.encode(a, !1) : ""
    }

    function e() {
        var a = ua.getElementsByTagName("a"), b = "";
        if ("allManual" == Q) {
            for (var c = 0; c < a.length; c++) if ((b = a[c].getAttribute("href")) && a[c].getAttribute("onclick") && a[c].getAttribute("onclick").indexOf("pt_domain") > -1) for (var d = b.toLowerCase(), e = 0; e < T.length; e++) if (d.indexOf(T[e]) > -1 && (b.indexOf(location.hostname) < 0 || b.indexOf(location.hostname) > d.indexOf(T[e]))) {
                a[c].setAttribute("href", f(b));
                break
            }
        } else if ("halfManual" == Q) for (var c = 0; c < a.length; c++) if ((b = a[c].getAttribute("href")) && b.match(/^https?:\/\//) && b.length < 900) for (var d = b.toLowerCase(), e = 0; e < T.length; e++) if (d.indexOf(T[e]) > -1 && (b.indexOf(location.hostname) < 0 || b.indexOf(location.hostname) > d.indexOf(T[e]))) {
            a[c].setAttribute("href", f(b));
            break
        }
    }

    function f(a) {
        var b = a.split("#");
        if (za.readCookies(), za.cookiesValue) {
            var c = za.getValueFromCookies("uid") + "." + za.getValueFromCookies("nid") + "." + za.getValueFromCookies("vid") + "." + za.getValueFromCookies("sact") + "." + za.getValueFromCookies("vn") + "." + za.getValueFromCookies("pvn") + "." + (va.localStorage && "function" == typeof va.localStorage.removeItem && va.localStorage.getItem(Ka) ? va.localStorage.getItem(Ka).replace(/\./g, "*_*").replace(/\?/g, "*_wh_*") : "");
            1 == b.length ? a += "#_pt_link=" + c : "allManual" != Q && "halfManual" != Q || (a = b[0] + (-1 == a.indexOf("?") ? "?" : "&") + "_pt_link=" + c + "#" + b[1])
        }
        return a
    }

    function g(a, b, c) {
        var f = c || Ra, g = b || Pa, h = new Date, i = h.getTime();
        if (!("vpv" != a && i - qa < 1e4)) {
            za.readCookies(), _a = xa.getYMax(), jb = 0, ib = 1, oa = i, pa = i, qa = i, "pn" == a ? (Ga = "1", Ia = za.getValueFromCookies("vn"), Oa = za.getIsNID(), Ua = "", Ha = ya.createID(da + g + pa + "v"), Ia = +Ia + 1, Ja = 1) : (Ua = za.getValueFromCookies("pl"), Ha = za.getValueFromCookies("vid"), Ja = za.getValueFromCookies("pvn"), Ja = Ja ? +Ja + 1 : 1), Ta = ya.createID(da + Ha + g + oa + "v"), Ua = za.plPrc(Ra), za.writeCookies(), sa = "?id=" + ca + "." + da + "." + Ha + "." + f + "." + Ta + "&stat=" + ("pn" == a ? 0 == +Ia ? 1 : +Ia : Ja) + "." + (1 == Fa ? xa.getScrollY() : (xa.getScrollY() + 1) * Fa) + "." + _a * Fa + "." + xa.getViewHeight() + ".0.0" + ("pn" == a ? "" : "." + Ia) + "&ref=" + ("pn" == a ? "" : "&vref=" + ya.encode(Na, !1)) + "&p=" + ya.encode(g.replace(/&/g, "*&*"), !1) + "&tl=" + Sa + (Z ? "&cad=" + Z : "") + "&ptif=" + Ea, sa += xa.getSysInfo(), sa += d();
            for (var j = 0; j < fa.length; j++) if ("cookie" == fa[j][2]) {
                var k = Aa.getValue(fa[j][1]);
                k && (sa += "&" + fa[j][0] + "=" + ya.encode(k, !1))
            } else sa += "&" + fa[j][0] + "=" + ya.encode(fa[j][1], !1);
            Ba.sendMsg(("pn" == a ? y : z) + sa), jb = 0, !U || "vpv" == a || "519aa7cd" != ca && "4d304c7a" != ca || e()
        }
    }

    function h(a) {
        var b = a.length, c = 0;
        if (b > 0) for (var d = 0; d < b; d++) if (c = a[d].indexOf(","), !i(a[d].slice(0, c), a[d].slice(c + 1))) return !1;
        return !0
    }

    function i(a, b) {
        if (!b) return !1;
        switch (a) {
            case"setServer":
                v = b ? +b : 0, x = w + u[v], y = x + "/pn", z = x + "/pv", A = x + "/oc", B = x + "/os", C = x + "/hb", D = x + "/te";
                break;
            case"setAdParam":
                O = "cellant", b = b.replace(/^\|*/, "").replace(/\|*$/, ""), $ = b ? b.split("|") : "";
                break;
            case"setCamParam":
                _ = b.split(",");
                break;
            case"setURL":
                V = b;
                break;
            case"setIgnoreCampaign":
                aa = "true" == b.toLowerCase();
                break;
            case"setVPV":
                W = b.toLowerCase().split(",")[0];
                break;
            case"setVPT":
                X = b;
                break;
            case"setAccount":
            case"setSID":
                ca = b.toLowerCase();
                break;
            case"isTestWeb":
                "true" == b && "" != ca && (ma[ca] = !0);
                break;
            case"useHttpCookie":
                ea = "false" != b.toLowerCase();
                break;
            case"setDomain":
                return function () {
                    E = "";
                    var a = b.split(",");
                    U = a.length > 1, a.sort(function (a, b) {
                        return a.replace(/^https?:\/\//, "").length > b.replace(/^https?:\/\//, "").length ? 1 : -1
                    });
                    for (var c = 0; c < a.length; c++) T.push(a[c].replace(/^https?:\/\//, "")), a[c].match(/https?:\/\//) && a[c].match(/https?:\/\//)[0] != location.protocol + "//" || location.hostname.indexOf(a[c].replace(/^https?:\/\//, "")) > -1 && (E = a[c].replace(/^https?:\/\//, ""));
                    return "default" != b && "http" == location.href.slice(0, 4) || (E = location.href.toLowerCase().split("://")[1].split("?")[0].split("/")[0], T.push(E)), !0
                }();
            case"setAutoEvent":
                2 == b.split(",").length && (ga[b.split(",")[0]] = b.split(",")[1]);
                break;
            case"setEventReport":
                ba = "true" == b
        }
        return !0
    }

    function j(a) {
        var b = null;
        this.init = function () {
            if (!b) try {
                b = ua.createElement("input"), b.type = "hidden", b.addBehavior("#default#userData"), ua.body.appendChild(b)
            } catch (a) {
                return !1
            }
            return !0
        }, this.isEnabled = function () {
            return !0
        }, this.clearOtherCookie = function () {
            var a = new l;
            a.getValue(tb) && (a.setValue(tb, "", {expires: ""}), a.setValue(vb, "", {expires: ""}))
        }, this.setValue = function (c, d, e) {
            if (c == ub) return void a.setValue(c, d, e);
            try {
                if (this.init()) {
                    var f = b;
                    f.load(c), d && f.setAttribute("code", d);
                    var g = new Date;
                    g.setDate(g.getDate() + 30), f.expires = g.toUTCString(), f.save(c)
                }
            } catch (a) {
            }
        }, this.getValue = function (c) {
            if (c == ub) return a.getValue(c);
            if (this.init()) try {
                var d = b;
                return d.load(c), d.getAttribute("code")
            } catch (a) {
                return null
            }
        }
    }

    function k() {
        this.isEnabled = function () {
            return va.localStorage && "function" == typeof va.localStorage.removeItem
        }, this.clearOtherCookie = function () {
            var a = new l;
            a.getValue(tb) && (a.setValue(tb, "", {expires: ""}), a.setValue(vb, "", {expires: ""}))
        }, this.getValue = function (a) {
            return va.sessionStorage.getItem(a) || va.localStorage.getItem(a)
        }, this.setValue = function (a, b, c) {
            "" == c.expires ? (va.sessionStorage.setItem(a, b), va.localStorage.removeItem(a)) : va.localStorage.setItem(a, b)
        }
    }

    function l() {
        this.isEnabled = function () {
            return ta.cookieEnabled
        }, this.clearOtherCookie = function () {
        }, this.getValue = function (a) {
            var b = "";
            if (this.isEnabled() || (Va = !1), ua.cookie && "" != ua.cookie) for (var c = ua.cookie.split(";"), d = 0; d < c.length; d++) {
                var e = ya.trim(c[d]);
                if (e.substring(0, a.length + 1) == a + "=" && (a != tb || a == tb && e.indexOf("pt1pt") < 0 && e.indexOf("pt0pt") < 0)) {
                    b = e.substring(a.length + 1);
                    break
                }
            }
            return b
        }, this.setValue = function (a, b, c) {
            if (!this.isEnabled()) return void(Va = !1);
            var d = "";
            if (c.expires && ("number" == typeof c.expires || c.expires.toUTCString)) {
                var e;
                "number" == typeof c.expires ? (e = new Date, e.setTime(e.getTime() + 24 * c.expires * 60 * 60 * 1e3)) : e = c.expires, d = "; expires=" + e.toUTCString()
            }
            ua.cookie = a + "=" + b + d + "; path=/; domain=" + E
        }
    }

    function m() {
        var a = !1;
        if (this.localDataType = "", !ea && ta.userAgent.toLowerCase().match(/msie\s([2-8]+?\.[\d]+)/gi)) this.localDataType = new j(new l); else if (!ea && va.localStorage && va.sessionStorage && "function" == typeof va.localStorage.removeItem && "function" == typeof va.sessionStorage.removeItem) {
            var b = "pt_test";
            if (va.sessionStorage.setItem(b + "sk", b + "sv"), va.localStorage.setItem(b + "lk", b + "lv"), va.sessionStorage.getItem(b + "sk") == b + "sv" && va.localStorage.getItem(b + "lk") == b + "lv") this.localDataType = new k; else var a = !0;
            va.sessionStorage.removeItem(b + "sk"), va.localStorage.removeItem(b + "lk")
        } else if (ea) this.localDataType = new l; else var a = !0;
        a ? (this.clearOtherCookie = function () {
        }, this.isEnabled = function () {
            return !1
        }, this.setValue = function (a, b, c) {
        }, this.getValue = function (a) {
            return ""
        }) : (this.clearOtherCookie = function () {
            this.localDataType.clearOtherCookie()
        }, this.isEnabled = function () {
            return this.localDataType.isEnabled()
        }, this.setValue = function (a, b, c) {
            this.localDataType.setValue(a, b, c)
        }, this.getValue = function (a) {
            return this.localDataType.getValue(a)
        })
    }

    function n() {
        this.getSysInfo = function () {
            var a = [];
            return 1 == this.getTerminalType() || 4 == this.getTerminalType() ? (a.push("." + [this.getViewWidth(), this.getScreenHeight()].sort()[0]), a.push("." + [this.getViewWidth(), this.getScreenHeight()].sort()[1])) : (a.push("." + this.getScreenWidth()), a.push("." + this.getScreenHeight())), a.push("." + (va.screen.colorDepth || 0)), a.push("." + this.getTimezone().replace(/\./g, "_")), a.push("." + (ta.platform || "").replace(/\./g, "_").toLowerCase()), a.push("." + (ta.language || ta.browserLanguage || "").replace(/\./g, "_").toLowerCase()), a.push("." + (ua.characterSet || ua.charset || "").replace(/\./g, "_").toLowerCase()), a.join("")
        }, this.getUidStr = function () {
            try {
                var a = [this.getSysInfo()];
                a.push("&ua=" + ya.encode(ta.userAgent || "", !1)), a.push("&bw=" + (ua.documentElement.clientWidth || ua.body.clientWidth || 0)), a.push("&bh=" + xa.getBrowserHeight()), a.push("&pi=" + xa.getPlugins()), a.push("&ts=" + Ma);
                var b = a.join("");
                return b || (b = (new Date).getTime() + "" + Math.random()), b
            } catch (a) {
                return (new Date).getTime() + "" + Math.random()
            }
        }, this.getTitle = function () {
            try {
                var a = ua.getElementsByTagName("title")[0] && ua.getElementsByTagName("title")[0].innerHTML || ua.title;
                return a = ya.trim(a.split("#")[0]), X && (a = X), ya.encode(a, !1)
            } catch (a) {
                return ""
            }
        }, this.getRefType = function (a) {
            if (a) {
                for (var b = a.split("?")[0].toLowerCase(), c = 0; c < T.length; c++) {
                    var d = b.split("://")[0];
                    if (!T[c].match(/^https?:\/\/.*/) && b.indexOf(T[c]) > -1) return 0;
                    if (d == T[c].split("://")[0] && b.indexOf(T[c].split("://")[1]) > -1) return 0
                }
                return 1
            }
            return 0
        }, this.getRef = function () {
            try {
                var a = {flag: 0, referrer: ""}, b = ua.referrer;
                if (b || R && S) {
                    R && (b = S || "*" + b + "*");
                    var c = b.match(/^(\S+:\/\/)?([^\/|\?|\#]+)(\S*)/);
                    if (a.referrer = c[1].toLowerCase() + c[2].toLowerCase() + c[3], a.referrer) {
                        a.referrer = a.referrer.split("#")[0].replace(/(^\s*)/g, "").replace(/(\s*$)/g, ""), a.referrer.indexOf("?_randomTest") > -1 && (a.referrer = a.referrer.split("?_randomTest")[0]), a.referrer = a.referrer.replace(/\/*$/, "");
                        for (var d = a.referrer.split("?")[0].toLowerCase(), e = 0; e < T.length; e++) {
                            var f = d.split("://")[0];
                            if (!T[e].match(/^https?:\/\/.*/) && d.indexOf(T[e]) > -1) return a;
                            if (f == T[e].split("://")[0] && d.indexOf(T[e].split("://")[1]) > -1) return a
                        }
                        R || (a.flag = 1)
                    }
                }
                return a
            } catch (b) {
                return a
            }
        }, this.getPlugins = function () {
            var a = "", b = ta.plugins;
            if (0 != b.length) {
                for (var c = new Array, d = 0; d < b.length; d++) {
                    c[d] = b[d].name + ";" + b[d].description + ";" + b[d].filename + ";";
                    for (var e = 0; e < b[d].length; e++) c[d] += "(" + b[d][e].description + ";" + b[d][e].type + ";" + b[d][e].suffixes + ")";
                    c[d] += "."
                }
                a = c.sort().join("")
            }
            return a
        }, this.setURLMerger = function (a) {
            function b(a, b) {
                var c = b.match(/^https?:\/\//);
                return c ? 0 == a.indexOf(c[0]) && a.indexOf(b.substring(c[0].length)) > -1 : a.indexOf(b) > -1
            }

            for (var c = /*window.allPageInfo*/[['seofangfa.com', true, false, false, 'index.html', true]] || [], d = a, e = 0; e < c.length; e++) if (b(a, c[e][0])) {
                c[e][1] && (d = d.replace(/\#[^#|\$|\?]*/g, "")), c[e][2] && (d = d.replace(/^(http:\/\/|https:\/\/)?www./, "$1")), c[e][3] && (d = d.replace(new RegExp("([^#|$|?]*)" + c[e][4] + "(S*)"), "$1$2")), P = "tmpUrlAPI" == P ? "tmpUrlAPI" : 0 != c[e][5];
                break
            }
            return d
        }, this.getPage = function () {
            var a, b = [], c = "", d = (wa.protocol + "//" + wa.host).toLowerCase() + wa.pathname + wa.search + wa.hash;
            if (!d) return "";
            if (T.length > 1) {
                var e = new RegExp(/(\?|\&|\#)_pt_link=([^\&|\#]*)(\&|\#)?/);
                d.match(e) && (eb = d.match(e)[2], d = "&" == d.match(e)[3] ? d.replace(e, "$1") : d.replace(e, "$3"))
            }
            switch (d = "56fbce4e" == ca ? d.replace(/(\?|\&)__SID=\S*/, "") : d, d = d.replace(/\?_randomTest=\S*/, ""), W && (d = W), d = this.setURLMerger(d), O) {
                case"cellant":
                    if ($) {
                        d = d.split("#")[0];
                        var f = "";
                        for (a = 0; a < $.length; a++) f = "", d.indexOf("?" + $[a] + "=") > -1 ? f = "?" : d.indexOf("&" + $[a] + "=") > -1 && (f = "&"), f && (Y = !0, Z && (Z += ","), b = d.split(f + $[a] + "="), c = b[1] ? b[1].split("&")[0] : "", Z += $[a] + ":" + c, d = b[0] + f + b[1].slice(c.length + 1));
                        d = d.replace(/\?*$/, "").replace(/\&*$/, "")
                    }
                    break;
                case"oisix":
                    var g = ["utm_referrer", "utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign", "sessionid", "urlserverid", "SESSIONISNEW", "k", "tk", "KAKUNINJIKAN", "screenmode", "OVRAW", "OVKEY", "OVMTC", "OVADID", "OVKWID", "OVCAMPGID", "OVADGRPID", "SESSIONISNEW", "jid", "KENSAKUMOZIFLG", "KENSAKUMOZIJOUKEN", "searchValue", "param", "faqSearchKeyword", "startNum", "maxDisplayNum", "detail", "mi2", "roadid", "cart", "ref", "hosid", "utm_expid"],
                        f = "";
                    for (a = 0; a < g.length; a++) f = "", d.indexOf("?" + g[a] + "=") > -1 ? f = "?" : d.indexOf("&" + g[a] + "=") > -1 && (f = "&"), f && (b = d.split(f + g[a] + "="), c = b[1] ? b[1].split("&")[0] : "", d = b[0] + f + b[1].slice(c.length + 1));
                    d = d.replace(/\?*$/, "").replace(/\&*$/, "")
            }
            return V && (d += "#" + V), "7f21ceb9" != ca && "2934b1d1" != ca && "2161b761" != ca && "2f120b77" != ca && "tmpUrlAPI" != P && P && (d = d.replace(/\/*$/, "")), "4c92a252" == ca && (d = d.replace(/\/([\?|#])/, "$1")), d
        }, this.isPCByPlat = function () {
            var a = ta.platform.toLowerCase();
            if (a.indexOf("win") > -1) return !0;
            for (var b = ["mac68k", "macppc", "macintosh", "macintel"], c = 0; c < b.length; c++) if (a == b[c]) return !0;
            return !1
        }, this.isPCByOSList = function (a) {
            for (var b = ["AIX", "Amiga", "BeOS", "DragonFly", "FreeBSD", "GNU", "Haiku", "HP-UX", "IRIX", "Joli", "Java", "Macintosh", "Minix", "MorphOS", "NetBSD", "OpenBSD", "PClinuxOS", "QNX x86pc", "SunOS", "Ubuntu", "Mint", "Red Hat", "Slackware", "SUSE", "PCLinuxOS", "Debian", "Fedora", "CentOS", "Vine", "Arch Linux", "Gentoo", "Kanotix", "Mandriva"], c = 0; c < b.length; c++) if (a.indexOf(b[c]) > -1) return !0;
            return !1
        }, this.isMobileByOSList = function (a) {
            for (var b = ["Android", "AROS", "Bada", "BlackBerry", "Chromium", "CrOS", "Danger Hiptop", "Inferno", "iPhone", "iPad", "iPod", "Nintendo DS", "Nintendo Wii", "Palm OS", "PLAYSTATION", "Syllable", "SymbOS", "Symbian", "Tizen", "webOS", "WebTV", "Windows CE", "Windows Mobile", "Windows Phone", "Xbox"], c = 0; c < b.length; c++) if (a.indexOf(b[c]) > -1) return !0;
            return !1
        }, this.getTerminalType = function () {
            try {
                var a = ta.userAgent;
                return a ? this.isPCByPlat() || this.isPCByOSList(a) ? this.isMobileByOSList(a) ? 3 : a.match(/.*MSIE.*Windows NT 6\.2;.*Touch\).*/) ? 4 : 2 : a.indexOf("iPad") > -1 || Math.min(xa.getScreenWidth(), va.screen.height) >= 1e3 ? 4 : 1 : 0
            } catch (a) {
                return 0
            }
        }, this.getScreenWidth = function () {
            try {
                var a = va.screen.width;
                return a ? isNaN(parseInt(a, 10)) ? 0 : parseInt(a, 10) : 0
            } catch (a) {
                return 0
            }
        }, this.getScreenHeight = function () {
            try {
                var a = va.screen.height;
                return (1 == this.getTerminalType() && a > 2e3 || 4 == this.getTerminalType() && a > 3e3) && (a = this.getViewHeight()), a ? isNaN(parseInt(a, 10)) ? 0 : parseInt(a, 10) : 0
            } catch (a) {
                return 0
            }
        }, this.getBrowserHeight = function () {
            try {
                var a = va.innerHeight || ua.documentElement.clientHeight || ua.body.clientHeight;
                return [].join(",").indexOf(ca) > -1 && (a = va.innerHeight || ua.body.clientHeight || ua.documentElement.clientHeight), a ? isNaN(parseInt(a, 10)) ? 0 : parseInt(a, 10) : 0
            } catch (a) {
                return 0
            }
        }, this.getScrollY = function () {
            var a = 0;
            try {
                a = ua.documentElement.scrollTop || va.pageYOffset, a = isNaN(a) ? 0 : a
            } catch (b) {
                a = 0
            }
            return parseInt(a, 10)
        }, this.getYMax = function () {
            var a = +this.getScrollY() + +this.getBrowserHeight();
            return a = isNaN(a) ? 0 : parseInt(a, 10)
        }, this.getScrollX = function () {
            var a = ua.documentElement.scrollLeft || va.pageXOffset;
            return a = isNaN(a) ? 0 : a, parseInt(a, 10)
        }, this.getTimezone = function () {
            try {
                var a = (new Date).getTimezoneOffset();
                return a || 0 == a ? "GMT" + (a <= 0 ? "+" : "") + a / 60 * -1 : ""
            } catch (a) {
                return ""
            }
        }, this.getSrcElement = function (a) {
            return a.target || va.event.srcElement
        }, this.getOffset = function (b) {
            var c = {top: 0, left: 0};
            if (typeof b.getBoundingClientRect != typeof a) {
                var d = ua.documentElement, e = b.getBoundingClientRect();
                c = {
                    top: e.top + (va.pageYOffset || d.scrollTop) - (d.clientTop || 0),
                    left: e.left + (va.pageXOffset || d.scrollLeft) - (d.clientLeft || 0)
                }
            } else {
                if (c.top += b.offsetTop, c.left += b.offsetLeft, b.offsetParent) {
                    var f = this.getOffset(b.offsetParent);
                    c.top += f.top, c.left += f.left
                }
                c.top < 0 && (c.top = 0), c.left < 0 && (c.left = 0), c.top = isNaN(c.top) ? 0 : parseInt(c.top, 10), c.left = isNaN(c.left) ? 0 : parseInt(c.left, 10)
            }
            return c.top = Math.round(c.top), c.left = Math.round(c.left), c
        }, this.getMouseRC = function (a) {
            var b = {x: 0, y: 0};
            try {
                switch (b.x = a.touches[0].pageX ? a.touches[0].pageX : a.clientX, b.y = a.touches[0].pageY ? a.touches[0].pageY : a.clientY, ca) {
                    case"7ba4a69b":
                        a.touches[0].clientY <= 110 && (b.y = a.touches[0].clientY)
                }
                b.x || (b.x = 0), b.y || (b.y = 0)
            } catch (a) {
            }
            return b.x = isNaN(b.x) ? 0 : parseInt(b.x, 10), b.y = isNaN(b.y) ? 0 : parseInt(b.y, 10), b
        }, this.getMouseRC1 = function (a) {
            var b = parseInt(+a.clientX + +this.getScrollX(), 10), c = parseInt(+a.clientY + +this.getScrollY(), 10);
            return b = isNaN(b) ? 0 : b, c = isNaN(c) ? 0 : c, {x: b, y: c}
        }, this.getPageWidth = function () {
            var a = parseInt(ua.body.scrollWidth, 10);
            return a = isNaN(a) ? 0 : a
        }, this.getPageHeight = function () {
            var a = parseInt(ua.body.scrollHeight, 10);
            return a = isNaN(a) ? 0 : a
        }, this.getViewWidth = function () {
            var a = self.innerWidth || ua.body.clientWidth;
            return a = isNaN(a) ? 0 : parseInt(a, 10)
        }, this.getViewHeight = function () {
            try {
                var a = self.innerHeight || ua.body.clientHeight;
                return a = isNaN(a) ? 0 : parseInt(a, 10)
            } catch (a) {
                return 0
            }
        }, this.getInitialScale = function () {
            try {
                var a = ua.getElementsByName("viewport")[0].content;
                return a ? a.match("initial-scale=\\d.\\d+").toString().split("=")[1] : 1
            } catch (a) {
                return 1
            }
        }
    }

    function o() {
        this.valFunction = function (a, b) {
            var c = "";
            try {
                switch (a) {
                    case"heatmap":
                        if (-1 == b) return !0;
                        if (b) {
                            for (var d = xa.setURLMerger(wa.href).replace(/\/*$/, ""), e = d.split("?")[0].replace(/\/*$/, "") == d ? d.split("#")[0].replace(/\/*$/, "") == d ? null : d.split("#")[0].replace(/\/*$/, "") : d.split("?")[0].replace(/\/*$/, ""), f = 0; f < b.length; f++) if (c = b[f], c && (c = xa.setURLMerger(c).replace(/\/*$/, ""), c = c.split("?")[0].replace(/\/*$/, "") == c ? c.split("#")[0].replace(/\/*$/, "") == c ? c : c.split("#")[0].replace(/\/*$/, "") : c.split("?")[0].replace(/\/*$/, "")), d == c || e == c) return !0;
                            return !1
                        }
                        return !1
                }
            } catch (a) {
            }
        }, this.sendMsgByScript = function (a) {
            if (!(Ja > 99)) {
                var b = a + "&v=" + t + "&ts=" + (new Date).getTime(), c = document.createElement("script");
                if (c.setAttribute("src", b), document.getElementsByTagName("head")[0].appendChild(c), ma[ca]) if ("4c92a252" == ca) {
                    for (var d = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-/", e = da.substr(1, 2) + da.substr(5, 1) + da.substr(8, 1) + da.substr(10, 1) + da.substr(13, 1) + da.substr(15, 1) + da.substr(19, 1), f = 0, g = 0; f < 8;) {
                        var h = e.charAt(7 - f), i = d.indexOf(h);
                        g += i * Math.pow(64, f), f++
                    }
                    if (g % 10 == 0) {
                        var b = a.replace(/collect.ptengine.cn/, "tzcj.ptmind.com") + "&v=" + t + "&ts=" + (new Date).getTime(),
                            c = document.createElement("script");
                        c.setAttribute("src", b), document.getElementsByTagName("head")[0].appendChild(c)
                    }
                } else {
                    var b = a.replace(/collect.ptengine.cn/, "tzcj.ptmind.com") + "&v=" + t + "&ts=" + (new Date).getTime(),
                        c = document.createElement("script");
                    c.setAttribute("src", b), document.getElementsByTagName("head")[0].appendChild(c)
                }
            }
        }, this.sendMsg = function (a) {
            if (!(Ja > 99)) {
                if ((new Image).src = a + "&v=" + t + "&ts=" + (new Date).getTime(), ma[ca]) if ("4c92a252" == ca) {
                    for (var b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-/", c = da.substr(1, 2) + da.substr(5, 1) + da.substr(8, 1) + da.substr(10, 1) + da.substr(13, 1) + da.substr(15, 1) + da.substr(19, 1), d = 0, e = 0; d < 8;) {
                        var f = c.charAt(7 - d), g = b.indexOf(f);
                        e += g * Math.pow(64, d), d++
                    }
                    e % 10 == 0 && ((new Image).src = a.replace(/collect.ptengine.cn/, "tzcj.ptmind.com") + "&v=" + t + "&ts=" + (new Date).getTime())
                } else (new Image).src = a.replace(/collect.ptengine.cn/, "tzcj.ptmind.com") + "&v=" + t + "&ts=" + (new Date).getTime()
            }
        }, this.getCssPath = function (a) {
            var b = a.nodeName.toLowerCase();
            if ("body" == b || "html" == b) return "body";
            var c = a.parentNode;
            if (a.getAttribute("id")) return this.getCssPath(c) + ">#" + a.getAttribute("id");
            if (("input" == b || "select" == b || "textarea" == b || "button" == b) && a.getAttribute("name")) {
                var d = c.querySelectorAll(b + "[name=" + a.getAttribute("name") + "]");
                if (d.length > 1) {
                    for (var e = 0; e < d.length; e++) if (d[e] == a) return this.getCssPath(c) + ">" + b + ":input[name='" + a.getAttribute("name") + "']:eq(" + e + ")"
                } else if (1 == d.length) return this.getCssPath(c) + ">" + b + ":input[name='" + a.getAttribute("name") + "']"
            }
            for (var f = [], e = 0; e < c.children.length; e++) {
                var g = c.children[e];
                g.nodeName && g.nodeName.toLowerCase() == b && f.push(g)
            }
            for (var e = 0; e < f.length; e++) if (f[e] == a) return this.getCssPath(c) + ">" + b + ":eq(" + e + ")"
        }, this.getCssPathOld = function (a) {
            var b = a.nodeName.toLowerCase();
            if ("body" == b || "html" == b) return "body";
            if (a.getAttribute("id")) return "#" + a.getAttribute("id");
            for (var c = a.parentNode, d = 0; b == c.nodeName.toLowerCase() && !c.getAttribute("id");) c = c.parentNode;
            for (var e = c.getElementsByTagName(b); 1 == e.length && !c.getAttribute("id") && "body" != c.nodeName.toLowerCase();) c = c.parentNode, e = c.getElementsByTagName(b);
            for (var f = 0; f < e.length; f++) if (e[f] == a) {
                if (("input" == b || "select" == b || "textarea" == b || "button" == b) && a.getAttribute("name")) {
                    var g = c.querySelectorAll(b + "[name=" + a.getAttribute("name") + "]");
                    if (g.length > 1) {
                        for (var f = 0; f < g.length; f++) if (g[f] == a) return this.getCssPathOld(c) + ">" + b + ":input[name='" + a.getAttribute("name") + "']:eq(" + f + ")"
                    } else if (1 == g.length) return this.getCssPathOld(c) + ">" + b + ":input[name='" + a.getAttribute("name") + "']"
                }
                return this.getCssPathOld(c) + " " + b + ":eq(" + (f - d) + ")"
            }
        }, this.parentA = function (a) {
            for (; "body" != a.nodeName.toLowerCase();) {
                if ("a" == a.nodeName.toLowerCase()) return a;
                a = a.parentNode
            }
            return !1
        }
    }

    function p() {
        this.cookiesValue = "", this.writeCookies = function () {
            Va && (this.cookiesValue = this.createCookiesValue(), Aa.setValue(tb, this.cookiesValue, {expires: F})), this.readCookies()
        }, this.readCookies = function () {
            Va && (this.cookiesValue = Aa.getValue(tb))
        }, this.getIsRefresh = function (a) {
            return this.cookiesValue.indexOf(Ra) > -1 && !ya.timeCompare_M(this.getValueFromCookies("sact"), a, M) ? 1 : 0
        }, this.getIsNV = function (a) {
            return 0 != hb || R ? ya.timeCompare_M(this.getValueFromCookies("sact"), a, G) && !R ? 1 : 1 != this.getValueFromCookies("to_flag") || R ? 0 : 1 : 1
        }, this.getIsNID = function () {
            var a = this.getValueFromCookies("nid");
            return "1" == a && (a = 0), a
        }, this.isActive = function () {
            return this.getValueFromCookies("pl") == Ra + "*pt*" + oa
        }, this.isNewVisit = function (a, b) {
            return this.getValueFromCookies("vid") != a && +b >= +this.getValueFromCookies("sact")
        }, this.createCookiesValue = function () {
            var a = Math.floor(Ua.length / 3800);
            return "uid=" + da + "&nid=" + Oa + "&vid=" + Ha + "&vn=" + Ia + "&pvn=" + Ja + "&sact=" + pa + "&to_flag=" + jb + (+a > 0 ? "&cn=" + a : "") + "&pl=" + Ua
        }, this.checkCookiesValue = function () {
            for (var a = ["uid", "nid", "vid", "vn", "sact", "to_flag", "pl"], b = 0; b < a.length; b++) if (this.cookiesValue.indexOf(a[b]) < 0) return !1;
            return !0
        }, this.getValueFromCookies = function (a) {
            try {
                if ("pl" == a) return -1 != this.cookiesValue.indexOf(a) ? this.cookiesValue.split(a + "=")[1] : "";
                var b = -1 != this.cookiesValue.indexOf(a) ? this.cookiesValue.split(a + "=")[1].split("&")[0] : "";
                return "pvn" == a && (b = isNaN(b) ? 0 : b), b
            } catch (a) {
                return ""
            }
        }, this.plPrc = function (a) {
            return a + "*pt*" + oa
        }
    }

    function q() {
        this.addLoadEvent = function (a, b) {
            var c = a.onload;
            "function" != typeof a.onload ? a.onload = b : a.onload = function () {
                c(), b()
            }
        }, this.timeCompare_M = function (a, b, c) {
            return +b - +a > +c
        }, this.encode = function (a, b) {
            return encodeURIComponent instanceof Function ? b ? encodeURI(a) : encodeURIComponent(a) : escape(a)
        }, this.decode = function (a, b) {
            var c = "";
            if (a = a.split("+").join(" "), decodeURIComponent instanceof Function) try {
                c = b ? decodeURI(a) : decodeURIComponent(a)
            } catch (b) {
                c = unescape(a)
            } else c = unescape(a);
            return c
        }, this.isNull = function (b) {
            return a == b || "null" == b || -1 == b || "" == b
        }, this.trim = function (a) {
            return a.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "")
        }, this.base64encodeForBin = function (a) {
            for (var b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-/", c = "", d = 0; d < a.length / 6 - 1;) c += b.charAt(parseInt(a.slice(6 * d, 6 * (d + 1)), 2).toString(10)), d++;
            var e = a.slice(6 * d, 6 * (d + 1));
            if (e) {
                var f = e.length;
                for (d = 0; d < 6 - f; d++) e += "0";
                c += b.charAt(parseInt(e, 2).toString(10))
            }
            return c
        }, this.Hex2Bin = function (a) {
            for (var b = "", c = "", d = 0, e = a.length, f = 0; f < e; f++) {
                c = parseInt(a.charAt(f), 16).toString(2), d = c.length;
                for (var g = 0; g < 4 - d; g++) c = "0" + c;
                b += c
            }
            return b
        }, this.createID = function (a) {
            return this.base64encodeForBin(this.Hex2Bin(this.MD5(a)))
        }, this.MD5 = function (a) {
            function b(a, b) {
                return a << b | a >>> 32 - b
            }

            function c(a, b) {
                var c, d, e, f, g;
                return e = 2147483648 & a, f = 2147483648 & b, c = 1073741824 & a, d = 1073741824 & b, g = (1073741823 & a) + (1073741823 & b), c & d ? 2147483648 ^ g ^ e ^ f : c | d ? 1073741824 & g ? 3221225472 ^ g ^ e ^ f : 1073741824 ^ g ^ e ^ f : g ^ e ^ f
            }

            function d(a, b, c) {
                return a & b | ~a & c
            }

            function e(a, b, c) {
                return a & c | b & ~c
            }

            function f(a, b, c) {
                return a ^ b ^ c
            }

            function g(a, b, c) {
                return b ^ (a | ~c)
            }

            function h(a, e, f, g, h, i, j) {
                return a = c(a, c(c(d(e, f, g), h), j)), c(b(a, i), e)
            }

            function i(a, d, f, g, h, i, j) {
                return a = c(a, c(c(e(d, f, g), h), j)), c(b(a, i), d)
            }

            function j(a, d, e, g, h, i, j) {
                return a = c(a, c(c(f(d, e, g), h), j)), c(b(a, i), d)
            }

            function k(a, d, e, f, h, i, j) {
                return a = c(a, c(c(g(d, e, f), h), j)), c(b(a, i), d)
            }

            function l(a) {
                for (var b, c = a.length, d = c + 8, e = (d - d % 64) / 64, f = 16 * (e + 1), g = Array(f - 1), h = 0, i = 0; i < c;) b = (i - i % 4) / 4, h = i % 4 * 8, g[b] = g[b] | a.charCodeAt(i) << h, i++;
                return b = (i - i % 4) / 4, h = i % 4 * 8, g[b] = g[b] | 128 << h, g[f - 2] = c << 3, g[f - 1] = c >>> 29, g
            }

            function m(a) {
                var b, c, d = "", e = "";
                for (c = 0; c <= 3; c++) b = a >>> 8 * c & 255, e = "0" + b.toString(16), d += e.substr(e.length - 2, 2);
                return d
            }

            var n, o, p, q, r, s, t, u, v, w = 32, x = w, y = Array(), z = 7, A = 12, B = 17, C = 22, D = 5, E = 9,
                F = 14, G = 20, H = 4, I = 11, J = 16, K = 23, L = 6, M = 10, N = 15, O = 21;
            for (y = l(a), s = 1732584193, t = 4023233417, u = 2562383102, v = 271733878, n = 0; n < y.length; n += 16) o = s, p = t, q = u, r = v, s = h(s, t, u, v, y[n + 0], z, 3614090360), v = h(v, s, t, u, y[n + 1], A, 3905402710), u = h(u, v, s, t, y[n + 2], B, 606105819), t = h(t, u, v, s, y[n + 3], C, 3250441966), s = h(s, t, u, v, y[n + 4], z, 4118548399), v = h(v, s, t, u, y[n + 5], A, 1200080426), u = h(u, v, s, t, y[n + 6], B, 2821735955), t = h(t, u, v, s, y[n + 7], C, 4249261313), s = h(s, t, u, v, y[n + 8], z, 1770035416), v = h(v, s, t, u, y[n + 9], A, 2336552879), u = h(u, v, s, t, y[n + 10], B, 4294925233), t = h(t, u, v, s, y[n + 11], C, 2304563134), s = h(s, t, u, v, y[n + 12], z, 1804603682), v = h(v, s, t, u, y[n + 13], A, 4254626195), u = h(u, v, s, t, y[n + 14], B, 2792965006), t = h(t, u, v, s, y[n + 15], C, 1236535329), s = i(s, t, u, v, y[n + 1], D, 4129170786), v = i(v, s, t, u, y[n + 6], E, 3225465664), u = i(u, v, s, t, y[n + 11], F, 643717713), t = i(t, u, v, s, y[n + 0], G, 3921069994), s = i(s, t, u, v, y[n + 5], D, 3593408605), v = i(v, s, t, u, y[n + 10], E, 38016083), u = i(u, v, s, t, y[n + 15], F, 3634488961), t = i(t, u, v, s, y[n + 4], G, 3889429448), s = i(s, t, u, v, y[n + 9], D, 568446438), v = i(v, s, t, u, y[n + 14], E, 3275163606), u = i(u, v, s, t, y[n + 3], F, 4107603335), t = i(t, u, v, s, y[n + 8], G, 1163531501), s = i(s, t, u, v, y[n + 13], D, 2850285829), v = i(v, s, t, u, y[n + 2], E, 4243563512), u = i(u, v, s, t, y[n + 7], F, 1735328473), t = i(t, u, v, s, y[n + 12], G, 2368359562), s = j(s, t, u, v, y[n + 5], H, 4294588738), v = j(v, s, t, u, y[n + 8], I, 2272392833), u = j(u, v, s, t, y[n + 11], J, 1839030562), t = j(t, u, v, s, y[n + 14], K, 4259657740), s = j(s, t, u, v, y[n + 1], H, 2763975236), v = j(v, s, t, u, y[n + 4], I, 1272893353), u = j(u, v, s, t, y[n + 7], J, 4139469664), t = j(t, u, v, s, y[n + 10], K, 3200236656), s = j(s, t, u, v, y[n + 13], H, 681279174), v = j(v, s, t, u, y[n + 0], I, 3936430074), u = j(u, v, s, t, y[n + 3], J, 3572445317), t = j(t, u, v, s, y[n + 6], K, 76029189), s = j(s, t, u, v, y[n + 9], H, 3654602809), v = j(v, s, t, u, y[n + 12], I, 3873151461), u = j(u, v, s, t, y[n + 15], J, 530742520), t = j(t, u, v, s, y[n + 2], K, 3299628645), s = k(s, t, u, v, y[n + 0], L, 4096336452), v = k(v, s, t, u, y[n + 7], M, 1126891415), u = k(u, v, s, t, y[n + 14], N, 2878612391), t = k(t, u, v, s, y[n + 5], O, 4237533241), s = k(s, t, u, v, y[n + 12], L, 1700485571), v = k(v, s, t, u, y[n + 3], M, 2399980690), u = k(u, v, s, t, y[n + 10], N, 4293915773), t = k(t, u, v, s, y[n + 1], O, 2240044497), s = k(s, t, u, v, y[n + 8], L, 1873313359), v = k(v, s, t, u, y[n + 15], M, 4264355552), u = k(u, v, s, t, y[n + 6], N, 2734768916), t = k(t, u, v, s, y[n + 13], O, 1309151649), s = k(s, t, u, v, y[n + 4], L, 4149444226), v = k(v, s, t, u, y[n + 11], M, 3174756917), u = k(u, v, s, t, y[n + 2], N, 718787259), t = k(t, u, v, s, y[n + 9], O, 3951481745), s = c(s, o), t = c(t, p), u = c(u, q), v = c(v, r);
            var P;
            return "16" == x && (P = m(t) + m(u)), "32" == x && (P = m(s) + m(t) + m(u) + m(v)), P
        }, this.substringByByte = function (a, b) {
            for (var c = 0, d = 0, e = a.length; d < e; d++) {
                if (/[\x00-\xff]/.test(a[d]) ? c++ : c += 2, c == b) return a.substring(0, d + 1);
                if (c > b) return a.substring(0, d)
            }
            return a
        }
    }

    function r(b, c) {
        b = ya.decode(b);
        var d;
        try {
            d = document.querySelectorAll ? document.querySelectorAll(b) : s(b)
        } catch (a) {
            d = s(b)
        }
        var e, f = [];
        if (c === a || "" === c) f = d; else for (var g = 0, h = d.length; g < h; g++) e = d[g], ya.MD5(e.text || "") === c && f.push(e);
        return f
    }

    function s(a, b) {
        var c, d = [];
        if (a = a || [], b = b || document, "string" == typeof a && (a = a.split(/\s|>/)), 0 === a.length) return [];
        for (var e = a.shift(); !e && a.length > 0;) e = a.shift();
        if (!e) return [];
        c = 0 !== a.length;
        var f = -1, g = e.match(/:nth-child\(\d\)/);
        if (g) {
            var h = g[0], i = e.match(/[^:]*/g)[0];
            f = +h.match(/\d/)[0];
            var j = b.children[f - 1];
            return j && j.nodeName.toLowerCase() === i ? c ? s(a, j) : (d.push(j), d) : []
        }
        var k, l, m, n, o, p, q = [], r = e.match(/[^#\.:\[]*/), t = e.match(/#[^.:\[]*/), u = e.match(/\.[^#:\[]*/),
            v = e.match(/\[[^#:\.]*/);
        r && (r = r[0]), t && (t = t[0]), u && (u = u[0]), v && (v = v[0]), t && (t = t.replace("#", ""), (p = document.getElementById(t)) && d.push(p)), r && (t || (d = b.querySelectorAll ? b.querySelectorAll(r) : b.getElementsByTagName(r))), u && (t || r || (d = b.querySelectorAll ? b.querySelectorAll(u) : b.getElementsByClassName ? b.getElementsByClassName(u.replace(/\./g, " ")) : b.getElementsByTagName("*"))), v && (t || r || u || b.querySelectorAll && (d = b.querySelectorAll(v)));
        var w, x, y, z, A = u ? u.split(/\./) : [], B = v ? v.split(/\[|]/g) : [];
        for (l = 0, m = d.length; l < m; l++) if (k = d[l], !r || k.nodeName.toLowerCase() === r) {
            if (z = !0, u) {
                var C = " " + k.className + " ";
                for (n = 0, o = A.length; n < o; n++) if (A[n] && (w = new RegExp("\\s" + A[n] + "\\s"), !w.test(C))) {
                    z = !1;
                    break
                }
                if (!z) continue
            }
            if (v) {
                for (n = 0, o = B.length; n < o; n++) if (B[n] && (x = B[n].split("="), x[1] = x[1].replace(/^'|'$/g, ""), y = k.getAttribute(x[0]), y && (y = y.replace(/'/g, "\\'")), y !== x[1])) {
                    z = !1;
                    break
                }
                if (!z) continue
            }
            q.push(k)
        }
        return d = q, c ? s(a, d[0]) : d
    }

    window.edc7uo || (window.edc7uo = -1);
    var t = "v1.43.0", u = ["collect.ptengine.cn", "collect.ptengine.cn"], v = 0,
        w = "https:" == location.protocol ? "https://" : "http://", x = w + u[v], y = x + "/pn", z = x + "/pv",
        A = x + "/oc", B = x + "/os", C = x + "/hb", D = x + "/te", E = "", F = 1e3, G = 18e4, H = 3e4, I = 3e5,
        J = 3e3, K = 1e3, L = 1e3, M = 6e4, N = 60, O = "", P = !0, Q = !1, R = !1, S = "", T = [], U = !1, V = "",
        W = "", X = "", Y = !1, Z = "", $ = [], _ = [], aa = !1, ba = !1, ca = "", da = "", ea = !0, fa = [], ga = {},
        ha = [0, 0, ""], ia = window._pt_sp_2 ? "_pt_sp_2" : "_pt_pe", ja = "ptengine-event-explore=open", ka = "focus",
        la = [], ma = {"4c92a252": !0};
    if (!(!window[ia] || window[ia].join("").indexOf("setAccount") < 0 && window[ia].join("").indexOf("setSID") < 0 || window[ia].join("").indexOf("setDomain") < 0)) {
        for (var na = 0; na < window[ia].length; na++) /setpvtag/i.test(window[ia][na]) && (window[ia][na] = window[ia][na].replace(/setpvtag/i, "setVPV"));
        if (h(window[ia])) {
            var oa, pa, qa, ra, sa = "", ta = navigator, ua = document, va = window, wa = location, xa = new n,
                ya = new q, za = new p, Aa = new m, Ba = new o, Ca = xa.getRef(), Da = xa.getInitialScale(),
                Ea = xa.getTerminalType(), Fa = va.orientation == a || 0 == va.orientation ? 1 : -1, Ga = "0", Ha = "",
                Ia = 0, Ja = 0, Ka = ca + "_/", La = new Date, Ma = La.getTime() + "-" + La.getDate(), Na = "",
                Oa = "0", Pa = "", Qa = "", Ra = "", Sa = xa.getTitle(), Ta = "", Ua = "", Va = Aa.isEnabled(), Wa = "",
                Xa = "", Ya = "", Za = 0, $a = 0, _a = xa.getYMax(), ab = 1 == Fa ? _a : 0, bb = 1 != Fa ? _a : 0,
                cb = 0, db = La.getTime(), eb = "", fb = !1, gb = "", hb = 0, ib = !0, jb = 0, kb = !1, lb = !1,
                mb = "Optimizely", nb = !1, ob = {
                    lastTime: (new Date).getTime() - 1e4, AddTime: function () {
                        var a = (new Date).getTime();
                        return !(this.lastTime + 1e3 > a) && (a - this.lastTime > 1e4 ? (this.lastTime = a - 9e3, !0) : (this.lastTime += 1e3, !0))
                    }
                };
            if (location.href.indexOf("ptengine=") > -1) {
                var pb = location.href.split("ptengine="), qb = {
                    0: "https://report.ptengine.jp/js/popup/ptpopupheatmap.js",
                    1: "https://reportv3.ptengine.jp/components/pagescene/overlay/overlay.js",
                    2: "https://report.ptengine.com/js/popup/ptpopupheatmap.js",
                    3: "https://reportv3.ptengine.com/components/pagescene/overlay/overlay.js",
                    4: "https://demo.ptengine.jp/components/pagescene/heatmap/js/popup/ptpopupheatmap_jp.js",
                    5: "https://demo.ptengine.com/components/pagescene/heatmap/js/popup/ptpopupheatmap_en.js",
                    6: "https://reportv3test.ptengine.jp/components/pagescene/overlay/overlay.js",
                    7: "https://reportv3test.ptengine.com/components/pagescene/overlay/overlay.js",
                    8: "https://testreportv3.ptengine.jp/components/pagescene/overlay/overlay.js",
                    9: "https://testreportv3.ptengine.com/components/pagescene/overlay/overlay.js",
                    A: "http://localhost:3100/components/pagescene/overlay/overlay.js",
                    B: "http://localhost:3000/components/pagescene/overlay/overlay.js",
                    a: "https://report.ptengine.cn/components/pagescene/overlay/overlay.js",
                    b: "https://testreport.ptengine.cn/components/pagescene/overlay/overlay.js",
                    c: "https://reportv3test.ptengine.cn/components/pagescene/overlay/overlay.js",
                    d: "http://localhost:3200/components/pagescene/overlay/overlay.js"
                }, rb = qb[pb[1].substring(0, 1)];
                if (!rb) return;
                var sb = document.createElement("script");
                return sb.type = "text/javascript", sb.async = !0, sb.charset = "utf-8", sb.src = rb, void document.body.appendChild(sb)
            }
            if (function () {
                    function a() {
                        c = c.replace(/^https?:/, wa.protocol);
                        var a = document.createElement("script");
                        a.type = "text/javascript", a.async = !0, a.src = c + "/components/event/foreign/dest/event.js", ua.body.appendChild(a)
                    }

                    var b = document.referrer || window.name || "", c = localStorage.ptengineDomain;
                    wa.href.indexOf(ja) > -1 && /^https?:\/\/(.*\.ptengine.(com|cn|jp)|localhost).*/gim.test(b) ? (localStorage.ptengineDomain = c = b.match(/https?:\/\/([^\/]+)/i)[0], a()) : opener && c && a()
                }(), "" != E) {
                var tb = "pt_" + ca, ub = "pt_s_" + ca, vb = "pt_t_" + ca, wb = "pt_v_" + ca, xb = "pt_sc_" + ca;
                switch (ca) {
                    case"7915ceae":
                        O = "CONVERSE"
                }
                if ("VjjxITmt45nXMldop676zQ" == ya.createID("ptmind")) {
                    if (b.prototype = {
                            constructor: b, addProperty: function (a) {
                                this.properties.push({
                                    key: encodeURIComponent(a.key), type: a.type, value: function () {
                                        var b = a.value;
                                        return encodeURIComponent("function" == typeof b ? b.call() : b)
                                    }()
                                }), this.rules.key.lengthLimit && a.key.length > this.rules.key.lengthLimit && this.errors.push({
                                    errorType: "key",
                                    errorValue: a.key,
                                    msg: "key[" + a.key + "]长度过长"
                                }), this.rules.key.regex && !this.rules.key.regex.test(a.key) && this.errors.push({
                                    errorType: "key",
                                    errorValue: a.key,
                                    msg: "key[" + a.key + "]必须为字母数字下划线"
                                }), "string" == typeof a.value ? (this.rules.value.lengthLimit && a.value.length > this.rules.value.lengthLimit && this.errors.push({
                                    errorType: "value",
                                    errorValue: a.value,
                                    msg: "value[" + a.value + "]长度过长"
                                }), this.rules.value.regex && !this.rules.value.regex.test(a.value) && this.errors.push({
                                    errorType: "value",
                                    errorValue: a.value,
                                    msg: "value[" + a.value + "]必须为字母数字下划线"
                                })) : "number" == typeof a.value && ((a.value > 4294967294 || a.value < -4294967296) && this.errors.push({
                                    errorType: "value",
                                    errorValue: a.value,
                                    msg: "value[" + a.value + "]范围不合法，float应在-4294967296,4294967294之间, int应在-2147483648,2147483647之间"
                                }), "int" == a.type && (a.value > 2147483647 || a.value < -2147483648) && this.errors.push({
                                    errorType: "value",
                                    errorValue: a.value,
                                    msg: "value[" + a.value + "]为" + a.type + "类型, 范围应在-2147483648,2147483647之间"
                                }))
                            }, getErrorMsg: function () {
                                for (var a = [], b = 0, c = this.errors, d = c.length; b < d; b++) a.push(c[b].msg);
                                return a.join("\n")
                            }, getType: function () {
                                var b = /^\d{4}\-\d{2}\-\d{2}(?:\x20\d{2}:\d{2}:\d{2})?$/;
                                return function (c) {
                                    return c === a && "undefined" != typeof console && console.warn("getType paramer is required!"), "function" == typeof c ? arguments.callee.call(this, c.call()) : "number" == typeof c ? c % 1 == 0 ? "int" : "float" : "string" == typeof c ? b.test(c) ? "date" : "string" : "object" == typeof c && c instanceof Date ? "date" : void("undefined" != typeof console && console.warn("unsupported type, only support 4 types:[int, float, string, date]"))
                                }
                            }(), getCustomVarEid: function () {
                                for (var a = [this.eventName + ":" + this.eventType + ":" + this.elementType], b = 0, c = this.properties, d = c.length; b < d; b++) {
                                    var e = c[b];
                                    a.push(e.key + ":" + e.type + ":" + e.value)
                                }
                                return a.join("|")
                            }, getDateFormat: function () {
                                function a(a) {
                                    return 1 == (a + "").length ? "0" + a : a + ""
                                }

                                return function (b) {
                                    if (b instanceof Date) return b.getFullYear() + "-" + a(b.getMonth() + 1) + "-" + a(b.getDate()) + " " + a(b.getHours()) + ":" + a(b.getMinutes()) + ":" + a(b.getSeconds())
                                }
                            }()
                        }, window[ia].push = function (c, d) {
                            var e = c.split(",");
                            switch (e[0]) {
                                case"setPVTag":
                                    try {
                                        if ("replace" == e[2]) Pa = e[1]; else {
                                            var f = e[1] ? e[1] : "";
                                            Pa = Qa + "#" + f
                                        }
                                        Ra = ya.createID(Pa), g("vpv", Pa, Ra)
                                    } catch (a) {
                                    }
                                    break;
                                case"setCustomEvent":
                                    try {
                                        var h = d.eventName ? d.eventName : "";
                                        if (h = ya.trim(h), 0 == ba || !h) return;
                                        var h = encodeURIComponent(ya.substringByByte(h, N)), i = "0",
                                            j = d.isActiveElement ? d.isActiveElement : 0;
                                        Ja = +Ja + 1;
                                        var k = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&eid=" + h + ":" + i + ":" + j + "&ptif=" + Ea + "&pvn=" + Ja;
                                        Ba.sendMsgByScript(D + k)
                                    } catch (a) {
                                    }
                                    break;
                                case"setTrackEvent":
                                    try {
                                        if (0 == ba) return;
                                        if ("string" == typeof e[6] && !wa.href.replace(/\/$/, "").match(new RegExp(e[6].replace(/^\//, "").replace(/\/$/, "")))) return;
                                        void 0 === e[3] && (e[3] = ""), void 0 === e[4] && (e[4] = "0"), e[4] = e[4].replace(/\./g, "e");
                                        for (var l = 1; l < 5; l++) e[l] = ya.decode(e[l]);
                                        e[1] = e[1].substr(0, 200), e[2] = e[2].substr(0, 200), e[3] = e[3].substr(0, 500), e[4] = e[4].substr(0, 10);
                                        for (var l = 1; l < 5; l++) if (e[l] = ya.encode(e[l]).replace(/\./g, "%2E"), e[l].indexOf(".") > -1) {
                                            var m = e[l].split(".");
                                            e[l] = m.join("%2E")
                                        }
                                        if ("string" == typeof e[7]) la.push(e); else {
                                            if ("" == da || "" == Ha || "" == Ra || "" == Ta) return;
                                            if (!ob.AddTime()) return;
                                            Ja = +Ja + 1, za.writeCookies();
                                            var k = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&stat=" + e.slice(1, 5).join(".") + "&ptif=" + Ea + "&pvn=" + Ja;
                                            Ba.sendMsgByScript(D + k)
                                        }
                                    } catch (a) {
                                    }
                                    break;
                                case"setCustomVar":
                                    !function () {
                                        var a, b = e[3];
                                        "cookie" == b ? a = e[4] : "globalVar" == b ? a = window[e[4]] : "domId" == b ? ua.getElementById(e[4]) && (a = ua.getElementById(e[4]).innerHTML) : "value" == b && (a = e[4]), a && ("ptselfSource" == e[2] && fa.push(["def01", Aa.getValue(xb), e[3]]), fa.push([e[1], a, e[3]])), "ptself" != e[2] && "ptselfSource" != e[2] || (g("vpv"), "ptselfSource" == e[2] && fa.pop(), fa.pop(), "ptselfSource" == e[2] && Aa.setValue(xb, "", {expires: ""}))
                                    }();
                                    break;
                                case"setCustomVarV2":
                                    try {
                                        var h = d.eventName ? d.eventName : "";
                                        h = ya.trim(h), h.length > ya.substringByByte(h, N).length && (h = ya.substringByByte(h, N), "undefined" != typeof console && console.warn("the eventName[" + h + "] length must less than " + N));
                                        var n = new b;
                                        n.eventName = encodeURIComponent(h);
                                        for (var o in d) {
                                            var p = d[o], q = n.getType(p);
                                            if (q === a) return void("undefined" != typeof console && console.warn("unsupported type, only support 4 types:[int, float, string, date]"));
                                            "eventName" == o || n.addProperty({
                                                key: o,
                                                type: q,
                                                value: p instanceof Date ? n.getDateFormat(p) : p
                                            })
                                        }
                                        if (n.properties.length > 10 && n.errors.length) return void("undefined" != typeof console && console.warn("The custom properties count must not more than 10"));
                                        if (n.errors.length) {
                                            var r = n.getErrorMsg();
                                            return void("undefined" != typeof console && console.warn("一些属性或值设置不合法,无法发包: \n" + r))
                                        }
                                        if (0 == ba || !h) return;
                                        Ja = +Ja + 1;
                                        var k = "?id=" + ca + "." + da + "." + Ha + "." + Ra + "." + Ta + "&eid=" + n.getCustomVarEid() + "&ptif=" + Ea + "&pvn=" + Ja;
                                        Ba.sendMsgByScript(D + k)
                                    } catch (a) {
                                    }
                                    break;
                                case"setFunnelStep":
                                    try {
                                        R = "true" == e[1], S = 3 == e.length ? e[2] : ""
                                    } catch (a) {
                                    }
                                    break;
                                case"useURLTrim":
                                    try {
                                        P = "false" != e[1] || "tmpUrlAPI"
                                    } catch (a) {
                                    }
                                    break;
                                case"setCrossDomainLink":
                                    try {
                                        Q = "allManual" == e[1] ? "allManual" : "halfManual" == e[1] && "halfManual"
                                    } catch (a) {
                                    }
                                    break;
                                case"setIframe":
                                    nb = "true" == e[1];
                                    break;
                                case"RecordSource":
                                    if (Aa.getValue(wb) == Ha) return;
                                    var s;
                                    s = location.search.indexOf("utm_") > -1 ? location.href : Na ? Na.split("://")[1].split("/")[0] : "";
                                    var t = ya.encode(s, !1) || "no referrer", u = Aa.getValue(xb);
                                    t = u ? u + "," + t : t, Aa.setValue(xb, t, {expires: F}), Aa.setValue(wb, Ha, {expires: F});
                                    break;
                                case"ClearSource":
                                    Aa.setValue(xb, "", {expires: ""});
                                    break;
                                case"setSampleRate":
                                    try {
                                        gb = e[1]
                                    } catch (a) {
                                    }
                                    break;
                                case"setOptimizely":
                                    try {
                                        lb = "true" == e[1], e[2] && (mb = e[2])
                                    } catch (a) {
                                    }
                                    break;
                                case"setOptimizelyX":
                                    try {
                                        lb = "true" == e[1], mb = "OptimizelyX"
                                    } catch (a) {
                                    }
                            }
                        }, window[ia].length > 0) for (var yb = window[ia], na = 0; na < yb.length; na++) window[ia].push(yb[na]);
                    "308fd851" != ca && "633fdbe6" != ca || (H = 6e4), c()
                }
            }
        }
    }
}();
