package com.implementsblog.c;

import com.implementsblog.a.A;
import com.implementsblog.b.B;

public class C {
    public static String call() {
        return "C-1.0.2 -> " + A.call() + "\n"
             + "C-1.0.2 -> " + B.call();
    }

    public static void main(String[] args) {
        System.out.println(C.call());
    }
}
