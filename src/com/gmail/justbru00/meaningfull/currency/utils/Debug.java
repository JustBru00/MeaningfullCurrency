/**
The MIT License (MIT)

Copyright (c) 2016 Justin "JustBru00" Brubaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
**/ 
package com.gmail.justbru00.meaningfull.currency.utils;

import com.gmail.justbru00.meaningfull.currency.main.Main;

public class Debug {
	private static Main main2;

	public static void send(String msg) {
		if (main2.config.getBoolean("debug")) {
		Messager.msgConsole("&8[&cDebug&8] &c" + msg);	
		}
	}
	
	public static void initialize(Main main) {
		main2 = main;
		return;
	}
}
