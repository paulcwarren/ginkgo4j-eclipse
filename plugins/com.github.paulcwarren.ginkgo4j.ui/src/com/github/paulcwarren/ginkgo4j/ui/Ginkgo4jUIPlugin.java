package com.github.paulcwarren.ginkgo4j.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Ginkgo4jUIPlugin extends AbstractUIPlugin {

	public static Ginkgo4jUIPlugin plugin = null;
	
	public static Ginkgo4jUIPlugin getPlugin() {
		return plugin;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
}
