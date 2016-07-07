package cz.vutbr.mefw.plugins;

import cz.vutbr.mefw.Config;
import cz.vutbr.mefw.ProcessorAdapter;
import edu.insight.unlp.nn.example.TwitterSentiMain;


/***
 * This is an example of adapter class for TwiterSentientClassifier. It extends ProfessorAdapter abstract class.
 */
public class TwiterSentiClassifier extends ProcessorAdapter {

    String glovePath = "resources/TweetSentiClassifier/embeddings/glove.twitter.27B.50d.txt";
    String datapath = "resources/TweetSentiClassifier/data/twitterSemEval2013.tsv";
    String modelPath = "resources/TweetSentiClassifier/model/learntSentiTwitter.model";
    TwitterSentiMain main;

    public TwiterSentiClassifier(Config config) {
        super(config);
        main = new TwitterSentiMain();

    }

    public void load() {
        main.loadModel(modelPath, glovePath, datapath);
    }


    public String process(String data) {
        return main.classify(data);

    }
}






