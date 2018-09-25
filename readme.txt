test task:
in archive test_task.zip, password is "test_task" (to avoid indexing)
Compiling:
mvn install
Usage:
cd target
java -jar card-parser-0.0.1-SNAPSHOT.jar "../java_test_task/imgs" ::(or any other path to images)
or use run.cmd
run.cmd java_test_task/imgs ::(or any other path to images)