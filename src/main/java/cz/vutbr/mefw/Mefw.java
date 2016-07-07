package cz.vutbr.mefw;

import org.docopt.Docopt;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cz.vutbr.mefw.Mefw;


public class Mefw {


    private ProcessorPool processorPool;
    private HTTPServer server;

    private static String doc =
            "Mixed Emotions IO\n"
                    + "\n"
                    + "Usage:\n"
                    + "  mefw server <ip> [--port=<port>]\n"
                    + "  mefw process <processor> <inputfile> <outputfile> \n"
                    + "  mefw list processors \n"
                    + "  mefw (-h | --help)\n"
                    + "  mefw --version\n"
                    + "\n"
                    + "Options:\n"
                    + "  -h --help        Show this screen.\n"
                    + "  --version        Show version.\n"
                    + "  --threads=<num>  Speed in knots [default: 1].\n"
                    + "  --port=<num>     Server listening port [default: 80].\n"
                    + "\n";


    public Mefw(){
        processorPool =  new ProcessorPool();
        server  = new HTTPServer(processorPool);
    }

    private void processFile(String in, String out, String processorName){

        processorPool.load(processorName);
        ProcessorAdapter processor = processorPool.get(processorName);
        try {
            String input = new Scanner(new File(in)).useDelimiter("\\Z").next();
            String output = processor.process(input);
            PrintWriter outputfile = new PrintWriter(out);
            outputfile.println(output);
            outputfile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void startServer(String host, Integer port){
        System.out.println("Initialize HTTP server at: " + host + ":" + port);
        processorPool.loadAll();
        server.initialize(host, port);
        server.start();
    }

    private void listProcessors(){
        System.out.println("List of available processors:");
        List<String> classes = processorPool.getProcessorList(true);
        for (int i = 0; i < classes.size(); i++) {
            System.out.println(classes.get(i));
        }
        processorPool.loadAll();
    }




    public static void main(String [] args){
        Map<String, Object> opts = new Docopt(doc).withVersion("Mixed Emotions 0.1").parse(args);
        //TODO: make global debug mode
        //System.out.println(opts);
        Mefw core = new Mefw();
        if((Boolean)opts.get("server")){
            System.out.println("starting server");
            core.startServer((String)opts.get("<ip>"), Integer.parseInt((String)opts.get("--port")));
            //TODO:Instead readline() use Thread.join for wait and sigint (ctrl+c) for ending
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if((Boolean)opts.get("process")){
            core.processFile((String)opts.get("<inputfile>"), (String)opts.get("<outputfile>"), (String)opts.get("<processor>"));
        }else if((Boolean)opts.get("list")){
            core.listProcessors();
        }


    }

}
