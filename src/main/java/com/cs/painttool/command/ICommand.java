package com.cs.painttool.command;

import java.util.List;

public interface ICommand {

	void execute(List<String> parameters) throws Exception;
}
