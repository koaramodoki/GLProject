<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>test</title>

	<style type="text/css">
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

	</style>
</head>
<body>
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