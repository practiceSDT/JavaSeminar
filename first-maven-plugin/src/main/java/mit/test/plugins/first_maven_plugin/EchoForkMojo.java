package mit.test.plugins.first_maven_plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Echos an object string to the output screen.
 * @goal echo-fork
 * @execute lifecycle="echocycle" phase="package"
 */
public class EchoForkMojo extends AbstractMojo
{

	public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        getLog().info( "echo-forked." );
    }
}