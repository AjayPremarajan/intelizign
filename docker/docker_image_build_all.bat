@echo off 
call echo "------------------------------------------Starting docker image build for all microservices------------------------------------------"
call docker build -f inspect-order\Dockerfile -t ajaypremarajan/inspect-order .
call docker build -f inspect-result\Dockerfile -t ajaypremarajan/inspect-result .
call docker build -f sap-adapter\Dockerfile -t ajaypremarajan/sap-adapter .
call docker build -f send-email\Dockerfile -t ajaypremarajan/send-email .
call docker build -f test-station\Dockerfile -t ajaypremarajan/test-station .
call echo "------------------------------------------Finished docker image build for all microservices------------------------------------------"