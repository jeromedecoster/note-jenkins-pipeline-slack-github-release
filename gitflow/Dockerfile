FROM ubuntu

ARG GIT_CONFIG_NAME=
ARG GIT_CONFIG_EMAIL=
ARG NETRC_GITHUB_LOGIN=
ARG NETRC_GITHUB_PASSWORD=

RUN apt update \
    && apt install \
        --yes \
        git \
        git-flow \
        curl \
        zsh \
        nano \
    && sh -c \
        "$(curl \
        --fail \
        --silent \
        --show-error \
        --location \
        https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" \
    && rm \
        --recursive \
        --force \
        /var/lib/apt/lists/* \
    && chsh \
        --shell \
        /bin/zsh \
    && printf "\
[user]\n\
  name = ${GIT_CONFIG_NAME}\n\
  email = ${GIT_CONFIG_EMAIL}\n" > /root/.gitconfig \
    && printf "\
machine github.com\n\
  login ${NETRC_GITHUB_LOGIN}\n\
  password ${NETRC_GITHUB_PASSWORD}\n" > /root/.netrc

WORKDIR /tmp

CMD ["zsh"]