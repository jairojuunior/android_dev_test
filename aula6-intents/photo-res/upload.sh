#!/bin/bash
# usage upload.sh <PORT>

SDK_HOME=$HOME/Android/Sdk
ADB=$SDK_HOME/platform-tools/adb
TARGET=/sdcard/photos

if [ -z $1 ]
then
	echo "Usage: upload.sh <PORT>"
else
	$ADB -e connect localhost:$1
	$ADB -e shell mkdir $TARGET
	for f in `ls *.jpg`
	do
		echo "$ADB -e push $f $TARGET/"
		$ADB -e push $f $TARGET/
	done
fi
