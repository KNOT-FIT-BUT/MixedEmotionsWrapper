# Mixed Emotions CLI and HTTP Wrapper
This project create unified I/O interface for different MixedEmotions algorithms aka processors. All processors are dynamicly loaded at startup.

## Usage and commandline parameters
```
  mefw server <ip> [--port=<port>]
  mefw process <processor> <inputfile> <outputfile>
  mefw list processors
  mefw (-h | --help)
  mefw --version

Options:
  -h --help        Show this screen.
  --version        Show version.
  <ip>             IP address on which server will listen.
  --port=<num>     Server listening port [default: 80].
```
You can run mefw one time to parse a file or as a HTTP server daemon. For file I/O run mefw with *process* key and specify **<processor>**, **<inputfile>** and **<outputfile>**.
You can get list of available processors by running
```mefw list processors```
Server mefw need **<ip>** on which should server listen. You can also specify port **--port=<num>**.

## Libraries and external resourecs
Application libraries via Maven
Processors libraries via Maven
Processor itself via Maven or as JAR/class included in CLASSPATH
Resources in folder **resources/<ProcessorName>/...**


## Usage
TODO:

## PluginAdapter example
Example is available **/src/main/java/cz/vutbr/mefw/plugins/TwiterSentiClassifier.java**