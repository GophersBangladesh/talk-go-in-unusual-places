#!/usr/bin/env bash

GOOS=js GOARCH=wasm go build -o unusualgo.wasm .
