package com.imos.sample;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author Pintu
 */
public class JdbcParameters {

    @Getter
    private final List<ParameterPair> parameters = new ArrayList<>();

    public JdbcParameters setDataTypeAndValue(DataType dataType, Object data) {
        parameters.add(new ParameterPair(dataType, data));
        return this;
    }
}
