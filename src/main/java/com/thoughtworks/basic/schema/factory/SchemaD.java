package com.thoughtworks.basic.schema.factory;

import com.thoughtworks.basic.Arg;
import com.thoughtworks.basic.schema.Schema;
import com.thoughtworks.basic.schema.factory.Exception.GrammarErrorException;

public class SchemaD implements Schema {

    @Override
    public Object grammarCheck(Object inMessage) {
        String message = (String) inMessage;
        if (message.trim().contains(" ")){
            throw new GrammarErrorException("指令中不能含有空格！");
        }
        return message;
    }

    @Override
    public Arg getDefaultArg() {
        String flag = "d";
        Object value = ValueType.STRING.getDefaultValue();
        return new Arg(flag, value);
    }
}
