@echo off 
call echo "------------------------------------------Starting build for microservice------------------------------------------"
call mvn_build_all.bat 
call echo "------------------------------------------Starting Image build for microservice------------------------------------------"
call docker_image_build_all.bat
call echo "------------------------------------------Finished build for microservice------------------------------------------"