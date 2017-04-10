package com.github.paulcwarren.ginkgo4j.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jdt.internal.ui.text.java.JavaTypeCompletionProposalComputer;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;

public class Ginkgo4jProposalComputer implements IJavaCompletionProposalComputer {

	@Override
	public void sessionStarted() {
	}

	@Override
	public List computeCompletionProposals(ContentAssistInvocationContext context, IProgressMonitor monitor) {

		ArrayList<CompletionProposal> proposals = new ArrayList<CompletionProposal>();

		CharSequence prefix = getPrefix(context);
		
		if ("describe".startsWith(prefix.toString().toLowerCase())) {
			String replacement = "Describe(\"\", () -> {});";

			Image image = Ginkgo4jUIPlugin.getPlugin().getImageRegistry().get("/icons/sample.gif");
			if (image == null) {
				Ginkgo4jUIPlugin.getPlugin().getImageRegistry().put("/icons/sample.gif", Ginkgo4jUIPlugin.imageDescriptorFromPlugin("com.github.paulcwarren.ginkgo4j.ui", "/icons/sample.gif"));
				image = Ginkgo4jUIPlugin.getPlugin().getImageRegistry().get("/icons/sample.gif");
			}
			proposals.add(new CompletionProposal(replacement, context.getInvocationOffset() - prefix.length(), prefix.length(), 10, image, "Describe - Ginkgo4j", null, "Desc"));
		}

//		proposals.add(new CompletionProposal("<your proposal here>", context.getInvocationOffset(), 0,
//				"<your proposal here>".length()));

		return proposals;
	}

	private CharSequence getPrefix(ContentAssistInvocationContext context) {
		try {
			return context.computeIdentifierPrefix();
		} catch (BadLocationException e) {
		}
		return null;
	}

	@Override
	public List computeContextInformation(ContentAssistInvocationContext context, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public void sessionEnded() {
	}

	public static boolean isGinkgo4jProposal(ICompletionProposal proposal) {
		return proposal.getDisplayString().contains("Ginkgo4j");
	}
}