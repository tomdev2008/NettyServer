
call ant clean jar

copy /B generated\jar\messages.jar ..\netty_protobuf\server\lib
pause