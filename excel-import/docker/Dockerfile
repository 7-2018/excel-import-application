FROM azul/zulu-openjdk:17-jre
MAINTAINER Marta Mladenovic
ENV JAR_FILE=excel-import.jar

ARG TARGET_PATH=target/${JAR_FILE}
ADD ${TARGET_PATH} /${JAR_FILE}

ENTRYPOINT ["java","-jar","/excel-import.jar", "ExcellImportApplication"]