package com.github.wenhao.tdd.pos.parser;

import com.github.wenhao.tdd.pos.domain.Product;

public class ProductParser extends Parser<Product>
{
    public Product convert(String line)
    {
        String[] split = line.split(":");
        return new Product(split[0], Double.valueOf(split[1]));
    }
}
