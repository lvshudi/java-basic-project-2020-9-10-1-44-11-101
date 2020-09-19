package com.thoughtworks.basic;

import com.thoughtworks.basic.Exception.FlagRepeatException;
import com.thoughtworks.basic.Exception.InputErrorException;
import com.thoughtworks.basic.schema.Schema;
import com.thoughtworks.basic.schema.factory.SchemaFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Args {

    public static void main(String[] args) {
        new Args("-l true -l false");
    }

    public static List<Arg> argList;
    public Args(String inputCommand) {
        argList = grammarCheck(lexicalCheck(inputCommand));
        System.out.println(argList.toString());
    }

    public static List<Arg> lexicalCheck(String inputCommand) {
        if (inputCommand==null || !inputCommand.trim().substring(0,1).equals("-")) {
            throw new InputErrorException();
        }
        String[] argArray = inputCommand.substring(1).split("-");
        List<Arg> argList = new ArrayList<Arg>();
        // 记录已经输入的flag
        Set<String> flagSet = new HashSet<>();
        for (String argString : argArray) {
            Arg arg = Arg.of(argString);
            if (flagSet.contains(arg.getFlag())) {
                throw new FlagRepeatException();
            }
            flagSet.add(arg.getFlag());
            argList.add(arg);
        }
        return argList;
    }

    public static List<Arg> grammarCheck(List<Arg> inArgList) {
        List<Arg> argList = new ArrayList<Arg>();
        for (Arg arg : inArgList) {
            Schema schema = SchemaFactory.getSchemaFactory(arg.getFlag());
            if (arg.getValue() == null) {
                arg = schema.getDefaultArg();
            }
            schema.grammarCheck(arg.getValue());
            argList.add(arg);
        }
        return argList;
    }

    public static List<Arg> getArgList() {
        return argList;
    }
}
