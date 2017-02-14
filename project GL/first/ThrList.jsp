<!DOCTYPE html>
<html>
<head>
	<title>test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/ThreadList.css">
<script type="text/javascript" src="javaScript/ThreadList.js"></script>
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
