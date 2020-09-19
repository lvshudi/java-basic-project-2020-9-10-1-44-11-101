package com.thoughtworks.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ArgsTest {
    @Test
    public void should_return_defaultValue_when_inputArgs_without_value() throws Exception {
        String inputArgs = "-l  -p  -d ";

        Args args = new Args(inputArgs);

        assertEquals("[Arg{flag='l', value=false}, Arg{flag='p', value=0}, Arg{flag='d', value=}]"
                ,args.getArgList().toString());
    }

    @Test
    public void should_return_exception_when_inputArgs_without_value() throws Exception {
        String inputArgs = "-l -true";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals(exception.getMessage(), "命令未找到");
        }
    }

    @Test
    public void should_throw_error_no_legal_when_repeat_flag() throws Exception {
        String inputArgs = "-l true -l false";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals(exception.getMessage(), "请不要重复输入相同的flag");
        }
    }

    @Test
    public void should_return_args_when_inputArgs() throws Exception {
        String inputArgs = "-l true -p 8080 -d /usr/logs";

        Args args = new Args(inputArgs);

        assertEquals("[Arg{flag='l', value=true}, Arg{flag='p', value=8080}, Arg{flag='d', value=/usr/logs}]"
                ,args.getArgList().toString());
    }

    @Test
    public void should_throw_error_no_blank_when_have_blank() throws Exception {
        String inputArgs = "-d t  rue -l ";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals(exception.getMessage(), "指令中不能含有空格！");
        }
    }

    @Test
    public void should_throw_error_no_blank_when_p_not_num() throws Exception {
        String inputArgs = "-p aaa";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals(exception.getMessage(), "命令P的参数仅能为数字!");
        }
    }

    @Test
    public void should_throw_error_when_l_not_boolean() throws Exception {
        String inputArgs = "-l aaa";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals(exception.getMessage(), "L的命令仅能为true或者false");
        }
    }
}
