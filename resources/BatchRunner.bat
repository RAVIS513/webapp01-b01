@echo off
rem ********************************************************
rem * �o�b�`�t�@�C����	�FBatchRunner.bat
rem *
rem * �I���R�[�h		�F0�i����I���j
rem * 					�F1�i�ُ�I���j
rem * �����T�v			�F�o�b�`�v���Z�X�̌Ăяo��
rem ********************************************************
rem * �����     ������e
rem * ---------- -------------------------------------------
rem * 2016/08/31 �V�K�쐬
rem *
rem *
rem ********************************************************

echo %date% %time:~0,2%:%time:~3,2%:%time:~6,2% �o�b�`�J�n

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
echo �G���[���������܂��� [%ERRORLEVEL%]

:END
echo %date% %time:~0,2%:%time:~3,2%:%time:~6,2% �o�b�`�I�� [%ERRORLEVEL%]

pause
exit(%ERRORLEVEL%)