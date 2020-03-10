FROM jenkins/jenkins:lts

USER root

# ADMIN USER / PASSWORD
ENV ADMIN_USER="admin" ADMIN_PASSWORD="admin"

# https://github.com/jenkinsci/docker/blob/master/Dockerfile#L32
COPY setup.groovy /usr/share/jenkins/ref/init.groovy.d/

# Install the Jenkins plugins recommanded by default
RUN install-plugins.sh \
  ant \
  antisamy-markup-formatter \
  build-timeout \
  cloudbees-folder \
  credentials-binding \
  email-ext \
  git \
  github-branch-source \
  gradle \
  ldap \
  mailer \
  matrix-auth \
  pam-auth \
  pipeline-github-lib \
  pipeline-stage-view \
  ssh-slaves \
  subversion \
  timestamper \
  workflow-aggregator \
  ws-cleanup \
  # Install more Jenkins plugins
  github-pullrequest \
  role-strategy \
  slack \
  # Mark installation as fully configured so Jenkins will skip setup wizard
  && echo ${JENKINS_VERSION} > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state \
  && echo ${JENKINS_VERSION} > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion
