package com.github.wenhao.tdd.pos.parser;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

import com.google.common.base.Function;
import com.google.common.io.Resources;

public abstract class Parser<T>
{
    public List<T> parse(String name)
    {

        URL url = Resources.getResource(name);
        try {
            List<String> lines = Resources.readLines(url, Charset.defaultCharset());
            return from(lines).transform(new Function<String, T>()
            {
                @Override
                public T apply(String line)
                {
                    return convert(line);
                }
            }).toList();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return newArrayList();
    }

    abstract T convert(String line);
}
