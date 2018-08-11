$(document).ready(function() {
	// 菜单
	$(".nav-mobile").click(function() {
		$("#mobile-nav").slideToggle(500);
	});

	// 去边线
	$(".message-widget li:last, .message-page li:last, .hot_commend li:last, .search-page li:last, .my-comment li:last, .message-tab li:last").css("border", "none");

	// 字号 √
	$("#fontsize").click(function() {
		var _this = $(this);
		var _t = $(".single-content");
		var _c = _this.attr("class");
		if (_c == "size_s") {
			_this.removeClass("size_s").addClass("size_l");
			_this.text("A+");
			_t.removeClass("fontsmall").addClass("fontlarge");
		} else {
			_this.removeClass("size_l").addClass("size_s");
			_this.text("A-");
			_t.removeClass("fontlarge").addClass("fontsmall");
		};
	});
// 结束
});

// 隐藏侧边
function pr() {
	var R = document.getElementById("sidebar");
	var L = document.getElementById("primary");
	if (R.className == "sidebar") {
		R.className = "sidebar-hide";
		L.className = "";
	} else {
		R.className = "sidebar";
		L.className = "primary";
	}
}

//获取相对路径
// function  getPath(){
//     var pathName = document.location.pathname;
//     var index = pathName.substr(1).indexOf("/");
//     var result = pathName.substr(0,index+1);
//     return result;
// }

// 文字滚动
(function($) {
    $.fn.textSlider = function(settings) {
        settings = jQuery.extend({
                speed: "normal",
                line: 2,
                timer: 1000
            },
            settings);
        return this.each(function() {
            $.fn.textSlider.scllor($(this), settings)
        })
    };
    $.fn.textSlider.scllor = function($this, settings) {
        var ul = $("ul:eq(0)", $this);
        var timerID;
        var li = ul.children();
        var _btnUp = $(".up:eq(0)", $this);
        var _btnDown = $(".down:eq(0)", $this);
        var liHight = $(li[0]).height();
        var upHeight = 0 - settings.line * liHight;
        var scrollUp = function() {
            _btnUp.unbind("click", scrollUp);
            ul.animate({
                    marginTop: upHeight
                },
                settings.speed,
                function() {
                    for (i = 0; i < settings.line; i++) {
                        ul.find("li:first").appendTo(ul)
                    }
                    ul.css({
                        marginTop: 0
                    });
                    _btnUp.bind("click", scrollUp)
                })
        };
        var scrollDown = function() {
            _btnDown.unbind("click", scrollDown);
            ul.css({
                marginTop: upHeight
            });
            for (i = 0; i < settings.line; i++) {
                ul.find("li:last").prependTo(ul)
            }
            ul.animate({
                    marginTop: 0
                },
                settings.speed,
                function() {
                    _btnDown.bind("click", scrollDown)
                })
        };
        var autoPlay = function() {
            timerID = window.setInterval(scrollUp, settings.timer)
        };
        var autoStop = function() {
            window.clearInterval(timerID)
        };
        ul.hover(autoStop, autoPlay).mouseout();
        _btnUp.css("cursor", "pointer").click(scrollUp);
        _btnUp.hover(autoStop, autoPlay);
        _btnDown.css("cursor", "pointer").click(scrollDown);
        _btnDown.hover(autoStop, autoPlay)
    }
})(jQuery);

$("#scrolldiv").textSlider({line: 1, speed: 300, timer: 6000});


//评论区域
$(".comment-reply-link").click(function () {
    var authorName = $(this).parents('.comment-author').find("strong").text();
    $("#cancel-comment-reply-link").show();
    $("#reply-title-word").html("回复 " + authorName);
    var commentId = $(this).parents('.comment-body').attr("id").match(/\d+/g);
    $("input[name=commentPid]").attr("value", commentId);
    $("input[name=commentPname]").attr("value", authorName);
    $("#comment").attr("placeholder", "@ " + authorName)
})

$("#cancel-comment-reply-link").click(function () {
    $("#cancel-comment-reply-link").hide();
    $("input[name=commentPid]").attr("value", 0);
    $("input[name=commentPname]").attr("value", "");
    $("#reply-title-word").html("发表评论");
})

function bugeijin() {
    alert("后台管理不给进~");

}
