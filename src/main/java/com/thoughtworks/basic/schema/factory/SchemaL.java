package com.thoughtworks.basic.schema.factory;

import com.thoughtworks.basic.Arg;
import com.thoughtworks.basic.schema.Schema;
import com.thoughtworks.basic.schema.factory.Exception.GrammarErrorException;

public class SchemaL implements Schema {
    @Override
    public Object grammarCheck(Object message) {

        try {
            Boolean b = new Boolean(message.toString());
        } catch (Exception  e) {
            throw  new GrammarErrorException("L的命令仅能为true或者false");
        }
        return message;
    }

    @Override
    public Arg getDefaultArg() {
        String flag = "l";
        Object value = ValueType.BOOLEAN.getDefaultValue();
        return new Arg(flag, value);
    }
}
