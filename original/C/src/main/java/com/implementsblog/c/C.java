package com.implementsblog.c;

import com.implementsblog.a.A;
import com.implementsblog.b.B;

public class C
{
    public static String call()
    {
        return "C-1.0.0 -> " + A.call() + "\n"
             + "C-1.0.0 -> " + B.call();
    }
}
