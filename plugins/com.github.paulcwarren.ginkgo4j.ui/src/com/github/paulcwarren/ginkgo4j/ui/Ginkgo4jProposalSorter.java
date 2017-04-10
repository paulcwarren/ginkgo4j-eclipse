package com.github.paulcwarren.ginkgo4j.ui;

import org.eclipse.jdt.ui.text.java.AbstractProposalSorter;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class Ginkgo4jProposalSorter extends AbstractProposalSorter {

	public Ginkgo4jProposalSorter() {
	}

	@Override
	public int compare(ICompletionProposal p1, ICompletionProposal p2) {
		if (Ginkgo4jProposalComputer.isGinkgo4jProposal(p1)) {
			return -1;
		} else if (Ginkgo4jProposalComputer.isGinkgo4jProposal(p2)) {
			return 1;
		}
		return 0;
	}

}
