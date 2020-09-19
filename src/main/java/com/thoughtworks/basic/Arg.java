package com.thoughtworks.basic;

public class Arg {
    private String flag;
    private Object value;

    public Arg(String flag, Object value) {
        this.flag = flag;
        this.value = value;
    }

    public static Arg of(String argString) {
        String[] args = argString.split(" ");
        try {
            return new Arg(args[0],args[1]);
        } catch (Exception e) {
            return new Arg(args[0],null);
        }

    }

    public String getFlag() {
        return flag;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Arg{" +
                "flag='" + flag + '\'' +
                ", value=" + value +
                '}';
    }
}
