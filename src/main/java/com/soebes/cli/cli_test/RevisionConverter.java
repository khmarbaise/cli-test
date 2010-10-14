package com.soebes.cli.cli_test;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

public class RevisionConverter implements IStringConverter<Long> {

    @Override
    public Long convert(String value) {
        Long revision = null;

        if ("HEAD".equalsIgnoreCase(value)) {
            revision = new Long(-1);
        } else {
            try {
                revision = new Long(value);
            } catch (NumberFormatException e) {
                throw new ParameterException(e);
            }
        }
        return revision;
    }
}
