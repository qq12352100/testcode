#!/bin/bash
echo "remove classes file!"
rm -rf vgc-apon-business-trip-portlet/docroot/WEB-INF/classes
rm -rf vgc-apon-e-leave-portlet/docroot/WEB-INF/classes
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