Crypto Commons
===============
![GitHub](https://img.shields.io/github/license/osslabz/crypto-commons)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/osslabz/crypto-commons/build-on-push.yml?branch=dev&label=build&logo=git)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/osslabz/crypto-commons/build-release-on-main-push.yml?branch=main&label=perform-release&logo=semanticrelease)
[![Reproducible Builds](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/jvm-repo-rebuild/reproducible-central/master/content/net/osslabz/crypto-commons/badge.json)](https://github.com/jvm-repo-rebuild/reproducible-central/blob/master/content/net/osslabz/crypto-commons/README.md)
[![Maven Central](https://img.shields.io/maven-central/v/net.osslabz/crypto-commons?label=Maven%20Central)](https://search.maven.org/artifact/net.osslabz/crypto-commons)

Contains some common classes used by various other crypto related projects.

There probably won't be any benefit for anybody to use this directly, it's pulled transitively when required.

0.6.4 is from April 2025, the last of 23 releases since June 2024. There are no tests, the source hasn't changed since March 2025, and the
known users are mexc-client and two private projects of mine.

Current release:

```xml
<dependency>
    <groupId>net.osslabz</groupId>
    <artifactId>crypto-commons</artifactId>
    <version>0.6.4</version>
</dependency>
```