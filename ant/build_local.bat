@echo off
rem ********************************************************
rem * バッチファイル名	：build.bat
rem *
rem * 処理概要			：コンパイルおよびビルド実行
rem ********************************************************
rem * 改定日     改定内容
rem * ---------- -------------------------------------------
rem * 2016/08/30 新規作成
rem *
rem *
rem ********************************************************

cd %~dp0

rem ANT呼び出し
ant -f build_local.xml

pause
