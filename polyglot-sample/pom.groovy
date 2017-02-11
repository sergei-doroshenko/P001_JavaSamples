project {
    modelVersion '4.0.0'
    groupId 'org.sergei'
    artifactId 'polyglot-sample'
    version '1.0-SNAPSHOT'
    name 'polyglot-sample'
    properties {
        'project.build.sourceEncoding' 'UTF-8'
    }
    dependencies {
        dependency {
            groupId 'junit'
            artifactId 'junit'
            version '3.8.1'
            scope 'test'
        }
    }

    build {
        $execute(id: 'hello', phase: 'compile') {
            if ("true".equals(System.getProperty("file-test"))) {
                println "File generation is enabled"
                println properties.size()
                println this.getProperties().containsKey('greet')
                println properties
                println properties.get('greet')
                if (getProperties().getOrDefault('greet', false)) {
                    System.out.println 'Hello from groovy'
                }
                def directory = "target/classes/new"
                def dirCreated = new File(directory).mkdir();
                println "Directory was created? " + dirCreated
                def file = new File(directory + "/hello.txt")
                if (!file.exists()) {
                    println "Creating hello.txt"
                    file.createNewFile();
                    file.write("hello from groovy")
                } else {
                    println "hello.txt is already created"
                }
            } else {
                println "File generation is disabled"
            }
        }
    }
}
