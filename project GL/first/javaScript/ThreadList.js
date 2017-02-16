$(function(){
var menu = $('#slide_menu'),
    menuBtn = $('#button'),
    body = $(document.body),
    // .layer もオブジェクト化    
    layer = $('.layer'),
    menuWidth = menu.outerWidth();                
         
    menuBtn.on('click', function(){
    body.toggleClass('open');
        if(body.hasClass('open')){
            // css で非表示にしていた .layer を表示
            $(".layer").show();
            body.animate({'top' : menuWidth }, 300);
            menu.animate({'top' : 0 }, 300);                    
        } else {
            // .layer を非表示
            $(".layer").hide();
            menu.animate({'top' : -menuWidth }, 300);
            body.animate({'top' : 0 }, 300);            
        }             
    });
    // .layer をクリック時にもメニューを閉じる
    layer.on('click', function(){
            menu.animate({'top' : -menuWidth }, 300);
            body.animate({'top' : 0 }, 300).removeClass('open');
            layer.hide();
    });
});  