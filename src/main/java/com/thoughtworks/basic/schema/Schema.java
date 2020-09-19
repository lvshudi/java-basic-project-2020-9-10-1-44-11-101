package com.thoughtworks.basic.schema;


import com.thoughtworks.basic.Arg;

public interface Schema {
    Object grammarCheck(Object message);
    Arg getDefaultArg();
}
