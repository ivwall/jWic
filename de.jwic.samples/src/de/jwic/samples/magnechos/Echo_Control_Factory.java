package de.jwic.samples.magnechos;

public class Echo_Control_Factory {
	public Echo_Control_Factory() {
	}
	public IEchoController getEchoController( String className ) {
		IEchoController controller = null;
		try {
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
		return controller;
	}
}