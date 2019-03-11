package com.github.wenhao.tdd.pos.parser;

import static com.google.common.collect.Lists.newArrayList;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Parser<T> {
    public List<T> parse(String name) {

        URL url = Resources.getResource(name);
        try {
            List<String> lines = Resources.readLines(url, Charset.defaultCharset());
            return lines.stream().map(line -> convert(line)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newArrayList();
    }

    abstract T convert(String line);
}
