
enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}


interface TextAnalyzer {
    Label processText(String text);
}


abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract String[] getKeywords();

    abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}


class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    String[] getKeywords() {
        return keywords;
    }

    @Override
    Label getLabel() {
        return Label.SPAM;
    }
}


class NegativeTextAnalyzer extends KeywordAnalyzer {
    private final String[] keywords = {":(", "=(", ":|"};

    @Override
    String[] getKeywords() {
        return keywords;
    }

    @Override
    Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}


class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return (text.length() > maxLength) ? Label.TOO_LONG : Label.OK;
    }
}


public class CommentValidatorRunner {

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label result = analyzer.processText(text);
            if (result != Label.OK) {
                return result;
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        String[] tests = {
                "This comment is so good.",                             // OK
                "This comment is so Loooooooooooooooooooooooooooong.", // TOO_LONG
                "Very negative comment !!!!=(!!!!;",                    // NEGATIVE_TEXT
                "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;",     // NEGATIVE_TEXT or TOO_LONG
                "This comment is so bad....",                           // SPAM
                "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!",   // SPAM or TOO_LONG
                "Negative bad :( spam.",                                // SPAM or NEGATIVE_TEXT
                "Very bad, very neg =(, very .................."        // SPAM or NEGATIVE_TEXT or TOO_LONG
        };

        CommentValidatorRunner commentValidatorRunner = new CommentValidatorRunner();
        for (String test : tests) {
            System.out.println(commentValidatorRunner.checkLabels(textAnalyzers, test));
        }
    }
}
