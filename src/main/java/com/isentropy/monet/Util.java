package com.isentropy.monet;

import java.io.File;

import org.web3j.codegen.SolidityFunctionWrapperGenerator;

public class Util {

	public static void generateJavaSources(File solidity_dir, String source_output_dir, String java_package) throws Exception{
		for(File f : solidity_dir.listFiles()){
			if(f.getName().endsWith(".abi")){
				String abi=f.getAbsolutePath();
				String bin=abi.substring(0,abi.length()-4)+".bin";
				String[] cmd = {bin,abi,"-p",java_package,"-o",source_output_dir};
				SolidityFunctionWrapperGenerator.main(cmd);
			}
		}
	}
	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * generate java sources from solidity
	 * @param args
	 */

	public static void main(String[] args) {
		//first run:  solc --abi --bin *.sol -o .
		//in solidity dir
		
		File sd = new File("/path/to/solidity");
		String javadir= "/path/to/javasrc";
		String pkg = "com.isentropy.monet.contracts";
		try{
			generateJavaSources(sd,javadir,pkg);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
