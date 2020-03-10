import hudson.security.FullControlOnceLoggedInAuthorizationStrategy
import hudson.security.HudsonPrivateSecurityRealm
import hudson.security.csrf.DefaultCrumbIssuer
import jenkins.install.InstallState
import jenkins.model.Jenkins
import jenkins.security.s2m.AdminWhitelistRule

def env = System.getenv()
def jenkins = Jenkins.getInstance()
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
def defaultCrumbIssuer = new DefaultCrumbIssuer(true)

// create admin user
hudsonRealm.createAccount(env.ADMIN_USER, env.ADMIN_PASSWORD)
jenkins.setSecurityRealm(hudsonRealm)
jenkins.setAuthorizationStrategy(strategy)

// create crumb issuer
jenkins.crumbIssuer = defaultCrumbIssuer
jenkins.setSecurityRealm(hudsonRealm)

// enabling slave access control mechanism
jenkins.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)

// jenkins root url
def location = jenkins.getDescriptor('jenkins.model.JenkinsLocationConfiguration')
location.setUrl('http://127.0.0.1:8080/')

jenkins.save()