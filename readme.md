# [Scala.js] facades for the [Probot] framework :robot:

[![](https://travis-ci.com/laughedelic/scalajs-probot.svg?branch=master)](https://travis-ci.com/laughedelic/scalajs-probot)
[![](http://img.shields.io/github/release/laughedelic/scalajs-probot/all.svg)](https://github.com/laughedelic/scalajs-probot/releases/latest)
[![](https://img.shields.io/badge/license-MPL--2.0-blue.svg)](https://www.tldrlegal.com/l/mpl-2.0)
[![](https://img.shields.io/badge/contact-gitter_chat-dd1054.svg)](https://gitter.im/laughedelic/scalajs-probot)

This project contains Scala.js facades for the Probot framework used to build GitHub Apps on Node.js.

## Usage

1. Add Probot dependency to your `package.json`:
    ```shell
    npm install probot@next
    ```
    These facades are based on the [WIP](https://github.com/probot/probot/pull/372) TypeScript version of Probot, this the `next` version tag.

2. Add facades dependency to your `build.sbt`:
    ```scala
    resolvers += Resolver.jcenterRepo
    libraryDependencies += "laughedelic" %%% "scalajs-probot" % "<version>"
    ```
    (see the latest release version on the badge above)


[Scala.js]: https://www.scala-js.org
[Probot]: https://probot.github.io
