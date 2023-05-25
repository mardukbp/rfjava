package com.rfjava;

import java.util.*;

public class RobotRemote {
    private KeywordLibrary library;

    public RobotRemote(KeywordLibrary library) {
        this.library = library;
    }

    public List<String> get_keyword_names() {
        return new ArrayList<>(library.getKeywordNames());
    }

    public List<String> get_keyword_arguments(String keyword) {
        return new ArrayList<>(library.getKeyword(keyword).args);
    }

    public List<String> get_keyword_types(String keyword) {
        return new ArrayList<>(library.getKeyword(keyword).types);
    }

    public List<String> get_keyword_tags(String keyword) {
        return new ArrayList<>();
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

    public Map<String, Object> run_keyword(String keyword, Object[] args) {
        return library.callKeyword(keyword, args).asMap();
    }
}
