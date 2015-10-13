### Mower2

##### Program a set of automatic mowers and see how they react.

First, get the project :  
`$> git clone https://github.com/tomtomlehero/Mower2.git`  
`$> cd Mower2`

###### Mower2 comes in two flavors, both wrapped in a single SpringBoot application:

- **A standalone java app:** specify your input file as program argument and see the result on stdout.

try it:  
`$> mvn clean install -Pstandalone`  
`$> java -jar target/mower2-1.0.jar <yourInputFile>`

there is a sample input file : `in.txt` so you can try :  
`$> java -jar target/mower2-1.0.jar in.txt`

- **A RESTful WS / angularJs webApp (recommanded):** type (or paste) your mower instructions in the dedicated text area in your browser and see the result "on the fly"

try it:  
`$> mvn clean install -Pserver`  
(or simply `mvn clean install` - this is the default)  
(Profile only affects the `MANIFEST.MF`, that's why you need to build again - but this is the same code in the same core-logic that's involved)  
`$> java -jar target/mower2-1.0.jar`

Then open your browser and go to this url:
[`http://localhost:8080`](http://localhost:8080)

**Required:** JDK 8 (there are lambdas)

The jar is made an uber jar so you don't have to modify your classpath
