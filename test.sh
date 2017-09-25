#!/bin/bash
echo "remove classes file!"
#声明字符串
a="vgc-apon-business-trip-portlet,vgc-apon-e-leave-portlet"
#分割字符串到数组
OLD_IFS="$IFS" 
IFS="," 
arr=($a) 
IFS="$OLD_IFS" 
for s in ${arr[@]} 
do 
	rm -rf "$s"/docroot/WEB-INF/classes
	rm -rf "$s"/docroot/WEB-INF/lib
	rm -rf "$s"/docroot/WEB-INF/service
	
	rm -rf "$s"/docroot/WEB-INF/src/com/business/trip/model/impl
	rm -rf "$s"/docroot/WEB-INF/src/com/business/trip/service/base
	rm -rf "$s"/docroot/WEB-INF/src/com/business/trip/service/persistence
	
	#find "$s"/docroot/WEB-INF/src/com -type d -name "model" 
done
sleep 1s
git add .
sleep 3s
git commit -m "$1"
sleep 1s
git push origin master
sleep 3s
echo "remove all file!"
rm -rf vgc-apon*
sleep 1s
echo "ok!"