package test;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**

 * @author Administrator

 * @create 2018-03-14 17:33

 * @desc TestCLI

 **/
public class TestCLI {
	public static void main1(String[] args) throws ParseException {
// Create a Parser
		Options options = new Options();
		options.addOption("h", "help", false, "Print this usage information");
		options.addOption("v", "verbose", false, "Print out VERBOSE information");
		options.addOption("f", "file", true, "File to save program output to");
		// Parse the program arguments
		String[] arg = {"-h", "-v", "-f","file"};
		CommandLineParser parser = new BasicParser();
		CommandLine commandLine = parser.parse(options, arg);
		// Set the appropriate variables based on supplied options
		boolean verbose = false;
		String file = "";
		if (commandLine.hasOption('h')) {
			System.out.println("Help Message");
			System.exit(0);
		}
		if (commandLine.hasOption('v')) {
			verbose = true;
		}
		if (commandLine.hasOption('f')) {
			file = commandLine.getOptionValue('f');
		}
	}

	public static void main(String[] args) throws ParseException {
		// for test

//	Option help = new Option("h", "the command help");
//	Option user = OptionBuilder.withArgName("type").hasArg().withDescription("target the search type").create("t");
//
//	// 此处定义参数类似于 java 命令中的 -D<name>=<value>
//	Option property = OptionBuilder.withArgName("property=value").hasArgs(2).withValueSeparator().withDescription
//			("search the objects which have the target property and value").create("D");
//	Options opts = new Options();
//	opts.addOption(help);
//	opts.addOption(user);
//	opts.addOption(property);

		// do test
		String[] Args = {"-h"};
//		String[] Args1 = {"-i", "192.168.1.1", "-p", "8443", "-t", "https"};
		simpleTest(Args);
//		simpleTest(Args1);
		main1(Args);
	}

	/////////

	public static void simpleTest(String[] args) {
		Options opts = new Options();
//		opts.addOption("h", "help", false, "Print this usage information");
		opts.addOption("h", "help", false, "HELP_DESCRIPTION");
		opts.addOption("i", true, "HELP_IPADDRESS");
		opts.addOption("p", true, "HELP_PORT");
		opts.addOption("t", true, "HELP_PROTOCOL");
		CommandLineParser parser = new BasicParser();
//        CommandLineParser parser = new GnuParser ();
//        CommandLineParser parser = new PosixParser();
		CommandLine cl;
		try {
			cl = parser.parse(opts, args);
			if (cl.getOptions().length > 0) {
				if (cl.hasOption('h')) {
					HelpFormatter hf = new HelpFormatter();
					hf.printHelp("May Options", opts);
				} else {
					String ip = cl.getOptionValue("i");
					String port = cl.getOptionValue("p");
					String protocol = cl.getOptionValue("t");
					System.out.println(ip);
					System.out.println(port);
					System.out.println(protocol);
				}
			} else {
				System.err.println("ERROR_NOARGS");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
