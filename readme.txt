Original dependencies are located in pom.xml

$> mvn dependency:resolve
$> mvn -o dependency:list | grep compile | cut -d ] -f 2 > pom.deps
$> groovy pom2ivy.groovy pom.deps
