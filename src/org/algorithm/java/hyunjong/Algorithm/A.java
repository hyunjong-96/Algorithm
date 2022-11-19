package org.algorithm.java.hyunjong.Algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class A{
	public static void main(String[] args) throws IOException{
		Client client = new Client();
		client.talk();
	}

	public interface Command{
		void run();
	}

	static public class HeaterCommand implements Command{
		Heater heater;
		void setHeater(Heater heater){
			this.heater = heater;
		}
		@Override
		public void run() {
			this.heater.powerOn();
		}
	}

	static public class Heater{
		public void powerOn(){
			System.out.println("히터 켜기!");
		}
	}

	static public class LampCommand implements Command{
		Lamp lamp;

		void setLamp(Lamp lamp){
			this.lamp = lamp;
		}
		@Override
		public void run() {
			this.lamp.turnOn();
		}
	}

	static public class Lamp{
		public void turnOn(){
			System.out.println("램프 켜기!");
		}
	}

	static public class Genie{
		Command command;

		public void setCommand(Command command){
			this.command = command;
		}

		public void talk(){
			this.command.run();
		}
	}

	static public class Client{
		public void talk(){
			Genie genie = new Genie();

			HeaterCommand heaterCommand = new HeaterCommand();
			Heater heater = new Heater();
			heaterCommand.setHeater(heater);

			genie.setCommand(heaterCommand);
			genie.talk();

			LampCommand lampCommand = new LampCommand();
			Lamp lamp = new Lamp();
			lampCommand.setLamp(lamp);

			genie.setCommand(lampCommand);
			genie.talk();
		}
	}
}