@echo off
setLocal EnableDelayedExpansion
 
set JAVA_OUT=generated\java
set CPP_OUT=generated\cpp

rmdir /S /Q %JAVA_OUT%
rmdir /S /Q %CPP_OUT%
mkdir %JAVA_OUT%
mkdir %CPP_OUT%

set PROTOC_CMD=tools\protoc-2.5.0-win32\protoc
for /D %%a in (protos/*) do (
  set PROTOC_CMD=!PROTOC_CMD! -I=protos/%%a
)
set PROTOC_CMD=!PROTOC_CMD! --java_out=%JAVA_OUT% --cpp_out=%CPP_OUT% 
for /D %%a in (protos/*) do (
  set PROTOC_CMD=!PROTOC_CMD! protos/%%a/*.proto
)

rem echo %PROTOC_CMD%
@echo on
call %PROTOC_CMD%
if errorlevel 1 (
    pause
    exit /B
)

java -cp tools\pb-helper\pbhelper.jar ^
    com.cwa.sanguo.pb2json.Main ^
    protos generated\cpp generated\js

dir
call ant clean jar

pause