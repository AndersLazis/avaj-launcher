package com.anderslazis.avaj.simulator;

	public class AnsiColor {

		public static final String RESET = "\u001B[0m";


		public static final String RED = "\u001B[31m";
		public static final String GREEN = "\u001B[32m";
		public static final String YELLOW = "\u001B[33m";
		public static final String BLUE = "\u001B[34m";
		public static final String PURPLE = "\u001B[35m";
		public static final String CYAN = "\u001B[36m";
		public static final String WHITE = "\u001B[37m";


		public static final String INFO = GREEN + "[INFO] " + RESET;
		public static final String EVENT = CYAN + "[EVENT] " + RESET;
		public static final String WARN = YELLOW + "[WARN] " + RESET;
		public static final String ERROR = RED + "[ERROR] " + RESET;


		public static String colorize(String text, String color) {
			return color + text + RESET;
		}
	}

//How to use:
// System.out.println(AnsiColor.colorize(("TEXT")"), AnsiColor.GREEN));