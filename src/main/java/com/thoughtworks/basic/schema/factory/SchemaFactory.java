package com.thoughtworks.basic.schema.factory;

import com.thoughtworks.basic.schema.Schema;

import com.thoughtworks.basic.schema.factory.Exception.SchemaNotFoundExceptin;

public class SchemaFactory {

    public static Schema getSchemaFactory(String flag) {
        switch (flag){
            case "l": return new SchemaL();

            case "p": return new SchemaP();

            case "d": return new SchemaD();

        }
        throw new SchemaNotFoundExceptin("命令未找到");
    }
}
