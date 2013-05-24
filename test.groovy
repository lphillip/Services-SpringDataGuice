out="mvn -o dependency:list | grep compile | cut -d ] -f 2".execute().text;
println out;

