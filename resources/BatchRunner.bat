@echo off
rem ********************************************************
rem * バッチファイル名	：BatchRunner.bat
rem *
rem * 終了コード		：0（正常終了）
rem * 					：1（異常終了）
rem * 処理概要			：バッチプロセスの呼び出し
rem ********************************************************
rem * 改定日     改定内容
rem * ---------- -------------------------------------------
rem * 2016/08/31 新規作成
rem *
rem *
rem ********************************************************

echo %date% %time:~0,2%:%time:~3,2%:%time:~6,2% バッチ開始

SET CLASSPATH=%CLASSPATH%;%~dp0\properties
SET CLASSPATH=%CLASSPATH%;%~dp0\classes\commons-logging-1.2.jar
SET CLASSPATH=%CLASSPATH%;%~dp0\classes\jsoup-1.9.2.jar
SET CLASSPATH=%CLASSPATH%;%~dp0\classes\log4j-1.2.17.jar
SET CLASSPATH=%CLASSPATH%;%~dp0\classes\mybatis-3.4.1.jar
SET CLASSPATH=%CLASSPATH%;%~dp0\classes\postgresql-9.4.1211.jre6.jar
SET CLASSPATH=%CLASSPATH%;%~dp0\classes\RaviSiteBatch.jar

SET RUNDATE=%date:~0,4%%date:~5,2%%date:~8,2%
java -classpath %CLASSPATH% jp.ne.ravisite.runner.BatchRunner %RUNDATE%

if ERRORLEVEL 1 GOTO ERROR

GOTO END

:ERROR
echo エラーが発生しました [%ERRORLEVEL%]

:END
echo %date% %time:~0,2%:%time:~3,2%:%time:~6,2% バッチ終了 [%ERRORLEVEL%]

pause
exit(%ERRORLEVEL%)