package com.thoughtworks.basic.schema.factory;

import com.thoughtworks.basic.Arg;
import com.thoughtworks.basic.schema.Schema;
import com.thoughtworks.basic.schema.factory.Exception.GrammarErrorException;

public class SchemaP implements Schema {
    @Override
    public Object grammarCheck(Object message) {
        try {
            Integer i = Integer.parseInt(message.toString());
        } catch (Exception e) {
            throw new GrammarErrorException("命令P的参数仅能为数字!");
        }
        return message;
    }

    @Override
    public Arg getDefaultArg() {
        String flag = "p";
        Object value = ValueType.INTEGER.getDefaultValue();
        return new Arg(flag, value);
    }
}
