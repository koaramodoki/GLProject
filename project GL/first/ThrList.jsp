<!DOCTYPE html>
<html>
<head>
	<title>test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(function(){
var menu = $('#slide_menu')
    ,menuBtn = $('#button')
    ,body = $(document.body)    
    ,menuWidth = menu.outerWidth();                
     
    menuBtn.on('click', function(){
    body.toggleClass('open');
        if(body.hasClass('open')){
            body.animate({'top' : menuWidth }, 300);            
            menu.animate({'top' : 0 }, 300);                    
        } else {
            menu.animate({'top' : -menuWidth }, 300);
            body.animate({'top' : 0 }, 300);            
        }             
    });
});
function koshin(){
  location.reload();
}    
</script>
	<style type="text/css">
	header {
    position: fixed;
    top: 0;
    left:0;
    width: 100%;
    height: 25px;
    background-color: #888;
    z-index:2;
}
	#thr a { display:block;
		padding:10px;
	}

	#thr a:hover { background-color: #ccc;
 	}

	#thr_top{
		font-weight: bold;
		padding:10px;
	}

	#thr_id{
		width: 60px;
		display: table-cell;
	}
	#thr_name{
		width: 300px;
		display: table-cell;
	}
	#thr_create_user{
		width: 100px;
		display: table-cell;
	}
	#thr_create_date{
		width: 180px;
		display: table-cell;
	}
	#thr_update{
		width: 180px;
		display: table-cell;
	}
	#thr_count{
		width: 50px;
		display: table-cell;
	}

	a:link { color:#000; text-decoration:none }
	a:visited { color:#000; text-decoration:none }
	a:hover { color:#000; text-decoration:none }
	a:active { color:#000; text-decoration:none }

}
#slide_menu{
    position: fixed;
    
    top: -120px;
    width: 100%;
    height: 120px;
    background: #888;
    z-index:1;
}
	#textbox{
		width:380px;
		height:80px;
	}
	#hd{
		float: left;
	}
</style>
</head>
<body>
<header>
	<button id="button" id="hd">
		<i class="fa fa-bars"></i>スレッド作成 
	</button>
	<form id="hd">
		<input type="button" value="更新" onclick="koshin()">
	</form>
</header>
<form>
<input type="button"  value="更新" onclick="koshin()">
</form>
<!-- スライドメニュー部分-->
<nav id="slide_menu">
	<br><br>

 	<div>
		<form method='post' action='dbatestservlet'>
			<table>
				<tr><td>名前</td><td><input type="text" name="User" id="res_name"></td></tr>
				<tr><td>スレッド名</td><td><input type="text" name="User" id="res_name"></td></tr>
				<tr><td align="right" colspan="2"><input type="submit" value="作成 "></td></tr>
			</table>
		</form>
	</div>
</nav>
 <br>


	<div id=thr_top>
		<div id="thr_id" align="center">ID</div>
		<div id="thr_name">スレッド名</div>
		<div id="thr_create_user">作成者</div>
		<div id="thr_create_date">作成日</div>
		<div id="thr_update">最終更新日</div>
		<div id="thr_count" align="center">レス数</div>
	</div>
		<hr>
	<div id="thr"><a href="https://www.google.co.jp">
		<div id="thr_id" align="center">${thr.thrId}</div>
		<div id="thr_name">${thr.thrName}</div>
		<div id="thr_create_user">${thr.thrCreateUser}</div>
		<div id="thr_create_date">${thrCreateDate}</div>
		<div id="thr_update">${thrUpdateDate}</div>
		<div id="thr_count" align="center">${resCount}</div>	
		
	</a></div>
	<hr>
</body>
</html>
