/*!
 * tipso - A Lightweight Responsive jQuery Tooltip Plugin v1.0.1
 * Copyright (c) 2014 Bojan Petkovski
 * http://tipso.object505.com
 * Licensed under the MIT license
 * http://object505.mit-license.org/
 */
!function (t, o, s, e) {
    function r(o, s) {
        this.element = t(o), this.settings = t.extend({}, l, s), this._defaults = l, this._name = d, this._title = this.element.attr("title"), this.mode = "hide", this.init()
    }

    function i() {
        var t = o.navigator.msMaxTouchPoints, e = "ontouchstart" in s.createElement("div");
        return t || e ? !0 : !1
    }

    function n(o) {
        var s = o.clone();
        s.css("visibility", "hidden"), t("body").append(s);
        var e = s.outerHeight();
        return s.remove(), e
    }

    function a(s) {
        var e, r, i, a = s.tooltip(), d = s.element, l = s, f = t(o), p = 10;
        switch (l.settings.position) {
            case"top":
                r = d.offset().left + d.outerWidth() / 2 - a.outerWidth() / 2, e = d.offset().top - n(a) - p, a.find(".tipso_arrow").css({marginLeft: -8}), e < f.scrollTop() ? (e = d.offset().top + d.outerHeight() + p, a.find(".tipso_arrow").css({
                    "border-bottom-color": l.settings.background,
                    "border-top-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass("bottom")) : (a.find(".tipso_arrow").css({
                    "border-top-color": l.settings.background,
                    "border-bottom-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass("top"));
                break;
            case"bottom":
                r = d.offset().left + d.outerWidth() / 2 - a.outerWidth() / 2, e = d.offset().top + d.outerHeight() + p, a.find(".tipso_arrow").css({marginLeft: -8}), e + n(a) > f.scrollTop() + f.outerHeight() ? (e = d.offset().top - n(a) - p, a.find(".tipso_arrow").css({
                    "border-top-color": l.settings.background,
                    "border-bottom-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass("top")) : (a.find(".tipso_arrow").css({
                    "border-bottom-color": l.settings.background,
                    "border-top-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass(l.settings.position));
                break;
            case"left":
                r = d.offset().left - a.outerWidth() - p, e = d.offset().top + d.outerHeight() / 2 - n(a) / 2, a.find(".tipso_arrow").css({
                    marginTop: -8,
                    marginLeft: ""
                }), r < f.scrollLeft() ? (r = d.offset().left + d.outerWidth() + p, a.find(".tipso_arrow").css({
                    "border-right-color": l.settings.background,
                    "border-left-color": "transparent",
                    "border-top-color": "transparent",
                    "border-bottom-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass("right")) : (a.find(".tipso_arrow").css({
                    "border-left-color": l.settings.background,
                    "border-right-color": "transparent",
                    "border-top-color": "transparent",
                    "border-bottom-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass(l.settings.position));
                break;
            case"right":
                r = d.offset().left + d.outerWidth() + p, e = d.offset().top + d.outerHeight() / 2 - n(a) / 2, a.find(".tipso_arrow").css({
                    marginTop: -8,
                    marginLeft: ""
                }), r + p + l.settings.width > f.scrollLeft() + f.outerWidth() ? (r = d.offset().left - a.outerWidth() - p, a.find(".tipso_arrow").css({
                    "border-left-color": l.settings.background,
                    "border-right-color": "transparent",
                    "border-top-color": "transparent",
                    "border-bottom-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass("left")) : (a.find(".tipso_arrow").css({
                    "border-right-color": l.settings.background,
                    "border-left-color": "transparent",
                    "border-top-color": "transparent",
                    "border-bottom-color": "transparent"
                }), a.removeClass("top bottom left right"), a.addClass(l.settings.position))
        }
        r < f.scrollLeft() && ("bottom" == l.settings.position || "top" == l.settings.position) && (a.find(".tipso_arrow").css({marginLeft: r - 8}), r = 0), r + l.settings.width > f.outerWidth() && ("bottom" == l.settings.position || "top" == l.settings.position) && (i = f.outerWidth() - (r + l.settings.width), a.find(".tipso_arrow").css({
            marginLeft: -i - 8,
            marginTop: ""
        }), r += i), r < f.scrollLeft() && ("left" == l.settings.position || "right" == l.settings.position) && (r = d.offset().left + d.outerWidth() / 2 - a.outerWidth() / 2, a.find(".tipso_arrow").css({
            marginLeft: -8,
            marginTop: ""
        }), e = d.offset().top - n(a) - p, e < f.scrollTop() ? (e = d.offset().top + d.outerHeight() + p, a.find(".tipso_arrow").css({
            "border-bottom-color": l.settings.background,
            "border-top-color": "transparent",
            "border-left-color": "transparent",
            "border-right-color": "transparent"
        }), a.removeClass("top bottom left right"), a.addClass("bottom")) : (a.find(".tipso_arrow").css({
            "border-top-color": l.settings.background,
            "border-bottom-color": "transparent",
            "border-left-color": "transparent",
            "border-right-color": "transparent"
        }), a.removeClass("top bottom left right"), a.addClass("top")), r + l.settings.width > f.outerWidth() && (i = f.outerWidth() - (r + l.settings.width), a.find(".tipso_arrow").css({
            marginLeft: -i - 8,
            marginTop: ""
        }), r += i), r < f.scrollLeft() && (a.find(".tipso_arrow").css({marginLeft: r - 8}), r = 0)), r + l.settings.width > f.outerWidth() && ("left" == l.settings.position || "right" == l.settings.position) && (r = d.offset().left + d.outerWidth() / 2 - a.outerWidth() / 2, a.find(".tipso_arrow").css({
            marginLeft: -8,
            marginTop: ""
        }), e = d.offset().top - n(a) - p, e < f.scrollTop() ? (e = d.offset().top + d.outerHeight() + p, a.find(".tipso_arrow").css({
            "border-bottom-color": l.settings.background,
            "border-top-color": "transparent",
            "border-left-color": "transparent",
            "border-right-color": "transparent"
        }), a.removeClass("top bottom left right"), a.addClass("bottom")) : (a.find(".tipso_arrow").css({
            "border-top-color": l.settings.background,
            "border-bottom-color": "transparent",
            "border-left-color": "transparent",
            "border-right-color": "transparent"
        }), a.removeClass("top bottom left right"), a.addClass("top")), r + l.settings.width > f.outerWidth() && (i = f.outerWidth() - (r + l.settings.width), a.find(".tipso_arrow").css({
            marginLeft: -i - 8,
            marginTop: ""
        }), r += i), r < f.scrollLeft() && (a.find(".tipso_arrow").css({marginLeft: r - 8}), r = 0)), a.css({
            left: r + l.settings.offsetX,
            top: e + l.settings.offsetY
        })
    }

    var d = "tipso", l = {
        speed: 400,
        background: "#55b555",
        color: "#ffffff",
        position: "top",
        width: 200,
        delay: 200,
        offsetX: 0,
        offsetY: 0,
        content: null,
        ajaxContentUrl: null,
        useTitle: !0,
        onBeforeShow: null,
        onShow: null,
        onHide: null
    };
    t.extend(r.prototype, {
        init: function () {
            var o = this, e = this.element;
            e.addClass("tipso_style").removeAttr("title"), i() ? (e.on("click." + d, function (t) {
                "hide" == o.mode ? o.show() : o.hide(), t.stopPropagation()
            }), t(s).on("click", function () {
                "show" == o.mode && o.hide()
            })) : (e.on("mouseover." + d, function () {
                o.show()
            }), e.on("mouseout." + d, function () {
                o.hide()
            }))
        }, tooltip: function () {
            return this.tipso_bubble || (this.tipso_bubble = t('<div class="tipso_bubble"><div class="tipso_content"></div><div class="tipso_arrow"></div></div>')), this.tipso_bubble
        }, show: function () {
            var s = this.tooltip(), e = this, r = t(o);
            t.isFunction(e.settings.onBeforeShow) && e.settings.onBeforeShow(t(this)), s.css({
                background: e.settings.background,
                color: e.settings.color,
                width: e.settings.width
            }).hide(), s.find(".tipso_content").html(e.content()), a(e), r.resize(function () {
                a(e)
            }), e.timeout = o.setTimeout(function () {
                s.appendTo("body").stop(!0, !0).fadeIn(e.settings.speed, function () {
                    e.mode = "show", t.isFunction(e.settings.onShow) && e.settings.onShow(t(this))
                })
            }, e.settings.delay)
        }, hide: function () {
            var s = this, e = this.tooltip();
            o.clearTimeout(s.timeout), s.timeout = null, e.stop(!0, !0).fadeOut(s.settings.speed, function () {
                t(this).remove(), t.isFunction(s.settings.onHide) && "show" == s.mode && s.settings.onHide(t(this)), s.mode = "hide"
            })
        }, destroy: function () {
            var t = this.element;
            t.off("." + d), t.removeData(d), t.removeClass("tipso_style").attr("title", this._title)
        }, content: function () {
            var o, s = this.element, e = this, r = this._title;
            return o = e.settings.ajaxContentUrl ? t.ajax({
                type: "GET",
                url: e.settings.ajaxContentUrl,
                async: !1
            }).responseText : e.settings.content ? e.settings.content : e.settings.useTitle === !0 ? r : s.data("tipso")
        }, update: function (t, o) {
            var s = this;
            return o ? void(s.settings[t] = o) : s.settings[t]
        }
    }), t[d] = t.fn[d] = function (o) {
        var s = arguments;
        if (o === e || "object" == typeof o) return this instanceof t || t.extend(l, o), this.each(function () {
            t.data(this, "plugin_" + d) || t.data(this, "plugin_" + d, new r(this, o))
        });
        if ("string" == typeof o && "_" !== o[0] && "init" !== o) {
            var i;
            return this.each(function () {
                var e = t.data(this, "plugin_" + d);
                e || (e = t.data(this, "plugin_" + d, new r(this, o))), e instanceof r && "function" == typeof e[o] && (i = e[o].apply(e, Array.prototype.slice.call(s, 1))), "destroy" === o && t.data(this, "plugin_" + d, null)
            }), i !== e ? i : this
        }
    }
}(jQuery, window, document);