PACKAGE_PATH := si/unilj/fri/vss/aps2/seminar3
PACKAGE_NAME := si.unilj.fri.vss.aps2.seminar3
SRC_PATH := src/main/java/
MVN_TARGET_PATH := target
TARGET_PATH := /tmp/target/
JAR_NAME := seminar3-1.0-SNAPSHOT.jar
MAIN_CLASS := ${PACKAGE_NAME}.BatteryCharging

.PHONY: package clean test build run purge

clean:
	mvn clean
purge: 	clean
	find . -name '.*' -not -path . -exec rm -rf '{}' +
package:
	mvn package
build:
	mvn compile || \
		mkdir -p ${TARGET_PATH}/classes \
		&& javac -d ${TARGET_PATH}/classes ${SRC_PATH}/${PACKAGE_PATH}/*.java \
		&& jar -cfe ${TARGET_PATH}/${JAR_NAME} ${MAIN_CLASS} -C ${TARGET_PATH}/classes .
test:
	mvn test
run:
	java -jar ${MVN_TARGET_PATH}/${JAR_NAME} < input1.txt || \
		java -jar ${TARGET_PATH}/${JAR_NAME} < input1.txt

