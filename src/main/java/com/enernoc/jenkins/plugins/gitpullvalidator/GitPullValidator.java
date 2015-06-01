package com.enernoc.jenkins.plugins.gitpullvalidator;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.TaskListener;
import hudson.model.AbstractBuild;
import hudson.tasks.Builder;

import java.io.IOException;

import jenkins.plugins.git.GitSCMSource;
import jenkins.scm.api.SCMHead;
import jenkins.scm.api.SCMHeadObserver;
import jenkins.scm.api.SCMRevision;

import org.kohsuke.stapler.StaplerRequest;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * Sample {@link Builder}.
 *
 * <p>
 * When the user configures the project and enables this builder,
 * {@link DescriptorImpl#newInstance(StaplerRequest)} is invoked
 * and a new {@link GitPullValidator} is created. The created
 * instance is persisted to the project configuration XML by using
 * XStream, so this allows you to use instance fields (like {@link #name})
 * to remember the configuration.
 *
 * <p>
 * When a build is performed, the {@link #perform(AbstractBuild, Launcher, BuildListener)}
 * method will be invoked.
 *
 * @author Kohsuke Kawaguchi
 */
public class GitPullValidator extends GitSCMSource {

    public GitPullValidator(String id, String remote, String credentialsId,
	    String includes, String excludes, boolean ignoreOnPushNotifications) {
	super(id, remote, credentialsId, includes, excludes,
		ignoreOnPushNotifications);
    }

    @CheckForNull
    @Override
    protected SCMRevision retrieve(@NonNull SCMHead head,
	    @NonNull TaskListener listener) throws IOException,
	    InterruptedException {
	listener.getLogger().println("RETRIEVE1");
	return super.retrieve(head, listener);

    }

    @NonNull
    @Override
    protected void retrieve(@NonNull final SCMHeadObserver observer,
	    @NonNull TaskListener listener) throws IOException,
	    InterruptedException {
	listener.getLogger().println("RETRIEVE2");
	super.retrieve(observer, listener);
    }

    // @NonNull
    // @Override
    // public SCM build(@NonNull SCMHead head, @CheckForNull SCMRevision
    // revision) {
    // return super.build(head, revision);
    // }


}

