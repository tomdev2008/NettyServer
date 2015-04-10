CURRENT_PATH=$(cd "$(dirname "$0")"; pwd)
cd $CURRENT_PATH

sh release_cpp.sh 

echo done!
