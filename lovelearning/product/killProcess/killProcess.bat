echo 请输入杀掉的端口:
set /p portNumber=
echo "端口号 %portNumber%"
netstat -ano | find "%portNumber%"
echo 请输入进程号:
set /p processId=
TASKKILL /PID %processId% /F
pause