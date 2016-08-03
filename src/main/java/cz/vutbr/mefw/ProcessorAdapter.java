package cz.vutbr.mefw;

public abstract class ProcessorAdapter {

    //TODO:PAss config to constructor with paths to resources

    Config config;

    public ProcessorAdapter(Config config){
        this.config = config;
    }

    // xorman00: pridane aby som vobec rozchodil
    public ProcessorAdapter(){
        ;
    }

    // xorman00: pridane aby som vobec rozchodil
    public ProcessorAdapter(String new_procesor_name){
        this.config = config;
    }

    // xorman00: pridane aby som vobec rozchodil
    public ProcessorAdapter(Config config,String new_procesor_name){
        this.config = config;
    }

    abstract public void load();

    abstract public String process(String data);

    // xorman00: bolo by prijemne keby sa to vratilo, aj ked asi sa chcete spoliehat na GC
    // abstract public void unload()

}
