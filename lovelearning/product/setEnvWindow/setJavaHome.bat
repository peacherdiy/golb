echo 请输入java安装目录，如：C:\Program Files (x86)\Java\jdk1.6.0_22
:start
set /p JAVA_HOME=
if not exist "%JAVA_HOME%" (echo 你输入路径不存在！！ &goto :start)
SETX JAVA_HOME "%JAVA_HOME%"
pause