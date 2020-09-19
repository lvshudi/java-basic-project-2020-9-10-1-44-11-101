package com.thoughtworks.basic.schema.factory;

enum ValueType {
    BOOLEAN(false,"boolean"),INTEGER(0,"int"),STRING("","String");

    Object defaultValue;
    String type;
    ValueType(Object defaultValue,String type) {
        this.defaultValue = defaultValue;
        this.type = type;
    }

    Object getDefaultValue(){
        return defaultValue;
    }

    String getType(){
        return type;
    }
}
