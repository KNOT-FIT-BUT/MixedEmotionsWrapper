package cz.vutbr.mefw;

public abstract class ProcessorAdapter {

    //TODO:PAss config to constructor with paths to resources

    Config config;

    public ProcessorAdapter(Config config){
        this.config = config;
    }

    abstract public void load();

    abstract public String process(String data);



}
