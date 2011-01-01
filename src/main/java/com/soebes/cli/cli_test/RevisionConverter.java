package com.soebes.cli.cli_test;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

/**
 * This converter will convert the special
 * value <b>HEAD</b> into internal version number.
 *
 * @author Karl Heinz Marbaise
 *
 */
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
