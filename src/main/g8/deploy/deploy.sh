#!/usr/bin/env bash

buildProdDockerImage() {
    sbt dist

    unzip target/universal/*.zip
    rm -rf $name;format="normalize"$
    mv $name;format="normalize"$* $name;format="normalize"$

    docker build -t $name;format="normalize"$ -f deploy/Dockerfile-prod .

    rm -rf $name;format="normalize"$
}