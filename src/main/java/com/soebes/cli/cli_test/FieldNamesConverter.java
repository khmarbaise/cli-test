package com.soebes.cli.cli_test;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

/**
 * This converter will convert the filed names into
 * internal enumeration type {@link FieldNames}.
 *
 * @author Karl Heinz Marbaise
 *
 */
public class FieldNamesConverter implements IStringConverter<FieldNames> {

    @Override
    public FieldNames convert(String value) {
        FieldNames result = null;
        for (FieldNames item : FieldNames.values()) {
            if (item.getValue().equalsIgnoreCase(value)) {
                result = item;
            }
        }
        if (result == null) {
            throw new ParameterException("The given value on command line " + value + " is not a valid field name.");
        }
        return result;
    }
}
