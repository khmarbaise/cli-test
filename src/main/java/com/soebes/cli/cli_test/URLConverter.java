package com.soebes.cli.cli_test;

import java.net.MalformedURLException;
import java.net.URL;

import com.beust.jcommander.IStringConverter;

public class URLConverter implements IStringConverter<URL> {

    @Override
    public URL convert(String value) {
        URL url = null;

        try {
            url = new URL(value);
        } catch (MalformedURLException e) {
            //Intentially left blank
        }

        return url;
    }
}
