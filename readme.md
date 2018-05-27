# [Scala.js] facades for the [Probot] framework :robot:

[<img align="right" src="https://img.shields.io/badge/probot-7.0.0--typescript.4-blue.svg">](https://www.npmjs.com/package/probot/v/7.0.0-typescript.4)
[<img align="right" src="https://www.scala-js.org/assets/badges/scalajs-0.6.17.svg">](https://www.scala-js.org)
[![](https://travis-ci.com/laughedelic/scalajs-probot.svg?branch=master)](https://travis-ci.com/laughedelic/scalajs-probot)
[![](http://img.shields.io/github/release/laughedelic/scalajs-probot/all.svg)](https://github.com/laughedelic/scalajs-probot/releases/latest)
[![](https://img.shields.io/badge/license-MPL--2.0-blue.svg)](https://www.tldrlegal.com/l/mpl-2.0)
[![](https://img.shields.io/badge/contact-gitter_chat-dd1054.svg)](https://gitter.im/laughedelic/scalajs-probot)

This project contains Scala.js facades for the Probot framework used to build GitHub Apps on Node.js.

## 🚧 WORK IN PROGRESS 🚧

_This project is in active development, there are no published releases yet. Things may break without a warning, so don't rely on it._

## Usage

### Installation

<details><summary>🛠 Check installation instructions later, when there is a published release...</summary>

1. Add Probot dependency to your project. It's important that the version of the underlying JS library matches the one this facade is built for.

    * If it's a Node.js project where you manage dependencies with npm, run
        ```shell
        npm install probot@next --save
        ```

    * If it's a Scala.js project use [scalajs-bundler] and add to your `build.sbt`:
        ```scala
        Compile/npmDependencies += "@octokit/rest" -> "7.0.0-typescript.4"
        ```

    These facades are based on the [TypeScript version of Probot](https://github.com/probot/probot/pull/372) which is not released yet.

2. Add facades dependency to your `build.sbt`:
    ```scala
    resolvers += Resolver.jcenterRepo
    libraryDependencies += "laughedelic" %%% "scalajs-probot" % "<version>"
    ```
    (see the latest release version on the badge above)

</details>


[Scala.js]: https://www.scala-js.org
[Probot]: https://probot.github.io
