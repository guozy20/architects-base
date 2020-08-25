package com.guozy.design.principle.lsp.methondparam;

import java.util.HashMap;
import java.util.Map;

public class MethodParamTest {
    public static void main(String[] args) {
        Base child = new Child();
        HashMap hashMap = new HashMap();
        Map map = new HashMap();
        child.method(hashMap);

    }
}
