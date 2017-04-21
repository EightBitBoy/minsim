# minsim
MinSim, a mining simulation game. No graphics, pure simulation.

[![Build Status](https://travis-ci.org/EightBitBoy/minsim.svg?branch=master)](https://travis-ci.org/EightBitBoy/minsim)

## Setup
* Install **[node.js](https://nodejs.org/)**, the package manager **npm** is included.
* `npm install -g cordova ionic`
* `ionic start minsim --v2`.
* `ionic serve`.
* `ionic platform add android`.
* Run `cordova platform update android@6.2.1`. This is necessary to fix an issue which prevents buiding the app.
* `ionic emulate ios`

## Build an .apk
* `ionic build android --debug`
* Adjust `config.xml`.
