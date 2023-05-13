import java.util.Hashtable;
import java.util.Vector;

public class RobotRemote {
    private KeywordLibrary library;

    public RobotRemote(KeywordLibrary library) {
        this.library = library;
    }

    public Vector<String> get_keyword_names() {
        return new Vector<>(library.getKeywordNames());
    }

    public Vector<String> get_keyword_arguments(String keyword) {
        return new Vector<>(library.getKeyword(keyword).args);
    }

    public Vector<String> get_keyword_types(String keyword) {
        return new Vector<>(library.getKeyword(keyword).types);
    }

    public Vector<String> get_keyword_tags(String keyword) {
        return new Vector<>();
    }

    public String get_keyword_documentation(String keyword) {
        if (keyword.equals("__init__")) {
            return library.getInit();
        }

        if (keyword.equals("__intro__")) {
            return library.getIntro();
        }

        return library.getKeyword(keyword).doc;
    }

    public Hashtable<String, Object> run_keyword(String keyword, Object[] args) {
        return library.callKeyword(keyword, args).asHashtable();
    }
}
