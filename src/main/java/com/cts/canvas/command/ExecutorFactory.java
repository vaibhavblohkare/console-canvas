package  com.cts.canvas.command;

import java.util.HashMap;
import java.util.Map;

public class ExecutorFactory {
	
	private static ExecutorFactory exeFactory;
	
	/**
	 * @description This will contain separate 
	 * ActionExecutorFactory map
	 */
	private Map<String, ActionExecutorFactory> actionExecutorMap;
	
	public ActionExecutorFactory getActionExecutorFactory(String name) {
		ActionExecutorFactory factory = actionExecutorMap.get(name);
		if(factory == null) {
			factory = new ActionExecutorFactory();
			actionExecutorMap.put(name, factory);
		}
		return factory;
	}

	private ExecutorFactory() {
		actionExecutorMap = new HashMap<String, ActionExecutorFactory>();
	}
	
	public static synchronized ExecutorFactory getInstance() {
		if (exeFactory == null) {
			exeFactory = new ExecutorFactory();
		}
		return exeFactory;
	}
}
