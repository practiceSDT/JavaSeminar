package iftool.controller;

import org.springframework.integration.annotation.ServiceActivator;

public interface Recieved {

	void execute(String st) throws Exception;

}