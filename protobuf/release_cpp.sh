SAN_GUO=../client/workspace/Sanguo

CPP_SRC=generated/cpp
CPP_DEST=$SAN_GUO/Classes/Generated/Messages
JS_SRC=generated/js
JS_DEST=$SAN_GUO/Resources/ccb/js/generated

echo copy code to $CPP_DEST
rm $CPP_DEST/*.h
cp $CPP_SRC/*.h $CPP_DEST
rm $CPP_DEST/*.cc
cp $CPP_SRC/*.cc $CPP_DEST
rm $CPP_DEST/*.cpp
cp $CPP_SRC/*.cpp $CPP_DEST

echo copy code to $JS_DEST
rm $JS_DEST/*.js
cp $JS_SRC/*.js $JS_DEST

echo copy revision to $CPP_DEST
cp generated/cwa-sanguo-messages-Revision.txt $CPP_DEST/cwa-sanguo-messages-Revision.txt

echo copy revison to $JS_DEST
cp generated/cwa-sanguo-messages-Revision.txt $JS_DEST/cwa-sanguo-messages-Revision.txt

echo done!
